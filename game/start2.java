import greenfoot.*;

public class start2 extends UI
{
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            World myWorld1 = new world1();
            Greenfoot.setWorld(myWorld1);
            Greenfoot.setSpeed(50);
            
            World W = getWorld();
            mainScreen2 main = (mainScreen2) W;
            main.stopMusic();
        }
    }    
}
