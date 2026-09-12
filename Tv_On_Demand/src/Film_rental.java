/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vergman
 */
import java.time.*;
import java.sql.*;
import java.util.*;
public class Film_rental {
public int rental_id;
public Timestamp rental_date;
public int inventory_id;
public int customer_id;
public String created_by;
public String updated_by;
public Film_rental(int rental_id,Timestamp rental_date,int inventory_id,int customer_id,String created_by,String updated_by){
this.rental_id=rental_id;
this.rental_date=rental_date;
this.inventory_id=inventory_id;
this.customer_id=customer_id;
this.created_by=created_by;
this.updated_by=updated_by;
}
public int getRentalId(){
return this.rental_id;
}
public Timestamp getRentalDate(){
return this.rental_date;
}
public int getInventoryId(){
return this.inventory_id;
}
public int getCustomerId(){
return this.customer_id;
}
public String getCreatedBy(){
return this.created_by;
}
public String getUpdatedBy(){
return this.updated_by;
}
}
