package com.shopping;

public class Query_Order {

        String select = "Select * from Order";
        String insert = "insert into Inventory.Order(Order_Id,Cust_Id,Order_Date,Dilvery_Date,Qty,Rate,Amount,Status) values(?,?,?,?,?,?,?,?)";
        String update = "Update Inventory.Order set Qty = ? where Order_Id =?";
        String delete = "DELETE FROM Inventory.Order  WHERE Order_Id=?";

}
