package controller.shop;

import model.Food;
import model.Shop;
import model.Tag;
import service.deal.DealService;
import service.deal.IDealService;
import service.food.FoodService;
import service.food.IFoodService;
import service.shop.IShopService;
import service.shop.ShopService;
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
     static String account;
     static String password;
     static int shopId;

    private ITagService tagService = new TagService();
    private IDealService dealService = new DealService();
    private IFoodService foodService = new FoodService();
    private IShopService shopService = new ShopService();

    @Override
    public void init() throws ServletException {

    }

    @Override
    public void destroy() {
        System.out.println("ngu vcllllll");
    }

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
                case "info":
                    shopInfo(request,response);
                    break;
                case "editInfo":
                    shopEditInfoView(request,response);
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


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        account = (String) session.getAttribute("shopAcc");
        password = (String) session.getAttribute("pass");
        shopId = (int) session.getAttribute("shopId");
        String action = request.getParameter("action");
        String add = request.getParameter("food_name");
        String updateShop = request.getParameter("shop_name");
        if (updateShop != null){
            shopEditInfo(request,response);
        }
        if (add != null){
            createFoodLite(request,response);
        }
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
        Shop shop = shopService.findById(shopId);
        List<Food> foods = foodService.findAllFoodByIdShop(shopId);
////        request.setAttribute("foods", foods);
        request.setAttribute("shop", shop);
        request.setAttribute("foodList", foods);

//        RequestDispatcher dispatcher = request.getRequestDispatcher("/client/assets/page/shop/shopHome.jsp");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/client/assets/page/shop/shopHome.jsp");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("shop?action=listFood");
        dispatcher.forward(request, response);
        System.out.println(password + account+shopId);
    }

    private void showFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/find.jsp");
        request.setAttribute("foods",foodService.fillAll());
        dispatcher.forward(request,response);
    }
    private void shopInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Shop shop = shopService.findById(shopId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/shop/shopInfo.jsp");
        request.setAttribute("shop", shop);
        dispatcher.forward(request,response);
    }
    private void shopEditInfoView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Shop shop = shopService.findById(shopId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/shop/shopEditInfo.jsp");
        request.setAttribute("shop", shop);
        dispatcher.forward(request,response);
    }
    private void shopEditInfo(HttpServletRequest request, HttpServletResponse response){
        try {
            String shop_name = new String(request.getParameter("shop_name").getBytes("iso-8859-1"),"utf-8");
            String shop_email = new String(request.getParameter("shop_email").getBytes("iso-8859-1"),"utf-8");
            String shop_address = new String(request.getParameter("shop_address").getBytes("iso-8859-1"),"utf-8");
            String shop_phone = new String(request.getParameter("shop_phone").getBytes("iso-8859-1"),"utf-8");
            String shop_image = new String(request.getParameter("shop_image"));
            String shop_description = new String(request.getParameter("shop_description").getBytes("iso-8859-1"),"utf-8");;
            Shop s = new Shop(1,null,null,null,shop_name,shop_email,shop_phone,shop_address,null,null,shop_image,shop_description,null);
            shopService.edit(shopId,s);
//            for (Tag t:tagService.fillAll()
//            ) {
//                if (t.getId()==tags)
//
//                    foodService.save(food, t);
//                break;
//            }
        } catch (UnsupportedEncodingException | SQLException e) {
            throw new RuntimeException(e);
        }
    }




    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int item_id = Integer.parseInt(request.getParameter("id"));
        Food food = this.foodService.findById(item_id);
        request.setAttribute("food",food);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/testShop/createTest.jsp");
        dispatcher.forward(request,response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/shop/shopCreatFood.jsp");
        request.setAttribute("tags", tagService.fillAll());
        request.setAttribute("deals", dealService.fillAll());
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
        int food_id = Integer.parseInt(request.getParameter("id"));
        foodService.delete(food_id);
//        List<Food> food = foodService.fillAll();
//        request.setAttribute("food",food);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/client/assets/page/shop/shopHome.jsp");
//        dispatcher.forward(request,response);
        listFood(request,response);
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
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher("/testShop/createTest.jsp");
        dispatcher.forward(request, response);
    }
    private void createFoodLite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
//            int shop_id = Integer.parseInt(request.getParameter("shop_id"));
            int tag_id = Integer.parseInt(request.getParameter("tags_id"));
            int deal_id = Integer.parseInt(request.getParameter("deal_id"));
            String food_name = new String(request.getParameter("food_name").getBytes("iso-8859-1"),"utf-8");
            double food_price = Double.parseDouble(request.getParameter("food_price"));
            String food_description = new String(request.getParameter("food_description").getBytes("iso-8859-1"),"utf-8");
            String food_image = new String(request.getParameter("food_img"));
            String scooktime = request.getParameter("food_cooktime");
            Time food_cooktime = Time.valueOf(scooktime);
//            Date food_daycreate = java.sql.Date.valueOf(request.getParameter("food_daycreate"));
//            Date food_lastupdate = java.sql.Date.valueOf(request.getParameter("food_lastupdate"));
//            int status = Integer.parseInt(request.getParameter("status"));

            request.setAttribute("tags", tagService.fillAll());
            Food food = new Food(shopId, tag_id, deal_id, food_name, food_description, food_image, food_price, food_cooktime, null, null, 1);
//            int tags = Integer.parseInt(request.getParameter("listTag"));
            foodService.save(food,tagService.findById(tag_id));
//            for (Tag t:tagService.fillAll()
//            ) {
//                if (t.getId()==tags)
//
//                    foodService.save(food, t);
//                break;
//            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/client/assets/page/shop/shopHome.jsp");
//        dispatcher.forward(request, response);
//        listFood(request,response);
    }
}
