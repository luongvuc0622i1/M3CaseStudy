package controller.clients;

import connection.ConnectionCMS;
import controller.HomeServlet;
import model.Bill;
import model.Client;
import model.Service;
import model.Shop;
import service.bill.BillService;
import service.client.ClientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="ClientServlet",value = "/client")
public class ClientServlet extends HttpServlet {
    private static final String DELETE_CLIENT_SQL="DELETE FROM client WHERE id=?;";
    private Connection connection= ConnectionCMS.getConnection();

    private HomeServlet homeServlet;
    private SearchCartClient searchCartClient=new SearchCartClient();
    private BillService billService =new BillService();

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
                    try {
                        addCart(request,response);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
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
    private void addCart(HttpServletRequest request,HttpServletResponse response)
     throws SQLException,IOException,ServletException {
                String code = request.getParameter("bill_code");
                Date date = Date.valueOf(request.getParameter("bill_date"));
                Double totalCost= Double.valueOf(request.getParameter("totalCost"));
                int client_id= Integer.parseInt(request.getParameter("client_id"));
                int shop_id= Integer.parseInt(request.getParameter("shop_id"));
                int status= Integer.parseInt(request.getParameter("bill_status"));
                Bill bill=new Bill(code,date,totalCost,client_id,shop_id,status);
                billService.insert(bill);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("client/assets");
        requestDispatcher.forward(request,response);
    }
}
