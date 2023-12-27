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
//В главном классе создается экземпляр DataManager, регистрируются обработчики данных,
// загружаются данные из файла, обрабатываются и затем сохраняются в другой файл.

//DataManager - это класс, который управляет операциями загрузки, обработки и сохранения данных. Он используется для регистрации и применения различных обработчиков данных.
//
//DataProcessorExample - это класс, который, вероятно, реализует интерфейс или абстрактный класс для обработки данных. В этом примере он используется как обработчик данных, который будет применяться к загруженным данным.
//
//Main - это основной класс программы, который создает экземпляр DataManager, регистрирует обработчик данных, загружает данные из файла "original.txt", обрабатывает их и сохраняет результат в файл "result.txt".