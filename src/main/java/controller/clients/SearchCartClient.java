package controller.clients;

import connection.ConnectionCMS;
import controller.HomeServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "SearchClient",value = "search")
public class SearchCartClient extends ClientServlet {
    private Connection connection= ConnectionCMS.getConnection();
    private HomeServlet homeServlet;
    private AddCartClient addCartClient=new AddCartClient();
    public void init(){
        homeServlet=new HomeServlet();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
        String search= request.getParameter("search");
        if(search==null){
            search="";
        }
//        try{
            switch (search){
                case "searchShop":
                    homeServlet.doGet(request,response);
                    break;
            }
//        }catch (SQLException e){
//            throw new ServletException(e);
//        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String addCartFromSearch=request.getParameter("addCartFromSearch");
        if(addCartFromSearch==null){
            addCartFromSearch="";
        }
//        try {
            switch (addCartFromSearch){
                case "add":
                   addCartClient.doPost(request,response);
            }
//        }catch (SQLException e){
//            throw new ServletException(e);
//        }
    }
}
