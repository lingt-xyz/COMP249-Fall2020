public class Circle implements Fillable {

    double x, y, radius;

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void fill(int c) {
        System.out.println("Circle filled at (" + x + ", " + y +") with radius " + radius + ", and color " + c);
    }

    @Override
    public void draw(int c) {
        System.out.println("Circle drawn at (" + x + ", " + y +") with radius " + radius + ", and color " + c);
    }
}
