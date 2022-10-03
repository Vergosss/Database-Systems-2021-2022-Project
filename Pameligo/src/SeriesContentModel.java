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
import javax.swing.table.AbstractTableModel;
public class SeriesContentModel extends AbstractTableModel {
public static final int INVENTORY_ID=0;
public static final int SERIES_ID1=1;
public static final int SERIES_ID2=2;
public static final int TITLE=3;
public static final int DESCRIPTION=4;
public static final int LANGUAGE_ID=5;
public static final int ORIGINAL_LANGUAGE_ID=6;
public static final int RELEASE_YEAR=7;
public static final int SPECIAL_FEATURES=8;
public static final int RATING=9;
public static final int NUMBER_OF_SEASONS=10;
public String columnNames[]={"inventory_id","series_id1","series_id2","title","description","language_id","original_language_id","release_year","special_features","rating","number_of_seasons"};
public List<SeriesContent> series_content;
public SeriesContentModel(List<SeriesContent> seriescontent){
series_content=seriescontent;
}
public int getColumnCount(){
return columnNames.length;
}
public int getRowCount(){
return series_content.size();
}
public String getColumnName(int col){
return columnNames[col];
}
public Object getValueAt(int row,int col){
SeriesContent temp=series_content.get(row);
switch(col){
    case INVENTORY_ID:
        return temp.getInventoryId();
    case SERIES_ID1:
        return temp.getSeriesId1();
    case SERIES_ID2:
        return temp.getSeriesId2();
    case TITLE:
        return temp.getTitle();
    case DESCRIPTION:
        return temp.getDescription();
    case LANGUAGE_ID:
        return temp.getLanguageId();
    case ORIGINAL_LANGUAGE_ID:
        return temp.getOriginalLanguageId();
    case RELEASE_YEAR:
        return temp.getReleaseYear();
    case SPECIAL_FEATURES:
        return temp.getSpecialFeatures();
    case RATING:
        return temp.getRating();
    case NUMBER_OF_SEASONS:
        return temp.getNumberOfSeasons();
    default:
        return temp.getInventoryId();
}



}
}
