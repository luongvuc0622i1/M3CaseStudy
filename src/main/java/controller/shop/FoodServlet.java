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
import java.sql.Time;
import java.util.Date;
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
                    deleteFood(request,response);
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


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try{
            switch (action){
                case "create":
                    createFood(request,response);
                    break;
                case "edit":
                    editFood(request, response);
                    break;
                case "delete":
                    deleteFood(request,response);
                    break;
                case "find":
                    searchFood(request,response);
                    break;
                case "listFood":
                    listFood(request, response);
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


    private void showEdit(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/createTest.jsp");
        request.setAttribute("tags", tagService.fillAll());
        dispatcher.forward(request, response);
    }



    private void searchFood(HttpServletRequest request, HttpServletResponse response) {

    }

    private void deleteFood(HttpServletRequest request, HttpServletResponse response) {

    }

    private void editFood(HttpServletRequest request, HttpServletResponse response) {

    }

    private void createFood(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        int shop_id = Integer.parseInt(request.getParameter("shop_id"));
        int tag_id = Integer.parseInt(request.getParameter("tags_id"));
        int deal_id = Integer.parseInt(request.getParameter("deal_id"));
        String food_name = new String(request.getParameter("food_name").getBytes("iso-8859-1"),"utf-8");
        double food_price = Double.parseDouble(request.getParameter("item_price"));
        String food_description = new String(request.getParameter("food_description").getBytes("iso-8859-1"),"utf-8");
        String item_image = new String(request.getParameter("item_image").getBytes("iso-8859-1"),"utf-8");
        Time food_cooktime = Time.valueOf(request.getParameter("food_cooktime"));
        Date food_daycreate = java.sql.Date.valueOf(request.getParameter("food_daycreate"));
        Date food_lastupdate = java.sql.Date.valueOf(request.getParameter("food_lastupdate"));
        int status = Integer.parseInt(request.getParameter("status"));
    }
}
