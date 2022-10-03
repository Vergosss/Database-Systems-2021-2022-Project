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
public class SeriesContent {
public int inventory_id;
public int series_id1;
public int series_id2;
public String title;
public String description;
public int language_id;
public int original_language_id;
public Timestamp release_year;
public String special_features;
public String rating;
public int number_of_seasons;
public SeriesContent(int inventory_id,int series_id1,int series_id2,String title,String description,int language_id,int original_language_id,Timestamp release_year,String special_features,String rating,int number_of_seasons)
{
super();
this.inventory_id=inventory_id;
this.series_id1=series_id1;
this.series_id2=series_id2;
this.title=title;
this.description=description;
this.language_id=language_id;
this.original_language_id=original_language_id;
this.release_year=release_year;
this.special_features=special_features;
this.rating=rating;
this.number_of_seasons=number_of_seasons;
}
public int getInventoryId(){
return this.inventory_id;
}
public int getSeriesId1(){
return this.series_id1;
}
public int getSeriesId2(){
return this.series_id2;
}
public String getTitle(){
return this.title;
}
public String getDescription(){
return this.description;
}
public int getLanguageId(){
return this.language_id;
}
public int getOriginalLanguageId(){
return this.original_language_id;
}
public Timestamp getReleaseYear(){
return this.release_year;
}
public String getSpecialFeatures(){
return this.special_features;
}
public String getRating(){
return this.rating;
}
public int getNumberOfSeasons(){
return this.number_of_seasons;
}
}
