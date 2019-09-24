package edu.mum.cs.wap.project.controller;

import edu.mum.cs.wap.project.dao.UserDAO;
import edu.mum.cs.wap.project.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/manageAccount")
public class ManageAccountController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        List<User> user = new ArrayList<>();
        user.add(userDAO.loadUser());
        if (user != null) {
            request.setAttribute("userLists", user);
            request.getRequestDispatcher("/view/admin/manageAccount.jsp").forward(request, response);
            /*RequestDispatcher rd = request.getRequestDispatcher("/view/admin/manageAccount.jsp");
            rd.forward(request, response);*/
        } else {
            response.sendRedirect("/view/admin/manageAccount.jsp");
        }
        /*        request.getRequestDispatcher("/view/admin/manageAccount.jsp").forward(request, response);*/
    }
}
