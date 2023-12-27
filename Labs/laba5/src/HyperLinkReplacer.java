//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class HyperLinkReplacer {
//    public static void main(String[] args) {
//        String inputText = "Ссылка на сайт https://www.random.com";
//
//        // Регулярное выражение для поиска ссылок
//        String regex = "(https?://\\S+)";
//
//        // Создание объекта Pattern для компиляции регулярного выражения
//        Pattern pattern = Pattern.compile(regex);
//
//        // Создание объекта Matcher для поиска соответствий регулярному выражению в тексте
//        Matcher matcher = pattern.matcher(inputText);
//
//        // Создание отдельного Matcher, чтобы проверить, существует ли хотя бы одна ссылка
//        Matcher matcher1 = pattern.matcher(inputText);
//
//        // Создание StringBuilder для сохранения измененного текста
//        StringBuilder replacementText = new StringBuilder();
//
//        // Проверка, существует ли хотя бы одна ссылка в тексте
//        if (matcher1.find()) {
//            // Пока находятся ссылки в тексте, заменяем их на указанный формат
//            while (matcher.find()) {
//                // Получаем найденную ссылку
//                String url = matcher.group();
//
//                // Удаляем "https://" или "http://" и слэши из ссылки
//                String replacement = url.replaceAll("https?://|\\/", "");
//
//                // Заменяем найденную ссылку в исходном тексте на измененную версию
//                matcher.appendReplacement(replacementText, replacement);
//            }
//
//            // Добавляем остаток текста после последней найденной ссылки
//            matcher.appendTail(replacementText);
//
//            // Вывод измененного текста, в котором ссылки заменены
//            System.out.println(replacementText.toString());
//        } else {
//            // Вывод сообщения об ошибке, если ссылок не найдено
//            System.out.println("Неверный адрес сайта!");
//        }
//    }
//
//
//}
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HyperLinkReplacer {
    public static void main(String[] args) {
        String text = "Пример текста с ссылками: " +
                "Ссылка 1: https://abcd.com, " +
                "Ссылка 2: http://abcd.com, " +
                "Ссылка 3: www.abcd";

        String replacedText = replaceLinks(text);

        System.out.println("Исходные ссылки:");
        System.out.println(text);
        System.out.println("\nРезультат замены:");
        System.out.println(replacedText);
    }

    public static String replaceLinks(String text) {
        String regex = "\\b(?:https?://|www\\.)\\S+\\b";

        String replacement = "<a href=\"$0\">$0</a>";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        String replacedText = matcher.replaceAll(replacement);

        return replacedText;
    }
}

