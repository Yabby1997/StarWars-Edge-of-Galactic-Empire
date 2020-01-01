import greenfoot.*;

public class start extends UI
{
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            World myWorld1 = new world1();
            Greenfoot.setWorld(myWorld1);
            Greenfoot.setSpeed(50);
            
            World W = getWorld();
            mainScreen main = (mainScreen) W;
            main.stopMusic();
        }
    }    
}
