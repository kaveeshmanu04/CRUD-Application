package com.xpersive.web;

import com.xpersive.web.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "list", value = "/list")
public class ListUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<User> users = User.getAllUsers();
            req.setAttribute("users",users);
            req.getRequestDispatcher("list.jsp").forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
