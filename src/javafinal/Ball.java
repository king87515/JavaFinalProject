package javafinal;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class Ball {
    private Point location;
    private int radius;
    private Color color;
    private int dx, dy;
    //private Color[] ballArr;

    public Ball(Point l, int r, Color c){
        location = l;
        radius = r;
        color = c;
    }

    public Ball(Point l, int r){
        location = l;
        radius = r;
        color = Color.RED;

    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;

    }

    public void setMotion(int dx, int dy){
        this.dx = dx;
        this.dy = dy;
    }

    public void move(){
        location.translate(dx, dy);
    }

    public void moveTo(int x, int y){
        location.move(x, y);
    }

    public void paint (Graphics g) {
        g.setColor (color);
        g.fillOval (location.x-radius, location.y-radius, 2*radius, 2*radius);
    }

    public void reclectHoriz() {
        dy = -dy;       
    }   

    public void reclectVert() {
        dx = -dx;       
    }
}