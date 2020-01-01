import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Score extends UI
{
    public int Score = 0;
    
    public void act() 
    {
        setImage(new GreenfootImage("Score : "+Score+"", 18, Color.YELLOW, new Color(255,255,255,0)));
    }    
    
    public void scoreUp(int amount){
        Score += amount;
    }
}
