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
        return gallons * 3.785;
    }
    public static int calc(int time, int intensity) {
        return time * intensity;
    }
    public static int containers(int box, int bags, int barrel) {
        return box * 20 + bags * 50 + barrel * 100;
    }
    public static String triangleType(int x, int y, int z) {
        if (x + y > z && x + z > y && y + z > x) {
            if (x == y && y == z) {
                return "equilateral";
            } else if (x == y || y == z || x == z) {
                return "isosceles";
            } else {
                return "different_sided";
            }
        } else {
            return "not a triangle";
        }
    }
    public static int ternaryEvalution(int a, int b) {
        return a > b? a : b;
    }
    public static int howManyItems(double length_t, double width, double h) {
        double s_t = length_t * 2;
        double s_d = ((width * 2) * (h * 2));
        return (int) (s_t / s_d);
    }
    public static int factorial(int num) {
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
    public static int gcd(int x, int y) {
        while (y != 0) {
            int result = x % y;
            x = y;
            y = result;
        }
        return x;
    }
    public static int ticketSaler(int ticket, int cost) {
        return (int) (ticket * (cost - cost * 0.28));
    }
    public static int tables(int students, int table) {
        int need_tables = students / 2;
        if (students % 2 != 0) {
            need_tables++;
        }
        int result = need_tables - table;
        if (result < 0) {
            result = 0;
        }
        return result;

    }
}