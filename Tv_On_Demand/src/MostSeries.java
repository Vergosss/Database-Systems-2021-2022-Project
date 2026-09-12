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
public class MostSeries {
int series_id;
int TOTAL;
public MostSeries(int series_id,int TOTAL){
super();
this.series_id=series_id;
this.TOTAL=TOTAL;
}
public int getSeries_Id(){
return this.series_id;
}
public int getTOTAL(){
return this.TOTAL;
}
}
