package com.xpersive.web;

import com.xpersive.web.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "update", value = "/update")
public class UpdateUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = User.getUser(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("user",user);
            req.getRequestDispatcher("update.jsp").forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        if (name.isBlank()) {
            System.out.println("Name required");
            resp.sendRedirect("add.jsp");
        } else if (email.isBlank()) {
            System.out.println("Email required");
            resp.sendRedirect("add.jsp");
        } else {
            User user = new User(id,name, email);
            try {
                user.updateUser();
                resp.sendRedirect("list");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
