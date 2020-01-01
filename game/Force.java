import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Force extends UI
{
    
    public int Force = 0;
    
    public void act() 
    {
        setImage(new GreenfootImage("Force: "+Force+"", 18, Color.YELLOW, new Color(255,255,255,0)));
    }    
    
    public void forceUp(int amount){
        Force += amount;
    }
}
