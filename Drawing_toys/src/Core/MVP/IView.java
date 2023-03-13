package Core.MVP;

import Core.Models.Toy;

import java.util.List;


public interface IView {
    Integer getToyId();

    String getToyName();

    String choose();

    int getToyFrequency();

    void showMenu();

    void emptyListMessage();

    void showAll(List<Toy> toys);

    void savedItem();

    void saveError();

    void showToy(Toy toy);
}
