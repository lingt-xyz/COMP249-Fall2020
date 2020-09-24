public class Driver {
    public static void main(String[] args) {
        AbstractFactoryPattern factory = new AbstractFactoryPattern();
        factory.makeJuices(new DelMonte());
    }
}
