import greenfoot.*; 
public class mainScreen extends World
{
    GreenfootSound BGM = new GreenfootSound("starwarsmaintheme.mp3");
    
    int maintimer = 0;
    
    alongtimeago intro = new alongtimeago();
    starwarslogo logo = new starwarslogo();
    subtitle sub = new subtitle();
    start start = new start();
    s1 s1 = new s1();
    s2 s2 = new s2();
    s3 s3 = new s3();
    s4 s4 = new s4();
    s5 s5 = new s5();
    s6 s6 = new s6();
    s7 s7 = new s7();
    s8 s8 = new s8();
    s9 s9 = new s9();
    s0 s0 = new s0();
    dXwing x1 = new dXwing();
    dXwing x2 = new dXwing();
    dXwing x3 = new dXwing();
    
    public mainScreen()
    {    
        super(360, 640, 1); 
    }
    
    public void act(){
        Greenfoot.setSpeed(50);
        animate();
        maintimer++;
    }
    
    public void animate(){
        if(maintimer < 200){
            addObject(intro, 180, 320);
        }
        if(maintimer == 160){
            BGM.playLoop();            
        }
        if(maintimer >=200 && maintimer <270){
            removeObject(intro);
            addObject(logo, 180, 640);       
        }
        if(maintimer >=270 && maintimer <340){
            addObject(sub, 180, 640);
        }
        if(maintimer == 340){
            addObject(start, 180, 600);
        }
        if(maintimer >=420 && maintimer <520){
            addObject(s1, 180, 570);
        }
        if(maintimer >=520 && maintimer <620){
            addObject(s2, 180, 570);
        }        
        if(maintimer >=620 && maintimer <720){
            addObject(s3, 180, 570);
        }        
        if(maintimer >=720 && maintimer <820){
            addObject(s4, 180, 570);
        }        
        if(maintimer >=820 && maintimer <920){
            addObject(s5, 180, 570);
        }     
        if(maintimer >=920 && maintimer <1020){
            addObject(s6, 180, 570);
        }        
        if(maintimer >=1020 && maintimer <1120){
            addObject(s7, 180, 570);
        }        
        if(maintimer >=1120 && maintimer <1220){
            addObject(s8, 180, 570);
        }        
        if(maintimer >=1220 && maintimer <1320){
            addObject(s9, 180, 570);
        }
        if(maintimer >=1320 && maintimer <1420){
            addObject(s0, 180, 570);
        }                
        if(maintimer >= 2300){
            addObject(x1, 150, 640);
            addObject(x2, 210, 640);
            addObject(x3, 180, 640);
            removeObject(logo);
            removeObject(sub);
            removeObject(start);
            if(maintimer <= 2350){
                x1.mover(1);
                x2.mover(1);
            }
            if(maintimer <= 2375){
                x3.mover(1);
            }
            if(maintimer >= 2500){
                x1.mover(10);
                x2.mover(10);
                if(maintimer == 2500){
                    Greenfoot.playSound("hyperdrive.wav");
                }
            }
            if(maintimer == 2560){
                World myWorld1 = new world1();
                 Greenfoot.setWorld(myWorld1);
                 BGM.stop();
            }
        }
    }
    
    public void stopMusic(){
        BGM.stop();
    }    
}
