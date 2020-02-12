import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private float velocidade;
    private int tamanho, corCobra, corFundo;
    private String vel;
    public Menu()
    {    
        super(15, 15, 30);  
        this.velocidade= 1f;
        this.vel = "Normal";
        this.tamanho = 15;
        this.corCobra = 1;
        this.corFundo = 1;        
        GreenfootImage img = new GreenfootImage("images/Background/b1.png");
        img.scale(60,60);   
        setBackground(img);
        menuTexto(tamanho, vel);
        setCorCobra(corCobra);
    }
    
    public void menuTexto(int tamanho, String velocidade){
      getBackground().drawImage(new GreenfootImage("Snake", 100, Color.WHITE, null), this.getBackground().getWidth()/4, 0);

      this.showText("OPÇOES DE JOGO:\nC - Cor Cobra\nF - Cor Fundo\nV - Cresc. Velocidade ("
      +velocidade+")\nT - Tamanho ("+tamanho+"x"+tamanho
      +")\n Enter - Iniciar", getWidth()/2, getHeight()-3);  
    }
    
    public void act(){
        if (Greenfoot.isKeyDown("enter")) Greenfoot.setWorld(new WorldSnake(corFundo, corCobra, tamanho, velocidade));
        if (Greenfoot.isKeyDown("C")){
            corCobra ++;
            if (corCobra == 5) corCobra = 1;
            setCorCobra(corCobra);
            Greenfoot.delay(15);
        }         
        if (Greenfoot.isKeyDown("F")){
            corFundo ++;
            if (corFundo == 6) corFundo = 1;
            setCorFundo(corFundo);
            Greenfoot.delay(15);
        }
        if (Greenfoot.isKeyDown("V")){
            if(velocidade == 1f){
                setVelocidade("Rapido", 1.5f);
            }else if (velocidade == 1.5f){
                setVelocidade("Lento",0.3f);
            }else if(velocidade == 0.3f){
                setVelocidade("Normal",1f);
            }
            Greenfoot.delay(25);
        }
        if (Greenfoot.isKeyDown("T")){
            if(tamanho == 15){
                setTamanho(18);
            }else if (tamanho == 18){
                setTamanho(20);
            }else if(tamanho == 20){
                setTamanho(22);
            }else if(tamanho == 22){
                setTamanho(15);
            }
            Greenfoot.delay(25);
        }
    }
    
    public void setText(String title ,int tam,  int posX, int posY){
      GreenfootImage img = new GreenfootImage(title, tam, null, null);
      this.getBackground().drawImage( img, posX, posY);
    }
    
    public void setCorCobra(int corCobra){
        removeObjects(getObjects(Cobra.class));
        addObject(new Cobra(true, corCobra), 6, 5);
        addObject(new Corpo(corCobra), 5, 5);
        addObject(new Corpo(corCobra), 4, 5);
        addObject(new Comida(),9, 5);
    }
    
    public void setCorFundo(int corFundo){
        GreenfootImage img = new GreenfootImage("images/Background/b"+corFundo+".png");
        img.scale(60,60);   
        setBackground(img);
        menuTexto(tamanho, vel);
        addObject(new Cobra(true, corCobra), 6, 5);
        addObject(new Corpo(corCobra), 5, 5);
        addObject(new Corpo(corCobra), 4, 5);
        addObject(new Comida(),9, 5);
    }

    public void setVelocidade(String _vel, float _velocidade){
        menuTexto(tamanho, _vel);
        this.velocidade = _velocidade;
        this.vel = _vel;
    }
    
    public void setTamanho(int _tamanho){
        menuTexto(_tamanho, this.vel);
        this.tamanho = _tamanho;
    }
}
