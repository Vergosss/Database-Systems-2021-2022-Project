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
import javax.swing.table.AbstractTableModel;
public class SeriesRevenueModel extends AbstractTableModel{
public static final int YEAR=0;
public static final int MONTH=1;
public static final int SERIES_REVENUE=2;
public String columnNames[]={"Year","Month","Series_revenue"};
public List<SeriesRevenue> seriesrevenue;
public SeriesRevenueModel(List<SeriesRevenue> series_revenue){
seriesrevenue=series_revenue;
}
public int getColumnCount(){
return columnNames.length;
}
public int getRowCount(){
return seriesrevenue.size();
}
public String getColumnName(int col){
return columnNames[col];
}
public Object getValueAt(int row,int col){
SeriesRevenue temp=seriesrevenue.get(row);
switch(col){
    case YEAR:
        return temp.Year;
    case MONTH:
        return temp.Month;
    case SERIES_REVENUE:
        return temp.Series_revenue;
    default:
        return temp.Series_revenue;
}

}    
}
