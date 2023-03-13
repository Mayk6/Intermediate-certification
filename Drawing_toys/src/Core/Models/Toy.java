package Core.Models;

public class Toy implements Comparable<Toy>{
    private final Integer id;
    private final String name;
    private Integer frequency;

    public Toy(Integer id, String name, Integer frequency) {
        this.name = name;
        this.frequency = frequency;
        this.id = id;

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }


    @Override
    public String toString() {
        return  "ID: " + id +
                ", Название: '" + name + '\'' +
                ", Шанс: " + frequency;
    }

    @Override
    public int compareTo(Toy o) {
        return o.getFrequency() - this.getFrequency();
    }
}
