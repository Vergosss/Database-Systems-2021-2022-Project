
import java.util.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.TableModel;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vergman
 */
public class CustomerModel extends AbstractTableModel {
public static final int CUSTOMER_ID=0;
public static final int FIRST_NAME=1;
public static final int LAST_NAME=2;
public static final int EMAIL=3;
public static final int ADDRESS_ID=4;
public static final int ACTIVE=5;
public static final int CREATE_DATE=6;
public static final int SUBSCRIPTION_TYPE=7;
public static final int CREATED_BY=8;
public static final int UPDATED_BY=9;

public String[] columnNames={"customer_id","first_name","last_name","email","address_id","active","create_date","subscription_type","created_by","updated_by"};
public List<Customer> customers;
public CustomerModel(List<Customer> customiers){
customers=customiers;
}
public int getColumnCount(){
return columnNames.length;
}
public int getRowCount(){
return customers.size();
}
public String getColumnName(int col){
return columnNames[col];
}
public Object getValueAt(int row,int col){
Customer temp=customers.get(row);
switch(col){
    case CUSTOMER_ID:
        return temp.getCustomerId();
    case FIRST_NAME:
        return temp.getFirstName();
    case LAST_NAME:
        return temp.getLastName();
    case EMAIL:
        return temp.getEmail();
    case ADDRESS_ID:
        return temp.getAddressId();
    case ACTIVE:
        return temp.getActive();
    case CREATE_DATE:
        return temp.getCreateDate();
    case SUBSCRIPTION_TYPE:
        return temp.getSubscriptionType();
    case CREATED_BY:
        return temp.getCreatedBy();
    case UPDATED_BY:
        return temp.getUpdated_by(); 
    default:
        return temp.getCustomerId();

}

}
/*
public Class getColumnClass(int c){
return getValueAt(0,c).getClass();
}
*/
}
