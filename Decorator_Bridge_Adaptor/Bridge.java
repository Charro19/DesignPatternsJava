package Decorator_Bridge_Adaptor;

public class Bridge {
    public static void main(String[] args) {
        Shape[] shapes = new Shape [2];
        shapes[0] = new CircleShape(1, 2, 3, new API1());
        shapes[1] = new CircleShape(5, 7, 11, new API2());
        for (Shape shape: shapes){
            shape.resizeByPercentage(2.5);
            shape.draw();
        }
    }
}


interface DrawingAPI{
    public void drawCircle(double x,double y,double radius);
}

class API1 implements DrawingAPI{
    public void drawCircle(double x,double y,double radius){
        System.out.printf("API1.circle at %f:%f radius %f\n",x,y,radius);
    }
}

class API2 implements DrawingAPI{
    public void drawCircle(double x,double y,double radius){
        System.out.printf("API2.circle at %f:%f radius %f\n", x, y, radius);
    }
}

interface Shape{
    public void draw();
    public void resizeByPercentage(double pct);
}

class CircleShape implements Shape{
    private double x,y,radius;
    private DrawingAPI drawingAPI;
    public CircleShape(double x, double y, double radius, DrawingAPI drawingAPI) {
        this.x = x; this.y = y; this.radius = radius; 
        this.drawingAPI = drawingAPI;
    }
    public void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }
    public void resizeByPercentage(double pct) {
        radius *= pct;
    }
        
}