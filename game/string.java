import greenfoot.*;

public class string extends Actor{
    
    public void move(int speed){   
        int xpos = this.getX();
        int ypos = this.getY();        
        ypos -= speed;
        setLocation(xpos, ypos);
    }
    
    public void fade(int y){
        if(this.getY() == y){
            getWorld().removeObject(this);
        }        
    }
    
    public void fix(int y){
        if(this.getY() <= y){
            setLocation(this.getX(), y);
        }
    }
}
