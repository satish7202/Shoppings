package com.shopping;

public class Queries {
    String Insert = "INSERT INTO `Shopping`.`Products` (`Product_Id`, `Product_Name`, `Product_Rate`, `Product_Description`, `Supplier_Id`) VALUES ((?), (?), (?), (?), (?));";
    String Select = "Select * From  `Shopping`.`Products`";
    String Update = "UPDATE `Shopping`.`Products` SET `Product_Rate`=(?) WHERE `Product_Id`=(?)";
    String Delete = "DELETE FROM `Shopping`.`Products` WHERE (`Product_Id` = (?));";
}
