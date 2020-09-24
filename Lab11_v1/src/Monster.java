import java.util.Objects;

public class Monster implements Comparable<Monster>, Cloneable {
    double strength;
    String name;

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Monster(double weight, String name) {
        this.strength = weight;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "weight=" + strength +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster pet = (Monster) o;
        return Double.compare(pet.strength, strength) == 0 &&
                name.equals(pet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strength, name);
    }

    @Override
    public int compareTo(Monster o) {
        double diff = this.strength - o.strength;
        if (diff < 0){
            return -1;
        } else if (diff > 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    protected Monster clone() {
        return new Monster(this.strength, this.name);
    }
}
