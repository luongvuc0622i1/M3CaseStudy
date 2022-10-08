package controller.clients;

import model.Deal;
import model.Tag;
import service.IService;
import service.deal.DealService;
import service.tag.ITagService;
import service.tag.TagService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TagServlet", value = "/tags")
public class TagServlet extends HttpServlet {

    ITagService tagService = new TagService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            default:
                listTag(request, response);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            default:
                listTag(request, response);
                break;
        }
    }

    private void listTag(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Tag> tagList = tagService.fillAll();
        request.setAttribute("tags", tagList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/page/category.jsp");
        dispatcher.forward(request,response);


    }
}
