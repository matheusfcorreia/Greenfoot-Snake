import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Corpo extends Cobra
{
    Corpo proximo;
    
    public Corpo(int cor){
        super(false, cor);
    }
    
    public void setPosition(int x, int y){
        setLocation(x, y);
    }
    
    public Corpo getProximo(){
        return this.proximo;
    }
    
    public void setProximo(Corpo _proximo){
        this.proximo = _proximo;
    }
}
