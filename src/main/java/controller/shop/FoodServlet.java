package controller.shop;

import model.Food;
import service.food.FoodService;
import service.food.IFoodService;
import service.tag.ITagService;
import service.tag.TagService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/foods")
public class FoodServlet extends HttpServlet {

    ITagService tagService = new TagService();
    private IFoodService foodService = new FoodService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try{
            switch (action){
                case "create":
                    showCreate(request,response);
                    break;
                case "edit":
                    showEdit(request,response);
                    break;
                case "delete":
                    deleteItem(request,response);
                    break;
                case "find":
                    showFind(request,response);
                    break;
                default:
                    listFood(request,response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void listFood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Food> foods = foodService.fillAll();
        request.setAttribute("foods", foods);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/listTest.jsp");
        dispatcher.forward(request, response);
    }

    private void showFind(HttpServletRequest request, HttpServletResponse response) {

    }

    private void deleteItem(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try{
            switch (action){
                case "create":
                    showCreate(request,response);
                    break;
                case "edit":
                    showEdit(request,response);
                    break;
                case "delete":
                    deleteItem(request,response);
                    break;
                case "find":
                    showFind(request,response);
                    break;
                default:
                    listFood(request,response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchFood(HttpServletRequest request, HttpServletResponse response) {

    }

    private void deleteFood(HttpServletRequest request, HttpServletResponse response) {

    }

    private void editFood(HttpServletRequest request, HttpServletResponse response) {

    }

    private void createFood(HttpServletRequest request, HttpServletResponse response) {

    }
}
