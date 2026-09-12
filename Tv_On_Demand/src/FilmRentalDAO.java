

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vergman
 */
import java.time.*;
import java.util.*;
import java.sql.*;
public class FilmRentalDAO {
    public static final String DB_URL = "jdbc:mariadb://localhost:3306/neo";
public Connection myConn;
public FilmRentalDAO() throws Exception{
myConn=DriverManager.getConnection(DB_URL,"root","");
}
//
public void InsertFilmRental(String username,int inventoryid,String created_by){
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
myStmt=myConn.prepareStatement("INSERT INTO film_rental(rental_date,inventory_id,customer_id,created_by) VALUES(?,?,?,?)");
myStmt.setString(1, date);
myStmt.setInt(2,inventoryid);
myStmt.setInt(3,customerid);
myStmt.setString(4,created_by);
int row=myStmt.executeUpdate();
}
catch(Exception e){
e.printStackTrace();
}
}
//
public List<Film_rental> getFilmRental(String xristis){
List<Film_rental> list=new ArrayList<>();
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
myStmt2=myConn.prepareStatement("select * from film_rental where customer_id=?");
myStmt2.setInt(1,id);
myRs2=myStmt2.executeQuery();
while(myRs2.next()){
Film_rental temp=convertRowtoFilm_rental(myRs2);
list.add(temp);
}
}
catch(Exception e){
e.printStackTrace();
}
return list;
}


//
public List<Film_rental> getFilmRentals() throws Exception{
List<Film_rental> list=new ArrayList<>();
Statement myStmt=null;
ResultSet myRs=null;
try{
myStmt=myConn.createStatement();
myRs=myStmt.executeQuery("select * from film_rental");
while(myRs.next()){
Film_rental temp=convertRowtoFilm_rental(myRs);
list.add(temp);
}
}
catch(Exception e){
e.printStackTrace();
}
return list;
}
public Film_rental convertRowtoFilm_rental(ResultSet myRs) throws SQLException{
int rental_id=myRs.getInt("rental_id");
Timestamp rental_date=myRs.getTimestamp("rental_date");
int inventory_id=myRs.getInt("inventory_id");
int customer_id=myRs.getInt("customer_id");
String created_by=myRs.getString("created_by");
String updated_by=myRs.getString("updated_by");
Film_rental temp=new Film_rental(rental_id,rental_date,inventory_id,customer_id,created_by,updated_by);
return temp;
}
}
