package controller.home;

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
                case "showByTag":
                    showByTag(request, response);
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

    private void showByTag(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
        RequestDispatcher dispatcher = request.getRequestDispatcher("testShop/listFoodSearchByTag.jsp");
=======
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/page/tag.jsp");
>>>>>>> 09662607b53f478d27f868c329f307110c573fd5

//        request.setAttribute("tags",tagService.fillAll());
//        request.setAttribute("shops",shopService.fillAll());
        request.setAttribute("foods",foodService.fillAll());
        dispatcher.forward(request,response);
    }

    private void showHome(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/client/assets/page/home.jsp");

        request.setAttribute("deals",dealService.fillAll());
        request.setAttribute("tags",tagService.fillAll());
        request.setAttribute("shops",shopService.fillAll());
        request.setAttribute("foods",foodService.fillAll());
        request.setAttribute("services",serviceService.fillAll());
        dispatcher.forward(request,response);
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
            default:
                    showHome(request, response);
                break;
        }
    }
}
