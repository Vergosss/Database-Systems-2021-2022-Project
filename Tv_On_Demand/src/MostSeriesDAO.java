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
public class MostSeriesDAO {
public static final String DB_URL = "jdbc:mariadb://localhost:3306/neo";
public Connection myConn;
public MostSeriesDAO() throws Exception{
myConn=DriverManager.getConnection(DB_URL,"root","");    
}
public List<MostSeries> getMostSeries() throws Exception{
List<MostSeries> lista=new ArrayList<>();
Statement myStmt1=myConn.createStatement();
try{
ResultSet myRs1=myStmt1.executeQuery("select last_day(curdate()- interval 2 month) + interval 1 day as run1");
String run1="";
while(myRs1.next()){
run1=myRs1.getString("run1");
}
Statement myStmt2=myConn.createStatement();
ResultSet myRs2=myStmt2.executeQuery("select last_day(curdate() -interval 1 month) as run2");
String run2="";
while(myRs2.next()){
run2=myRs2.getString("run2");
}
String mostseries="{call N_th_most_rentals(?,?,?,?)}";
CallableStatement callseries=myConn.prepareCall(mostseries);
callseries.setString(1,"s");
callseries.setInt(2,5);
callseries.setString(3,run1);
callseries.setString(4,run2);
ResultSet myRs3=callseries.executeQuery();
while(myRs3.next()){
MostSeries temp=convertRowtoMostSeries(myRs3);
lista.add(temp);
}
}
catch(Exception e){
e.printStackTrace();
}
return lista;
}
public MostSeries convertRowtoMostSeries(ResultSet myRs) throws SQLException{
int series_id=myRs.getInt("series_id");
int TOTAL=myRs.getInt("TOTAL");
MostSeries neo=new MostSeries(series_id,TOTAL);
return neo;
}    
}
