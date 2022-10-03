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
public class Customer {
public int customer_id;
public String first_name;
public String last_name;
public String email;
public int address_id;
public int active;
public Timestamp create_date;
public String subscription_type;
public String created_by;
public String updated_by;
public Customer(int customer_id,String first_name,String last_name,String email,int address_id,int active,Timestamp create_date,String subscription_type,String created_by,String updated_by){
super();
this.customer_id=customer_id;
this.first_name=first_name;
this.last_name=last_name;
this.email=email;
this.address_id=address_id;
this.active=active;
this.create_date=create_date;
this.subscription_type=subscription_type;
this.created_by=created_by;
this.updated_by=updated_by;
}
public int getCustomerId(){
return this.customer_id;
}   
public String getFirstName(){
return this.first_name;
}
public String getLastName(){
return this.last_name;
}
public String getEmail(){
return this.email;
}
public int  getAddressId(){
return this.address_id;
}
public int getActive(){
return this.active;
}
public Timestamp getCreateDate(){
return this.create_date;
}
public String getSubscriptionType(){
return this.subscription_type;
}
public String getCreatedBy(){
return this.created_by;
}
public String getUpdated_by(){
return this.updated_by;
}


}
