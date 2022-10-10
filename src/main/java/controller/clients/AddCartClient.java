package controller.clients;

import model.BillDetail;
import model.Client;
import service.billDetail.BillDetailService;
import service.client.ClientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddCarClient" , value ="/add")
public class AddCartClient {
    private ClientServlet clientServlet;
    public void init1(){
        clientServlet =new ClientServlet();
    }
    private BillDetailService billDetailService =new BillDetailService();
    private ClientService clientService;
    public void init(){
        clientService=new ClientService();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String addCart=request.getParameter("addCart");
        if(addCart==null){
            addCart="";
        }
        try{
            switch (addCart){
                case "delete":
                    deleteCart(request,response);
                    break;
                case "add":

                    break;
            }
        }catch (SQLException e){
            throw new ServletException(e);
        }
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        String addCart=request.getParameter("addCart");
        if(addCart==null){
            addCart="";
        }
//        try{
        switch (addCart){
            default:
                try {
                    listAddCart(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
//        }
    }
    private void listAddCart(HttpServletRequest request,HttpServletResponse response)
            throws SQLException,IOException,ServletException{
        List<BillDetail> billDetailList = billDetailService.fillAll();
        request.setAttribute("",billDetailList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("client/page/client/listCart.jsp");
        dispatcher.forward(request,response);
    }
    private void deleteCart(HttpServletRequest request,HttpServletResponse response)
            throws SQLException,IOException,ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        clientService.delete(id);
        List<Client> clientList = clientService.fillAll();
        request.setAttribute("listClient", clientList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/page/client/listCart.jsp");
        dispatcher.forward(request, response);
    }

}
