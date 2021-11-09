package com.shopping;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
       Sql_Operation s=new Sql_Operation();
        Operations_Order operations_order = new Operations_Order();
        Operations_Suppliers operationsSuppliers = new Operations_Suppliers();
        Scanner sc=new Scanner(System.in);
        int ch1=0;
        do {
            System.out.println("1.Order..\n2.Supplier..\n3.Product..\n0.Exit..\nEnter Choice");
            ch1= sc.nextInt();
            switch (ch1)
            {
                case 1:int ch = 0;
                    do {
                        System.out.println("1:Add Order..\n2:Delete Order..\n3:View Order..\n4:Update Order..\n0:Exit..\nEnter Your Choice..");
                        ch = sc.nextInt();
                        switch (ch) {
                            case 1:
                                operations_order.insert_func();
                                break;
                            case 2:
                                operations_order.delete_func();
                                break;
                            case 3:
                                operations_order.select_fun();
                                break;
                            case 4:
                                operations_order.update_func();
                                break;
                            case 0:
                                break;

                            default:
                                System.out.println("Wrong Input...");

                        }
                    } while (ch != 0);
                    break;
                case 2:
                    do {
                    System.out.println("1:Add Supplier..\n2:Delete Supplier..\n3:View Supplier..\n4:Update Supplier..\n0:Exit..\nEnter Your Choice..");
                    ch = sc.nextInt();
                    switch (ch) {
                        case 1:
                            operationsSuppliers.insert_func();
                            break;
                        case 2:
                            operationsSuppliers.delete_func();
                            break;
                        case 3:
                            operationsSuppliers.select_fun();
                            break;
                        case 4:
                            operationsSuppliers.update_func();
                            break;
                        case 0:
                            break;

                        default:
                            System.out.println("Wrong Input...");

                    }
                } while (ch != 0);
                    break;
                case 3:
                    do {
                        System.out.println("1:Insert Product..\n2:Delete Product..\n3:View Product..\n4:Update Product..\n0:Exit..\nEnter Your Choice..");
                        ch = sc.nextInt();
                        switch (ch) {
                            case 1:
                                s.Insert();
                                break;
                            case 2:
                                s.Delete();
                                break;
                            case 3:
                                s.GetData();
                                break;
                            case 4:
                                s.Update();
                                break;
                            case 0:
                                break;

                            default:
                                System.out.println("Wrong Input...");

                        }
                    } while (ch != 0);
                    break;
            }



        }while (ch1!=0);
    }
}
