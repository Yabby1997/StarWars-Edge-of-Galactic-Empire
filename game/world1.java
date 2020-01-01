import greenfoot.*;
import java.util.List;

public class world1 extends World
{
    GreenfootSound bgm1 = new GreenfootSound("sr3dialogue.mp3");
    GreenfootSound bgm2 = new GreenfootSound("undertale1.mp3");
    GreenfootSound boss1= new GreenfootSound("iwbtb.mp3");
    GreenfootSound boss2= new GreenfootSound("iwbtb.mp3");
    GreenfootSound boss3= new GreenfootSound("iwbtb.mp3");
    GreenfootSound victory= new GreenfootSound("starwarsendingtheme.mp3");
    
    fn9845 FN = new fn9845();
    imperialstarDestroyer isd = new imperialstarDestroyer();
    DeathStar finalboss = new DeathStar();
    
    Score nowScore = new Score();
    Force nowForce = new Force();
    
    static life secondlife = new  life();
    static life thirdlife = new life();
    
    public int tietimer = 0;
    public int tie2timer = 0;
    public int sdtimer = 0;
    public int fntimer = 0;
    public int status = 0;
    public static int isVictory = 0;
    
    public world1()
    {    
        super(360, 640, 1); 
        
        Xwing xwing1 = new Xwing(2, 0, 8, 2, 3, 0);
        addObject(nowScore, 50, 620);
        addObject(nowForce, 160, 620);
        addObject(secondlife, 320, 620);
        addObject(thirdlife, 345, 620);
        addObject(xwing1, 180,630);     
    }

    public void act(){
        bgm1.playLoop();
        if(status < 10){
            spawnTie(200);
        }
        else if(status >=10 && status <20){
            spawnTie(150);
        }
        if(status >= 20){
            bgm1.stop();
            boss1.playLoop();
            if(status == 20){
                Greenfoot.playSound("warning.mp3");  
                addObject(new warning(), 180, 320);
                addObject(FN, 90, 100);
                spawnTieSquad();
                status = 21;
            }
            if(status == 21){
                if(getObjects(fn9845.class).isEmpty()){
                    status = 22;
                }                 
            }
        } 
        if(status >= 22){
            boss1.stop();
            bgm2.playLoop();
            if(status >= 22 && status < 45){
                spawnTie2(300);
                spawnSD(2000);
            }
            if(status >= 45){
                bgm2.stop();
                boss2.playLoop();
                if(status == 45){
                    Greenfoot.playSound("warning.mp3");  
                    addObject(isd, 180, 20);
                    addObject(new warning(), 180, 320);
                    status = 46;
                }
                if(status == 46){
                    if(getObjects(imperialstarDestroyer.class).isEmpty()){
                        status = 47;
                    }                 
                }
                if(status >= 47){
                    status++;
                }
                if(status == 200){
                    Greenfoot.playSound("warning.mp3");  
                    status ++;
                }
                if(status == 250){
                    Greenfoot.playSound("warning.mp3"); 
                    status ++;
                }
                if(status == 300){
                    Greenfoot.playSound("warning.mp3");  
                    addObject(finalboss, 180, 150);
                    addObject(new warning(), 180, 380);
                    addObject(new warning(), 180, 320);
                    addObject(new warning(), 180, 260);
                    status ++;
                }
                if(status >= 301){
                    if(getObjects(DeathStar.class).isEmpty()){
                        boss1.stop();
                        boss2.stop();
                        victory.playLoop();
                        addObject(new Victory(), 180, 250);
                        addObject(new Restart(), 180, 340);
                        isVictory = 1;
                    }    
                }                
            } 
        }
    }
    
    public void spawnTie(int delay){
        if(tietimer == 0){
            addObject(new Tiefighter(), Greenfoot.getRandomNumber(360), 5);
            status ++;
            tietimer ++;
        }
        else{
            tietimer++;
        }
        if(tietimer == delay){
            tietimer = 0;
        }         
    }
    
    public void spawnSD(int delay){
        if(sdtimer == delay){
            addObject(new starDestroyer(), Greenfoot.getRandomNumber(360), 5);
            status ++;
            sdtimer = 0;
        }
        else{
            sdtimer++;
        }
    }    
    
    public void spawnTie2(int delay){
        if(tie2timer == 0){
            addObject(new Tiefighter2(), Greenfoot.getRandomNumber(360), 5);
            status ++;
            tie2timer ++;
        }
        else{
            tie2timer ++;
        }
        if(tie2timer == delay){
            tie2timer = 0;
        }         
    }
        
    public void spawnTieSquad(){
        addObject(new TieSquad(), 35, 50);
        addObject(new TieSquad(), 105, 50);
        addObject(new TieSquad(), 175, 50);
        addObject(new TieSquad(), 245, 50);
        addObject(new TieSquad(), 70, 80);
        addObject(new TieSquad(), 140, 80);
        addObject(new TieSquad(), 210, 80);
        addObject(new TieSquad(), 280, 80);
    }
    
    public Score getScore(){
        return nowScore;
    }
    
    public Force getForce(){
        return nowForce;
    }

    public void stopMusic(){
        bgm1.stop();
        bgm2.stop();
        boss1.stop();
        boss2.stop();
        victory.stop();
    }
}
