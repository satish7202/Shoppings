package com.shopping;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc_Connect_Class {
    public static Connection connect(){
        Connection conn = null;
         Credentials credential_obj=new Credentials();
         String DB_URL = credential_obj.url;
         String USER = credential_obj.user;
         String PASS = credential_obj.pass;
         try{
             Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            }
        catch(Exception e){
            System.out.println("Connection Failed!");
            e.printStackTrace();
            return null;
        }
        if(conn != null){
            System.out.println("Connection working");
        }
        else
        {
            System.out.println("Connection not working");
        }
        return conn;
    }
}
