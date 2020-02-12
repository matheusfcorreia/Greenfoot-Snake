// WARNING: This file is auto-generated and any changes to it will be overwritten
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cobra extends Actor
{
    public int cor;
    public Cobra(boolean cabeca, int cor) 
    {
        //seta imagem de acordo com a necessidade
        this.cor = cor;
        if(cabeca){
           GreenfootImage cabecinha = new GreenfootImage("images/Snake/Close"+cor+".png"); //inicializa cabeça da cobra
           cabecinha.scale(35,35);
           setImage(cabecinha);
        }else{
           GreenfootImage corpo = new GreenfootImage("images/Snake/Tail"+cor+".png"); //inicializa corpo da cobra
           corpo.scale(35,35);
           setImage(corpo);
        }
    }
}
