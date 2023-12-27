import java.io.IOException;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();
        dataManager.registerDataProcessor(new DataProcessorExample());

        try {
            Stream<String> dataStream = dataManager.loadData("");
            dataStream = dataManager.processData(dataStream);
            dataManager.saveData("", dataStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
