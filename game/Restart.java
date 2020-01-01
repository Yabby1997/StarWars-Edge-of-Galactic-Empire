import greenfoot.*;

public class Restart extends UI
{
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            World world1 = new world1();
            Greenfoot.setWorld(world1);
            Greenfoot.setSpeed(50);
            
            World W = getWorld();
            world1 myWorld1 = (world1) W;
            myWorld1.stopMusic();
        }
    }    
}
