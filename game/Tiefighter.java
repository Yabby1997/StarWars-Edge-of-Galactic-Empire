import greenfoot.*;

public class Tiefighter extends Enemy
{
    private int speed = 1;
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
        
        ypos += speed;
        
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
        
        if(ypos == 640){
            setLocation(Greenfoot.getRandomNumber(360), 5);
            scoreSet(-300);
        }
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
        if(isTouching(iontorpedo.class)){
            removeTouching(iontorpedo.class);
            this.hp -= Xwing.itdamage;
            Greenfoot.playSound("torpedohit.wav");
            scoreSet(Xwing.itdamage);
        }

        if(this.hp <= 0){
            die();
        }
    }        
    
    public void spawnItem(){
        if(Greenfoot.getRandomNumber(100) >= 80){
            getWorld().addObject(new power(), this.getX(), this.getY());
        }
        if(Greenfoot.getRandomNumber(100) >= 95){
            getWorld().addObject(new speed(), this.getX(), this.getY());
        }            
    }
    
    private void fire(){
        if(firetimer == 20){
            tBlaster blaster1 = new tBlaster();
            tBlaster blaster2 = new tBlaster();
            getWorld().addObject(blaster1, this.getX()-12, this.getY());
            getWorld().addObject(blaster2, this.getX()+12, this.getY());
            
            firetimer++;
        }
        else{
           firetimer++;
        }
        if(firetimer == 40){
           firetimer = 0;
        }
    }
}

