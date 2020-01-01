import greenfoot.*;

public class iontorpedo extends Projectile
{
    private int speed = 20;
    
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
