package controller.admin;

import model.Client;
import model.Shop;
import service.client.ClientService;
import service.client.IClientService;
import service.deal.DealService;
import service.deal.IDealService;
import service.food.FoodService;
import service.food.IFoodService;
import service.shop.IShopService;
import service.shop.ShopService;
import service.tag.ITagService;
import service.tag.TagService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/admin")
public class AdminServlet extends HttpServlet {

    IDealService dealService = new DealService();
    IFoodService foodService = new FoodService();
    ITagService tagService = new TagService();
    IShopService shopService = new ShopService();
    IClientService clientService = new ClientService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "showShop":
                    showShop(request, response);
                    break;
                case "showClient":
                    showClient(request, response);
                    break;
                case "deleteShop":
                    deleteShop(request, response);
                    break;
                case "deleteClient":
                    deleteClient(request, response);
                    break;
                default:
                    homeAdmin(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void homeAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/admin/shopManagement.jsp");
        request.setAttribute("tags", tagService.fillAll());
        request.setAttribute("shops", shopService.fillAll());
        request.setAttribute("foods", foodService.fillAll());
        request.setAttribute("deals", dealService.fillAll());
        request.setAttribute("clients", clientService.fillAll());
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int client_id = Integer.parseInt(request.getParameter("client_id"));
        clientService.delete(client_id);

        List<Client> clients = clientService.fillAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/admin/adminHome.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteShop(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int shop_id = Integer.parseInt(request.getParameter("shop_id"));
        shopService.delete(shop_id);

        List<Shop> shops = shopService.fillAll();
        request.setAttribute("shops", shops);
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/admin/adminHome.jsp");
        dispatcher.forward(request, response);
    }

    private void showClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/admin/clientManagement.jsp");
        request.setAttribute("clients",clientService.fillAll());
        dispatcher.forward(request, response);
    }

    private void showShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/admin/shopManagement.jsp");
        request.setAttribute("shops",shopService.fillAll());
        dispatcher.forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "blockShop":
                blockShop(request, response);
                break;
            case "blockClient":
                blockClient(request, response);
                break;
            case "unblockShop":
                unblockShop(request, response);
                break;
            case "unblockClient":
                unblockClinet(request, response);
                break;
            default:
                homeAdmin(request, response);
                break;
        }
    }

    private void blockShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("shop_id"));
        Shop existingShop = shopService.blockShopById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/admin/shopManagement.jsp");
        request.setAttribute("shop", existingShop);
        dispatcher.forward(request, response);
    }

    private void blockClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("client_id"));
        Shop existingShop = clientService.blockClientById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/admin/clientManagement.jsp");
        request.setAttribute("shop", existingShop);
        dispatcher.forward(request, response);
    }

    private void unblockShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("shop_id"));
        Shop existingShop = shopService.unblockShopById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/admin/shopManagement.jsp");
        request.setAttribute("shop", existingShop);
        dispatcher.forward(request, response);
    }

    private void unblockClinet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("client_id"));
        Shop existingShop = clientService.unblockClientById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/admin/clientManagement.jsp");
        request.setAttribute("shop", existingShop);
        dispatcher.forward(request, response);
    }


}