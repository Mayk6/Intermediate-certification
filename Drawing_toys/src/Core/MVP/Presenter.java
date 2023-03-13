package Core.MVP;

import Core.Models.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Presenter {
    private final Model model;
    private final IView view;

    public Presenter(IView view) {
        this.view = view;
        model = new Model();
    }

    public void putForRaffle() {
        if (model.currentRaffleSrv().putForRuffle(
                new Toy(view.getToyId(), view.getToyName(), view.getToyFrequency())))
            view.savedItem();
        else
            view.saveError();
    }

    public void deleteFromRaffle() {
        if (model.currentRaffleSrv.getToys().size() == 0)
            view.emptyListMessage();
        else
            model.currentRaffleSrv().remove(view.getToyId());
    }

    public void showAll() {
        if (model.currentRaffleSrv.getToys().size() == 0)
            view.emptyListMessage();
        else
            view.showAll(model.currentRaffleSrv.getToys());
    }

    public void clearAll() {
        if (model.currentRaffleSrv.getToys().size() == 0)
            view.emptyListMessage();
        else {
            model.currentRaffleSrv.getToys().clear();
            System.out.println("Данные успешно удалены!");
        }
    }

    public void getRaffle() {
        PriorityQueue<Toy> queue = new PriorityQueue<>();
        Toy rafflToy;
        List<Toy> toys = new ArrayList<>();
        if (model.currentRaffleSrv.getToys().size() != 0) {
            queue.addAll(model.currentRaffleSrv().getToys());
            rafflToy = queue.remove();
            view.showToy(rafflToy);
            toys.add(rafflToy);
            model.saveResult("result.txt", toys);
        } else
            view.emptyListMessage();
    }

    public String menu() {
        view.showMenu();
        return view.choose();
    }

    public void updToyFrequency() {
        System.out.println("Введите данные для изменения шанса выпадения");
        int id = view.getToyId();
        int frequency = view.getToyFrequency();
        if (model.currentRaffleSrv().updateFrequency(id, frequency)) {
            System.out.println("Изменение прошло успено");
        } else {
            System.out.println("При изменении произошла ошибка");
        }
    }
}
