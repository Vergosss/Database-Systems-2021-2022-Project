/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vergman
 */
//import javax.swing.*;
import java.util.*;
import java.time.*;
import java.sql.*;
public class FilmRevenueDAO  {
public static final String DB_URL = "jdbc:mariadb://localhost:3306/neo";
public Connection myConn;
public FilmRevenueDAO() throws Exception{
myConn=DriverManager.getConnection(DB_URL,"root","");
}
public List<FilmRevenue> getMonthlyFilmRevenue() throws Exception{
List<FilmRevenue> pliromes= new ArrayList<>();
String stored="{call Monthly_revenue()}";
try{
CallableStatement callrevenue=myConn.prepareCall(stored);
ResultSet myRs1=callrevenue.executeQuery();
while(myRs1.next()){
FilmRevenue temp=convertRowtoFilmRevenue(myRs1);
pliromes.add(temp);
}

}
catch(Exception e){
e.printStackTrace();
}
return pliromes;

}
public FilmRevenue convertRowtoFilmRevenue(ResultSet myRs) throws SQLException{
int Year=myRs.getInt("Year");
int Month=myRs.getInt("Month");
float Film_revenue=myRs.getFloat("Film_revenue");
FilmRevenue temp=new FilmRevenue(Year,Month,Film_revenue);
return temp;
}


}
