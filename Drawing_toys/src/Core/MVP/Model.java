package Core.MVP;

import Core.Infrostructure.RaffleSrv;
import Core.Models.Toy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Model {

    protected final RaffleSrv currentRaffleSrv;

    public Model() {
        currentRaffleSrv = new RaffleSrv();
    }

    public RaffleSrv currentRaffleSrv() {
        return this.currentRaffleSrv;
    }

    public void saveResult(String pathResult, List<Toy> toysList) {
        try (FileWriter writer = new FileWriter(pathResult, false)) {
            for (Toy toy : toysList) {
                writer.append(String.format("id: %s  ", toy.getId()));
                writer.append(String.format("Название: %s  ", toy.getName()));
                writer.append(String.format("Шанс: %s  ", toy.getFrequency()));
                writer.append("\n");
                writer.flush();
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
