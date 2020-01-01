import greenfoot.*;

public class xBlaster extends Projectile
{
    private int speed = 10;
    
    public void act() 
    {
        int xpos = getX();
        int ypos = getY();
           
        ypos -= speed;
        setLocation(xpos, ypos);
        
        if(ypos <= 0){
            getWorld().removeObject(this);
        }
     }    
}
