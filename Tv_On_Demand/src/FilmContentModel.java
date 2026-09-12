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
public class FilmContentModel extends AbstractTableModel {
public static final int INVENTORY_ID=0;
public static final int FILM_ID1=1;
public static final int FILM_ID2=2;
public static final int TITLE=3;
public static final int DESCRIPTION=4;
public static final int RELEASE_YEAR=5;
public static final int LANGUAGE_ID=6;
public static final int ORIGINAL_LANGUAGE_ID=7;
public static final int LENGTH=8;
public static final int RATING=9;
public static final int SPECIAL_FEATURES=10;
public String columnNames[]={"inventory_id","film_id1","film_id2","title","description","release_year","language_id","original_language_id","length","rating","special_features"};
public List<FilmContent> film_content;
public FilmContentModel(List<FilmContent> filmcontent){
film_content=filmcontent;
}
public int getColumnCount(){
return columnNames.length;
}
public int getRowCount(){
return film_content.size();
}
public String getColumnName(int col){
return columnNames[col];
}
public Object getValueAt(int row,int col){
FilmContent temp=film_content.get(row);
switch(col){
    case INVENTORY_ID:
        return temp.getInventoryId();
    case FILM_ID1:
        return temp.getFilmId1();
    case FILM_ID2:
        return temp.getFilmId2();
    case TITLE:
        return temp.getTitle();
    case DESCRIPTION:
        return temp.getDescription();
    case RELEASE_YEAR:
        return temp.getReleaseYear();
    case LANGUAGE_ID:
        return temp.getLanguageId();
    case ORIGINAL_LANGUAGE_ID:
        return temp.getOriginalLanguageId();
    case LENGTH:
        return temp.getLength();
    case RATING:
        return temp.getRating();
    case SPECIAL_FEATURES:
        return temp.getSpecialFeatures();
    default:
        return temp.getInventoryId();
}



}

}
