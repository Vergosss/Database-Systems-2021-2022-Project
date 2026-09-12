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
public class FilmContent {
public int inventory_id;
public int film_id1;
public int film_id2;
public String title;
public String description;
public Timestamp release_year;
public int language_id;
public int original_language_id;
public int length;
public String rating;
public String special_features;
public FilmContent(int inventory_id,int film_id1,int film_id2,String title,String description,Timestamp release_year,int language_id,int original_language_id,int length,String rating,String special_features){
super();
this.inventory_id=inventory_id;
this.film_id1=film_id1;
this.film_id2=film_id2;
this.title=title;
this.description=description;
this.release_year=release_year;
this.language_id=language_id;
this.original_language_id=original_language_id;
this.length=length;
this.rating=rating;
this.special_features=special_features;
}
public int getInventoryId(){
return this.inventory_id;
}
public int getFilmId1(){
return this.film_id1;
}
public int getFilmId2(){
return this.film_id2;
}
public String getTitle(){
return this.title;
}
public String getDescription(){
return this.description;
}
public Timestamp getReleaseYear(){
return this.release_year;
}
public int getLanguageId(){
return this.language_id;
}
public int getOriginalLanguageId(){
return this.original_language_id;
}
public int getLength(){
return this.length;
}
public String getRating(){
return this.rating;
}
public String getSpecialFeatures(){
return this.special_features;
}
}
