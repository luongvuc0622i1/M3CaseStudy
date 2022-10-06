package controller;

import connection.ConnectionCMS;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name="ClientServlet",value = "/client")
public class ClientServlet extends HttpServlet {
    private Connection connection= ConnectionCMS.getConnection();
    private HomeServlet homeServlet;
    public void init(){
        homeServlet=new HomeServlet();}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String action =request.getParameter("action");
        String add=request.getParameter("add");
        if(action==null){
            action="";
        }
//        try{
            switch (action){
                case "search":
                    break;
                case "add":

                    switch (add){
                        case "more":
                            break;
                        case "edit":

                            break;
                        case "delete":

                            break;
                        default:
                            break;
                    }
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
            }
        }
//        catch (SQLException e){
//            throw new ServletException(e);
//        }
//    }
}
