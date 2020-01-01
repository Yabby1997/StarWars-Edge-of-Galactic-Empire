import greenfoot.*;  

public class s4 extends string
{
    int timer = 0;
    public void act() 
    {
        if(timer % 3 == 0){
            move(1);
        }
        fade(290);
        timer ++;
    }    
}
