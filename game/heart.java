import greenfoot.*; 

public class heart extends Items
{
    public int timer = 0;

    public void act() 
    {     
        mover();
        remover();
        timer++;             
    }    
    public void mover(){
        if(timer == 0){
            turn(Greenfoot.getRandomNumber(90)-45);
        }
        if (isAtEdge()){
            turn(Greenfoot.getRandomNumber(40)+5);
        }        
        move(3);
    }
    public void remover(){
        if(timer >= 800){
            getWorld().removeObject(this);
        }
    }
}
