abstract class Shape {
    //Return the center of the shape
    //Compute the area of the shape
    //Compute the circumference
    //Indicate whether a point is inside a shape or not
    //Compute the Euclidean distance to another shape
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

    double Euclidean(Point dist) {
        double x1 = shapeCenter().getX();
        double y1 = shapeCenter().getY();
        double x2 = dist.getX();
        double y2 = dist.getY();
        double euclidean = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        return euclidean;
    }

    double distance(Point p1, Point p2) {
        double x1 = p1.getX();
        double y1 = p1.getX();
        double x2 = p2.getX();
        double y2 = p2.getY();
        double distance = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        return distance;
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

    public Point getStartPoint() {
        return startPoint;
    }

    @Override
    Point shapeCenter() {
        double centerX = getStartPoint().getX() + (getWidth() / 2);
        double centerY = getStartPoint().getY() + (getHeight() / 2);
        Point center = new Point(centerX, centerY);
        return center;
    }

    @Override
    double shapeArea() {
        double area = getWidth() * getHeight();
        return area;
    }

    @Override
    double shapeCircumference() {
        double circumference = (getHeight() * 2) + (getWidth() * 2);
        return circumference;
    }

    @Override
    boolean pointInShape(Point p) {
        if (p.getX() >= startPoint.getX() && p.getX() <= startPoint.getX() + getWidth() &&
                p.getY() >= getStartPoint().getY() && p.getY() <= startPoint.getY() + getHeight()) {
            return true;

        }
        return false;
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

    public Point getStartPoint() {
        return startPoint;
    }

    @Override
    Point shapeCenter() {
        Point center = startPoint;
        return center;
    }

    @Override
    double shapeArea() {
        double area = Math.PI * radius * radius;
        return area;
    }

    @Override
    double shapeCircumference() {
        double circumference = 2 * Math.PI * radius;
        return circumference;
    }

    @Override
    boolean pointInShape(Point p) {
        double x1 = shapeCenter().getX();
        double y1 = shapeCenter().getY();
        double x2 = p.getX();
        double y2 = p.getY();
        double euclidean = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));

        if (euclidean < radius) {
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return ("Start point: " + startPoint + " Radius: " + getRadius());
    }
}

class Triangle extends Shape {
    private final Point startPoint;
    private final double width;
    private final double height;


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

    public Point getStartPoint() {
        return startPoint;

    }
    public double sideC(){
        double sideC = Math.sqrt( width*width+height*height );
        return sideC;
    }

    @Override
    Point shapeCenter(){
        double xA = startPoint.getX();
        double xB = startPoint.getX();
        double xC = startPoint.getX()+getWidth();
        double yA = startPoint.getY();
        double yB = startPoint.getY()+getHeight();
        double yC = startPoint.getY();
        Point center = new Point((xA+xB+xC)/3,(yA+yB+yC)/3);
        return center;
    }

    @Override
    double shapeArea(){
        double area = getHeight()*getWidth()/2;
        return area;
    }

    @Override
    double shapeCircumference(){
        double circumference = getHeight()+getWidth()+sideC();
        return circumference;
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