package com.xpersive.web;

import com.xpersive.web.db.DBconnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "Servlet4", value = "/Servlet4")
public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        try {
            connection = DBconnection.getConnection();
            System.out.println(connection);

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }


}
