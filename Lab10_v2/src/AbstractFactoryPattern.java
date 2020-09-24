import java.util.ArrayList;
import java.util.List;

public class AbstractFactoryPattern {
    void makeJuices(JuiceFactory factory) {
        List<Object> juiceList = new ArrayList<>();
        juiceList.add(factory.createAppleJuice());
        juiceList.add(factory.createAppleJuice());
        juiceList.add(factory.createOrangeJuice());
        juiceList.add(factory.createOrangeJuice());
        juiceList.add(factory.createOrangeJuice());
        for (Object juice : juiceList) {
            if (juice instanceof AppleJuice) {
                ((AppleJuice) juice).getAppleJuiceInfo();
            } else if (juice instanceof OrangeJuice) {
                ((OrangeJuice) juice).getOrangeJuiceInfo();
            }
        }
    }
}
