package com.xpersive.web;

import com.xpersive.web.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "delete", value = "/delete")
public class DeleteUser extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            User.deleteUser(Integer.parseInt(req.getParameter("id")));
            resp.sendRedirect("list");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
