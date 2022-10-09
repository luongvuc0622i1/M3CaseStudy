package controller.login;

import model.*;
import service.admin.AdminService;
import service.admin.IAdminService;
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

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private IAdminService adminService = new AdminService();
    private IShopService shopService = new ShopService();
    private IFoodService foodService = new FoodService();
    private IClientService clientService = new ClientService();
    private IDealService dealService = new DealService();
    private ITagService tagService = new TagService();
    private IServiceService serviceService = new ServiceService();

    public static String account ="";
    private static boolean checkLogin = false;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "addFood":
                addFood(request,response);
                break;
            default:
                showLogin(request,response);
                break;
        }
    }

    private void addFood(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        request.setAttribute("foods",foodService.fillAll());
//        request.setAttribute("account", account);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/client/assets/page/client/clientCart.jsp");
//        dispatcher.forward(request,response);

        double sum = 0;
        int quantity = 1;
        int id;
        request.setAttribute("account", LoginServlet.account);
        if (request.getParameter("id")!=null){
            id = Integer.parseInt(request.getParameter("id"));
            Food food = foodService.findById(id);
            request.setAttribute("account", LoginServlet.account);
            if (food != null){
                if (request.getParameter("food_quantity")!=null){
                    quantity = Integer.parseInt(request.getParameter("food_quantity"));
                }
                HttpSession session = request.getSession();
                if (session.getAttribute("order")==null){
                    Order order = new Order();
                    List<Food> itemList = new ArrayList<>();
                    order.setQuantityFood(quantity);
                    itemList.add(food);
                    order.setFood(itemList);
                    sum=food.getPrice();

                    session.setAttribute("total",sum);
                    session.setAttribute("order",order);
                    session.setAttribute("quantity",quantity);
                } else {
                    Order order = (Order) session.getAttribute("order");
                    List<Food> foods = order.getFood();
                    boolean check = false;
                    for (Food food1 : foods){
                        if (food1.getId() == food.getId()){
                            order.setQuantityFood(order.getQuantityFood() + quantity);
                            check = true;
                        }
                    }
                    if (check == false){
                        order.setQuantityFood(quantity);
                        Food food1 = new Food();
                        foods.add(food1);
                    }

                    session.setAttribute("order",order);
                    session.setAttribute("total",sum);
                }
            }
            request.setAttribute("account", LoginServlet.account);
            response.sendRedirect("client/assets/page/client/clientCart.jsp");

        }else {
            request.setAttribute("account", LoginServlet.account);
            response.sendRedirect("client/assets/page/client/clientCart.jsp");
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
            case "addFood":
                addFood(request,response);
                break;
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
                    request.setAttribute("deals",dealService.fillAll());
                    request.setAttribute("tags",tagService.fillAll());
                    request.setAttribute("shops",shopService.fillAll());
                    request.setAttribute("foods",foodService.fillAll());
                    request.setAttribute("services",serviceService.fillAll());
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
