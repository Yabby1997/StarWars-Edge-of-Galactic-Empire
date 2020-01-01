    import greenfoot.*;  


public class Xwing extends Me
{
        public int speed;
        public int grade;
        public int fireSpeed;
        public int life;
        public int torpedo;
        public static int damage;
        public static int itdamage = 300;
        public int lifetime;    
        
        public int firetimer = 0;
        public int torpedotimer = 0;
        
        public Xwing(){
        }
        
        public Xwing(int nowSpeed, int nowGrade, int nowFireSpeed, int nowLife, int nowTorpedo, int nowlifetime){
            speed = nowSpeed;
            grade = nowGrade;
            fireSpeed = nowFireSpeed;
            life = nowLife;
            torpedo = nowTorpedo;
            lifetime = nowlifetime;
        }

        public void act() 
        {
            controller();      
            forcegrow();
            if(isTouching(power.class)){   
                powerUp();
            }       
            if(isTouching(speed.class)){   
                speedUp();
            }                        
            if(isTouching(heart.class)){
                lifeUp();
            }
            activateGuard();
            if(world1.isVictory == 0){
                if(getOneObjectAtOffset(0, 0, Tiefighter.class) != null || getOneObjectAtOffset(0, 0, Tiefighter2.class) != null || getOneObjectAtOffset(0, 0, Tiecba.class) != null || getOneObjectAtOffset(0, 0, tBlaster.class) != null || getOneObjectAtOffset(0, 0, ball.class) != null || getOneObjectAtOffset(0, 0, ball2.class) != null || getOneObjectAtOffset(0, 0, starDestroyer.class) != null || getOneObjectAtOffset(0, 0, imperialstarDestroyer.class) != null){
                    die();
                }
            }
            lifetime ++;
        }
        
        public void forcegrow(){
            if(lifetime % 30 == 0){
                forceSet(1);
            }
        }
        
        public void activateGuard(){
            if(lifetime % 10 == 0 && lifetime <=  150){
                setImage("superstatus.png");
            }
            else{
                setImage("Xwing1.png");
            }                                   
        }
        
        public void controller(){
            int xpos = this.getX();
            int ypos = this.getY();
            
            if(lifetime <= 30){
                ypos -= speed;
            }
            else if(lifetime > 30){
                if(Greenfoot.isKeyDown("up")){
                    ypos -= speed;
                }
                if(Greenfoot.isKeyDown("Down")){
                    ypos += speed+1;
                }
                if(Greenfoot.isKeyDown("Left")){
                    xpos -= speed;
                }
                if(Greenfoot.isKeyDown("Right")){
                    xpos += speed;
                }
                if(Greenfoot.isKeyDown("b")){ 
                    world1 myWorld1 = (world1) getWorld();
                    Force myForce = myWorld1.getForce();
                    if(myForce.Force > 0 ){
                        Greenfoot.setSpeed(40);
                        forceSet(-1);
                    }
                    else if(myForce.Force == 0){
                        Greenfoot.setSpeed(50);
                    }
                }
                else{
                    Greenfoot.setSpeed(50);
                }
                if(Greenfoot.isKeyDown("n")){
                    if(torpedotimer == 0){
                        launch();
                        if(Greenfoot.isKeyDown("n") == true){
                            torpedotimer ++;
                        }
                        else{
                            torpedotimer = 0;
                        }
                    }
                    else{
                        torpedotimer++;
                    }
                    if(torpedotimer == 50 || torpedotimer >= 50){
                        torpedotimer = 0;
                    } 
                }      
                if (Greenfoot.isKeyDown("space")){
                    if(firetimer == 0){
                        fire();
                        Greenfoot.playSound("Laser_Shoot96.wav");
                        if(Greenfoot.isKeyDown("space") == true){
                            firetimer ++;
                        }
                        else{
                            firetimer = 0;
                        }
                    }
                    else{
                        firetimer++;
                    }
                    if(firetimer == fireSpeed || firetimer >= 8){
                        firetimer = 0;
                    } 
                }               
            }

            setLocation(xpos, ypos);
        
        }
        
        private void fire(){
            if (grade == 0){
                xBlaster blaster1 = new xBlaster();
                getWorld().addObject(blaster1, this.getX(), this.getY());
                damage = 12;
            }
            
            else if (grade == 1){
                 xBlaster blaster1 = new xBlaster();
                 xBlaster blaster2 = new xBlaster();
                 getWorld().addObject(blaster1, this.getX()-9, this.getY());
                 getWorld().addObject(blaster2, this.getX()+9, this.getY());
                 damage = 10;
            }
            
            else if (grade == 2){
                 xBlaster blaster1 = new xBlaster();
                 xBlaster blaster2 = new xBlaster();
                 xBlaster blaster3 = new xBlaster();
                 getWorld().addObject(blaster1, this.getX(), this.getY());
                 getWorld().addObject(blaster2, this.getX()-12, this.getY());
                 getWorld().addObject(blaster3, this.getX()+12, this.getY());
                 damage = 8;
                }
                 
            else if (grade == 3){
                 xBlaster blaster1 = new xBlaster();
                 xBlaster blaster2 = new xBlaster();
                 xBlaster blaster3 = new xBlaster();
                 xBlaster blaster4 = new xBlaster();
                 getWorld().addObject(blaster1, this.getX()-6, this.getY());
                 getWorld().addObject(blaster2, this.getX()+6, this.getY());      
                 getWorld().addObject(blaster3, this.getX()-17, this.getY());
                 getWorld().addObject(blaster4, this.getX()+17, this.getY()); 
                 damage = 6;
                }
        }        
                    
        private void launch(){
            iontorpedo it = new iontorpedo ();
            if(torpedo == 3){
                getWorld().addObject(it, this.getX(), this.getY());
                Greenfoot.playSound("Laser_Shoot96.wav");
                torpedo = 2;
            }
            if(torpedo == 2){
                getWorld().addObject(it, this.getX(), this.getY());
                Greenfoot.playSound("Laser_Shoot96.wav");
                torpedo = 1;
            }
            if(torpedo == 2){
                getWorld().addObject(it, this.getX(), this.getY());
                Greenfoot.playSound("Laser_Shoot96.wav");
                torpedo = 0;
            }
        }
        
        public void powerUp(){
            if( this.grade <= 2){
                this.grade += 1;
            }
            removeTouching(power.class);
            Greenfoot.playSound("power.wav");
                
            scoreSet(100);
        }

        public void speedUp(){
            if( this.fireSpeed  >= 5){
                this.fireSpeed -= 1;
            }
            removeTouching(speed.class);
            Greenfoot.playSound("power.wav");
                
            scoreSet(150);
        }        
        
        public void lifeUp(){
            if( this.life  == 1){
                this.life += 1;
                getWorld().addObject(world1.secondlife, 320, 620); 
            }
            if( this.life == 0){
                this.life += 1;
                getWorld().addObject(world1.thirdlife, 345, 620);
            }   
            removeTouching(heart.class);
            Greenfoot.playSound("power.wav");
                
            scoreSet(1500);
        }            

        private void die(){
            Xwing xwing2 = new Xwing(2, 0, 8, 1, 3, 0);
            Xwing xwing3 = new Xwing(2, 0, 8, 0, 3, 0);    
              
            if(grade >= 1){
                if(Greenfoot.getRandomNumber(100)>=60){
                    getWorld().addObject(new power(), this.getX(), this.getY());
                }
                if(grade >= 2){
                    if(Greenfoot.getRandomNumber(100)>=40){
                        getWorld().addObject(new power(), this.getX(), this.getY());
                    }
                    if(grade == 3){
                        if(Greenfoot.getRandomNumber(100)>=20){
                            getWorld().addObject(new power(), this.getX(), this.getY());
                        }
                    }
                }
            }
             
            
            if(fireSpeed <= 7){
                if(Greenfoot.getRandomNumber(100)>=60){
                    getWorld().addObject(new speed(), this.getX(), this.getY());
                }
                if(fireSpeed <= 6){
                    if(Greenfoot.getRandomNumber(100)>=40){
                        getWorld().addObject(new speed(), this.getX(), this.getY());
                    }
                    if(fireSpeed <= 5){
                        if(Greenfoot.getRandomNumber(100)>=20){
                            getWorld().addObject(new speed(), this.getX(), this.getY());
                        }
                    }
                }
            }
            
            if(lifetime >= 150){
                getWorld().addObject(new Explosion(), this.getX(),this.getY());  
                Greenfoot.playSound("explosion.wav");    
                if(life == 2){ 
                    getWorld().removeObject(world1.secondlife);
                    getWorld().addObject(xwing2, 180, 640);
                    getWorld().removeObject(this);
                }
                else if(life == 1){
                    getWorld().removeObject(world1.thirdlife);
                    getWorld().addObject(xwing3, 180, 640);
                    getWorld().removeObject(this);
                }
                else if(life == 0){
                    getWorld().addObject(new GameOver(), 180, 250);
                    getWorld().addObject(new Restart(), 180, 350);
                    getWorld().addObject(new Tomain(), 180, 420);
                    getWorld().removeObject(this);
                    Greenfoot.setSpeed(40);
                } 
            }
        }
}
