import static org.junit.jupiter.api.Assertions.*;

class Test {

    @org.junit.jupiter.api.Test
    void area() {
        Point test  = new Point(10,35);
        Triangle triangleTest = new Triangle(test,10,10);
        assertEquals(50,triangleTest.shapeArea());
    }

    @org.junit.jupiter.api.Test
    void getWidth() {
        Point test  = new Point(10,35);
        Triangle triangleTest = new Triangle(test,10,10);
        assertEquals(10,triangleTest.getWidth());
    }

    @org.junit.jupiter.api.Test
    void getHeight() {
        Point test  = new Point(10,35);
        Rectangle rectTest = new Rectangle(test,10,10);
        assertEquals(10,rectTest.getHeight());
    }

    @org.junit.jupiter.api.Test
    void getStartPoint() {
        Point test  = new Point(10,35);
        Rectangle rectTest = new Rectangle(test,10,10);
        assertEquals(test,rectTest.getStartPoint());
    }

    @org.junit.jupiter.api.Test
    void sideC() {
        Point test  = new Point(10,35);
        Triangle triangleTest = new Triangle(test,10,10);
        assertEquals(14.142135623730951,triangleTest.sideC());
    }

    @org.junit.jupiter.api.Test
    void shapeCenter() {
        Point test  = new Point(10,35);
        Circle circleTest = new Circle(test,10);
        assertEquals(test,circleTest.shapeCenter());
    }

    @org.junit.jupiter.api.Test
    void shapeArea() {
        Point test  = new Point(10,35);
        Triangle triangleTest = new Triangle(test,10,10);
        assertEquals(50,triangleTest.shapeArea());
    }

    @org.junit.jupiter.api.Test
    void shapeCircumference() {
        Point test  = new Point(10,35);
        Triangle triangleTest = new Triangle(test,10,10);
        assertEquals(34.14213562373095,triangleTest.shapeCircumference());
    }

    @org.junit.jupiter.api.Test
    void pointInShape() {
        Point test  = new Point(10,35);
        Point inPoint = new Point(11,36);
        Triangle triangleTest = new Triangle(test,10,10);
        assertEquals(true,triangleTest.pointInShape(inPoint));
    }
}