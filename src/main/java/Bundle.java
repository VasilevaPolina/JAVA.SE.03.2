package main.java;

import java.util.*;

public class Bundle {

    private static void chooseLocale() {
        System.out.println("Please, enter \"en\" for English or \"ru\" for Russian");

        Scanner scanner = new Scanner(System.in);
        String answerS = scanner.next();

        Locale locale;

        if (answerS.equalsIgnoreCase("en")) {
            locale = new Locale("en", "us");
        } else if (answerS.equalsIgnoreCase("ru")) {
            locale = new Locale("ru", "ru");
        } else {
            throw new UnsupportedOperationException("Unsupported answer");
        }

        ResourceBundle questionsBundle = ResourceBundle.getBundle("questions", locale);
        ResourceBundle answersBundle = ResourceBundle.getBundle("answers", locale);

        for (String keys : Collections.list(questionsBundle.getKeys())) {
            System.out.println(questionsBundle.getString(keys));
        }

        System.out.printf("Please, enter number of question to get answer(from %d to %d)\n",
                1, questionsBundle.keySet().size());

        int answerI = scanner.nextInt();

        if(answerI > questionsBundle.keySet().size() || answerI < 1){
            throw new UnsupportedOperationException("Unsupported answer");
        } else {
            System.out.println(answersBundle.getString(String.valueOf(answerI)));
        }
    }

    public static void main(String[] args) {
        Bundle.chooseLocale();
    }
}
