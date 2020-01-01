import greenfoot.*;

public class starDestroyer extends Enemy
{
    private  int speed = 1; 
    public int hp = 1000;
    public int firetimer = 0;
    public int movetimer = 0;
    public int cbatimer = 0;
    
    public void act() 
    {
        fire();    
        spawnCba(200);
        mover();
        hit();
    }
    
    public void mover(){
        int ypos = this.getY();    
        
        if(ypos <= 320){
            if(movetimer % 4 == 0){
                ypos += speed;
                movetimer ++;
            }
            else{
                movetimer ++;
            }
            setLocation(this.getX(), ypos);
        }
    }
    
     public void die(){
        spawnItem();
        scoreSet(300);
        forceSet(200);        
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
        if(Greenfoot.getRandomNumber(100) >= 70){
            getWorld().addObject(new power(), this.getX(), this.getY());
        }
        if(Greenfoot.getRandomNumber(100) >= 90){
            getWorld().addObject(new speed(), this.getX(), this.getY());
        }      
        if(Greenfoot.getRandomNumber(100) >= 98){
            getWorld().addObject(new heart(), this.getX(), this.getY());
        }          
    }
    
    public void spawnCba(int delay){
        if(cbatimer == 0){
            getWorld().addObject(new Tiecba(), (this.getX()-10+Greenfoot.getRandomNumber(20)), this.getY());
            cbatimer ++;
        }
        else{
            cbatimer++;
        }
        if(cbatimer == delay){
            cbatimer = 0;
        }         
    }     
    
    private void fire(){
        if(firetimer == 20){
            tBlaster blaster1 = new tBlaster();
            tBlaster blaster2 = new tBlaster();
            tBlaster blaster3 = new tBlaster();
            tBlaster blaster4 = new tBlaster();
            getWorld().addObject(blaster1, this.getX()-22, this.getY());
            getWorld().addObject(blaster2, this.getX()+10, this.getY());
            getWorld().addObject(blaster4, this.getX()-10, this.getY());
            getWorld().addObject(blaster3, this.getX()+22, this.getY());
            
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

