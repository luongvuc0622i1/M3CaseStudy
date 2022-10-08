package controller.admin;

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
    }

    private void homeAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/admin/shopManagement.jsp");
        request.setAttribute("tags", tagService.fillAll());
        request.setAttribute("shops", shopService.fillAll());
        request.setAttribute("foods", foodService.fillAll());
        request.setAttribute("deals", dealService.fillAll());
        request.setAttribute("clients", clientService.fillAll());
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response) {

    }

    private void deleteShop(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showClient(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showShop(HttpServletRequest request, HttpServletResponse response) {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                homeAdmin(request, response);
                break;
        }
    }
    }