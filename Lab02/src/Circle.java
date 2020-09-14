import java.util.Objects;

public class Circle {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(Circle c) {
        this.radius = c.radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public static double getTotalArea(Circle[] cs) {
        double d = 0;
        for (Circle c : cs) {
            d += c.getArea();
        }
        return d;
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(1.0);
        Circle c2 = new Circle(2.0);
        System.out.println(getTotalArea(new Circle[]{c1, c2}));
    }
}
