public class Fila{ 
    private Corpo primeiro;
    private Corpo ultimo;    
    private int size;

    public Fila(){
        this.size = 0;
    }
    
    public void enfileirar(Corpo c){
        if(size == 0){
            primeiro = c;
            ultimo = c;
        }else{
            ultimo.setProximo(c);
            ultimo = c;
        }
        size ++;
    }
    
    public void desenfileirar(){
        primeiro = primeiro.getProximo();
        size --;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public Corpo getPrimeiro(){
        return this.primeiro;
    }
    
    public Corpo getUltimo(){
        return this.ultimo;
    }
    
    public boolean vazio(){
        return (size > 0)?  false : true;
    }
}
