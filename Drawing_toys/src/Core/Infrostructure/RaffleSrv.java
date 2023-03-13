package Core.Infrostructure;

import Core.Models.Toy;

import java.util.ArrayList;
import java.util.List;


public class RaffleSrv {

    private final List<Toy> toys;

    public RaffleSrv() {
        this.toys = new ArrayList<>();
    }

    public boolean putForRuffle(Toy toy) {
        boolean flag = false;
        if (!toys.contains(toy)) {
            this.toys.add(toy);
            flag = true;
        }
        return flag;
    }

    public boolean updateFrequency(Integer ind, Integer frequency) {
        int index = indexContains(ind);
        if (index != -1) {
            toys.get(index).setFrequency(frequency);
            return true;
        } else {
            return false;
        }
    }

    public void remove(Integer toyId) {
        if (indexContains(toyId) != -1) {
            toys.remove(indexContains(toyId));
            System.out.println("Успешно удалено");
        } else
            System.out.println("Ошибка удаления, данный ID не найден");
    }

    private int indexContains(int index) {
        int searchIndex = -1;
        for (Toy toy : toys) {
            if (toy.getId() == index)
                searchIndex = toys.indexOf(toy);
        }
        return searchIndex;
    }

    public List<Toy> getToys() {
        return toys;
    }

}
