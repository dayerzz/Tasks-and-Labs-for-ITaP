//public class ArrayAverage {
//    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};
//        int sum = 0;
//        try {
//            for (int i = 0; i <= arr.length; i++) {
//                sum += i;
//            }
//            double result = (double) sum / arr.length;
//            System.out.println(result);
//        }   catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Ошибка: произошёл выход за пределы массива");
//        }   catch (NumberFormatException e) {
//            System.out.println("Ошибка: элемент массива не является числом");
//        }
//    }
//}
public class ArrayAverage {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "three", "4", "5"}; // Изменен тип массива на String и добавлено "three"
        int sum = 0;
        try {
            for (String str : arr) {
                sum += Integer.parseInt(str); // Попытка преобразования строки в число может вызвать NumberFormatException
            }
            double result = (double) sum / arr.length;
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: элемент массива не является числом" + e.getMessage());
        }
    }
}
