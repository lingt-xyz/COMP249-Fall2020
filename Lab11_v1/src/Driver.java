import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        List<Pet> removeList = new ArrayList<>();

        Random r = new Random();
        for (int i = 0; i < 2 + r.nextInt(10); i++) {
            Pet p = new Pet(r.nextDouble(), r.nextInt(10) + "");
            list.insert(p);
            removeList.add(p.clone());
        }
        System.out.println(list.toString());
        int loop = list.size;
        for (int i = 0; i < loop; i++) {
            int index = r.nextInt(removeList.size());
            Pet p = removeList.get(index);
            list.remove(p);
            removeList.remove(index);
            System.out.println(p.toString());
            System.out.println(list.toString());
        }
    }
}
