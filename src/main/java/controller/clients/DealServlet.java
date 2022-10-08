package controller.clients;

import model.Deal;
import service.IService;
import service.deal.DealService;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DealServlet", value = "/deals")
public class DealServlet extends HttpServlet {

    IService service= new DealService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            default:
                listDeal(request, response);
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
                listDeal(request, response);
                break;
        }
    }

    private void listDeal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Deal> dealList;
        dealList = service.fillAll();
        request.setAttribute("deals", dealList);
        request.getRequestDispatcher("").forward(request, response);

    }


}
