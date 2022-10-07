package controller.clients;

import model.Client;
import service.client.ClientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddCarClient" , value ="/client")
public class AddCartClient {
    private ClientServlet clientServlet;
    public void init1(){
        clientServlet =new ClientServlet();
    }

    private ClientService clientService;
    public void init(){
        clientService=new ClientService();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        String addCart=request.getParameter("addCArt");
        if(addCart==null){
            addCart="";
        }
        try{
            switch (addCart){
                case "delete":
                    deleteClient(request,response);
                    break;
                case "add":
                    break;
            }
        }catch (SQLException e){
            throw new ServletException(e);
        }
    }
    private void deleteClient(HttpServletRequest request,HttpServletResponse response)
    throws SQLException,IOException,ServletException {
        int id=Integer.parseInt(request.getParameter("id"));
        clientService.delete(id);
        List<Client> clientList=clientService.fillAll();
        request.setAttribute("listClient",clientList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("");
        dispatcher.forward(request,response);
    }
}
