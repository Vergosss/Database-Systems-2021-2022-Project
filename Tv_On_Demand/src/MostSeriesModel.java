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
public class MostSeriesModel extends AbstractTableModel {
public static final int SERIES_ID=0;
public static final int TOTAL=1;
public String columnNames[]={"series_id","TOTAL"};
public List<MostSeries> mostseries;
public MostSeriesModel(List<MostSeries> most_series){
mostseries=most_series;
}
public int getColumnCount(){
return columnNames.length;
}
public int getRowCount(){
return mostseries.size();
}
public String getColumnName(int col){
return columnNames[col];
}
public Object getValueAt(int row,int col){
MostSeries temp=mostseries.get(row);
switch(col){
    case SERIES_ID:
        return temp.series_id;
    case TOTAL:
        return temp.TOTAL;
    default:
        return temp.series_id;
    
    
}
}    
}
