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
public class SeriesRevenueDAO {
public static final String DB_URL = "jdbc:mariadb://localhost:3306/neo";
public Connection myConn;
public SeriesRevenueDAO() throws Exception{
myConn=DriverManager.getConnection(DB_URL,"root","");
}  
public List<SeriesRevenue> getMonthlySeriesRevenue() throws Exception{
List<SeriesRevenue> pliromes= new ArrayList<>();
String stored="{call Monthly_revenue()}";
try{
CallableStatement callrevenue=myConn.prepareCall(stored);
ResultSet myRs1=callrevenue.executeQuery();
callrevenue.getMoreResults();
ResultSet myRs2=callrevenue.getResultSet();
while(myRs2.next()){
SeriesRevenue temp=convertRowtoSeriesRevenue(myRs2);
pliromes.add(temp);
}

}
catch(Exception e){
e.printStackTrace();
}
return pliromes;

}
public SeriesRevenue convertRowtoSeriesRevenue(ResultSet myRs) throws SQLException{
int Year=myRs.getInt("Year");
int Month=myRs.getInt("Month");
float Series_revenue=myRs.getFloat("Series_revenue");
SeriesRevenue temp=new SeriesRevenue(Year,Month,Series_revenue);
return temp;
}

}
