package com.xpersive.web;

import com.xpersive.web.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "adduser", value = "/adduser")
public class AddUser extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        if (name.isBlank()) {
            System.out.println("Name required");
            resp.sendRedirect("list");
        } else if (email.isBlank()) {
            System.out.println("Email required");
            resp.sendRedirect("list");
        } else {
            User user = new User(name, email);
            try {
                user.addUser();
                resp.sendRedirect("list");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
