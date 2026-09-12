/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vergman
 */
public class SeriesRevenue {
int Year;
int Month;
float Series_revenue;
public SeriesRevenue(int Year,int Month,float Series_revenue){
super();
this.Year=Year;
this.Month=Month;
this.Series_revenue=Series_revenue;
}
public int getYear(){
return this.Year;
}
public int getMonth(){
return this.Month;
}
public float getSeries_revenue(){
return this.Series_revenue;
}
    
}
