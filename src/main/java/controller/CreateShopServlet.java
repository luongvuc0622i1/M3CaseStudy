package controller;

import controller.login.LoginServlet;
import model.Service;
import model.Shop;
import service.shop.IShopService;
import service.shop.ShopService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;

import static java.lang.Integer.parseInt;

@WebServlet(name = "CreateShopServlet", value = "/createShop")
public class CreateShopServlet extends HttpServlet {
    private static final int CREATE_STATUS = 1;
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
        try {
            switch (action) {
                case "reset":
                    showCreateShop(request, response);
                    break;
                case "submit":
                    createShop(request, response);
                    break;
                default:
                    showCreateShop(request, response);
                    break;
            }
        } catch (ParseException e) {
                e.printStackTrace();
        }
    }

    private void createShop(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        String account = request.getParameter("account");
        LoginServlet.account = account;
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int oHour = parseInt(request.getParameter("open"));
        Time open = new Time(oHour, 00, 00);
        int cHour = parseInt(request.getParameter("close"));
        Time close = new Time(cHour, 00, 00);
        String image = request.getParameter("image");
        String description = request.getParameter("description");
        int status = CREATE_STATUS;
        Service service = null;

        Shop shop = new Shop(status, open, close, name, email, phone, address, account, password, image, description, service);
        shopService.insert(shop);
        request.setAttribute("account", account);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/client/assets/page/shop/shopHome.jsp");
        request.setAttribute("message", "New shop was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
