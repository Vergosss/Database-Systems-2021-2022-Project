/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vergman
 */
import java.util.*;
import java.time.*;
import java.sql.*;
import javax.swing.*;
public class AdminDAO {
public static final String DB_URL = "jdbc:mariadb://localhost:3306/neo";
public Connection myConn;
public AdminDAO() throws Exception{
myConn=DriverManager.getConnection(DB_URL,"root","");
}
//
public List<Admin> getAdmin(String search){
List<Admin> list=new ArrayList<>();
PreparedStatement myStmt=null;
ResultSet myRs=null;
try{
myStmt=myConn.prepareStatement("select * from Administrator where email=?");
myStmt.setString(1, search);
myRs=myStmt.executeQuery();
while(myRs.next()){
Admin temp=convertRowtoAdmin(myRs);
list.add(temp);
}
}
catch(Exception e){
e.printStackTrace();
}
return list;

}//
public void DeleteAdmin(String delete){
PreparedStatement myStmt=null;
try{
myStmt=myConn.prepareStatement("DELETE FROM Administrator WHERE email=?");
myStmt.setString(1, delete);
int row=myStmt.executeUpdate();

}
catch(Exception e){
e.printStackTrace();

}
}
//
public Admin convertRowtoAdmin(ResultSet myRs) throws SQLException{
int id=myRs.getInt("id");
String first_name=myRs.getString("first_name");
String last_name=myRs.getString("last_name");
String email=myRs.getString("email");
Timestamp create_date=myRs.getTimestamp("create_date");
int address_id=myRs.getInt("address_id");
Admin neosdiax=new Admin(id,first_name,last_name,email,create_date,address_id);
return neosdiax;

}
//
public void InsertAdmin(List<Employee> ipalilos){
Employee emp=ipalilos.get(0);
String first_name=emp.getFirstName();
String last_name=emp.getLastName();
String email=emp.getEmail();
int address_id=emp.getAddressId();
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
myStmt=myConn.prepareStatement("INSERT INTO Administrator(first_name,last_name,email,create_date,address_id) VALUES (?,?,?,?,?)");
myStmt.setString(1,first_name);
myStmt.setString(2,last_name);
myStmt.setString(3,email);
myStmt.setString(4,date);
myStmt.setInt(5,address_id);
int row=myStmt.executeUpdate();
}
catch(Exception e){
e.printStackTrace();
}
}
}
