/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vergman
 */
import java.util.*;
import java.sql.*;
import javax.swing.table.AbstractTableModel;
public class RentalModel  extends AbstractTableModel {
public static final int RENTAL_ID=0;
public static final int RENTAL_DATE=1;
public static final int INVENTORY_ID=2;
public static final int CUSTOMER_ID=3;
public static final int EPISODE=4;
public static final int CREATED_BY=5;
public static final int UPDATED_BY=6;

public String[] columnNames={"rental_id","rental_date","inventory_id","customer_id","episode","created_by","updated_by"};
public List<Series_rental> series_rentals;
public RentalModel(List<Series_rental> seires_rentals){
series_rentals=seires_rentals;
}
public int getColumnCount(){
return columnNames.length;
}
public int getRowCount(){
return series_rentals.size();
}
public String getColumnName(int col){
return columnNames[col];
}
public Object getValueAt(int row,int col){
Series_rental temp=series_rentals.get(row);
switch(col){
    case RENTAL_ID:
        return temp.getRentalId();
    case RENTAL_DATE:
        return temp.getRentalDate();
    case INVENTORY_ID:
        return temp.getInventoryId();
    case CUSTOMER_ID:
        return temp.getCustomerId();
    case EPISODE:
        return temp.getEpisode();
    case CREATED_BY:
        return temp.getCreatedBy();
    case UPDATED_BY:
        return temp.getUpdatedBy();
    default:
        return temp.getRentalId();

}

}
/*
public Class getColumnClass(int c){
return getValueAt(0,c).getClass();
}
*/


}
