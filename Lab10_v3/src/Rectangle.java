public class Rectangle implements Fillable {
    double x1, y1, x2, y2;

    public Rectangle(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void fill(int c) {
        System.out.println("Rectangle filled  with upper-left corner at (" + x1 + ", " + y1 +") and lower-right corner at (" + x2 + ", " + y2 +") ) and color " + c);
    }

    @Override
    public void draw(int c) {
        System.out.println("Rectangle drawn with upper-left corner at (" + x1 + ", " + y1 +") and lower-right corner at (" + x2 + ", " + y2 +") ) and color " + c);
    }
}
