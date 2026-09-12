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
public class FilmRentalModel  extends AbstractTableModel {
public static final int RENTAL_ID=0;
public static final int RENTAL_DATE=1;
public static final int INVENTORY_ID=2;
public static final int CUSTOMER_ID=3;
public static final int CREATED_BY=4;
public static final int UPDATED_BY=5;
public String[] columnNames={"rental_id","rental_date","inventory_id","customer_id","created_by","updated_by"};
public List<Film_rental> film_rentals;
public FilmRentalModel(List<Film_rental> films_rentals){
film_rentals=films_rentals;
}
public int getColumnCount(){
return columnNames.length;
}
public int getRowCount(){
return film_rentals.size();
}
public String getColumnName(int col){
return columnNames[col];
}
public Object getValueAt(int row,int col){
Film_rental temp=film_rentals.get(row);
switch(col){
    case RENTAL_ID:
        return temp.getRentalId();
    case RENTAL_DATE:
        return temp.getRentalDate();
    case INVENTORY_ID:
        return temp.getInventoryId();
    case CUSTOMER_ID:
        return temp.getCustomerId();
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
