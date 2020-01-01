import greenfoot.*;

public class TieSquad extends Enemy
{
    public int hp = 120;
    public int firetimer = 0;
    public int movetimer = 0;
    
    public void act() 
    {
        fire();        
        mover();
        hit();
    }
    
    public void mover(){
        int xpos = this.getX();
        int ypos = this.getY();    
        if(movetimer < 80){
            xpos ++;
            movetimer ++;
        }
        else if(movetimer >= 80){
            xpos --;
            movetimer ++;
        }
        if(movetimer == 160){
            movetimer = 0;
        }
       
        setLocation(xpos, ypos);
    }
    
     public void die(){
        spawnItem();
        scoreSet(20);
        forceSet(10);        
        getWorld().addObject(new Explosion(), this.getX(), this.getY());
        getWorld().removeObject(this);
        Greenfoot.playSound("Explosion60.wav");     
    }

    public void hit(){
        if(isTouching(xBlaster.class)){
            removeTouching(xBlaster.class);
            this.hp -= Xwing.damage;
            Greenfoot.playSound("laserhit.wav");
            scoreSet(Xwing.damage);
        }
        
        if(this.hp <= 0){
            die();
        }
    }        
    
    public void spawnItem(){
        if(Greenfoot.getRandomNumber(100) >= 90){
            getWorld().addObject(new power(), this.getX(), this.getY());
        }
        if(Greenfoot.getRandomNumber(100) >= 95){
            getWorld().addObject(new speed(), this.getX(), this.getY());
        }        
    }
    
    private void fire(){
        if(firetimer == 20){
            tBlaster blaster1 = new tBlaster();
            getWorld().addObject(blaster1, this.getX(), this.getY());
            
            firetimer++;
        }
        else{
           firetimer++;
        }
        if(firetimer == 60){
           firetimer = 0;
        }
    }
}

