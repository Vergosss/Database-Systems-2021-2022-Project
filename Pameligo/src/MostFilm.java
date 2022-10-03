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
import javax.swing.*;
public class MostFilm {
int film_id;
int TOTAL;
public MostFilm(int film_id,int TOTAL){
super();
this.film_id=film_id;
this.TOTAL=TOTAL;
}
public int getFilm_Id(){
return this.film_id;
}
public int getTOTAL(){
return this.TOTAL;
}
}
