import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Comida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Comida extends Actor
{    
    public Comida(){
        GreenfootImage comida = new GreenfootImage("images/maca.png");
        comida.scale(30,30);       
        setImage(comida); 
    }
}