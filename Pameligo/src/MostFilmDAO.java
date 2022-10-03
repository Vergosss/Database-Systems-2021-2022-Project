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
public class MostFilmDAO {
public static final String DB_URL = "jdbc:mariadb://localhost:3306/neo";
public Connection myConn;
public MostFilmDAO() throws Exception{
myConn=DriverManager.getConnection(DB_URL,"root","");    
}
public List<MostFilm> getMostFilms() throws Exception{
List<MostFilm> lista=new ArrayList<>();
Statement myStmt1=myConn.createStatement();
Statement myStmt2=myConn.createStatement();
ResultSet myRs1=null;
ResultSet myRs2=null;
String run1="re";
String run2="sd";
String mostfilms="{call N_th_most_rentals(?,?,?,?)}";
try{
myRs1=myStmt1.executeQuery("select last_day(curdate()- interval 2 month) + interval 1 day as run1");
while(myRs1.next()){
run1=myRs1.getString("run1");
}
myRs2=myStmt2.executeQuery("select last_day(curdate() -interval 1 month) as run2");
while(myRs2.next()){
run2=myRs2.getString("run2");
}
CallableStatement callmostfilms=myConn.prepareCall(mostfilms);
callmostfilms.setString(1,"m");
callmostfilms.setInt(2,5);
callmostfilms.setString(3,run1);
callmostfilms.setString(4,run2);
ResultSet myRs3=callmostfilms.executeQuery();
while(myRs3.next()){
MostFilm temp=convertRowtoMostFilm(myRs3);
lista.add(temp);
}
}
catch(Exception e){
e.printStackTrace();
}
return lista;
}
public MostFilm convertRowtoMostFilm(ResultSet myRs) throws SQLException{
int film_id=myRs.getInt("film_id");
int TOTAL=myRs.getInt("TOTAL");
MostFilm neo=new MostFilm(film_id,TOTAL);
return neo;
}

}
