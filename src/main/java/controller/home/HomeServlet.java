package controller.home;

import service.deal.DealService;
import service.deal.IDealService;
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

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "showByTag":
//                    showByTag(request, response);
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

    private void showHome(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/client/assets/page/home.jsp");

        request.setAttribute("deals",dealService.fillAll());
        request.setAttribute("tags",tagService.fillAll());
//        request.setAttribute("shops",shopService.fillAll());
//        request.setAttribute("foods",foodService.fillAll());
//        request.setAttribute("services",serviceService.fillAll());
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "...":
//                    ...(request, response);
                break;
            default:
//                    showHome(request, response);
                break;
        }
    }
}
