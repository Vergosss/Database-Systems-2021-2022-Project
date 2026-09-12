/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vergman
 */

public class FilmRevenue {
int Year;
int Month;
float Film_revenue;
public FilmRevenue(int Year,int Month,float Film_revenue){
super();
this.Year=Year;
this.Month=Month;
this.Film_revenue=Film_revenue;
}
public int getYear(){
return this.Year;
}
public int getMonth(){
return this.Month;
}
public float getFilm_revenue(){
return this.Film_revenue;

}
}
