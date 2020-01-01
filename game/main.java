import greenfoot.*;

public class main extends Actor
{
    
    public void scoreSet(int amount){
            world1 myWorld1 = (world1) getWorld();
            Score myScore = myWorld1.getScore();
            myScore.scoreUp(amount);
        } 
        
    public void forceSet(int amount){
            world1 myWorld1 = (world1) getWorld();
            Force myForce = myWorld1.getForce();
            myForce.forceUp(amount);
        }         
}
