package controller;

import controller.login.LoginServlet;
import model.Food;
import model.Order;
import service.food.FoodService;
import service.food.IFoodService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddFoodToCartServlet", value = "/addToCart")
public class AddFoodToCartServlet extends HttpServlet {

    IFoodService foodService = new FoodService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        request.setAttribute("account", LoginServlet.account);
        switch (action) {
            case "delete":
                deleteOrder(request, response);
                break;
            case "addOrder":
                addOrder(request, response);
                break;
        }
    }

    private void addOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        double sum = 0;
        int quantity = 1;
        int id;
        request.setAttribute("account", LoginServlet.account);
        if (request.getParameter("food_id")!=null){
            id = Integer.parseInt(request.getParameter("food_id"));
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
            response.sendRedirect("/client/assets/page/client/clientCart.jsp");
        }
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("order");
        if (order!=null){
            order.getFood().remove(order.getFood().size()-1);
            session.setAttribute("order",order);
        }
        request.setAttribute("account", LoginServlet.account);
        response.sendRedirect("/client/assets/page/client/clientCart.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        request.setAttribute("account", LoginServlet.account);
    }
}
