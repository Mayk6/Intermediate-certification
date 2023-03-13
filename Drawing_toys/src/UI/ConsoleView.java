package UI;

import Core.MVP.IView;
import Core.Models.Toy;

import java.util.List;
import java.util.Scanner;

public class ConsoleView implements IView {
    Scanner in;

    public ConsoleView() {
        in = new Scanner(System.in);
    }

    @Override
    public Integer getToyId() {
        System.out.print("ID игрушки : ");
        return Integer.parseInt(in.nextLine());
    }


    @Override
    public String getToyName() {
        System.out.print("Название игрушки: ");
        return in.nextLine();
    }

    @Override
    public int getToyFrequency() {
        System.out.print("Шанс выпадения: ");
        return Integer.parseInt(in.nextLine());
    }


    @Override
    public void showAll(List<Toy> toys) {
        System.out.println("\nВсе игрушки для розыгрыша:");
        for (Toy toy : toys) {
            System.out.println(toy);
        }

    }

    @Override
    public void showToy(Toy toy) {
        System.out.print("\nРезультат розыгрыша: ");
        System.out.println(toy);
    }

    @Override
    public void savedItem() {
        System.out.println("\nИгрушка успешно добавлена");
    }

    @Override
    public void saveError() {
        System.out.println("\nПри добавлении произошла ошибка");
    }

    @Override
    public void emptyListMessage() {
        System.out.println("Список игрушек пуст");
    }

    public String choose() {
        System.out.print("Сделайте свой выбор: ");
        return in.nextLine();
    }

    public void showMenu() {
        System.out.println("1 - Добавьте игрушку в розыгрыш\n" +
                "2 - Удалить игрушку из розыгрыша\n" +
                "3 - Изменить шанс выпадения игрушки\n" +
                "4 - Начать розыгрыш\n" +
                "5 - Показать игрушки для розыгрыша\n" +
                "6 - Очистить очередь розыгрыша\n" +
                "7 - Выход");
    }
}