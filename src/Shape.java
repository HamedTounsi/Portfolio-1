abstract class Shape {
    //Return the center of the shape
    //Compute the area of the shape
    //Compute the circumference
    //Indicate whether a point is inside a shape or not
    //Compute the Euclidean distance to another shape

    public Point getStartPoint() {
        return null;
    }

    Point shapeCenter() {
        return null;
    }

    double shapeArea() {
        return 0;
    }

    double shapeCircumference() {
        return 0;
    }

    boolean pointInShape(Point p) {
        return false;
    }

    double euclidean(Point dist) {
        double x1 = shapeCenter().getX();
        double y1 = shapeCenter().getY();
        double x2 = dist.getX();
        double y2 = dist.getY();
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }
}


class Rectangle extends Shape {
    private final double width;
    private final double height;
    private final Point startPoint;

    public Rectangle(Point startPoint, double width, double height) {
        this.height = height;
        this.width = width;
        this.startPoint = startPoint;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public Point getStartPoint() {
        return startPoint;
    }

    @Override
    Point shapeCenter() {
        double centerX = getStartPoint().getX() + (getWidth() / 2);
        double centerY = getStartPoint().getY() + (getHeight() / 2);
        return new Point(centerX, centerY);
    }

    @Override
    double shapeArea() {
        return getWidth() * getHeight();
    }

    @Override
    double shapeCircumference() {
        return  (getHeight() * 2) + (getWidth() * 2);
    }

    @Override
    boolean pointInShape(Point p) {
        return p.getX() >= startPoint.getX() && p.getX() <= startPoint.getX() + getWidth() &&
                p.getY() >= getStartPoint().getY() && p.getY() <= startPoint.getY() + getHeight();
    }

    @Override
    public String toString() {
        return ("Start point: " + startPoint + " Width: " + getWidth() + " Height: " + getHeight());
    }
}

class Circle extends Shape {
    private final double radius;
    private final Point startPoint;

    public Circle(Point startPoint, double radius) {
        this.radius = radius;
        this.startPoint = startPoint;
    }


    public double getRadius() {
        return radius;
    }

    @Override
    public Point getStartPoint() {
        return startPoint;
    }

    @Override
    Point shapeCenter() {
        return startPoint;
    }

    @Override
    double shapeArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double shapeCircumference() {
        return 2 * Math.PI * radius;
    }

    @Override
    boolean pointInShape(Point p) {
        double x1 = shapeCenter().getX();
        double y1 = shapeCenter().getY();
        double x2 = p.getX();
        double y2 = p.getY();
        double euclidean = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));

        return euclidean < radius;
    }


    @Override
    public String toString() {
        return ("Start point: " + startPoint + " Radius: " + getRadius());
    }
}

class Triangle extends Shape {
    private final double width;
    private final double height;
    private final Point startPoint;

    public Triangle(Point startPoint, double width, double height) {
        this.startPoint = startPoint;
        this.width = width;
        this.height = height;
    }

    static double area(double xA,double yA, double xB, double yB, double xC, double yC){
        //calculating area
        return Math.abs((xA*(yB-yC)+xB*(yC-yA)+xC*(yA-yB))/2);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public Point getStartPoint() {
        return startPoint;
    }
    public double sideC(){
        return Math.sqrt( width*width+height*height );
    }

    @Override
    Point shapeCenter(){
        double xA = startPoint.getX();
        double xB = startPoint.getX();
        double xC = startPoint.getX()+getWidth();
        double yA = startPoint.getY();
        double yB = startPoint.getY()+getHeight();
        double yC = startPoint.getY();
        return new Point((xA+xB+xC)/3,(yA+yB+yC)/3);
    }

    @Override
    double shapeArea(){
        return getHeight()*getWidth()/2;
    }

    @Override
    double shapeCircumference(){
        return getHeight()+getWidth()+sideC();
    }

    @Override
    boolean pointInShape(Point p){
        double xA = startPoint.getX();
        double xB = startPoint.getX();
        double xC = startPoint.getX()+getWidth();
        double yA = startPoint.getY();
        double yB = startPoint.getY()+getHeight();
        double yC = startPoint.getY();

        double A = area(xA,yA, xB, yB, xC, yC);
        double a1 = area(p.getX(),p.getY(),xB,yB,xC,yC);
        double a2 = area(xA, yA, p.getX(), p.getY(), xC, yC);
        double a3 = area(xA, yA, xB, yB,p.getX(), p.getY());
        return (A == a1+a2+a3);
    }

    @Override
    public String toString(){
        return("Start point: "+startPoint+" Width: "+getWidth()+" Height: "+getHeight());
    }
}