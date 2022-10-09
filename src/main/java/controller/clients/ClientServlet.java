package controller.clients;

import connection.ConnectionCMS;
import controller.home.HomeServlet;
import model.Bill;
import model.Client;
import model.Service;
import model.Shop;
import service.bill.BillService;
import service.client.ClientService;
import service.client.IClientService;
import service.deal.DealService;
import service.deal.IDealService;
import service.food.FoodService;
import service.food.IFoodService;
import service.service.IServiceService;
import service.service.ServiceService;
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
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="ClientServlet",value = "/client")
public class ClientServlet extends HttpServlet {
    private static final String DELETE_CLIENT_SQL="DELETE FROM client WHERE id=?;";
    private Connection connection= ConnectionCMS.getConnection();

    private HomeServlet homeServlet;
    private SearchCartClient searchCartClient=new SearchCartClient();
    private BillService billService =new BillService();
    private IClientService clientService = new ClientService();
    private IShopService shopService = new ShopService();
    private IDealService dealService = new DealService();
    private ITagService tagService = new TagService();

    private IFoodService foodService = new FoodService();

    private IServiceService serviceService = new ServiceService();

    public void init(){
        homeServlet=new HomeServlet();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String action =request.getParameter("action");
        if(action==null){
            action="";
        }
//        try{
        switch (action){
            case "search":
                searchCartClient.doGet(request,response);
                //searchHome
                break;
            case "addCart":
                try {
                    addCart(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                showHome(request, response);
                break;
        }
//        }catch (SQLException e){
//            throw new ServletException(e);
//        }
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
//        try{
        switch (action){
//                case "search":
            //showSearchFrom;
//                    homeServlet.doGet(request,response);
//                    break;
            default:
                showHome(request, response);
                break;
        }
    }

    private void showHome(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/home.jsp");

        request.setAttribute("deals",dealService.fillAll());
        request.setAttribute("tags",tagService.fillAll());
        request.setAttribute("shops",shopService.fillAll());
        request.setAttribute("foods",foodService.fillAll());
        request.setAttribute("services",serviceService.fillAll());
        dispatcher.forward(request,response);

    }

    //        catch (SQLException e){
//            throw new ServletException(e);
//        }
//    }
    private void addCart(HttpServletRequest request,HttpServletResponse response)
            throws SQLException,IOException,ServletException {
        List<Client> clients = clientService.fillAll();
        List<Shop> shops = shopService.fillAll();
        String code = request.getParameter("bill_code");
        Date date = Date.valueOf(request.getParameter("bill_date"));
        Double totalCost= Double.valueOf(request.getParameter("totalCost"));
        int clientId= Integer.parseInt(request.getParameter("client_id"));
        Client client = null;
        for (Client c : clients) {
            if (c.getId() == clientId) {
                client = c;
            }
        }
        int shopId= Integer.parseInt(request.getParameter("shop_id"));
        Shop shop = null;
        for (Shop s : shops) {
            if (s.getId() == shopId) {
                shop = s;
            }
        }
        int status= Integer.parseInt(request.getParameter("status"));
        Bill bill=new Bill(code,date,totalCost,client,shop,status);
        billService.insert(bill);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("client/assets");
        requestDispatcher.forward(request,response);
    }
}
