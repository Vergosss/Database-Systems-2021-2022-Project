
import java.sql.*;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vergman
 */
public class CheckTypeDAO {
public static final String DB_URL = "jdbc:mariadb://localhost:3306/neo";
private Connection myConn;
public CheckTypeDAO() throws Exception{
myConn=DriverManager.getConnection(DB_URL,"root","");
}
public String getSubType(String xristis){
PreparedStatement myStmt=null;
ResultSet myRs=null;
try{
myStmt=myConn.prepareStatement("select subscription_type from customer where email=?");
myStmt.setString(1, xristis);
myRs=myStmt.executeQuery();
String type="";
while(myRs.next()){
type=myRs.getString("subscription_type");
}
if(type.equals("Film")){
return "Film";
}
else if(type.equals("Series")){
return "Series";
}
else if(type.equals("Both")){
return "Both";
}
}
catch(Exception e){
e.printStackTrace();
}
return "";


}
    
}
