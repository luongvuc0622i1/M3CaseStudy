package controller.clients;

import model.Deal;
import model.Food;
import service.deal.DealService;
import service.deal.IDealService;
import service.food.FoodService;
import service.food.IFoodService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DealShopServlet", value = "/dealShops")
public class DealFoodServlet extends HttpServlet {
    IFoodService itemService = new FoodService();
    IDealService dealService = new DealService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        List<Food> foodList = itemService.findAllFoodByIdDeal(id);
        Deal deal = dealService.findById(id);
        req.setAttribute("deal", deal);
        req.setAttribute("foods", foodList);
        req.getRequestDispatcher("client/assets/page/customer/foodDeal.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}