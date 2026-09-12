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
public class MostFilmModel extends AbstractTableModel{
public static final int FILM_ID=0;
public static final int TOTAL=1;
public String columnNames[]={"film_id","TOTAL"};
public List<MostFilm> mostfilm;
public MostFilmModel(List<MostFilm> most_film){
mostfilm=most_film;
}
public int getColumnCount(){
return columnNames.length;
}
public int getRowCount(){
return mostfilm.size();
}
public String getColumnName(int col){
return columnNames[col];
}
public Object getValueAt(int row,int col){
MostFilm temp=mostfilm.get(row);
switch(col){
    case FILM_ID:
        return temp.film_id;
    case TOTAL:
        return temp.TOTAL;
    default:
        return temp.film_id;
    
    
}
}
}
