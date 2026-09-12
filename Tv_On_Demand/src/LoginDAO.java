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
public class LoginDAO {
public static final String DB_URL = "jdbc:mariadb://localhost:3306/neo";
private Connection myConn;
public LoginDAO() throws Exception{
myConn=DriverManager.getConnection(DB_URL,"root","");
    
}
public String CheckUsername(String xristis) throws Exception{
try{
PreparedStatement myStmt=null;
ResultSet myRs=null;
myStmt=myConn.prepareStatement("SELECT EXISTS(SELECT * FROM customer WHERE email=?) as run");
myStmt.setString(1,xristis);
myRs=myStmt.executeQuery();
int result=0;
while(myRs.next()){
result=myRs.getInt("run");
//System.out.println(result);
}
if(result==1){
return "Customer";
}
PreparedStatement myStmt2=myConn.prepareStatement("SELECT EXISTS(SELECT * FROM Employee WHERE email=?) as run");
myStmt2.setString(1,xristis);
ResultSet myRs2=myStmt2.executeQuery();
while(myRs2.next()){
result=myRs2.getInt("run");
//System.out.println(result);
}
if(result==1){
return "Employee";
}
PreparedStatement myStmt3=myConn.prepareStatement("SELECT EXISTS(SELECT * FROM Administrator WHERE email=?) as run");
myStmt3.setString(1,xristis);
ResultSet myRs3=myStmt3.executeQuery();
while(myRs3.next()){
result=myRs3.getInt("run");
//System.out.println(result);
}
if(result==1){
return "Administrator";
}
}
catch(Exception e){
e.printStackTrace();
}
return "Default";
}
public static void main(String[] args) throws Exception{
LoginDAO dao=new LoginDAO();
System.out.println(dao.CheckUsername("georgekalogirou@gmail.com"));
/*
if(elenxos.equals("Customer")){
System.out.println("pelaths");
}
else if(elenxos.equals("Administrator")){
System.out.println("ADMIN");
}
else if(elenxos.equals("Employee")){
System.out.println("Employee");
}
else{
System.out.println("other");
}
*/

}

}