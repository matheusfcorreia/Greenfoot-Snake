import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Contador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Contador extends Actor
{
    private int pontos;
    
    public Contador(){
        this.pontos = -1;
    }
    
    public void aumentarPontos(){
        pontos++;
        updateText();
        setImage(new GreenfootImage(1,1));
    }
    
    public void updateText()
    {         
        this.getWorld().showText("Pontos: " + pontos, 1, 0);        
    }   
    
    public void setPontos(int pontos){
        this.pontos = pontos;
    }
}
