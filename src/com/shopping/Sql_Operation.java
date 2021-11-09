package com.shopping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Sql_Operation extends Helper {
    Scanner sc = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Helper h=new Helper();
    Queries q=new Queries();
    Connection con;
    public void Insert() throws IOException {
        int P_Rate;

        String P_Name,P_Id,S_Id,P_Description;
        System.out.println("Enter Product Id:- ");
         P_Id= reader.readLine();
        System.out.println("Enter Product Rate:- ");
        P_Rate=sc.nextInt();
        System.out.println("Enter Product Name:- ");
        P_Name= reader.readLine();
        System.out.println("Enter Product Description:- ");
        P_Description=reader.readLine();
        System.out.println("Enter Supplier Id:- ");
         S_Id= reader.readLine();
        con=h.GetConnection();
        try {
            PreparedStatement pr;
            pr=con.prepareStatement(q.Insert);
            pr.setString(1,P_Id);
            pr.setString(2,P_Name);
            pr.setInt(3,P_Rate);
            pr.setString(4,P_Description);
            pr.setString(5,S_Id);
            int Row_Inserted=pr.executeUpdate();
            System.out.println("Row Inserted.."+Row_Inserted);
            h.Connection_Close();



        }
        catch (Exception e)
        {
            System.out.println("Error ..."+ e);
        }
        finally {
            h.Connection_Close();
        }

    }
    public void GetData()
    {

        try {
            con=h.GetConnection();
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(q.Select);
            while (result.next()) {
                System.out.println( "Product_ID = "+ result.getString("Product_Id")
                        + " " + "Product_Name = "+result.getString("Product_Name")
                        + " " + "Product_Price = "+ result.getInt("Product_Rate")
                        + " " + "Supplier_ID = "+result.getString("Supplier_Id"));
            }



        }
        catch (Exception e)
        {
            System.out.println("Error..."+e);
        }
        finally {
            h.Connection_Close();
        }

    }
    public void Update()
    {

        try {
            con=h.GetConnection();
            System.out.println("Enter Product_Id....");
            String T_Id = sc.nextLine();
            System.out.println("Enter Price to Change....");
            int T_Rate = sc.nextInt();
            PreparedStatement pr = null;
            pr = con.prepareStatement(q.Update);
            pr.setInt(1, T_Rate);
            pr.setString(2,T_Id);
            int s = pr.executeUpdate();
            System.out.println("Row Updated:- " + s);


        }
        catch (Exception e)
        {
            System.out.println("Error..."+e);
        }
        finally {
            h.Connection_Close();
        }

    }
    public void Delete()
    {

        try {
            con=h.GetConnection();
            System.out.println("Enter Product_Id to Delete....");
            String T_Id = sc.nextLine();
            PreparedStatement pr = null;
            pr = con.prepareStatement(q.Delete);
            pr.setString(1,T_Id);
            int s = pr.executeUpdate();
            System.out.println("Row Deleted:- " + s);


        }
        catch (Exception e)
        {
            System.out.println("Error..."+e);
        }
        finally {
            h.Connection_Close();
        }

    }
}
