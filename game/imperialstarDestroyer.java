import greenfoot.*;

public class imperialstarDestroyer extends Enemy
{
    private  int speed = 1; 
    public int hp = 8000;
    public int firetimer = 0;
    public int movetimer = 0;
    
    public int tietimer = 0;
    public int spreadtimer = 0;
    
    public void act() 
    {   
        fire();
        spawnTie(200);
        mover();
        hit();
    }
    
    public void mover(){
        int ypos = this.getY();   
        
        if(ypos <= 80){
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
    
    public void spawnTie(int delay){
        if(tietimer == 0){
            getWorld().addObject(new Tiefighter(), Greenfoot.getRandomNumber(360), this.getY());
            tietimer ++;
        }
        else{
            tietimer++;
        }
        if(tietimer == delay){
            tietimer = 0;
        }         
    } 
    
     public void die(){
        spawnItem();
        scoreSet(3000);
        forceSet(1000);        
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
            getWorld().addObject(new power(), this.getX(), this.getY());
            getWorld().addObject(new speed(), this.getX(), this.getY());
            getWorld().addObject(new heart(), this.getX(), this.getY());
            getWorld().addObject(new power(), this.getX(), this.getY());
            getWorld().addObject(new speed(), this.getX(), this.getY());
            getWorld().addObject(new heart(), this.getX(), this.getY());            
    }
    
    private void fire(){
        if(firetimer == 20){
            tBlaster blaster1 = new tBlaster();
            tBlaster blaster2 = new tBlaster();
            tBlaster blaster3 = new tBlaster();
            tBlaster blaster4 = new tBlaster();
            tBlaster blaster5 = new tBlaster();
            tBlaster blaster6 = new tBlaster();
            getWorld().addObject(blaster1, this.getX()-120, this.getY());
            getWorld().addObject(blaster2, this.getX()-80, this.getY());
            getWorld().addObject(blaster3, this.getX()+20, this.getY());
            getWorld().addObject(blaster4, this.getX()-20, this.getY());
            getWorld().addObject(blaster5, this.getX()+80, this.getY());
            getWorld().addObject(blaster6, this.getX()+120, this.getY());
            
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

