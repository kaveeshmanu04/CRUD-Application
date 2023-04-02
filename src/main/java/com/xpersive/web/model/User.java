package com.xpersive.web.model;

import com.xpersive.web.db.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User(String name,String email){
        this.name = name;
        this.email = email;

    }

    public static List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        Connection connection = null;

        try {
            connection = DBconnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `user`");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                User user = new User(rs.getInt("id"),rs.getString("name"),rs.getString("email"));
                users.add(user);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return users;

    }

    public static User getUser(int id){
        User user = null;
        Connection connection;

        try{
            connection = DBconnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `user` WHERE `id` =" + id);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                user  = new User(rs.getInt("id"),rs.getString("name"),rs.getString("email"));

            }


        }catch(Exception ex){
            ex.printStackTrace();

        }
        return user;

    }

    public static void deleteUser(int id) {
        Connection connection = null;

        try {
            connection = DBconnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM `user` WHERE `id`=?");

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addUser() {
        Connection connection = null;

        try {
            connection = DBconnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO `user`(`name`,`email`) VALUES (?,?)");

            stmt.setString(1, this.name);
            stmt.setString(2, this.email);

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser() {
        Connection connection = null;

        try {
            connection = DBconnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE user SET name=?, email=? WHERE id=?");

            stmt.setString(1, this.name);
            stmt.setString(2, this.email);
            stmt.setInt(3, this.id);
            stmt.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
