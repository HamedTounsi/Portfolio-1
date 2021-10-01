// Made by "balblabla" group of " blablab "

public class Main {

    public static void main(String[] args) {
        //Rectangle
        Point test = new Point(10,35);
        Rectangle rect1 = new Rectangle(test,10,10);
        System.out.println("Center of the rectangle = "+rect1.shapeCenter());
        System.out.println("Area = "+rect1.shapeArea());
        System.out.println("Circumference = "+rect1.shapeCircumference());
        //Check if Point "check" is inside the rectangle
        Point check = new Point(19,40);
        System.out.println(rect1.pointInShape(check));
        //Calculate the distance between two objects
        Rectangle rect2 = new Rectangle(check,10,10);
        System.out.println(rect1.Euclidean(rect2.getStartPoint()));


        //Circle
        Point cPoint = new Point(45,70);
        Circle c1 = new Circle(cPoint,25);
        System.out.println("Center of the Circle = "+c1.shapeCenter());
        System.out.println("Area = "+c1.shapeArea());
        System.out.println("Circumference = "+c1.shapeCircumference());
        //Check if Point "check" is inside the rectangle
        //Point check = new Point(19,40);
        System.out.println(c1.pointInShape(check));
        //Calculate the distance between two objects
        Rectangle rect3 = new Rectangle(check,10,10);
        System.out.println(c1.Euclidean(rect2.getStartPoint()));


        Point triP = new Point(10,35);
        Triangle tri1 = new Triangle(triP,10,10);
        System.out.println("Center of the Triangle = "+tri1.shapeCenter());
        System.out.println("Area = "+tri1.shapeArea());
        System.out.println("Circumference = "+tri1.shapeCircumference());
        //Check if Point "check" is inside the rectangle
        Point checkTri = new Point(11,36);
        System.out.println(tri1.pointInShape(check));
        //Calculate the distance between two objects
        Triangle tri2 = new Triangle(checkTri,10,10);
        System.out.println(tri1.Euclidean(tri2.getStartPoint()));

    }
}
