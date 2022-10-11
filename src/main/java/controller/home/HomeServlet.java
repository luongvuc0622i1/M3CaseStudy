package controller.home;

import model.Food;
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
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    private IDealService dealService = new DealService();
    private ITagService tagService = new TagService();
    private IShopService shopService = new ShopService();

    private IFoodService foodService = new FoodService();

    private IServiceService serviceService = new ServiceService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "showAllTag":
                    showAllTag(request, response);
                    break;
                case "showByTag":
                    showByTag(request, response);
                    break;
//                case "listItem":
//                    listItem(request, response);
//                    break;
                case "find":
                    showFind(request, response);
                    break;
                default:
                    showHome(request, response);
                    break;
            }
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("items", foodService.fillAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/find.jsp");
        dispatcher.forward(request, response);
    }

    private void listItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchFood = request.getParameter("searchFood");
        List<Food> foods = foodService.selectFoodByName(searchFood);
        request.setAttribute("foods", foods);
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/find.jsp");
        dispatcher.forward(request, response);
    }

    private void showAllTag(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/client/listFoodSearchByTag.jsp");
        request.setAttribute("foods", foodService.fillAll());
        dispatcher.forward(request, response);
    }

    private void showByTag(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/client/listFoodSearchByTag.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("foods", foodService.findAllFoodByIdTag(id));
        dispatcher.forward(request, response);
    }

    private void showHome(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/assets/page/home.jsp");

        request.setAttribute("deals", dealService.fillAll());
        request.setAttribute("tags", tagService.fillAll());
        request.setAttribute("shops", shopService.fillAll());
        request.setAttribute("foods", foodService.fillAll());
        request.setAttribute("services", serviceService.fillAll());
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showByTag":
                showByTag(request, response);
                break;
            case "find":
                showFind(request, response);
                break;
            case "listItem":
                listItem(request, response);
                break;
            default:
                showHome(request, response);
                break;
        }
    }
}
