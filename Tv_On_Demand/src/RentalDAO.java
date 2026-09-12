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
public class RentalDAO {
public static final String DB_URL = "jdbc:mariadb://localhost:3306/neo";
private Connection myConn;
public RentalDAO() throws Exception{
myConn=DriverManager.getConnection(DB_URL,"root","");

}
//
public void InsertSeriesrental(String username,int inventoryid,int episode,String created_by){
PreparedStatement myStmt=null;
Statement stmt=null;
ResultSet rs=null;
String date="";
int customerid=0;
PreparedStatement nea=null;
ResultSet neors=null;
try{
stmt=myConn.createStatement();
rs=stmt.executeQuery("select date(now()) as run");
while(rs.next()){
date=rs.getString("run");
}
nea=myConn.prepareStatement("select customer_id from customer where email=?");
nea.setString(1,username);
neors=nea.executeQuery();
while(neors.next()){
customerid=neors.getInt("customer_id");
}
myStmt=myConn.prepareStatement("INSERT INTO series_rental(rental_date,inventory_id,customer_id,episode,created_by) VALUES(?,?,?,?,?)");
myStmt.setString(1, date);
myStmt.setInt(2,inventoryid);
myStmt.setInt(3,customerid);
myStmt.setInt(4,episode);
myStmt.setString(5,created_by);
int row=myStmt.executeUpdate();
}
catch(Exception e){
e.printStackTrace();
}


}
//
public List<Series_rental> getSeriesRentals(String xristis) throws Exception{
List<Series_rental> list=new ArrayList<>();
PreparedStatement myStmt1=null;
ResultSet myRs1=null;
PreparedStatement myStmt2=null;
ResultSet myRs2=null;
int id=0;
try{
myStmt1=myConn.prepareStatement("select customer_id from customer where email=?");
myStmt1.setString(1, xristis);
myRs1=myStmt1.executeQuery();
while(myRs1.next()){
id=myRs1.getInt("customer_id");
}
myStmt2=myConn.prepareStatement("select * from series_rental where customer_id=?");
myStmt2.setInt(1,id);
myRs2=myStmt2.executeQuery();
while(myRs2.next()){
Series_rental temp=convertRowToSeries_rental(myRs2);
list.add(temp);
}
}
catch(Exception e){
e.printStackTrace();
}
return list;
}
public List<Series_rental> getAllSeriesRentals() throws Exception{
List<Series_rental> list=new ArrayList<>();
Statement myStmt=null;
ResultSet myRs=null;
try{
myStmt=myConn.createStatement();
myRs=myStmt.executeQuery("select * from series_rental");
while(myRs.next()){
Series_rental temp=convertRowToSeries_rental(myRs);
list.add(temp);
}
//for(Series_rental x:list){
//System.out.println(x.rental_id+"|"+x.rental_date.toString()+"|"+x.customer_id +"|"+x.inventory_id+"|"+x.episode);
return list;
//}
}
finally{
close(myStmt,myRs);
}
}

private Series_rental convertRowToSeries_rental(ResultSet myRs) throws
        SQLException{
int rental_id=myRs.getInt("rental_id");
Timestamp rental_date=myRs.getTimestamp("rental_date");
int inventory_id=myRs.getInt("inventory_id");
int customer_id=myRs.getInt("customer_id");
int episode=myRs.getInt("episode");
String created_by=myRs.getString("created_by");
String updated_by=myRs.getString("updated_by");
Series_rental temp=new Series_rental(rental_id,rental_date,inventory_id,customer_id,episode,created_by,updated_by);
return temp;
}
private static void close(Connection myConn,Statement myStmt,ResultSet myRs) throws SQLException
{
if(myRs!=null){
myRs.close();
}
if(myStmt!=null){

}
if(myConn!=null){
myConn.close();
}

}
private void close(Statement myStmt,ResultSet myRs) throws SQLException{
close(null,myStmt,myRs);
}
public static void main(String[] args) throws Exception{
RentalDAO dao=new RentalDAO();
List<Series_rental> x=dao.getAllSeriesRentals();
for(Series_rental y :x){
System.out.println(y.rental_id+"|"+(y.rental_date).toString()+"|"+y.inventory_id+"|"+y.customer_id+"|"+y.episode);

}

}

}
