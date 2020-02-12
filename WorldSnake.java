import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class WorldSnake extends World{    
    Fila fila;
    private Contador contador;
    private int tamanho, cor, corFundo;
    private float velocidade;
    private boolean gameOver;
    
    public WorldSnake(int corFundo, int corCobra, int _tamanho, float velocidade){    
        //Malha de fundo 
        super(_tamanho, _tamanho, 35); 
        this.tamanho = _tamanho;
        this.cor = corCobra;
        this.velocidade = velocidade;
        this.gameOver = false;
        this.corFundo = corFundo;
        setBackground(corFundo);
        this.contador = new Contador();
        //Coloca a cobra
        fila = new Fila();  
        start(corCobra, velocidade, tamanho);
    }
    
    public void act(){
        if(gameOver){
            gameOver = false;
            if(Greenfoot.isKeyDown("enter")) Greenfoot.setWorld(new WorldSnake(corFundo, cor, tamanho, velocidade));
            else if(Greenfoot.isKeyDown("S")) Greenfoot.setWorld(new Menu());
         }
    }
    
    public void start(int corCobra, float velocidade, int tamanho){
        addObject(new Cabeca(corCobra, velocidade), 3, 10); //adiciona cabeça
        addObject(contador, 2, 0);
        addCorpo(corCobra, 2, 10);
        addCorpo(corCobra, 1, 10);
        addComida();
    }
    
    public void setBackground(int corFundo){
        GreenfootImage img = new GreenfootImage("images/Background/b"+corFundo+".png");
        img.scale(35*2,35*2);   
        setBackground(img);
    }
    
    public void gameOver(){
        addObject(new GameOver(), getWidth()/2 , getHeight()/2);
        showText("Pressione 'Enter'- recomeçar ou 'S'- voltar ao menu",7,getHeight()-2);
        gameOver = true;
    }
    
    public void addCorpo(int corCobra, int x, int y){ //x e y posicao cabeca
        Corpo c = new Corpo(corCobra);
        fila.enfileirar(c);
        addObject(c, x, y);
    }
    
    public void addComida(){
        int x, y;
        do{
             x = Greenfoot.getRandomNumber(getWidth());
             y = Greenfoot.getRandomNumber(getHeight());
        }while(getObjectsAt(x, y, null).size() > 0); //verifica se ha algum ator nesta posiçao.
        addObject(new Comida(), x, y);
        contador.aumentarPontos();
    }
    
    public void moveCobra(int x, int y, int rotation){ 
        int xAux = x;
        int yAux = y;
        int rotAux = rotation;
        Corpo c = fila.getPrimeiro();
        for(int i = 0; i < fila.getSize(); i++){
            xAux = c.getX();
            yAux = c.getY();
            rotAux = c.getRotation();
            c.setRotation(rotation);
            c.setPosition(x, y);
            c = c.getProximo();
            x = xAux;
            y = yAux;
            rotation = rotAux;
        }
    }
    
    public void setText(String title ,int tam,  int posX, int posY){
      GreenfootImage img = new GreenfootImage(title, tam, null, null);
      this.getBackground().drawImage(img, posX, posY);
    }

}