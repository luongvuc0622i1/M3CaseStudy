package controller.register;

import controller.login.LoginServlet;
import model.Client;
import service.client.ClientService;
import service.client.IClientService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateClientServlet", value = "/createClient")
public class CreateClientServlet extends HttpServlet {
    private static final int CREATE_STATUS = 1;
    private IClientService clientService = new ClientService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
//            case "create":
//                createClient(request,response);
//                break;
            default:
                showCreateClient(request,response);
                break;
        }
    }

    private void showCreateClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/client/assets/page/client/clientSignup.jsp");
        request.setAttribute("message","Hoặc đăng nhập bằng tài khoản của bạn");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "reset":
                showCreateClient(request,response);
                break;
            case "submit":
                createClient(request,response);
                break;
            default:
                showCreateClient(request,response);
                break;
        }
    }


    private void createClient(HttpServletRequest request, HttpServletResponse response) {
        String account = request.getParameter("account");
        LoginServlet.account = account;
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int status = CREATE_STATUS;

        Client client = new Client(name, phone, address, email, account, password, status);
        clientService.insert(client);
        request.setAttribute("account", account);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/client/assets/page/client/clientHome.jsp");
        request.setAttribute("message", "New client was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
