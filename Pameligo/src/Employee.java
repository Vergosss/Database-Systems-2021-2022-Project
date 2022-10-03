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
public class Employee {
public int employee_id;
public String first_name;
public String last_name;
public String email;
public Timestamp create_date;
public int address_id;
public Employee(int employee_id,String first_name,String last_name,String email,Timestamp create_date,int address_id){
super();
this.employee_id=employee_id;
this.first_name=first_name;
this.last_name=last_name;
this.email=email;
this.create_date=create_date;
this.address_id=address_id;
}
public int getEmployeeId(){
return this.employee_id;
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
public Timestamp getCreateDate(){
return this.create_date;

}
public int getAddressId(){
return this.address_id;
}
}
