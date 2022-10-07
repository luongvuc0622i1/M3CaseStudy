package controller.clients;

import connection.ConnectionCMS;
import controller.HomeServlet;
import service.client.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name="ClientServlet",value = "/homeClient")
public class ClientServlet extends HttpServlet {
    private Connection connection= ConnectionCMS.getConnection();
    private HomeServlet homeServlet;
    private SearchCartClient searchCartClient=new SearchCartClient();


    public void init(){
        homeServlet=new HomeServlet();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String action =request.getParameter("action");
        if(action==null){
            action="";
        }
//        try{
            switch (action){
                case "search":
                    searchCartClient.doGet(request,response);
                    //searchHome
                    break;
                case "addCart":
                    //addCart;
                    break;
            }
//        }catch (SQLException e){
//            throw new ServletException(e);
//        }
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
//        try{
            switch (action){
//                case "search":
                    //showSearchFrom;
//                    homeServlet.doGet(request,response);
//                    break;
                default:
                    homeServlet.doGet(request,response);
                    break;
            }
        }
//        catch (SQLException e){
//            throw new ServletException(e);
//        }
//    }

}
