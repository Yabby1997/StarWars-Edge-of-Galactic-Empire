import greenfoot.*; 

public class mainScreen2 extends World
{
    GreenfootSound maintheme = new GreenfootSound("starwarsmaintheme.mp3");    
    
    public mainScreen2()
    {   
        super(360, 640, 1); 
    }
    
    public void act(){
        addObject(new starwarslogo(), 180, 100);
        addObject(new subtitle(), 180, 240);
        addObject(new start2(), 180, 450);
        maintheme.playLoop();
    }
    
    public void stopMusic(){
        maintheme.stop();
    }       
}
