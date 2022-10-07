package controller;

import service.shop.IShopService;
import service.shop.ShopService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateShopServlet", value = "/createShop")
public class CreateShopServlet extends HttpServlet {
    private IShopService shopService = new ShopService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
//            case "create":
//                createClient(request,response);
//                break;
            default:
                showCreateShop(request,response);
                break;
        }
    }

    private void showCreateShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/client/assets/page/shop/shopSignup.jsp");
        request.setAttribute("message","Hoặc đăng nhập bằng tài khoản của bạn");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "reset":
                showCreateShop(request,response);
                break;
            case "submit":
                createShop(request,response);
                break;
            default:
                showCreateShop(request,response);
                break;
        }
    }

    private void createShop(HttpServletRequest request, HttpServletResponse response) {

    }
}
