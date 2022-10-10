package controller.shop;

import model.Food;
import model.Shop;
import model.Tag;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/shop")
public class ShopServlet extends HttpServlet {

    ITagService tagService = new TagService();
    private IFoodService foodService = new FoodService();

//    request.setAttribute("food", request.getAttribute("food"));
//        request.setAttribute("foodList", request.getAttribute("foodList"));


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("shop",request.getAttribute("shop"));
        session.setAttribute("foodList",request.getAttribute("foodList"));
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
        HttpSession session = request.getSession();
        session.setAttribute("shop",request.getAttribute("shop"));
        session.setAttribute("foodList",request.getAttribute("foodList"));
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
//        List<Food> foods = foodService.fillAll();
////        request.setAttribute("foods", foods);
////        request.setAttribute("shop", request.getAttribute("shop"));
////        request.setAttribute("foodList", request.getAttribute("foodList"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/client/assets/page/shop/shopHome.jsp");
        dispatcher.forward(request, response);
    }

    private void showFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/find.jsp");
        request.setAttribute("foods",foodService.fillAll());
        dispatcher.forward(request,response);
    }


    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int item_id = Integer.parseInt(request.getParameter("id"));
        Food food = this.foodService.findById(item_id);
        request.setAttribute("food",food);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/testShop/createTest.jsp");
        dispatcher.forward(request,response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/testShop/createTest.jsp");
        request.setAttribute("tags", tagService.fillAll());
        dispatcher.forward(request, response);
    }



    private void searchFood(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = new String(request.getParameter("search").getBytes("iso-8859-1"),"utf-8");
//        String name = request.getParameter("search");
        List<Food> items = foodService.selectFoodByName(name);

        request.setAttribute("items",items);
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/find.jsp");
        dispatcher.forward(request,response);
    }

    private void deleteFood(HttpServletRequest request, HttpServletResponse response) throws   SQLException, ServletException, IOException {
        int food_id = Integer.parseInt(request.getParameter("food_id"));
        foodService.delete(food_id);
        List<Food> foods = foodService.fillAll();
        request.setAttribute("foods",foods);
        RequestDispatcher dispatcher = request.getRequestDispatcher("test/home.jsp");
        dispatcher.forward(request,response);
    }

    private void editFood(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int food_id = Integer.parseInt(request.getParameter("food_id"));
        int shop_id = Integer.parseInt(request.getParameter("shop_id"));
        int tag_id = Integer.parseInt(request.getParameter("tags_id"));
        int deal_id = Integer.parseInt(request.getParameter("deal_id"));
        String food_name = new String(request.getParameter("food_name").getBytes("iso-8859-1"),"utf-8");
        double food_price = Double.parseDouble(request.getParameter("food_price"));
        String food_description = new String(request.getParameter("food_description").getBytes("iso-8859-1"),"utf-8");
        String food_image = new String(request.getParameter("food_image").getBytes("iso-8859-1"),"utf-8");
        Time food_cooktime = Time.valueOf(request.getParameter("food_cooktime"));
        Date food_daycreate = java.sql.Date.valueOf(request.getParameter("food_daycreate"));
        Date food_lastupdate = java.sql.Date.valueOf(request.getParameter("food_lastupdate"));
        int status = Integer.parseInt(request.getParameter("status"));

        Food food = new Food(shop_id, tag_id, deal_id, food_name, food_description, food_image, food_price, food_cooktime, (java.sql.Date) food_daycreate, (java.sql.Date) food_lastupdate, status);
        foodService.edit(food_id, food);

        request.setAttribute("message", "Đã sửa thành công");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/testShop/createTest.jsp");
        dispatcher.forward(request,response);
    }

    private void createFood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int shop_id = Integer.parseInt(request.getParameter("shop_id"));
            int tag_id = Integer.parseInt(request.getParameter("tags_id"));
            int deal_id = Integer.parseInt(request.getParameter("deal_id"));
            String food_name = new String(request.getParameter("food_name").getBytes("iso-8859-1"),"utf-8");
            double food_price = Double.parseDouble(request.getParameter("food_price"));
            String food_description = new String(request.getParameter("food_description").getBytes("iso-8859-1"),"utf-8");
            String food_image = new String(request.getParameter("food_image").getBytes("iso-8859-1"),"utf-8");
            String scooktime = request.getParameter("food_cooktime");
            Time food_cooktime = Time.valueOf(scooktime);
            Date food_daycreate = java.sql.Date.valueOf(request.getParameter("food_daycreate"));
            Date food_lastupdate = java.sql.Date.valueOf(request.getParameter("food_lastupdate"));
            int status = Integer.parseInt(request.getParameter("status"));

            request.setAttribute("tags", tagService.fillAll());
            Food food = new Food(shop_id, tag_id, deal_id, food_name, food_description, food_image, food_price, food_cooktime, (java.sql.Date) food_daycreate, (java.sql.Date) food_lastupdate, status);
            int tags = Integer.parseInt(request.getParameter("listTag"));
            for (Tag t:tagService.fillAll()
                 ) {
                if (t.getId()==tags)

                    foodService.save(food, t);
                break;
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher("/testShop/createTest.jsp");
        dispatcher.forward(request, response);
    }
}
