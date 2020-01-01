import greenfoot.*;  
public class ball2 extends Projectile
{
    public void act() 
    {  
        turn(-2);
        mover();
        move(-2);
        remove();
    }    
    
    public void mover(){
        int xpos = this.getX();
        int ypos = this.getY();
        
        ypos += 1;
        
        setLocation(xpos, ypos);
    }
    
    public void remove(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
