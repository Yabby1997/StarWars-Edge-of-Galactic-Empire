import greenfoot.*;

public class warning extends Effect
{

    private int timer = 0;
    
    public void act() 
    {
        animate();
        timer ++;
    }    
    
    private void animate(){
        if(timer >=0 && timer <10){
            setImage("warning.png");
        }
        else if(timer >= 10 && timer < 20){
            setImage("superstatus.png");
        }
        else if(timer >= 20 && timer <30){
            setImage("warning.png");
        }
        else if(timer >=30 && timer <40){
            setImage("superstatus.png");
        }
        else if(timer >= 40 && timer <50){
            setImage("warning.png");
        }
        else if(timer >=50 && timer <60){
            setImage("superstatus.png");
        }
        else if(timer >= 60 && timer < 70){
            setImage("superstatus.png");
        }
        else if(timer >= 70 && timer <80){
            setImage("warning.png");
        }
        else if(timer >=80 && timer <90){
            setImage("superstatus.png");
        }
        else if(timer >= 90 && timer <100){
            setImage("warning.png");
        }
        else if(timer >=100 && timer <110){
            setImage("superstatus.png");
        }
        else if(timer >= 110 && timer < 120){
            setImage("superstatus.png");
        }
        else if(timer >= 120 && timer <130){
            setImage("warning.png");
        }
        else if(timer >=130 && timer <140){
            setImage("superstatus.png");
        }
        else if(timer >= 140 && timer <150){
            setImage("warning.png");
        }
        else if(timer >=150 && timer <160){
            setImage("superstatus.png");
        }
        else
            getWorld().removeObject(this);
    }
}
