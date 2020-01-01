import greenfoot.*;

public class Explosion extends Effect
{

    private int timer = 0;
    
    public void act() 
    {
        animate();
        timer ++;
    }    
    
    private void animate(){
        if(timer >=0 && timer <50){
            setImage("BOOM1.png");
        }
        
       else
        getWorld().removeObject(this);
    }
}
