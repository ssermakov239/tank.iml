import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Plane {
    public double x;
    public double y;
    private double y0;
    private double v=7;
    private double r=40;
    private double t;
    public int direction =1;
    private int bombDirection =1;
    public double xstroke=-1;
    public int health=15;
    public Bomb bomb=new Bomb();
    BufferedImage planeImage;
    public Plane() throws IOException {
        this.planeImage= ImageIO.read(Plane.class.getResourceAsStream("trying-to-find-a-luftwaffe-pilot-axis-history-forum-luftwaffe-png-1114_450-min.png"));
        bomb.initialize(1,720,v);
    };
    public void initialize(double xx,double yy,double tt){
        x=xx;
        y=yy;
        t=tt;
        y0=y;
        direction =1;
    };
    public void update(double dt){
        if (Math.abs((int)(x)-100)<4.0&& direction ==-1){ direction =1;};
        x=x+ direction *v*dt;
        y=y0+r*Math.sin(t/8.0);
        t=t+dt;
        if (Math.abs((int)(x)-1300)<4.0&& direction ==1){ direction =-1;};
    };
    public void draw(Graphics g){
        if (direction ==1){
            g.drawImage(planeImage,(int)(x),(int)(y),120,48,null);
        } else {
            g.drawImage(planeImage,(int)(x+120),(int)(y),-120,48,null);
        };
    };
    public  void shoot(double dt,Graphics g,double ytank) throws IOException {
        bomb.draw(g);
        bomb.update(dt, bombDirection);
        if (Math.abs(y-bomb.y)<5.0){
            if (direction != bombDirection){
                bombDirection = direction;
            }
        }
        if (bomb.y>=ytank){
                xstroke =bomb.x;
            bomb.initialize((x+(direction +1)*60),y,30);
            bombDirection = direction;
        } else {xstroke=-100000;};


    };
    public void drawHealth(Graphics g ){
        g.setColor(Color.GRAY);
        g.fillRect((int)(x-30),((int)(y)-50),180,20);
        g.setColor(Color.RED);
        g.fillRect((int)(x-25),((int)(y)-45),(170/15*health),10);
    };
}
