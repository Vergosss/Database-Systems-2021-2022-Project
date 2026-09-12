

import javax.swing.*;
import java.util.*;
import java.time.*;
import java.sql.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vergman
 */
public class CustomerDAO {
public static final String DB_URL = "jdbc:mariadb://localhost:3306/neo";
public Connection myConn;
public CustomerDAO() throws Exception{
myConn=DriverManager.getConnection(DB_URL,"root","");

}

public List<Customer> getCustomers() throws Exception{
List<Customer> list=new ArrayList<>();
Statement myStmt=null;
ResultSet myRs=null;
try{
myStmt=myConn.createStatement();
myRs=myStmt.executeQuery("select * from customer");
while(myRs.next()){
Customer temp=convertRowToCustomer(myRs);
list.add(temp);
}
}
catch(Exception e){
e.printStackTrace();
}
return list;
}
//
public void DeleteCustomer(String delete){
PreparedStatement myStmt=null;
try{
myStmt=myConn.prepareStatement("DELETE FROM customer WHERE email=?");
myStmt.setString(1, delete);
int row=myStmt.executeUpdate();

}
catch(Exception e){
e.printStackTrace();

}

}
//
public void UpdateInfo(String email,String firstname,String lastname,int addressid,int active,String updatedby) throws Exception{
PreparedStatement myStmt=null;
//Statement stmt=null;
//ResultSet rs=null;
try{
myStmt=myConn.prepareStatement("UPDATE customer set first_name=?,last_name=?,address_id=?,active=?,updated_by=? where email=?");
myStmt.setString(1,firstname);
myStmt.setString(2,lastname);
myStmt.setInt(3,addressid);
myStmt.setInt(4,active);
myStmt.setString(5,updatedby);
myStmt.setString(6,email);
int row=myStmt.executeUpdate();
}
catch(Exception e){
e.printStackTrace();
}

}
//
public void UpdateSubscription(String username,String type) throws Exception{
PreparedStatement myStmt=null;
//Statement stmt=null;
//ResultSet rs=null;
String date="";
try{
    /*
stmt=myConn.createStatement();
rs=stmt.executeQuery("select date(now()) as run");
while(rs.next()){
date=rs.getString("run");
}
*/
myStmt=myConn.prepareStatement("UPDATE customer set subscription_type=?,updated_by=? where email=?");
myStmt.setString(1,type);
myStmt.setString(2,username);
myStmt.setString(3,username);
int row=myStmt.executeUpdate();
}
catch(Exception e){
e.printStackTrace();
}
}
//
public void InsertCustomer(String first_name,String last_name,String email,int address_number,String subscription_type,String created_by) throws Exception{
PreparedStatement myStmt=null;
Statement stmt=null;
ResultSet rs=null;
String date="";
try{
stmt=myConn.createStatement();
rs=stmt.executeQuery("select now() as run");
while(rs.next()){
date=rs.getString("run");
}
myStmt=myConn.prepareStatement("INSERT INTO customer(first_name,last_name,email,address_id,create_date,subscription_type,created_by) VALUES(?,?,?,?,?,?,?)");
myStmt.setString(1,first_name);
myStmt.setString(2,last_name);
myStmt.setString(3,email);
myStmt.setInt(4,address_number);
myStmt.setString(5,date);
myStmt.setString(6,subscription_type);
myStmt.setString(7,created_by);
int row =myStmt.executeUpdate();

}
catch(Exception e){
e.printStackTrace();
}


}
//
public List<Customer> getCustomer(String xristis){
List<Customer> list=new ArrayList<>();
PreparedStatement myStmt=null;
ResultSet myRs=null;
try{
myStmt=myConn.prepareStatement("select * from customer where email=?");
myStmt.setString(1, xristis);
myRs=myStmt.executeQuery();
while(myRs.next()){
Customer temp=convertRowToCustomer(myRs);
list.add(temp);
}
}
catch(Exception e){
e.printStackTrace();
}
return list;

}
public Customer convertRowToCustomer(ResultSet myRs) throws
        SQLException{
int customer_id=myRs.getInt("customer_id");
String first_name=myRs.getString("first_name");
String last_name=myRs.getString("last_name");
String email=myRs.getString("email");
int address_id=myRs.getInt("address_id");
int active=myRs.getInt("active");
Timestamp create_date=myRs.getTimestamp("create_date");
String subscription_type=myRs.getString("subscription_type");
String created_by=myRs.getString("created_by");
String updated_by=myRs.getString("updated_by");
Customer temp=new Customer(customer_id,first_name,last_name,email,address_id,active,create_date,subscription_type,created_by,updated_by);
return temp;
}



}
