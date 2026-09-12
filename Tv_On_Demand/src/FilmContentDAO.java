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
public class FilmContentDAO {
public static final String DB_URL = "jdbc:mariadb://localhost:3306/neo";
public Connection myConn;
public FilmContentDAO() throws Exception{
myConn=DriverManager.getConnection(DB_URL,"root","");    
}
public List<FilmContent> getFilmContent() throws Exception{
List<FilmContent> list=new ArrayList<>();
Statement myStmt=null;
ResultSet myRs=null;
try{
myStmt=myConn.createStatement();
myRs=myStmt.executeQuery("select * from film_inventory INNER JOIN film on film_inventory.film_id=film.film_id");
while(myRs.next()){
FilmContent temp=convertRowtoFilmContent(myRs);
list.add(temp);
}
}
catch(Exception e){
e.printStackTrace();
}
return list;

}
public FilmContent convertRowtoFilmContent(ResultSet myRs) throws SQLException{
int inventory_id=myRs.getInt("inventory_id");
int film_id1=myRs.getInt("film_id");
int film_id2=myRs.getInt("film_id");
String title=myRs.getString("title");
String description=myRs.getString("description");
Timestamp release_year=myRs.getTimestamp("release_year");
int language_id=myRs.getInt("language_id");
int original_language_id=myRs.getInt("original_language_id");
int length=myRs.getInt("length");
String rating=myRs.getString("rating");
String special_features=myRs.getString("special_features");
FilmContent temp=new FilmContent(inventory_id,film_id1,film_id2,title,description,release_year,language_id,original_language_id,length,rating,special_features);

return temp;


}




}
