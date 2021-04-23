import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ball {
    public double v=250;
    public double angle=Math.atan(200/150.0);
    public double vx=150;  //можно увеличивать массу, уменьшать скорости , увеличивать dt , тогда
    public double vy=200;  // полёт будет более плавным, траектория будет приближаться  параболе - теперь уже не надо
    public double x=100;
    private double x0;
    public  double y0;
    public double xstroke=-1;
    private int f=0;
    public double y=100;
    private double dt = 0.02;
    private double G =10;
    private double dvx;
    private double dvy;
    private double m = 0.9;
    private double k =0.04;  // k0 k=0.01
    BufferedImage bulletImage;

    public Ball(){ };
    public void initialize(double a, double b,double c, double d) throws IOException {
        v=a;
        angle=b;
        x=c+100;
        x0=x;
        y0=y;
        y=d;
        vx=v*Math.cos(angle);
        vy=v*Math.sin(angle);
        this.bulletImage = ImageIO.read(new File("src/bullets_png35596 (1).png"));
    };
    public void update (double a,double ymin,int direction){
        for (int i=0;i<3;i++) {
            dt = a;
        /*dvx=-1*dt/m*k*Math.exp(-1*const1*y)*Math.sqrt(vx*vx+vy*vy)*vx;
        dvy=-1*dt/m*(m*G+k*Math.exp(-1*const1*y)*Math.sqrt(vx*vx+vy*vy)*vy);*/
            if (y<860){
            dvx = -1 * dt / (m * 5.0) * k * Math.pow((1 - 3.65 * Math.pow(10, -3.5) * y), 2.5) * Math.sqrt(vx * vx + vy * vy) * vx;
            dvy = -1 * dt / (m * 5.0) * (m * G + k * Math.pow((1 - 3.65 * Math.pow(10, -3.5) * y), 2.5) * Math.sqrt(vx * vx + vy * vy) * vy);}
            else {dvx=0;
            dvy=-G*dt/5.0;}
            vx = vx + dvx;
            vy = vy + dvy;
            x = x - direction * (vx * dt);
            y = y + (vy * dt);
        }
            //System.out.println(y+" "+y0);
            if (vy < 0 && Math.abs(y - ymin) < 2.5 && x != x0 && f == 0) {
                xstroke = x;
                f = 1;
                //System.out.println("kkk");

            } else {
                xstroke = -1;
                if (Math.abs(y - ymin) > 2.5) {
                    f = 0;
                }
            }
            ;

        /*if (x>1500||y<0){
            x=100;
            y=100;
            vx=150;
            vy=200;
            dvx=0;
            dvy=0;
        };*/

    };
    public void draw(Graphics  g,int direction){
        g.setColor(Color.RED);
        double locationX = bulletImage.getWidth() / 2;
        double locationY = bulletImage.getHeight() / 2;
        double angleInRadians=0;
        if (direction==-1){
         angleInRadians=Math.atan(-vy/vx);}
        else if (direction==1){
            angleInRadians=Math.atan(vy/vx)+Math.PI;
        };
        AffineTransform tx = AffineTransform.getRotateInstance(angleInRadians, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        g.drawImage(op.filter(bulletImage, null), (int)(x-(direction+1)*50), (int)(800-y),50,37, null);
        //g.fillOval((int)(x),(int)(800-y),20,20);
    };
    public void drawline (double ymin,double xTrajectory,double yTrajectory,double vxTrajectory,double vyTrajectory, Graphics g,int direction){
        double dvxTrajectory;
        double dvyTrajectory;
        dt=0.04;
        g.setColor(Color.BLUE);
        int n=0;
        while (vyTrajectory>=0||yTrajectory>=ymin) {
            if (yTrajectory<860){
                dvxTrajectory=-1*dt/(m*5.0)*k*Math.pow((1-3.65*Math.pow(10,-3.5)*yTrajectory),2.5)*Math.sqrt(vxTrajectory*vxTrajectory+vyTrajectory*vyTrajectory)*vxTrajectory;
                dvyTrajectory=-1*dt/(m*5.0)*(m*G+k*Math.pow((1-3.65*Math.pow(10,-3.5)*yTrajectory),2.5)*Math.sqrt(vxTrajectory*vxTrajectory+vyTrajectory*vyTrajectory)*vyTrajectory);}
            else {dvxTrajectory=0;
                dvyTrajectory=-G*dt/5.0;}
            vxTrajectory = vxTrajectory + dvxTrajectory;
            vyTrajectory = vyTrajectory + dvyTrajectory;
            if (direction==-1){
                xTrajectory = xTrajectory + (vxTrajectory * dt);}
            else {xTrajectory = xTrajectory - (vxTrajectory * dt);};
            yTrajectory = yTrajectory + (vyTrajectory * dt);
            g.setColor(Color.BLUE);
            if (n%60==0) {
                g.fillOval((int)(xTrajectory-(direction+1)*50),(int)(800-yTrajectory),5,5);}
            n+=1;
        };
    };



}
