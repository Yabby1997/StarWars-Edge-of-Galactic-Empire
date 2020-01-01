import greenfoot.*; 
public class dXwing extends Me{
        public dXwing(){}
        
        public void mover(int Speed){
            int xpos = getX();
            int ypos = getY();
                
            ypos -= Speed;
            setLocation(xpos, ypos);
        }    
}
