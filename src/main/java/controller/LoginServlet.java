package controller;

import model.Admin;
import model.Shop;
import service.admin.AdminService;
import service.admin.IAdminService;
import service.deal.DealService;
import service.deal.IDealService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private IAdminService adminService = new AdminService();
//    private IShopService shopService = new ShopService();
    private static String account ="";
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        request.setAttribute("message","Hoặc đăng nhập bằng tài khoản của bạn");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            default:
                login(request,response);
                break;
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Admin> admins = adminService.fillAll();
//        List<Shop> shops = shopService.fillAll();
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
                dispatcher = request.getRequestDispatcher("adminHome.jsp");
                LoginServlet.checkLogin = true;
                dispatcher.forward(request, response);
                return;
            }
        }
//        for (Shop shop: shops) {
//            if (shop.getAccount().equals(account) && shop.getPassword().equals(password)) {
//
//                dispatcher = request.getRequestDispatcher("/client/assets/page/shop/shopHome.jsp");
//                LoginServlet.checkLogin = true;
//                dispatcher.forward(request, response);
//                return;
//            }
//        }

//            if (customers.get(i).getCustomer_account().equals(account)
//                    && customers.get(i).getCustomer_password().equals(password)){
//                LoginServlet.USER_ACCOUNT = account;
//                request.setAttribute("account",account);
//                dispatcher = request.getRequestDispatcher("client/assets/page/customer/customerHome.jsp");
//                LoginServlet.checkLogin =true;
//                dispatcher.forward(request,response);
//                return;
//            }
        request.setAttribute("message","Sai tài khoản hoặc mật khẩu!!");
        dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request,response);
    }
}
