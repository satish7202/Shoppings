package com.shopping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Operations_Order {

    public static String Order_Id;
    public static String Cust_Id;
    public static String Order_Date;
    public static String Dilvery_Date;
    public static int Quantity;
    public static int Rate;
    public static int Amount;
    public static String Status;
    Connection conn = null;

    jdbc_Connect_Class conn_obj;

    Query_Order query_Order_obj;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void insert_func() throws IOException {


        System.out.println("Enter your Order id");
        Order_Id = br.readLine();

        System.out.println("Enter your Customer id");
        Cust_Id = br.readLine();

        System.out.println("Enter your Order date");
        Order_Date = br.readLine();

        System.out.println("Enter your Dilivery date");
        Dilvery_Date = br.readLine();

        System.out.println("Enter Quantity");
        Quantity =Integer.parseInt(br.readLine());

        System.out.println("Enter Rate");
        Rate =Integer.parseInt(br.readLine());

        Amount = Quantity * Rate;
        //System.out.println(Amount);
        System.out.println("Enter your status");
        Status = br.readLine();


        try {
            conn_obj = new jdbc_Connect_Class();
            query_Order_obj = new Query_Order();
            conn = conn_obj.connect();
            PreparedStatement stmt = conn.prepareStatement(query_Order_obj.insert);

            stmt.setString(1, Order_Id);
            stmt.setString(2, Cust_Id);
            stmt.setString(3, Order_Date);
            stmt.setString(4, Dilvery_Date);
            stmt.setString(5, String.valueOf(Quantity));
            stmt.setString(6, String.valueOf(Rate));
            stmt.setString(7, String.valueOf(Amount));
            stmt.setString(8, Status);
            stmt.executeUpdate();
            System.out.println("Records inserted successfully");
            conn.close();
            System.out.println("Connection closed");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void select_fun() {
        try {
            conn_obj = new jdbc_Connect_Class();
            query_Order_obj = new Query_Order();
            conn = conn_obj.connect();
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("Select * from Inventory.Order");
            while (result.next()) {
                System.out.println(result.getString("Order_Id") + " " + result.getString("Cust_Id") + " " + result.getString("Order_Date") + " " + result.getString("Dilvery_Date") + " " + result.getString("Qty") + " " + result.getInt("Rate") + " " + result.getInt("Amount") + " " + result.getString("Status"));
            }
            conn.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update_func() throws IOException {
        System.out.println("Enter Updated Quantity");
        Quantity = Integer.parseInt(br.readLine());
        System.out.println("Enter Order Id");
        Order_Id = br.readLine();
        try {
            conn_obj = new jdbc_Connect_Class();
            query_Order_obj = new Query_Order();
            conn = conn_obj.connect();
            PreparedStatement stmt = conn.prepareStatement(query_Order_obj.update);
            stmt.setString(1, String.valueOf(Quantity));
            stmt.setString(2,  Order_Id);
            stmt.executeUpdate();
            System.out.println("Successfully updated");
            conn.close();
            System.out.println("Connection closed");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void delete_func() throws IOException {
        System.out.println("Enter Order Id that you want to delete");
        Order_Id = br.readLine();
        try {
            conn_obj = new jdbc_Connect_Class();
            query_Order_obj = new Query_Order();
            conn = conn_obj.connect();
            PreparedStatement stmt = conn.prepareStatement(query_Order_obj.delete);
            stmt.setString(1, Order_Id);
            stmt.executeUpdate();
            System.out.println("Successfully record deleted");
            conn.close();
            System.out.println("Connection closed");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
