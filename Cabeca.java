// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

public class Cabeca extends Cobra
{
    private float speed,speedDelay,velocidade;
    private boolean comeu;
    private int posTail;
    private GreenfootImage strikeAberto, strikeFechado;

    public Cabeca(int cor, float velocidade){
        super(true, cor);   
        strikeAberto = new GreenfootImage("images/Snake/Open"+cor+".png");
        strikeAberto.scale(35,35);
        strikeFechado = new GreenfootImage("images/Snake/Close"+cor+".png");
        strikeFechado.scale(35,35);
        this.comeu = false;
        this.posTail = 180;
        this.speed = 10f;
        this.velocidade = velocidade;
        this.speedDelay = velocidade;
        super.cor = cor;
    }

    public void act(){  
        if(isTouching(Comida.class)){ //caso toque na comida
            tocouComida();            
        } else if(isTouching(Corpo.class)){
            morreu();
        } else {
            moveSnake(); //move a cobra   
        }        
    }

    public void tocouComida(){
        WorldSnake world = (WorldSnake) getWorld();
        removeTouching(Comida.class);  //remove comida  pra n ficar cirando comidas em loop       
        world.addComida(); 
        comeu = true;
        moveSnake();
    }

    public void morreu(){
        WorldSnake world = (WorldSnake) getWorld();
        world.gameOver();
    }

    //Movimenta a cobra de acordo com os botoes
    public void moveSnake(){
        haComida();        
        speedDelay();//ativa o delay pra cobra ir devagar   

        if(Greenfoot.isKeyDown("left") && posTail != 0){
            if(getRotation() != 0 ){
                setRotation(180);
            }
        } else if(Greenfoot.isKeyDown("right") && posTail != 180){
            if(getRotation() != 180){
                setRotation(0);            
            }
        } else if(Greenfoot.isKeyDown("down") && posTail != 270){
            if(getRotation() != 270){
                setRotation(90);            
            }
        } else if(Greenfoot.isKeyDown("up") && posTail != 90){
            if(getRotation() != 90){
                setRotation(270);            
            }
        }
    }

    
    //executa o if SPEED vezes, dando um atraso na movimentação da cobra, senao ela corre
    // loucamente.
    public void speedDelay(){ //        
        if(speed < 0){
            speed = 10;            
            WorldSnake world = (WorldSnake)getWorld(); 
            posTail = getRotation();
            world.moveCobra(getX(), getY(), posTail);             

            if (comeu == true){
                world.addCorpo(super.cor, getX(), getY());
                speedDelay += 0.1;
                comeu = false;                
            }            
            move(1);
        }else{            
            speed -= speedDelay;
        }
    }

    public void haComida(){
        if(getNeighbours(4, false, Comida.class).size() > 0){
            abrirBoca();
        }else{
            fecharBoca();
        }        
    }

    public void abrirBoca(){        
        setImage(strikeAberto);
    }

    public void fecharBoca(){        
        setImage(strikeFechado);    
    }
}
