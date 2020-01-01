import greenfoot.*;

public class tBlaster extends Projectile
{
    private int speed = 4;
    public static int damage = 10;
    
    public void act() 
    {
        int xpos = getX();
        int ypos = getY();
           
        ypos += speed;
        setLocation(xpos, ypos);
        
        if(ypos >= 640){
            getWorld().removeObject(this);
        }

     }
}
