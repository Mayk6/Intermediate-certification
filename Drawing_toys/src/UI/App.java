package UI;

import Core.MVP.Presenter;


public class App {
    public static void buttonClick() {
        Presenter presenter = new Presenter(new ConsoleView());
        String choose;

        while (true) {

            choose = presenter.menu();

            if (choose.equals("7")) {
                return;
            }
            try {
                switch (choose) {
                    case "1" -> presenter.putForRaffle();
                    case "2" -> presenter.deleteFromRaffle();
                    case "3" -> presenter.updToyFrequency();
                    case "4" -> presenter.getRaffle();
                    case "5" -> presenter.showAll();
                    case "6" -> presenter.clearAll();
                    default -> System.out.println("\n Введена неверная команда!");
                }
            } catch (Exception e) {
                System.out.println("Ошибка. " + e.getMessage());
            }
        }
    }
}