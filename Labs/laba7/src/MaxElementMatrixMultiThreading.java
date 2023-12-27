import java.util.Arrays;
import java.util.Random;

public class MaxElementMatrixMultiThreading {
    private static int[][] matrix = new int[5][5]; // Пример: матрица 5x5
    private static int maxElement = Integer.MIN_VALUE;

    public static void main(String[] args) {
        // Заполнение матрицы случайными числами для примера
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(100); // Генерация случайных чисел от 0 до 99
            }
        }

        // Вывод матрицы в консоль
        System.out.println("Исходная матрица:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        Thread[] threads = new Thread[matrix.length]; // Создание массива потоков

        // Создание потоков для обработки каждой строки матрицы
        for (int i = 0; i < matrix.length; i++) {
            final int row = i; // Индекс строки для передачи в поток (значение final для использования в лямбда-выражении)
            threads[i] = new Thread(() -> {
                int maxInRow = Integer.MIN_VALUE;
                for (int j = 0; j < matrix[row].length; j++) {
                    if (matrix[row][j] > maxInRow) {
                        maxInRow = matrix[row][j];
                    }
                }
                // Сравнение максимального элемента в строке с общим максимальным элементом
                synchronized (MaxElementMatrixMultiThreading.class) {
                    if (maxInRow > maxElement) {
                        maxElement = maxInRow;
                    }
                }
            });
            threads[i].start(); // Запуск потока
        }

        // Ожидание завершения работы всех потоков
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Вывод наибольшего элемента матрицы
        System.out.println("Наибольший элемент в матрице: " + maxElement);
    }
}
