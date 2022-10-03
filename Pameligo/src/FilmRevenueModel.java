/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vergman
 */
import java.util.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.*;
import java.sql.*;
public class FilmRevenueModel extends AbstractTableModel {
public static final int YEAR=0;
public static final int MONTH=1;
public static final int FILM_REVENUE=2;
public String columnNames[]={"Year","Month","Film_revenue"};
public List<FilmRevenue> filmrevenue;
public FilmRevenueModel(List<FilmRevenue> film_revenue){
filmrevenue=film_revenue;
}
public int getColumnCount(){
return columnNames.length;
}
public int getRowCount(){
return filmrevenue.size();
}
public String getColumnName(int col){
return columnNames[col];
}
public Object getValueAt(int row,int col){
FilmRevenue temp=filmrevenue.get(row);
switch(col){
    case YEAR:
        return temp.Year;
    case MONTH:
        return temp.Month;
    case FILM_REVENUE:
        return temp.Film_revenue;
    default:
        return temp.Film_revenue;
}

}
}
