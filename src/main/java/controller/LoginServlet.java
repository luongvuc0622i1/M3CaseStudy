package controller;

import model.Admin;
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
    static boolean checkLogin = false;

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
        String account = request.getParameter("account");
//        LoginServlet.account = account;
        String password = request.getParameter("password");
//        RequestDispatcher dispatcher;
//        request.setAttribute("deals",dealService.fillAll());
//        request.setAttribute("categories",categoryService.fillAll());
//        request.setAttribute("shops",shopService.fillAll());
//        request.setAttribute("items",itemService.fillAll());
//        request.setAttribute("message","Hoặc đăng nhập bằng tài khoản của bạn");
        for (Admin admin: admins) {
            if (admin.getAccount().equals(account) && admin.getPassword().equals(password)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/client/assets/page/admin/adminHome.jsp");
                LoginServlet.checkLogin = true;
                dispatcher.forward(request,response);
                return;
            }
//            if (customers.get(i).getCustomer_account().equals(account)
//                    && customers.get(i).getCustomer_password().equals(password)){
//                LoginServlet.USER_ACCOUNT = account;
//                request.setAttribute("account",account);
//                dispatcher = request.getRequestDispatcher("client/assets/page/customer/customerHome.jsp");
//                LoginServlet.checkLogin =true;
//                dispatcher.forward(request,response);
//                return;
//            }
        }
//        request.setAttribute("message","Sai tài khoản hoặc mật khẩu!!");
//        dispatcher = request.getRequestDispatcher("client/assets/page/login.jsp");
//        dispatcher.forward(request,response);
    }
}
