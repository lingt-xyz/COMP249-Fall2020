import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        List<Fillable> list = new ArrayList<>();
        list.add(new Circle(1,2,3));
        list.add(new Circle(2,2,4));
        list.add(new Rectangle(1,1, 2, 2));
        list.add(new Rectangle(2,2, 2, 2));
        list.add(new Rectangle(3,3, 3, 4));

        Random r = new Random();
        for (Fillable f : list){
            int c = r.nextInt(Drawable.white);
            f.fill(c);
            f.draw(c);
        }
    }
}
