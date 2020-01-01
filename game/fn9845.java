import greenfoot.*;

public class  fn9845 extends Enemy
{
    private int speed = 1;
    public int hp = 3500;
    public int firetimer = 0;
    public int spreadtimer = 0;
    public int movetimer = 0;
    public int dietimer = 0;
    public static int lifetime = 0;
    
    public void act() 
    {
        mover();
        if(lifetime < 2500){
            fire();
            lifetime ++;
        }
        if(lifetime >= 2500 && lifetime < 4000){
            spread();
            lifetime ++;
        }
        if(lifetime == 4000){
            lifetime = 0;
        }
        
        lifetime++;
        hit();
    }
    
    public void mover(){
        int xpos = this.getX();
        int ypos = this.getY();    
        
        if(movetimer < 200){
            xpos +=speed;
            movetimer ++;
        }
        else if(movetimer >= 200){
            xpos -=speed;
            movetimer ++;
        }
        if(movetimer == 400){
            movetimer = 0;
        }        

        setLocation(xpos, ypos);
    }
    
     public void die(){
         getWorld().addObject(new Explosion(), this.getX(), this.getY());
         Greenfoot.playSound("explosion.wav");
         spawnItem();
         scoreSet(1000);
        forceSet(300);        
         getWorld().removeObject(this);
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
        if(Greenfoot.getRandomNumber(100) >= 0){
            getWorld().addObject(new power(), this.getX(), this.getY());
        }
        if(Greenfoot.getRandomNumber(100) >= 0){
            getWorld().addObject(new speed(), this.getX(), this.getY());
        }              
        if(Greenfoot.getRandomNumber(100) >= 0){
            getWorld().addObject(new heart(), this.getX(), this.getY());
        }          
    }
    
    private void fire(){
        if(firetimer == 0){
            tBlaster bs1 = new tBlaster();
            tBlaster bs2 = new tBlaster();
            tBlaster bs3 = new tBlaster();
            tBlaster bs4 = new tBlaster();
            
            getWorld().addObject(bs1, this.getX()+6, this.getY());
            getWorld().addObject(bs2, this.getX()-6, this.getY());
            getWorld().addObject(bs3, this.getX()+17, this.getY());
            getWorld().addObject(bs4, this.getX()-17, this.getY());
            firetimer++;
        }
        else{
            firetimer++;
        }
        if(firetimer == 30){
            firetimer = 0;
        }
    }
    
    public void spread(){
        ball b1 = new ball();
        ball2 b2 = new ball2();
        
        if(spreadtimer == 0){
            getWorld().addObject(b1, this.getX(), this.getY());
            getWorld().addObject(b2, this.getX(), this.getY());
            spreadtimer++;
        }
        if(spreadtimer == 20){
            spreadtimer = 0;
        }
        else{
            spreadtimer ++;
        }
    }
}

