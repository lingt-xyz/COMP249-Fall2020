import java.util.Objects;

public class Pet implements Comparable<Pet>, Cloneable {
    double weight;
    String name;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet(double weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Double.compare(pet.weight, weight) == 0 &&
                name.equals(pet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, name);
    }

    @Override
    public int compareTo(Pet o) {
        double diff = this.weight - o.weight;
        if (diff < 0){
            return -1;
        } else if (diff > 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    protected Pet clone() {
        return new Pet(this.weight, this.name);
    }
}
