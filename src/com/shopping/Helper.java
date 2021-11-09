package com.shopping;

import java.sql.Connection;
import java.sql.DriverManager;

public class Helper {
    Credentials cd=new Credentials();
    public Connection GetConnection()
    {
        try {


            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Shopping?characterEncoding=utf8", cd.user, cd.pass);
            System.out.println("Connection Successfull");
            return  con;
        }
        catch (Exception e)
        {
            System.out.println("Errorr..." + e);
        }

        return null;
    }
    public void Connection_Close()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Shopping?characterEncoding=utf8", "root", "password");
            con.close();
            System.out.println("Connection Close....");
        }
        catch (Exception e)
        {
            System.out.println("Error.." + e);
        }
        }
}
