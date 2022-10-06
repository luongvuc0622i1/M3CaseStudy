package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ShopServlet", value = "/shop")
public class ShopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
//        try {
//            switch (action) {
//                case "foodManager":
//                    showFoodManager(request, response);
//                    break;
//                case "editFood":
//                    showEditFood(request, response);
//                    break;
//                case "deleteFood":
//                    deleteFood(request, response);
//                    break;
//                default:
//                    homeShop(request, response);
//                    break;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
//        try {
//            switch (action) {
//                case "addFood":
//                    addFood(request, response);
//                    break;
//                case "edit":
//                    editFood(request, response);
//                    break;
//                case "search":
//                    searchByName(request, response);
//                    break;
//                default:
//                    homeShop(request, response);
//                    break;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
