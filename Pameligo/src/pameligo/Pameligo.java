/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pameligo;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author vergman
 */
public class Pameligo {
private static final String DB_URL = "jdbc:mariadb://localhost:3306/neo";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            //database connection
        Connection con=DriverManager.getConnection(DB_URL,"root","");
        // create statement
        
        Statement erotima=con.createStatement();
        //execute query
        ResultSet synolo=erotima.executeQuery("select * from series_rental");
        //traverse results
        
        while(synolo.next()){
        System.out.println(synolo.getString("rental_id")+ "|" +synolo.getString("rental_date")+"|"+synolo.getString("inventory_id")+"|"+synolo.getString("customer_id")+"|"+synolo.getString("episode"));
        }
        

        String stored="call Monthly_Revenue()";
        CallableStatement call_monthly_revenue=con.prepareCall(stored);
        call_monthly_revenue.execute();
        ResultSet apotelesma=call_monthly_revenue.getResultSet();
        System.out.println("Year|Month|Film_revenue");
         while(apotelesma.next()){
        System.out.println(apotelesma.getString("Year")+ "|" +apotelesma.getString("Month")+"|"+apotelesma.getString("film_revenue"));
        }
         //
         System.out.print("\n");
         System.out.println("Year|Month|Series_revenue");
         call_monthly_revenue.getMoreResults();
         ResultSet apotelesma2=call_monthly_revenue.getResultSet();
           while(apotelesma2.next()){
        System.out.println(apotelesma2.getString("Year")+ "|" +apotelesma2.getString("Month")+"|"+apotelesma2.getString("series_revenue"));
        }
        }
        
        catch(SQLException ex){
        ex.printStackTrace();
        
        }
        
    }
    
}

