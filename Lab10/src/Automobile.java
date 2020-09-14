public class Automobile {
    int wheels;
    int horsePower;

    private class Comparator implements Comparable {

        @Override
        public boolean faster(Automobile a) {
            return horsePower > a.horsePower;
        }

        @Override
        public boolean heavier(Automobile a) {
            return wheels > a.wheels;
        }
    }

    private class Validator implements Drivable {

        @Override
        public boolean isValid(Automobile a) {
            return (wheels == 4 && a instanceof Car) || (wheels == 2 && a instanceof Motorcycle);
        }
    }

    private Comparator comp;
    private Validator validator;

    public Automobile(int wheels, int horsePower) {
        this.wheels = wheels;
        this.horsePower = horsePower;
        comp = new Comparator();
        validator = new Validator();
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName() + "{" +
                "wheels=" + wheels +
                ", horsePower=" + horsePower +
                '}';
    }

    public void compare(Automobile a) {
        System.out.println("Faster? (" + this.toString() + ", " + a.toString() + "):" + comp.faster(a));
        System.out.println("Heavier? (" + this.toString() + ", " + a.toString() + "):" + comp.heavier(a));
    }

    public void validate() {
        System.out.println("Validated? (" + this.toString() + "):" + validator.isValid(this));
    }

    public static void main(String[] args) {
        Car c = new Car(4, 10);
        Motorcycle m = new Motorcycle(2, 4);
        c.compare(m);
        m.compare(c);
        c.validate();
        m.validate();
        Motorcycle me = new Motorcycle(3, 4);
        me.validate();
    }
}
