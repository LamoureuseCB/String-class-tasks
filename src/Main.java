
public class Main {
    public static void main(String[] args) {

//        Задача 4 из презентации:
//        Определить сколько раз слово из word встречается в text

        String text = "application hello template";
        String word = "hello";
        int amountCounter = 0;

        String[] words = text.split(" ");
        for (String element : words) {
            if(element.indexOf(word, 0) == 0){
                amountCounter++;
            }
        }
        System.out.println("Cлово " + word + " встречается в предложении " + amountCounter + " раз(-а).");

        System.out.println();
        System.out.println("Проверка пароля: ");
        boolean password1 = validatePassword("Qwerty1ui");
        boolean password2 = validatePassword("123uuu");
        System.out.println(password1);
        System.out.println(password2);
        System.out.println();
        System.out.println("Проверка email: ");
        boolean email1 = validateEmail("asdassd@mail.com");
        boolean email2 = validateEmail("asas dsadasd@gg.com");
        System.out.println(email1);
        System.out.println(email2);
        System.out.println();
        int s = amountOfWords("Сегодня отличный день для программирования");
        System.out.println();
        int t = amountOfWords("Подсчет количества слов в  данном предложении");
        System.out.println();
        int w = consonantCounter("Понедельник,Вторник,Среда,Четверг,Пятница,Суббота,Воскресенье");
        System.out.println();
        String p = longestWord("Java удивительный язык программирования");
        System.out.println();
        String d = snakeCaseText("Пример строки для конвертации");
        String d1 = snakeCaseText("еще один Пример строки для конвертации");


    }

//    Валидация пароля

    static boolean validatePassword(String password) {
        int length = 8;
        boolean passwordDigit = false;
        boolean passwordUpperCase = false;

        if (password.length() >= length) {
            for (int i = 0; i < password.length(); i++) {
                if (Character.isDigit(password.charAt(i))) {
                    passwordDigit = true;
                }
                if (Character.isUpperCase(password.charAt(i))) {
                    passwordUpperCase = true;
                }
            }
            return passwordDigit && passwordUpperCase;
        }
        return false;
    }

    //Валидация почты
    static boolean validateEmail(String email) {
        boolean atSymbol = false;
        boolean noSpaceSymbol = true;

        if (email.contains("@")) {
            atSymbol = true;
        }
        if (email.contains(" ")) {
            noSpaceSymbol = false;

        }
        return atSymbol && noSpaceSymbol;

    }
//1. Подсчет согласных букв в строке:

    static int consonantCounter(String text) {
        String consonantLetters = "БВГДЖЗЙКЛМНПРСТФХЦЧШЩбвгджзйклмнпрстфчцчшщ";
        int counter = 0;
        String[] words = text.split(",");

        for (String word : words) {
            System.out.print("В слове: \"" + word + "\"");
            for (int i = 0; i < word.length(); i++) {
                if (consonantLetters.contains(String.valueOf(word.charAt(i)))) {
                    counter++;
                }
            }
            System.out.println(" количество согласных букв = " + counter + ".");
            counter = 0;
        }

        return counter;
    }

    //2. Подсчет количества слов в предложении:
    static int amountOfWords(String sentence) {
        String[] sentenceWords = sentence.split(" ");
        int countWords = 0;
        for (String word : sentenceWords) {
            countWords++;

        }
        System.out.println("Количество слов в предложении: \"" + sentence + "\" = " + countWords);
        return countWords;
    }

    //    3. Определение длины самого длинного слова в строке:
    static String longestWord(String text) {
        String[] textWords = text.split(" ");
        String longest = "";
        for (String word : textWords) {
            if (word.length() > longest.length()) {
                longest = word;
            }

        }
        System.out.println("Самое длинное слово в предложении \"" + text + "\" - " + "\"" + longest + "\". Его длина составляет " + longest.length() + " символов.");
        return longest;

    }

    //4. Конвертация строки в "змеиный_регистр":
    static String snakeCaseText(String text) {

        String[] words = text.split(" ");
        StringBuilder builder = new StringBuilder();

        for (String word : words) {
            builder.append(word.substring(0, 1).toLowerCase())
                    .append(word.substring(1).toUpperCase())
                    .append("_");
        }
        System.out.println(builder.substring(0, builder.length() - 1));
        return builder.substring(0, builder.length() - 1);
    }

}




