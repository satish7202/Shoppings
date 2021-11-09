package com.shopping;
public class Query_Suppliers {

        String select = "Select * from Suppliers";
        String insert = "insert into Suppliers (Suppliers_Id,Suppliers_Name,City,Phone,Product_Id,Qantity,Rate,Amount) values(?,?,?,?,?,?,?,?)";
        String update = "Update Suppliers set Suppliers_Name = ? where Suppliers_Id =?";
        String delete = "DELETE FROM Suppliers  WHERE Suppliers_Id =?";

}
