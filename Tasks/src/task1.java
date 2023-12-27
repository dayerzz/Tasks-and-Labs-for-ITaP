public class task1 {
    public static void main(String[] args) {
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));
        System.out.println(calc(15, 1));
        System.out.println(calc(24, 2));
        System.out.println(calc(41, 3));
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));
        System.out.println(triangleType(0, 0, 0));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));
        System.out.println(ternaryEvalution(8, 4));
        System.out.println(ternaryEvalution(1, 11));
        System.out.println(ternaryEvalution(5, 9));
        System.out.println(howManyItems(22, 1.4f, 2));
        System.out.println(howManyItems(45, 1.8f, 1.9f));
        System.out.println(howManyItems(100, 2, 2));
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));
        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
    }
    public static double convert(int gallons) {
        return gallons * 3.785; // умножаем кол-во галлонов на американский галлон в литрах
    }
    public static int calc(int time, int intensity) {
        return time * intensity; // умножаем время тренировки на интенсивность тренировки
    }
    public static int containers(int box, int bags, int barrel) {
        return box * 20 + bags * 50 + barrel * 100; // вычисляем общее кол-во товаров на складе 
    }
    public static String triangleType(int x, int y, int z) {
        if (x + y > z && x + z > y && y + z > x) { // Проверка условия, что сумма длин двух сторон треугольника больше длины третьей стороны.
            if (x == y && y == z) { // Проверка, являются ли все три стороны треугольника равными.
                return "equilateral"; // Если все стороны равны, возвращается строка "equilateral" (равносторонний треугольник).
            } else if (x == y || y == z || x == z) { // Проверка, является ли хотя бы одна пара сторон треугольника равными.
                return "isosceles"; // Если хотя бы одна пара сторон равна, возвращается строка "isosceles" (равнобедренный треугольник).
            } else { // Если треугольник не является ни равносторонним, ни равнобедренным.
                return "different_sided"; // Возвращается строка "different_sided" (треугольник со сторонами различной длины).
            }
        } else { // Если условие для образования треугольника не выполнено.
            return "not a triangle"; // Возвращается строка "not a triangle" (не треугольник).
        }
    }

    public static int ternaryEvalution(int a, int b) {
    return a > b ? a : b; // возвращаем большее из двух чисел a и b при помощи тернарного оператора.
}

public static int howManyItems(double length_t, double width, double h) {
    double s_t = length_t * 2; // вычисляем площадь ткани
    double s_d = ((width * 2) * (h * 2)); // вычисляем площадь детали
    return (int) (s_t / s_d); // вычисляем кол-во пододеяльников
}

public static int factorial(int num) {
    int result = 1; // записываем первый элемент последовательности
    for (int i = 1; i <= num; i++) { // вычисляем факториал заданного числа
        result *= i;
    }
    return result;
}

public static int gcd(int x, int y) {
    while (y != 0) { // пока y не будет равен нулю
        int result = x % y; // вычисление остатка от деления x на y и сохранение в result
        x = y;
        y = result;
    }
    return x; / возврат x, которое стало наибольшим общим делителем
}

public static int ticketSaler(int ticket, int cost) {
    return (int) (ticket * (cost - cost * 0.28)); // рассчитываем общую выручку от продажи билетов
}

public static int tables(int students, int table) {
    int need_tables = students / 2; // делим количество студентов на 2 (т.к. за партой могут сидеть только двое), тем самым находим нужное кол-во парт
    if (students % 2 != 0) { 
        need_tables++; // добавляем парту, если кол-во студентов делённое на 2 имеет остаток
    }
    int result = need_tables - table; // вычисляем кол-во недостающих парт
    if (result < 0) {
        result = 0;
    }
    return result;
}
// Метод tables вычисляет необходимое количество дополнительных столов для учеников, поделив общее число учеников пополам и округлив в большую сторону. После этого вычисляется разница между необходимым количеством столов и имеющимся, и возвращается это значение (или 0, если не требуется дополнительных столов).
