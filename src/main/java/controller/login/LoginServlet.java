package controller.login;

import model.Admin;
import model.Client;
import model.Food;
import model.Shop;
import service.admin.AdminService;
import service.admin.IAdminService;
import service.client.ClientService;
import service.client.IClientService;
import service.food.FoodService;
import service.food.IFoodService;
import service.shop.IShopService;
import service.shop.ShopService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private IAdminService adminService = new AdminService();
    private IShopService shopService = new ShopService();
    private IFoodService foodService = new FoodService();
    private IClientService clientService = new ClientService();
    public static String account ="";
    private static boolean checkLogin = false;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            default:
                showLogin(request,response);
                break;
        }
    }

    private void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/client/assets/page/login.jsp");
        request.setAttribute("message","Hoặc đăng nhập bằng tài khoản của bạn");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "login":
                login(request,response);
                break;
            default:
                login(request,response);
                break;
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Admin> admins = adminService.fillAll();
        List<Shop> shops = shopService.fillAll();
        List<Client> clients = clientService.fillAll();
        String account = request.getParameter("account");
        LoginServlet.account = account;
        String password = request.getParameter("password");
        RequestDispatcher dispatcher;
//        request.setAttribute("deals",dealService.fillAll());
//        request.setAttribute("categories",categoryService.fillAll());
//        request.setAttribute("shops",shopService.fillAll());
//        request.setAttribute("items",itemService.fillAll());
        request.setAttribute("message","Hoặc đăng nhập bằng tài khoản của bạn");
        for (Admin admin: admins) {
            if (admin.getAccount().equals(account) && admin.getPassword().equals(password)) {
                request.setAttribute("account", account);
                dispatcher = request.getRequestDispatcher("/client/assets/page/admin/adminHome.jsp");
                LoginServlet.checkLogin = true;
                dispatcher.forward(request, response);
                return;
            }
        }
        for (Shop shop : shops) {
            if (shop.getAccount().equals(account) && shop.getPassword().equals(password)) {
                if (shop.getStatus() == 1) {
                    request.setAttribute("shop", shop);
                    List<Food> foodList = foodService.findAllFoodByIdShop(shop.getId());
                    request.setAttribute("foodList", foodList);
                    dispatcher = request.getRequestDispatcher("/shop/shopHome.jsp");
                    LoginServlet.checkLogin = true;
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("message","Tài khoản shop đã bị khoá! Hãy liên hệ hotline để được kích hoạt");
                    dispatcher = request.getRequestDispatcher("/client/assets/page/login.jsp");
                    dispatcher.forward(request,response);
                }
                return;
            }
        }
        for (Client client : clients) {
            if (client.getAccount().equals(account) && client.getPassword().equals(password)) {
                if (client.getStatus() == 1) {
                    request.setAttribute("account", account);
                    dispatcher = request.getRequestDispatcher("/client/assets/page/client/clientHome.jsp");
                    LoginServlet.checkLogin = true;
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("message","Tài khoản khách hàng đã bị khoá! Hãy liên hệ hotline để được kích hoạt");
                    dispatcher = request.getRequestDispatcher("/client/assets/page/login.jsp");
                    dispatcher.forward(request,response);
                }
                return;
            }
        }
        request.setAttribute("message","Sai tài khoản hoặc mật khẩu !!!");
        dispatcher = request.getRequestDispatcher("/client/assets/page/login.jsp");
        dispatcher.forward(request,response);
    }
}
