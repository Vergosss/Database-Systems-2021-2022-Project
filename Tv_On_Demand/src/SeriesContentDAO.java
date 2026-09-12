/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vergman
 */
import java.sql.*;
import java.util.*;
import java.time.*;
public class SeriesContentDAO {
public static final String DB_URL = "jdbc:mariadb://localhost:3306/neo";
public Connection myConn;
public SeriesContentDAO() throws Exception{
myConn=DriverManager.getConnection(DB_URL,"root","");    
}
public List<SeriesContent> getSeriesContent() throws Exception{
List<SeriesContent> list=new ArrayList<>();
Statement myStmt=null;
ResultSet myRs=null;
try{
myStmt=myConn.createStatement();
myRs=myStmt.executeQuery("select * from series_inventory INNER JOIN Series on series_inventory.series_id=Series.series_id");
while(myRs.next()){
SeriesContent temp=convertRowtoSeriesContent(myRs);
list.add(temp);
}
}
catch(Exception e){
e.printStackTrace();
}
return list;

}
public SeriesContent convertRowtoSeriesContent(ResultSet myRs) throws SQLException{
int inventory_id=myRs.getInt("inventory_id");
int series_id1=myRs.getInt("series_id");
int series_id2=myRs.getInt("series_id");
String title=myRs.getString("title");
String description=myRs.getString("description");
int language_id=myRs.getInt("language_id");
int original_language_id=myRs.getInt("original_language_id");
Timestamp release_year=myRs.getTimestamp("release_year");
String special_features=myRs.getString("special_features");
String rating=myRs.getString("rating");
int number_of_seasons=myRs.getInt("number_of_seasons");
SeriesContent temp=new SeriesContent(inventory_id,series_id1,series_id2,title,description,language_id,original_language_id,release_year,special_features,rating,number_of_seasons);

return temp;


}


}
