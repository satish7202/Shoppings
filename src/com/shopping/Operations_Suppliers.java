package com.shopping;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;


public class Operations_Suppliers {

    public static String City;
    public static String Suppliers_Name;
    public static String Suppliers_Id;
    public static String Phone;
    public static String Product_Id;
    public static int Quantity;
    public static int Rate;
    public static int Amount;

    Connection conn = null;

    jdbc_Connect_Class conn_obj;

    Query_Suppliers query_Suppliers_obj;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void insert_func() throws IOException {


        System.out.println("Enter your Suppliers id");
        Suppliers_Id = br.readLine();

        System.out.println("Enter your Suppliers name");
        Suppliers_Name = br.readLine();

        System.out.println("Enter your City");
        City = br.readLine();

        System.out.println("Enter your Phone");
        Phone = br.readLine();

        System.out.println("Enter your Product_ID");
        Product_Id = br.readLine();

        System.out.println("Enter Quantity");
        Quantity =Integer.parseInt(br.readLine());

        System.out.println("Enter Rate");
        Rate =Integer.parseInt(br.readLine());

        Amount = Quantity * Rate;
        System.out.println(Amount);

           try {
                conn_obj = new jdbc_Connect_Class();
                query_Suppliers_obj = new Query_Suppliers();
                conn = conn_obj.connect();
                PreparedStatement stmt = conn.prepareStatement(query_Suppliers_obj.insert);

                stmt.setString(1, Suppliers_Id);
                stmt.setString(2, Suppliers_Name);
                stmt.setString(3, City);
                stmt.setString(4, Phone);
                stmt.setString(5, Product_Id);
                stmt.setString(6, String.valueOf(Quantity));
                stmt.setString(7, String.valueOf(Rate));
                stmt.setString(8, String.valueOf(Amount));
               stmt.executeUpdate();
               System.out.println("Records inserted successfully");
               conn.close();
               System.out.println("Connection closed");
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        public void select_fun(){
            try {
                conn_obj = new jdbc_Connect_Class();
                query_Suppliers_obj = new Query_Suppliers();
                conn = conn_obj.connect();
                Statement stmt = conn.createStatement();
                ResultSet result =stmt.executeQuery(query_Suppliers_obj.select);
                while(result.next()){
                    System.out.println(result.getString("Suppliers_Id")+" "+result.getString("Suppliers_Name")+" "+result.getString("City")+" "+result.getString("Phone")+" "+result.getString("Product_Id")+" "+result.getInt("Qantity")+" "+result.getInt("Rate")+" "+result.getInt("Amount"));
                }
                conn.close();
                System.out.println("Connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            }
            public void update_func() throws IOException {
                System.out.println("Enter Updated Suppliers name");
                Suppliers_Name = br.readLine();
                System.out.println("Enter Updated Suppliers Id");
                Suppliers_Id = br.readLine();
                try {
                    conn_obj = new jdbc_Connect_Class();
                    query_Suppliers_obj = new Query_Suppliers();
                    conn = conn_obj.connect();
                    PreparedStatement stmt = conn.prepareStatement(query_Suppliers_obj.update);
                    stmt.setString(1, Suppliers_Name);
                    stmt.setString(2, Suppliers_Id);
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
                System.out.println("Enter Updated Suppliers Id");
                Suppliers_Id = br.readLine();
                try {
                    conn_obj = new jdbc_Connect_Class();
                    query_Suppliers_obj = new Query_Suppliers();
                    conn = conn_obj.connect();
                    PreparedStatement stmt = conn.prepareStatement(query_Suppliers_obj.delete);
                    stmt.setString(1, Suppliers_Id);
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
