package controller.clients;

import connection.ConnectionCMS;
import controller.HomeServlet;

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
    public void init(){
        homeServlet=new HomeServlet();}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String action =request.getParameter("action");
        if(action==null){
            action="";
        }
//        try{
            switch (action){
                case "search":
                    //searchShop
                    break;
                case "add":
                    //addKet;
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
                case "view":
                    break;
                case "search":
                    //showSearchFrom;
                    break;
                case "add":
                    //showAddFrom;
            }
        }
//        catch (SQLException e){
//            throw new ServletException(e);
//        }
//    }

}
