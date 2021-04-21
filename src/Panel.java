import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Panel extends JPanel implements MouseListener, MouseMotionListener {
    private Ball ball = new Ball();
    private Tank tank = new Tank();
    private Enemytank enemytank = new Enemytank();
    private Plane plane = new Plane();
    public boolean frameClose =true;
    private int f = 5;
    private int ifBulletIsDrawingAndUpdating = 3;
    private int ifTankShooting =0;
    private int EnemyBoom = 0;
    private int enemyBoomDirection = 0;
    private int planeBoomDirection = 0;
    private double enemyBoomR3 = 0;
    private int time = 0;
    private int timeWin = 0;
    private int planeStroke = 0;
    private int moveRight = 0;
    private int tankGo =0;
    private int tankGof =0;
    private int moveLeft = 0;
    private int vPlus = 0;
    private int vMinus = 0;
    private int anglePlus = 0;
    private int angleMinus = 0;
    private int enemyBallDirection = -1;
    private int ballDirection = -1;
    private int numberOfTheLevel = -1;
    private int timeStudy = -1;
    private int timeLevel1 = -1;
    private int timeLevel2 = -1;
    private int timeLevel3 =-1;
    private double timeLevel4=-1;
    private int timeTrajectory = -1;
    private int threeBegin = 0;
    private int shootButtonMoved =0;
    private int yesMouseMoved=0;
    private int noMouseMoved=0;
    private int f3=1;
    private int studyF =0;
    private int finishStudyF =0;
    private int goto2level=0;
    private  int goto3level=0;
    private int howManyTimesIWon=0;
    private int showTrajectoryButtonMoved =0;
    private long previousTime;
    private long currentTime;
    private long deltaTime;
    private double boomR = 0;
    private double enemyBoomR = 0;
    private double planeBoom = 0;
    private final TankGoes sound1=new TankGoes();
    private final AirBombExplodes soundBomb=new AirBombExplodes();
    private final EnemyTankGoes enemyTankGo = new EnemyTankGoes();
    BufferedImage dieImage;
    BufferedImage winImage;
    BufferedImage studyImage;
    BufferedImage study1Image;
    BufferedImage level1Image;
    BufferedImage level2Image;
    BufferedImage level3Image;
    BufferedImage level1backgroundImage;
    BufferedImage level2backgroundImage;
    BufferedImage level0background;
    BufferedImage level3backgroundImage;
    BufferedImage beginStudy;
    BufferedImage beginStudyMouseMoved;
    BufferedImage shootImage;
    BufferedImage showTrajectoryImage;
    BufferedImage shootMouseMovedImage;
    BufferedImage shootMouseClickedImage;
    BufferedImage showTrajectoryMouseMovedImage;
    BufferedImage showTrajectoryMouseClickedImage;
    BufferedImage finishStudy;
    BufferedImage finishStudyMouseMoved;
    BufferedImage GoTo2Level;
    BufferedImage GoTo2LevelMouseMoved;
    BufferedImage GoTo3Level;
    BufferedImage GoTo3LevelMouseMoved;
    BufferedImage KurskImage;
    BufferedImage Leningrad;
    BufferedImage Stalingrad;
    BufferedImage MapKursk;
    BufferedImage MapLeningrad;
    BufferedImage MapStalingrad;
    BufferedImage FinalImage;
    BufferedImage Yesimage;
    BufferedImage YesMouseMovedImage;
    BufferedImage NoImage;
    BufferedImage NoMouseMovedImage;
    BufferedImage floor;
    BufferedImage floor1;

    public Panel() throws IOException {
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());
        tank.initialize(300, 660);
        enemytank.initialize(800, 140);
        plane.initialize(120, 100, 0);

        enemytank.x1 = -1;
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        dieImage = ImageIO.read(Panel.class.getResourceAsStream("image-created.png"));
        winImage = ImageIO.read((Panel.class.getResourceAsStream("477-4772900_icon-you-win-graphic-design-hd-png-download.png")));
        studyImage = ImageIO.read(Panel.class.getResourceAsStream("обучение01.png"));
        study1Image = ImageIO.read(Panel.class.getResourceAsStream("инфа1.png"));
        level1Image = ImageIO.read(Panel.class.getResourceAsStream("обучение01.png"));
        level2Image = ImageIO.read(Panel.class.getResourceAsStream("ы (1).png"));
        level1backgroundImage = ImageIO.read(Panel.class.getResourceAsStream("imgonline-com-ua-Resize-LdS3Mu9x4idZoD9.png"));
        level2backgroundImage = ImageIO.read(Panel.class.getResourceAsStream(/*"src/scale_1200.png"*/"немецкий бомбардировщик.jpg"));
        level3backgroundImage = ImageIO.read(Panel.class.getResourceAsStream("3background.png"));
        level0background = ImageIO.read(Panel.class.getResourceAsStream("level0background.png"));
        shootImage=ImageIO.read(Panel.class.getResourceAsStream("shootpng1.png"));
        shootMouseMovedImage =ImageIO.read(Panel.class.getResourceAsStream("shootmousemoved2.png"));
        shootMouseClickedImage=ImageIO.read(Panel.class.getResourceAsStream("shootmouseclicked2.png"));
        showTrajectoryImage =ImageIO.read(Panel.class.getResourceAsStream("showtraektorypng1.png"));
        showTrajectoryMouseMovedImage =ImageIO.read(Panel.class.getResourceAsStream("showtraektorymousemoved2.png"));
        showTrajectoryMouseClickedImage =ImageIO.read(Panel.class.getResourceAsStream("showtraektorymouseclicked2.png"));
        beginStudy=ImageIO.read(Panel.class.getResourceAsStream("beginstudy.png"));
        beginStudyMouseMoved=ImageIO.read(Panel.class.getResourceAsStream("beginstudymousemoved.png"));
        floor =ImageIO.read(Panel.class.getResourceAsStream("level0background0000.png"));
        floor1=ImageIO.read(Panel.class.getResourceAsStream("level0background11111.png"));
        finishStudy =ImageIO.read(Panel.class.getResourceAsStream("finishstudy.png"));
        finishStudyMouseMoved=ImageIO.read(Panel.class.getResourceAsStream("finishstudymousemoved.png"));
        GoTo2Level=ImageIO.read(Panel.class.getResourceAsStream("goto2level.png"));
        GoTo2LevelMouseMoved=ImageIO.read(Panel.class.getResourceAsStream("goto2levelmousemoved.png"));
        GoTo3Level=ImageIO.read(Panel.class.getResourceAsStream("goto3level.png"));
        GoTo3LevelMouseMoved=ImageIO.read(Panel.class.getResourceAsStream("goto3levelmousemoved.png"));
        KurskImage =ImageIO.read(Panel.class.getResourceAsStream("Курская битва.jpg"));
        Leningrad=ImageIO.read(Panel.class.getResourceAsStream("Битва за Ленинград.jpg"));
        Stalingrad=ImageIO.read(Panel.class.getResourceAsStream("Сталинградская битва 2.jpg"));
        level3Image=ImageIO.read(Panel.class.getResourceAsStream("уровень 3 1.png"));
        MapKursk=ImageIO.read(Panel.class.getResourceAsStream("карта ссср курск.jpg"));
        MapLeningrad=ImageIO.read(Panel.class.getResourceAsStream("карта ссср ленинград.jpg"));
        MapStalingrad=ImageIO.read(Panel.class.getResourceAsStream("карта ссср сталинград.jpg"));
        FinalImage=ImageIO.read(Panel.class.getResourceAsStream("советский флаг над рейхстагом фото.jpg"));
        Yesimage=ImageIO.read(Panel.class.getResourceAsStream("да.png"));
        YesMouseMovedImage=ImageIO.read(Panel.class.getResourceAsStream("да1.png"));
        NoImage=ImageIO.read(Panel.class.getResourceAsStream("нет.png"));
        NoMouseMovedImage=ImageIO.read(Panel.class.getResourceAsStream("нет1.png"));
    }



    @Override
    public void paintComponent(Graphics g) {
         //numberOfTheLevel=4;                                                            //надо будет потом убрать!!!!
        currentTime = System.currentTimeMillis();
        deltaTime = currentTime - previousTime;
        previousTime = currentTime;
        if (numberOfTheLevel == -1 || timeStudy >= 0) {
            if (timeStudy >= 0 && timeStudy <= 200) {
                g.drawImage(study1Image, 100, 0, 1131, 1600, null);
                timeStudy -= deltaTime /5.0;
            } else {
                g.drawImage(studyImage, 0, 0, 1425, 600, null);
                g.setColor(Color.BLACK);
                g.drawImage(beginStudy,50,500,272,60,null);
                if (studyF ==1){
                    g.drawImage(beginStudyMouseMoved,50,500,272,60,null);
                }

            }
        }
        else if (numberOfTheLevel == 0 || timeLevel1 >= 0) {                                                              //0 level started
            if (timeLevel1 >= 0 && timeLevel1 <= 800) {
                if (timeLevel1 >=680) {
                g.drawImage(level1Image, 100, 0, 1131, 1600, null); }
                else {g.drawImage(KurskImage,600,0,882,740,null);
                g.drawImage(MapKursk,0,0,592,740,null);}
                timeLevel1 -= deltaTime / 6.5;
                enemytank.enemyball.vy = -1;
                enemytank.enemyball.y = -1;
                if (Math.abs(timeLevel1-5)<2.0){
                    new Thread(() -> {
                        enemyTankGo.playSound("h");
                    }).start();
                }

            } else {
                g.drawImage(level0background, 0, 0, 1500, 800, null);
                g.setColor(Color.BLACK);
                g.drawImage(shootImage,50,15,110,40,null);
                g.drawImage(showTrajectoryImage,50,58,180,40,null);
                g.drawImage(finishStudy,50,150,187,40,null);
                if (shootButtonMoved ==1){
                    g.drawImage(shootMouseMovedImage,50,15,110,40,null);
                }
                if (shootButtonMoved ==2){
                    g.drawImage(shootMouseClickedImage,50,15,110,40,null);
                    f3=1;
                }

                if (showTrajectoryButtonMoved ==1&&f3==1){
                    g.drawImage(showTrajectoryMouseMovedImage,50,58,180,40,null);
                } else
                if (f3==0){

                    g.drawImage(showTrajectoryMouseClickedImage,50,58,180,40,null);
                } else if (timeTrajectory ==0){f3=0;}
                if (timeTrajectory ==400){f3=0;}
                if (timeTrajectory ==0){f3=1;}
                if (finishStudyF ==1){
                    g.drawImage(finishStudyMouseMoved,50,150,187,40,null);
                }




                g.setFont(new Font("Impact",Font.PLAIN, 14));
                g.drawString("Скорость равна=" + (int) (ball.v), 50, 115);
                g.drawString("Угол равен=" + (int) (ball.angle * 180 / Math.PI), 50, 133);
                g.drawString("Обучение", 700, 50);
                g.setColor(Color.GRAY);
                //g.fillRect(0, 720, 1500, 80);
                g.drawImage(floor,0, 720, 1500, 80,null);

                if (f == 1) {
                    if (timeTrajectory >= 0) {
                        ball.drawline( ball.y, ball.x, ball.y, ball.vx, ball.vy, g, -1);
                        timeTrajectory -= deltaTime / 10.0;
                        try {
                            ball.initialize(ball.v, ball.angle, tank.x, (800 - tank.y));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    if (timeTrajectory == -1) {
                        f = -1;
                    }

                }

                if (ifBulletIsDrawingAndUpdating == 1) {
                    if (ball.y >= (750 - tank.y)) {
                        ball.draw(g, -1);
                        //System.out.println("jjj");
                        ball.update((deltaTime / 200.0), ball.y0, -1);
                    } else {

                        if (boomR < 10) {
                            g.setColor(Color.RED);
                        } else if (boomR < 20) {
                            Color color = new Color(250, 102, 4);
                            g.setColor(color);
                        } else if (boomR < 30) {
                            g.setColor(Color.ORANGE);
                        } else if (boomR < 40) {
                            g.setColor(Color.YELLOW);
                        }
                        if (Math.abs(boomR-40)<1.0){
                            ifTankShooting =0;
                        }

                        g.fillOval((int) (ball.x + 30 - boomR), (int) (800 - ball.y + 10 - boomR), 2 * (int) (boomR), 2 * (int) (boomR));
                        if (boomR < 39) {
                            boomR = boomR + deltaTime / 30.0;
                        } else {
                            boomR = 0;
                            ifBulletIsDrawingAndUpdating = 0;

                        }

                    }
                }

                if (moveRight == 1 && tank.x < 1380) {
                    tank.moveRight(deltaTime / 10.0);
                } else if (moveLeft == 1 && tank.x > 0) {
                    tank.moveLeft(deltaTime / 10.0);
                }

                tank.draw(g, -1,ball.angle);
                tank.drawHealth(g);
                if ((moveLeft ==1 || moveRight ==1)&& tankGof ==0){
                    tankGo =1;
                new Thread(() -> {
                    sound1.bool=1;
                    sound1.playSound("h");
                }).start();
                tankGof =1;}
                if (moveRight ==0&& moveLeft ==0){
                    tankGo =0;
                    tankGof =0;
                    sound1.bool=0;
                }

                if (vPlus == 1) {
                    ball.v += 0.2;
                } else if (vMinus == 1) {
                    ball.v -= 0.2;
                }

                if (anglePlus == 1&&ball.angle<=80/180.0*3.1416) {
                    ball.angle = ball.angle + 1 / 1800.0 * Math.PI;
                } else if (angleMinus == 1&&ball.angle>=0/180.0*3.1416) {
                    ball.angle = ball.angle - 1 / 1800.0 * Math.PI;
                }
                if (f == 1) {
                    ifBulletIsDrawingAndUpdating = 0;
                }

                //f = 0;
            }
        }
        else if (numberOfTheLevel == 1) {
            if (timeLevel2 >= 0) {
                if (timeLevel2 >= 700  ){
                g.drawImage(level2Image, 0, 0, 1500, 2121, null);}
                else {g.drawImage(Leningrad,586,0,876,730,null);
                g.drawImage(MapLeningrad,0,0,584,730,null);}
                if (timeLevel2 == 0) {
                    numberOfTheLevel = 2;
                    try {
                        plane.bomb.initialize(120, 100, 30);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                timeLevel2 -= deltaTime / 10.0;
            } else {
                g.drawImage(level1backgroundImage, 0, 0, 1500, 800, null);
                g.setColor(Color.BLACK);                                                                           //1 level started
                g.drawImage(shootImage,50,15,110,40,null);
                sound1.bool= tankGo;
                g.drawImage(showTrajectoryImage,50,58,180,40,null);
                g.drawImage(GoTo2Level,50,140,178,40,null);
                if (goto2level==1){
                    g.drawImage(GoTo2LevelMouseMoved,50,140,178,40,null);
                }
                if (shootButtonMoved ==1){
                    g.drawImage(shootMouseMovedImage,50,15,110,40,null);
                }
                if (shootButtonMoved ==2){
                    g.drawImage(shootMouseClickedImage,50,15,110,40,null);
                    f3=1;
                }


                if (showTrajectoryButtonMoved ==1&&f3==1){
                    g.drawImage(showTrajectoryMouseMovedImage,50,58,180,40,null);
                } else
                if (f3==0){
                    g.drawImage(showTrajectoryMouseClickedImage,50,58,180,40,null);
                } else if (timeTrajectory ==0){f3=0;}
                if (timeTrajectory ==400){f3=0;}
                if (timeTrajectory ==0){f3=1;}



                g.setFont(new Font("Impact",Font.PLAIN, 14));
                g.drawString("Скорость равна=" + (int) (ball.v), 50, 115);
                g.drawString("Угол равен=" + (int) (ball.angle * 180 / Math.PI), 50, 133);
                g.setColor(Color.GRAY);
                g.drawImage(floor,0,720,1500,80,null);
                if (tank.x < enemytank.x) {
                    enemytank.draw(g, 1);
                } else {
                    enemytank.draw(g, -1);
                }

                enemytank.drawhealth(g);
                if ((int) (ball.xstroke) >= (enemytank.x/*-10*/) && (int) (ball.xstroke) <= (enemytank.x + 120/*+130*/)) {
                    enemytank.health -= 1;
                }

                if (Math.abs(enemytank.enemyball.y - enemytank.enemyball.y0 + 60) < 3.5 && enemytank.enemyball.y != enemytank.enemyball.y0) {
                    if (tank.x < enemytank.x) {
                        enemyBallDirection = -1;
                    } else {
                        enemyBallDirection = 1;
                    }

                }


                if (enemytank.enemyball.xstroke > 0) {
                    EnemyBoom = 1;
                    enemytank.enemyball.xstroke = -10000;
                    enemyBoomDirection = enemyBallDirection;
                }

                if (EnemyBoom == 1) {
                    if (enemyBoomR < 10) {
                        g.setColor(Color.RED);
                    } else if (enemyBoomR < 20) {
                        Color color = new Color(250, 102, 4);
                        g.setColor(color);
                    } else if (enemyBoomR < 30) {
                        g.setColor(Color.ORANGE);
                    } else if (enemyBoomR < 40) {
                        g.setColor(Color.YELLOW);
                    }


                    g.fillOval((int) (enemytank.enemyball.x + 30 - enemyBoomR), (int) (800 - enemytank.enemyball.y + 10 - enemyBoomR), 2 * (int) (enemyBoomR), 2 * (int) (enemyBoomR));
                    if (enemyBoomR < 39) {
                        enemyBoomR = enemyBoomR + deltaTime / 30.0;
                    } else {
                        enemyBoomR = 0;
                        EnemyBoom = 0;
                    }

                }

                try {
                    if (EnemyBoom == 0) {
                        enemytank.shoot(deltaTime / 200.0, tank.x, 82, g, enemyBallDirection);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (enemytank.enemyball.xstroke >= tank.x && enemytank.enemyball.xstroke <= (tank.x + 120)) {
                    tank.health -= 1;
                    //System.out.println(tank.health);
                }

                if (tank.x < enemytank.x) {
                    enemytank.move(deltaTime / 20.0, tank.x, -1);
                } else {
                    enemytank.move(deltaTime / 20.0, tank.x, 1);
                }

                if (f == 1) {
                    if (timeTrajectory >= 0) {
                        ball.drawline( ball.y, ball.x, ball.y, ball.vx, ball.vy, g, ballDirection);

                        timeTrajectory -= deltaTime / 10.0;
                        try {
                            ball.initialize(ball.v, ball.angle, tank.x, (800 - tank.y));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    if (timeTrajectory == -1) {
                        f = -1;
                    }

                }

                if (ifBulletIsDrawingAndUpdating == 1) {
                    if (ball.y >= (750 - tank.y)) {
                        ball.draw(g, ballDirection);
                        ball.update(deltaTime / 200.0, ball.y0, ballDirection);
                    } else {
                        ball.xstroke = -10000;
                        if (boomR < 10) {
                            g.setColor(Color.RED);
                        } else if (boomR < 20) {
                            Color color = new Color(250, 102, 4);
                            g.setColor(color);
                        } else if (boomR < 30) {
                            g.setColor(Color.ORANGE);
                        } else if (boomR < 40) {
                            g.setColor(Color.YELLOW);
                        }
                        if (Math.abs(boomR-40)<1.0){
                            ifTankShooting =0;
                        }


                        if (ballDirection == -1) {
                            g.fillOval((int) (ball.x + 30 - boomR), (int) (800 - ball.y + 10 - boomR), 2 * (int) (boomR), 2 * (int) (boomR));
                        } else {
                            g.fillOval((int) (ball.x - 80 - boomR), (int) (800 - ball.y + 10 - boomR), 2 * (int) (boomR), 2 * (int) (boomR));
                        }
                        if (boomR < 39) {
                            boomR = boomR + deltaTime / 30.0;
                        } else {
                            boomR = 0;
                            ifBulletIsDrawingAndUpdating = 0;
                        }

                    }
                }

                if (moveRight == 1 && tank.x < 1380) {
                    tank.moveRight(deltaTime / 10.0);
                } else if (moveLeft == 1 && tank.x > 0) {
                    tank.moveLeft(deltaTime / 10.0);
                }

                if ((moveLeft ==1 || moveRight ==1)&& tankGof ==0){
                    tankGo =1;
                    new Thread(() -> {
                        sound1.bool=1;
                        sound1.playSound("h");
                    }).start();
                    tankGof =1;}
                if (moveRight ==0&& moveLeft ==0){
                    tankGo =0;
                    tankGof =0;
                    sound1.bool=0;
                }
                if ((tank.x < enemytank.x)) {
                    tank.draw(g, -1,ball.angle);
                } else {
                    tank.draw(g, 1,ball.angle);
                }

                tank.drawHealth(g);
                if (vPlus == 1) {
                    ball.v += 0.2;
                } else if (vMinus == 1) {
                    ball.v -= 0.2;
                }

                if (anglePlus == 1&&ball.angle<=80/180.0*3.1416) {
                    ball.angle = ball.angle + 1 / 1800.0 * Math.PI;
                } else if (angleMinus == 1&&ball.angle>=0/180.0*3.1416) {
                    ball.angle = ball.angle - 1 / 1800.0 * Math.PI;
                }
                if (f == 1) {
                    ifBulletIsDrawingAndUpdating = 0;
                }

                // f = 0;

                if (tank.health <= 0 && time < 100) {
                    g.drawImage(dieImage, 0, 0, 1500, 800, null);
                    time += deltaTime / 10.0;
                    if (Math.abs(time - 99)<2.0) {
                        tank.health = 10;
                        enemytank.health = 2;
                        ifTankShooting =0;
                        time = 0;
                    }
                }

                if (enemytank.health <= 0 && timeWin < 100) {
                    g.drawImage(winImage, 0, 0, 1500, 800, null);
                    timeWin += deltaTime / 10.0;
                    enemyTankGo.bool=0;
                    if (Math.abs(timeWin - 99)<2.0) {
                        tank.health = 10;
                        enemytank.health = 2;
                        timeWin = 0;

                        timeLevel2 = 800;
                        enemyBoomR =0;
                        try {
                            plane.bomb.initialize(120, 100, 30);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                                                                                                          //1 level ended
            }


        }
        else if (numberOfTheLevel == 2) {                                                                    //level 2 started
            if (timeLevel3 >= 0) {
                if (timeLevel3 >= 700  ){
                    g.drawImage(level3Image, 0, 0, 1500, 2121, null);}
                else {g.drawImage(Stalingrad,755,0,563,750,null);
                g.drawImage(MapStalingrad,150,0,600,750,null);}
                if (timeLevel3 == 0) {
                    numberOfTheLevel = 3;
                    enemyTankGo.bool=1;
                    tank.health = 10;
                    plane.health = 15;
                    timeWin = 0;
                    timeLevel3 =-1;
                }

                timeLevel3 -= deltaTime / 10.0;} else{
            g.drawImage(level2backgroundImage, 0, 0, 1500, 800, null);
            g.setColor(Color.BLACK);
                sound1.bool= tankGo;
            g.drawImage(shootImage,50,15,110,40,null);
            g.drawImage(showTrajectoryImage,50,58,180,40,null);
            g.drawImage(GoTo3Level,50,140,180,40,null);
            if (goto3level==1){
                g.drawImage(GoTo3LevelMouseMoved,50,140,180,40,null);
            }
            if (shootButtonMoved ==1){

                g.drawImage(shootMouseMovedImage,50,15,110,40,null);
            }
            if (shootButtonMoved ==2){

                g.drawImage(shootMouseClickedImage,50,15,110,40,null);
                f3=1;
            }


            if (showTrajectoryButtonMoved ==1&&f3==1){

                g.drawImage(showTrajectoryMouseMovedImage,50,58,180,40,null);
            } else
            if (f3==0){

                g.drawImage(showTrajectoryMouseClickedImage,50,58,180,40,null);
            } else if (timeTrajectory ==0){f3=0;}
            if (timeTrajectory ==400){f3=0;}
            if (timeTrajectory ==0){f3=1;}



            g.setFont(new Font("Impact",Font.PLAIN, 14));
            g.drawString("Скорость равна=" + (int) (ball.v), 50, 115);
            g.drawString("Угол равен=" + (int) (ball.angle * 180 / Math.PI), 50, 133);
            g.setColor(Color.GRAY);

            g.drawImage(floor,0,720,1500,80,null);
            plane.update(deltaTime / 70.0);

            if (plane.xstroke > 0) {
                planeBoom = 1;
                planeBoomDirection = (int) (plane.xstroke);
                plane.xstroke = -100000;
                new Thread(() -> {
                    soundBomb.playSound("h");
                }).start();

            }

            if (planeBoom == 0) {
                try {
                    plane.shoot(deltaTime / 150.0, g, 720);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (planeBoom == 1) {
                if (enemyBoomR < 10) {
                    g.setColor(Color.RED);
                } else if (enemyBoomR < 20) {
                    Color color = new Color(250, 102, 4);
                    g.setColor(color);
                } else if (enemyBoomR < 30) {
                    g.setColor(Color.ORANGE);
                } else if (enemyBoomR < 40) {
                    g.setColor(Color.YELLOW);
                }


                g.fillOval((int) (planeBoomDirection - enemyBoomR), (int) (tank.y + 60 - enemyBoomR), 2 * (int) (enemyBoomR), 2 * (int) (enemyBoomR));
                if (enemyBoomR < 39) {
                    enemyBoomR = enemyBoomR + deltaTime / 30.0;
                } else {
                    enemyBoomR = 0;
                    planeBoom = 0;
                    try {
                        plane.bomb.initialize((plane.x + (plane.direction + 1) * 60), plane.y, 30);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    plane.xstroke = -100000;

                }

            }
            plane.draw(g);
            plane.drawHealth(g);
            if (plane.xstroke >= tank.x && plane.xstroke <= (tank.x + 120)) {
                tank.health -= 1;
                //System.out.println(tank.health);
            }

            if (ball.x >= plane.x && ball.x <= (plane.x + 120) && (800 - ball.y) >= (plane.y - 48) && (800 - ball.y) <= (plane.y)) {
                if (planeStroke == 0) {
                    plane.health -= 1;
                    planeStroke = 1;
                }

            } else {
                planeStroke = 0;
            }

            if (f == 1) {
                if (timeTrajectory >= 0) {
                    ball.drawline( ball.y, ball.x, ball.y, ball.vx, ball.vy, g, -1);

                    timeTrajectory -= deltaTime / 10.0;
                    try {
                        ball.initialize(ball.v, ball.angle, tank.x, (800 - tank.y));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                if (timeTrajectory == -1) {
                    f = -1;
                }

            }

            if (ifBulletIsDrawingAndUpdating == 1) {
                if (ball.y >= (750 - tank.y)) {
                    ball.draw(g, -1);
                    ball.update(deltaTime / 200.0, ball.y0, -1);
                } else {
                    if (boomR < 10) {
                        g.setColor(Color.RED);
                    } else if (boomR < 20) {
                        Color color = new Color(250, 102, 4);
                        g.setColor(color);
                    } else if (boomR < 30) {
                        g.setColor(Color.ORANGE);
                    } else if (boomR < 40) {
                        g.setColor(Color.YELLOW);
                    }
                    if (Math.abs(boomR-40)<1.0){
                        ifTankShooting =0;
                    }

                    g.fillOval((int) (ball.x + 30 - boomR), (int) (800 - ball.y + 10 - boomR), 2 * (int) (boomR), 2 * (int) (boomR));
                    if (boomR < 39) {
                        boomR = boomR + deltaTime / 30.0;
                    } else {
                        boomR = 0;
                        ifBulletIsDrawingAndUpdating = 0;
                    }

                }
            }

            if (moveRight == 1 && tank.x < 1380) {
                tank.moveRight(deltaTime / 10.0);
            } else if (moveLeft == 1 && tank.x > 0) {
                tank.moveLeft(deltaTime / 10.0);
            }

            tank.draw(g, -1,ball.angle);
            tank.drawHealth(g);
                if ((moveLeft ==1 || moveRight ==1)&& tankGof ==0){
                    tankGo =1;
                    new Thread(() -> {
                        sound1.bool=1;
                        sound1.playSound("h");
                    }).start();
                    tankGof =1;}
                if (moveRight ==0&& moveLeft ==0){
                    tankGo =0;
                    tankGof =0;
                    sound1.bool=0;
                }
            if (vPlus == 1) {
                ball.v += 0.2;
            } else if (vMinus == 1) {
                ball.v -= 0.2;
            }

            if (anglePlus == 1&&ball.angle<=80/180.0*3.1416) {
                ball.angle = ball.angle + 1 / 1800.0 * Math.PI;
            } else if (angleMinus == 1&&ball.angle>=0/180.0*3.1416) {
                ball.angle = ball.angle - 1 / 1800.0 * Math.PI;
            }
            if (f == 1) {
                ifBulletIsDrawingAndUpdating = 0;
            }

            //f = 0;

            if (tank.health <= 0 && time < 100) {
                g.drawImage(dieImage, 0, 0, 1500, 800, null);
                time += deltaTime / 10;
                if (Math.abs(time- 99)<2.0) {
                    tank.health = 10;
                    plane.health = 15;
                    ifTankShooting =0;
                    time = 0;
                }
            }

            if (plane.health <= 0 && timeWin < 100) {
                g.drawImage(winImage, 0, 0, 1500, 800, null);
                timeWin += deltaTime / 10;
                if (Math.abs(timeWin - 99)<2.0) {
                    tank.health = 10;
                    plane.health = 15;
                    timeWin = 0;
                    tank.initialize(300, 660);
                    enemyTankGo.bool=1;
                    //numberOfTheLevel = 3;
                    timeLevel3 =800;
                }
            }

        } }                                                                                                    //level2 ended


        else if (numberOfTheLevel == 3) {                                                                           //level3 started
            g.drawImage(level3backgroundImage, 0, 0, 1500, 800, null);
            g.setColor(Color.BLACK);
            sound1.bool= tankGo;
            g.drawImage(shootImage,50,15,110,40,null);
            g.drawImage(showTrajectoryImage,50,58,180,40,null);
            if (shootButtonMoved ==1){

                g.drawImage(shootMouseMovedImage,50,15,110,40,null);
            }
            if (shootButtonMoved ==2){

                g.drawImage(shootMouseClickedImage,50,15,110,40,null);
                f3=1;
            }


            if (showTrajectoryButtonMoved ==1&&f3==1){

                g.drawImage(showTrajectoryMouseMovedImage,50,58,180,40,null);
            } else
            if (f3==0){

                g.drawImage(showTrajectoryMouseClickedImage,50,58,180,40,null);
            } else if (timeTrajectory ==0){f3=0;}
            if (timeTrajectory ==400){f3=0;}
            if (timeTrajectory ==0){f3=1;}



            g.setFont(new Font("Impact",Font.PLAIN, 14));
            g.drawString("Скорость равна=" + (int) (ball.v), 50, 115);
            g.drawString("Угол равен=" + (int) (ball.angle * 180 / Math.PI), 50, 133);
            g.setColor(Color.GRAY);
            g.drawImage(floor,0, 720, 1500, 80,null);
            g.drawImage(floor1,800, 600, 700, 200,null);
            if (threeBegin < 2) {
                tank.initialize(300, 660);
                enemytank.initialize(1000, 260);
                plane.initialize(100, 100, 0);
                enemyTankGo.bool=1;
                try {
                    plane.bomb.initialize(100, 100, 30);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                enemytank.enemyball.vy = -1;
                plane.xstroke = -10000;
                enemytank.enemyball.y = 0;
            }

            threeBegin += 1;
            if (f == 1) {
                if (timeTrajectory >= 0) {
                    ball.drawline( (ball.y + 100), ball.x, ball.y, ball.vx, ball.vy, g, -1);

                    timeTrajectory -= deltaTime / 10.0;
                    try {
                        ball.initialize(ball.v, ball.angle, tank.x, (800 - tank.y));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                if (timeTrajectory == -1) {
                    f = -1;
                }

            }

            if (ifBulletIsDrawingAndUpdating == 1) {
                if ((ball.y >= (750 - tank.y + 120) || ball.vy > 0 || ball.x < 800 && ball.y >= (750 - tank.y))&&(ball.x<770||ball.y>200)) {
                    ball.draw(g, -1);
                    ball.update(deltaTime / 200.0, (750 - tank.y + 120), -1);
                } else {
                    if (boomR < 10) {
                        g.setColor(Color.RED);
                    } else if (boomR < 20) {
                        Color color = new Color(250, 102, 4);
                        g.setColor(color);
                    } else if (boomR < 30) {
                        g.setColor(Color.ORANGE);
                    } else if (boomR < 40) {
                        g.setColor(Color.YELLOW);
                    }
                    if (Math.abs(boomR-40)<2.5){
                        ifTankShooting =0;
                    }

                    g.fillOval((int) (ball.x + 30 - boomR), (int) (800 - ball.y + 10 - boomR), 2 * (int) (boomR), 2 * (int) (boomR));
                    if (boomR < 39) {
                        boomR = boomR + deltaTime / 30.0;
                    } else {
                        boomR = 0;
                        ifBulletIsDrawingAndUpdating = 0;
                    }

                }
            }

            if (moveRight == 1 && tank.x < 680) {
                tank.moveRight(deltaTime / 10.0);
            } else if (moveLeft == 1 && tank.x > 0) {
                tank.moveLeft(deltaTime / 10.0);
            }

            tank.draw(g, -1,ball.angle);
            tank.drawHealth(g);
            if ((moveLeft ==1 || moveRight ==1)&& tankGof ==0){
                tankGo =1;
                new Thread(() -> {
                    sound1.bool=1;
                    sound1.playSound("h");
                }).start();
                tankGof =1;}
            if (moveRight ==0&& moveLeft ==0){
                tankGo =0;
                tankGof =0;
                sound1.bool=0;
            }
            if (enemytank.health > 0) {
                enemytank.draw(g, 1);
                enemytank.drawhealth(g);
                if ((int) (ball.xstroke) >= (enemytank.x/*-10*/) && (int) (ball.xstroke) <= (enemytank.x + 120/*+130*/)) {
                    enemytank.health -= 1;
                    //System.out.println(tank.health);
                }

                if (Math.abs(enemytank.enemyball.y - enemytank.enemyball.y0) < 2.5 && enemytank.enemyball.y != enemytank.enemyball.y0) {
                    if (tank.x < enemytank.x) {
                        enemyBallDirection = -1;
                    } else {
                        enemyBallDirection = 1;
                    }

                }

                if (enemytank.enemyball.xstroke > 0) {
                    EnemyBoom = 1;
                    enemytank.enemyball.xstroke = -10000;
                    enemyBoomDirection = enemyBallDirection;
                }

                if (EnemyBoom == 1) {
                    if (enemyBoomR < 10) {
                        g.setColor(Color.RED);
                    } else if (enemyBoomR < 20) {
                        Color color = new Color(250, 102, 4);
                        g.setColor(color);
                    } else if (enemyBoomR < 30) {
                        g.setColor(Color.ORANGE);
                    } else if (enemyBoomR < 40) {
                        g.setColor(Color.YELLOW);
                    }


                    g.fillOval((int) (enemytank.enemyball.x + 30 - enemyBoomR), (int) (800 - enemytank.enemyball.y + 10 - enemyBoomR), 2 * (int) (enemyBoomR), 2 * (int) (enemyBoomR));
                    if (enemyBoomR < 39) {
                        enemyBoomR = enemyBoomR + deltaTime / 30.0;
                    } else {
                        enemyBoomR = 0;
                        EnemyBoom = 0;
                    }

                }

                try {
                    if (EnemyBoom == 0) {
                        enemytank.shoot(deltaTime / 200.0, tank.x, 800 - tank.y - 60, g, enemyBallDirection);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (enemytank.enemyball.xstroke >= tank.x && enemytank.enemyball.xstroke <= (tank.x + 120)) {
                    tank.health -= 1;
                    //System.out.println(tank.health);
                }


                enemytank.move(deltaTime / 20.0, 800, -1);
            } else{
                enemyTankGo.bool=0;}

            if (vPlus == 1) {
                ball.v += 0.2;
            } else if (vMinus == 1) {
                ball.v -= 0.2;
            }

            if (anglePlus == 1&&ball.angle<=80/180.0*3.1416) {
                ball.angle = ball.angle + 1 / 1800.0 * Math.PI;
            } else if (angleMinus == 1&&ball.angle>=0/180.0*3.1416) {
                ball.angle = ball.angle - 1 / 1800.0 * Math.PI;
            }
            if (f == 1) {
                ifBulletIsDrawingAndUpdating = 0;
            }

            if (plane.health > 0) {
                plane.draw(g);
                if (plane.bomb.x < 800) {

                    if (plane.xstroke > 0) {
                        planeBoom = 1;
                        planeBoomDirection = (int) (plane.xstroke);
                        plane.xstroke = -100000;


                    }

                    if (planeBoom == 0) {
                        try {
                            plane.shoot(deltaTime / 150.0, g, 720);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else if (planeBoom == 1) {
                        if (enemyBoomR3==0){
                            new Thread(() -> {
                                soundBomb.playSound("h");
                            }).start();
                        }
                        if (enemyBoomR3 < 10) {
                            g.setColor(Color.RED);
                        } else if (enemyBoomR3 < 20) {
                            Color color = new Color(250, 102, 4);
                            g.setColor(color);
                        } else if (enemyBoomR3 < 30) {
                            g.setColor(Color.ORANGE);
                        } else if (enemyBoomR3 < 40) {
                            g.setColor(Color.YELLOW);
                        }


                        g.fillOval((int) (planeBoomDirection - enemyBoomR3), (int) (720 - enemyBoomR3), 2 * (int) (enemyBoomR3), 2 * (int) (enemyBoomR3));
                        if (enemyBoomR3 < 39) {
                            enemyBoomR3 = (enemyBoomR3 + deltaTime / 30.0);
                        } else {
                            enemyBoomR3 = 0;
                            planeBoom = 0;
                            try {
                                plane.bomb.initialize((plane.x + (plane.direction + 1) * 60), plane.y, 30);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            plane.xstroke = -100000;

                        }

                    }

                } else {
                    if (plane.xstroke > 0) {
                        planeBoom = 1;
                        planeBoomDirection = (int) (plane.xstroke);
                        plane.xstroke = -100000;

                    }

                    if (planeBoom == 0) {
                        try {
                            plane.shoot(deltaTime / 150.0, g, 600);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else if (planeBoom == 1) {
                        if (enemyBoomR3==0){
                            new Thread(() -> {
                                soundBomb.playSound("h");
                            }).start();
                        }
                        if (enemyBoomR3 < 10) {
                            g.setColor(Color.RED);
                        } else if (enemyBoomR3 < 20) {
                            Color color = new Color(250, 102, 4);
                            g.setColor(color);
                        } else if (enemyBoomR3 < 30) {
                            g.setColor(Color.ORANGE);
                        } else if (enemyBoomR3 < 40) {
                            g.setColor(Color.YELLOW);
                        }


                        g.fillOval((int) (planeBoomDirection - enemyBoomR3), (int) (600 - enemyBoomR3), 2 * (int) (enemyBoomR3), 2 * (int) (enemyBoomR3));
                        if (enemyBoomR3 < 39) {
                            enemyBoomR3 = (enemyBoomR3 + deltaTime / 30.0);
                        } else {
                            enemyBoomR3 = 0;
                            planeBoom = 0;
                            try {
                                plane.bomb.initialize((plane.x + (plane.direction + 1) * 60), plane.y, 30);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            plane.xstroke = -100000;

                        }

                    }

                }
                plane.drawHealth(g);
                plane.update(deltaTime / 70.0);
            }
            if (plane.xstroke >= tank.x && plane.xstroke <= (tank.x + 120)) {
                tank.health -= 1;
                //System.out.println(tank.health);
            }

            if (ball.x >= plane.x && ball.x <= (plane.x + 120) && (800 - ball.y) >= (plane.y - 48) && (800 - ball.y) <= (plane.y)) {
                if (planeStroke == 0) {
                    plane.health -= 3;
                    planeStroke = 1;
                }

            } else {
                planeStroke = 0;
            }


            if (tank.health <= 0 && time < 100) {
                g.drawImage(dieImage, 0, 0, 1500, 800, null);
                time += deltaTime / 10;
                if (time == 99) {
                    tank.health = 10;
                    plane.health = 15;
                    time = 0;
                }
            }

            if (plane.health <= 0 && enemytank.health <= 0 && timeWin < 100) {
                g.drawImage(winImage, 0, 0, 1500, 800, null);
                timeWin += deltaTime / 10;
                if (Math.abs(timeWin -100) <= 2) {
                    tank.health = 10;
                    enemytank.health = 2;
                    plane.health = 15;
                    timeWin = 0;
                    numberOfTheLevel = 4;
                    enemyTankGo.bool=0;
                    howManyTimesIWon+=1;
                }
            }

            if (tank.health <= 0 && time < 100) {
                g.drawImage(dieImage, 0, 0, 1500, 800, null);
                time += deltaTime / 10;
                if (time == 99) {
                    tank.health = 10;
                    plane.health = 15;
                    ifTankShooting =0;
                    enemytank.health = 2;
                    time = 0;
                    enemyTankGo.bool=1;
                }
            }



        }
        else if (numberOfTheLevel==4){
            if (timeLevel4==-1){                      // delete then
                deltaTime=10;
            }
            if (timeLevel4<300) {
                timeLevel4 = timeLevel4+deltaTime/10.0;
               // System.out.println(timeLevel4);
                g.drawImage(FinalImage,0,0,1500,800,null);
            } else {
                g.setFont(new Font("Impact",Font.PLAIN, 80));
                g.drawString("Вы выиграли войну !!!",350,100);
                g.setFont(new Font("Impact",Font.PLAIN, 50));
                g.drawString("Начать заново ?",500,200);
                if (yesMouseMoved==0) {
                    g.drawImage(Yesimage, 450, 250, 175, 100, null);
                } else {g.drawImage(YesMouseMovedImage, 450, 250, 175, 100, null);}
                if (noMouseMoved==0){
                g.drawImage(NoImage,700,250,177,100,null);}
                else {g.drawImage(NoMouseMovedImage,700,250,177,100,null);}
                g.setFont(new Font("Impact",Font.PLAIN, 30));
                g.drawString("Количество побед = " + howManyTimesIWon,500,450);


            }
        }


    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if (((e.getX() >= 50) && (e.getX() <= 160)) && ((e.getY() >= 15) && (e.getY() <= 55))) {
            if (tank.x < enemytank.x) {
                ballDirection = -1;
            } else {
                ballDirection = 1;
            }


            shootButtonMoved =2;

            if (ifTankShooting ==0) {
                new Thread(() -> new TankFires().playSound("bip.wav")).start();
                ifTankShooting =1;
                ifBulletIsDrawingAndUpdating = 1;
                f = -1;
                boomR = 0;
                try {
                    ball.initialize(ball.v, ball.angle, tank.x, (800 - tank.y));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }


        }

        if (numberOfTheLevel == 0) {
            if (((e.getX() >= 50) && (e.getX() <= 237)) && ((e.getY() >= 150) && (e.getY() <= 190))) {
                numberOfTheLevel = 1;
                                                                                                        //на реальном запуске время увеличить до 200!!!!!!
                timeLevel1 =200;                                                                                                       //increase to 800!!!!
            }
        }

        if (numberOfTheLevel == -1) {
            if (((e.getX() >= 50) && (e.getX() <= 322)) && ((e.getY() >= 500) && (e.getY() <= 560))) {
                numberOfTheLevel = 0;
                timeStudy = 120;                 //на реальном запуске время увеличить до 200!!!!!!
            }


        }
        if (numberOfTheLevel == 1&& timeLevel1 <0) {
            if ((e.getX() >= 50) && (e.getX() <= 228) && (e.getY() >= 140) && (e.getY() <= 180)) {
                timeLevel2 = 800;
                enemyTankGo.bool=0;
            }

        }

        if (numberOfTheLevel==2){
            if ((e.getX() >= 50) && (e.getX() <= 230) && (e.getY() >= 140) && (e.getY() <= 180)) {
                //plane.health=-1;
                tank.initialize(300, 660);
                enemytank.initialize(1000, 260);
                plane.initialize(100, 100, 0);
                try {
                    plane.bomb.initialize(100, 100, 30);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                enemytank.enemyball.vy = -1;
                plane.xstroke = -10000;
                enemytank.enemyball.y = 0;
                timeLevel3 =800;
            }
        }
        if (numberOfTheLevel==4){
            if (((e.getX() >= 450) && (e.getX() <= 625)) && ((e.getY() >= 250) && (e.getY() <= 350))){
                timeLevel2=-1;
                timeLevel3=-1;
                timeLevel4=-1;
                time=0;
                timeWin=0;
                timeStudy=-1;
                enemytank.initialize(800, 140);
                numberOfTheLevel=1;
                timeLevel1 =200;
                enemyTankGo.bool=1;
            }
            if (((e.getX() >= 700) && (e.getX() <= 877)) && ((e.getY() >= 250) && (e.getY() <= 350))){
                frameClose =false;
            }
        }
        if (((e.getX() >= 50) && (e.getX() <= 230)) && ((e.getY() >= 58) && (e.getY() <= 98))) {
            if (ifTankShooting ==0) {
                if (tank.x < enemytank.x) {
                    ballDirection = -1;
                } else {
                    ballDirection = 1;
                }

                try {
                    ball.initialize(ball.v, ball.angle, tank.x, (800 - tank.y));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                timeTrajectory = 400;
                f = 1;
            }
        }



    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (((e.getX() >= 50) && (e.getX() <= 160)) && ((e.getY() >= 15) && (e.getY() <= 55))) {
            shootButtonMoved =1;
        } else {
            shootButtonMoved =0;}
        if (((e.getX() >= 50) && (e.getX() <= 230)) && ((e.getY() >= 58) && (e.getY() <= 98))) {
            showTrajectoryButtonMoved =1;
        } else {
            showTrajectoryButtonMoved =0;}
        if (numberOfTheLevel ==-1){
            if (((e.getX() >= 50) && (e.getX() <= 322)) && ((e.getY() >= 500) && (e.getY() <= 560))) {
                studyF =1;
            } else {
                studyF =0;}
        }
        if (numberOfTheLevel==0){
            if (((e.getX() >= 50) && (e.getX() <= 237)) && ((e.getY() >= 150) && (e.getY() <= 190))){
                finishStudyF =1;
            } else {
                finishStudyF =0;}
        }
        if (numberOfTheLevel==1){
            if (((e.getX() >= 50) && (e.getX() <= 228)) && ((e.getY() >= 140) && (e.getY() <= 180))){
                goto2level=1;
            } else {goto2level=0;}
        }
        if (numberOfTheLevel==2){
            if (((e.getX() >= 50) && (e.getX() <= 230)) && ((e.getY() >= 140) && (e.getY() <= 180))){
                goto3level=1;
            } else {goto3level=0;}
        }
        if (numberOfTheLevel==4){
            if (((e.getX() >= 450) && (e.getX() <= 625)) && ((e.getY() >= 250) && (e.getY() <= 350))){
                yesMouseMoved=1;
            } else {yesMouseMoved=0;}
            if (((e.getX() >= 700) && (e.getX() <= 877)) && ((e.getY() >= 250) && (e.getY() <= 350))){
                noMouseMoved=1;
            } else {noMouseMoved=0;}
        }

    }

    private class MyDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    moveRight = 1;

                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    moveLeft = 1;

                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    vPlus = 1;
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    vMinus = 1;
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    anglePlus = 1;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    angleMinus = 1;
                }

            }

            if (e.getID() == KeyEvent.KEY_RELEASED) {
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    moveRight = 0;
                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    moveLeft = 0;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    vPlus = 0;
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    vMinus = 0;
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    anglePlus = 0;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    angleMinus = 0;
                }

            }



            return false;
        }
    }
}
