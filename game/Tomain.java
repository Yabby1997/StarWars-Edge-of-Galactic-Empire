import greenfoot.*; 

public class Tomain extends UI{
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            World mainScreen2 = new mainScreen2();
            Greenfoot.setWorld(mainScreen2);
                
            World W = getWorld();
            world1 myWorld1 = (world1) W;
            myWorld1.stopMusic();
        }    
    }
}
