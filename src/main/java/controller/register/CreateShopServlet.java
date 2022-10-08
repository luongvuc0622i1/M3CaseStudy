package controller.register;

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
        String sOpen = request.getParameter("openTime");
        Time open = Time.valueOf(sOpen);
        String sClose = request.getParameter("closeTime");
        Time close = Time.valueOf(sClose);
        String image = request.getParameter("shopImage");
        String description = request.getParameter("description");
        int status = CREATE_STATUS;
        Service service = new Service(1, 1, "dfs", "dsd");


        Shop shop = new Shop(status, open, close, name, email, phone, address, account, password, image, description, service);
        shopService.insertDefaul(shop);
        request.setAttribute("account", account);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/client/assets/page/client/clientHome.jsp");
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
