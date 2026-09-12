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
public class EmployeeDAO {
public static final String DB_URL = "jdbc:mariadb://localhost:3306/neo";
public Connection myConn;
public EmployeeDAO() throws Exception{
myConn=DriverManager.getConnection(DB_URL,"root","");    
} 
//
public void addSeason(int idseries,String releaseyear,int numberofepisodes) throws Exception{
PreparedStatement myStmt=null;
try{
myStmt=myConn.prepareStatement("insert into season(id_series,release_year,number_of_episodes) values(?,?,?)");
myStmt.setInt(1,idseries);
myStmt.setString(2,releaseyear);
myStmt.setInt(3,numberofepisodes);
int row=myStmt.executeUpdate();
}
catch(Exception e){
e.printStackTrace();
}


}
//
public void addSeriesCategory(int seriesid,int categoryid) throws Exception{
PreparedStatement myStmt=null;
try{
myStmt=myConn.prepareStatement("insert into series_category(series_id,category_id) values(?,?)");
myStmt.setInt(1,seriesid);
myStmt.setInt(2,categoryid);
int row=myStmt.executeUpdate();
}
catch(Exception e){
e.printStackTrace();
}



}
//
public void addFilmCategory(int filmid,int categoryid) throws Exception{
PreparedStatement myStmt=null;
try{
myStmt=myConn.prepareStatement("insert into film_category(film_id,category_id) values(?,?)");
myStmt.setInt(1,filmid);
myStmt.setInt(2,categoryid);
int row=myStmt.executeUpdate();
}
catch(Exception e){
e.printStackTrace();
}


}
//
public void addSeriesActor(int actorid,int seriesid) throws Exception{
PreparedStatement myStmt=null;
try{
myStmt=myConn.prepareStatement("insert into series_actor(actor_id,series_id) values(?,?)");
myStmt.setInt(1,actorid);
myStmt.setInt(2,seriesid);
int row=myStmt.executeUpdate();
}
catch(Exception e){
e.printStackTrace();
}

}
//
public void addFilmActor(int actorid,int filmid) throws Exception{
PreparedStatement myStmt=null;
try{
myStmt=myConn.prepareStatement("insert into film_actor(actor_id,film_id) values(?,?)");
myStmt.setInt(1,actorid);
myStmt.setInt(2,filmid);
int row=myStmt.executeUpdate();
}
catch(Exception e){
e.printStackTrace();
}
}
//
public void addSeriestoInventory(int seriesid) throws Exception{
PreparedStatement myStmt=null;
try{
myStmt=myConn.prepareStatement("insert into series_inventory(series_id) values(?)");
myStmt.setInt(1,seriesid);
int row=myStmt.executeUpdate();
}
catch(Exception e){
e.printStackTrace();
}

}
//
public void addFilmtoInventory(int filmid) throws Exception{
PreparedStatement myStmt=null;
try{
myStmt=myConn.prepareStatement("insert into film_inventory(film_id) values(?)");
myStmt.setInt(1,filmid);
int row=myStmt.executeUpdate();
}
catch(Exception e){
e.printStackTrace();
}
}
//
public void AddCountry(String country) throws Exception{
PreparedStatement myStmt=null;
try{
myStmt=myConn.prepareStatement("insert into country(country) values(?)");
myStmt.setString(1,country);
int row=myStmt.executeUpdate();
}
catch(Exception e){

}

}
//
public void AddCity(String city,int countryid) throws Exception{
PreparedStatement myStmt=null;
try{
myStmt=myConn.prepareStatement("insert into city(city,country_id) values(?,?)");
myStmt.setString(1, city);
myStmt.setInt(2,countryid);
int row=myStmt.executeUpdate();
}
catch(Exception e){
e.printStackTrace();
}

}
//
public void AddAddress(String address,String district,int cityid,String postalcode,String phone) throws Exception{
PreparedStatement myStmt=null;
try{
myStmt=myConn.prepareStatement("insert into address(address,district,city_id,postal_code,phone) values(?,?,?,?,?)");
myStmt.setString(1,address);
myStmt.setString(2,district);
myStmt.setInt(3, cityid);
myStmt.setString(4,postalcode);
myStmt.setString(5,phone);
int row=myStmt.executeUpdate();
}
catch(Exception e){
e.printStackTrace();
}

}
//
public void AddActor(String firstname,String lastname) throws Exception{
PreparedStatement myStmt=null;
try{
myStmt=myConn.prepareStatement("INSERT INTO actor(first_name,last_name) values(?,?)");
myStmt.setString(1, firstname);
myStmt.setString(2,lastname);
int row=myStmt.executeUpdate();
}
catch(Exception e){

}
}
//
public void AddSeries(String title,String description,int langid,int orlangid,String releaseyear,String specialfeatures,String rating,int numberofseasons) throws Exception{
PreparedStatement myStmt=null;
try{
myStmt=myConn.prepareStatement("INSERT INTO Series(title,description,language_id,original_language_id,release_year,special_features,rating,number_of_seasons) values(?,?,?,?,?,?,?,?)");
myStmt.setString(1,title);
myStmt.setString(2,description);
myStmt.setInt(3, langid);
myStmt.setInt(4,orlangid);
myStmt.setString(5,releaseyear);
myStmt.setString(6,specialfeatures);
myStmt.setString(7, rating);
myStmt.setInt(8,numberofseasons);
int row=myStmt.executeUpdate();
}
catch(Exception e){
e.printStackTrace();
}

}
//
public void AddCategory(String category) throws Exception{
PreparedStatement myStmt=null;
try{
myStmt=myConn.prepareStatement("INSERT INTO category(name) values(?)");
myStmt.setString(1,category);
int row=myStmt.executeUpdate();
}
catch(Exception e){
e.printStackTrace();
}
}
//
public void AddFilm(String title,String description,String releaseyear,int languageid,int originallanguageid,int length,String rating,String specialfeatures) throws Exception{
PreparedStatement myStmt=null;
try{
myStmt=myConn.prepareStatement("INSERT INTO film(title,description,release_year,language_id,original_language_id,length,rating,special_features) VALUES(?,?,?,?,?,?,?,?)");
myStmt.setString(1,title);
myStmt.setString(2,description);
myStmt.setString(3, releaseyear);
myStmt.setInt(4,languageid);
myStmt.setInt(5,originallanguageid);
myStmt.setInt(6,length);
myStmt.setString(7,rating);
myStmt.setString(8,specialfeatures);
int row=myStmt.executeUpdate();
}
catch(Exception e){
e.printStackTrace();
}

}
//
public void AddLanguage(String lang) throws Exception{
PreparedStatement myStmt=null;
try{
myStmt=myConn.prepareStatement("INSERT INTO language(name) values(?)");
myStmt.setString(1, lang);
int row=myStmt.executeUpdate();
}
catch(Exception e){
e.printStackTrace();
}

}

//
public void UpdateCustomer(String email,int id,String firstname,String lastname,int addressid,int active,String createdate,String subtype,String updatedby) throws Exception{
PreparedStatement myStmt=null;
try{
myStmt=myConn.prepareStatement("UPDATE customer set customer_id=?,first_name=?,last_name=?,address_id=?,active=?,create_date=?,subscription_type=?,updated_by=? where email=?");
myStmt.setInt(1,id);
myStmt.setString(2,firstname);
myStmt.setString(3,lastname);
myStmt.setInt(4,addressid);
myStmt.setInt(5,active);
myStmt.setString(6,createdate);
myStmt.setString(7,subtype);
myStmt.setString(8,updatedby);
myStmt.setString(9,email);
int row=myStmt.executeUpdate();
}
catch(Exception e){
e.printStackTrace();
}




}
//
public List<Employee> getEmployee(String search){
List<Employee> list=new ArrayList<>();
PreparedStatement myStmt=null;
ResultSet myRs=null;
try{
myStmt=myConn.prepareStatement("select * from Employee where email=?");
myStmt.setString(1, search);
myRs=myStmt.executeQuery();
while(myRs.next()){
Employee temp=convertRowtoEmployee(myRs);
list.add(temp);
}
}
catch(Exception e){
e.printStackTrace();
}
return list;

}
//
public Employee convertRowtoEmployee(ResultSet myRs) throws SQLException{
int employee_id=myRs.getInt("employee_id");
String first_name=myRs.getString("first_name");
String last_name=myRs.getString("last_name");
String email=myRs.getString("email");
Timestamp create_date=myRs.getTimestamp("create_date");
int address_id=myRs.getInt("address_id");
Employee ipalilos=new Employee(employee_id,first_name,last_name,email,create_date,address_id);
return ipalilos;
}
//
public void eisagogiEmployee(List<Admin> diaxeiristis){
Admin adm=diaxeiristis.get(0);
String first_name=adm.getFirstName();
String last_name=adm.getLastName();
String email=adm.getEmail();
int address_id=adm.getAddressId();
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
myStmt=myConn.prepareStatement("INSERT INTO Employee(first_name,last_name,email,create_date,address_id) VALUES (?,?,?,?,?)");
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


//
public void InsertEmployee(String firstname,String lastname,String email,int addressid){
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
myStmt=myConn.prepareStatement("INSERT INTO Employee(first_name,last_name,email,create_date,address_id) VALUES (?,?,?,?,?)");
myStmt.setString(1,firstname);
myStmt.setString(2,lastname);
myStmt.setString(3,email);
myStmt.setString(4,date);
myStmt.setInt(5,addressid);
int row=myStmt.executeUpdate();
}
catch(Exception e){
e.printStackTrace();
}

}
//
public void DeleteEmployee(String delete){
PreparedStatement myStmt=null;
try{
myStmt=myConn.prepareStatement("DELETE FROM Employee WHERE email=?");
myStmt.setString(1, delete);
int row=myStmt.executeUpdate();

}
catch(Exception e){
e.printStackTrace();

}
}
}
