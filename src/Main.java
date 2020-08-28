import java.util.*;

public class Main {
    private static String first;
    private static String second;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String task = scanner.nextLine();
        System.out.println(transformFirstStringToSecond(task));
    }

    public static int transformFirstStringToSecond(String task){
        String[] substrings = task.split(" ");
        first = substrings[0];
        second = substrings[1];
        if (first.length() != second.length()) {
            return 0;
        }
        removeDuplicates();
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                first = first.replaceAll(Character.toString(first.charAt(i)), Character.toString(second.charAt(i)));
            }
        }

        if (first.equals(second)) {
            return 1;
        }
        return 0;
    }

    public static char getRandomlyGeneratedChar(){
        Random random = new Random();
        char randomlyGeneratedChar = (char) ('а' + random.nextInt(33));
        while (first.contains(String.valueOf(randomlyGeneratedChar))) {
            randomlyGeneratedChar = (char)('а' + random.nextInt(33));
        }
        return randomlyGeneratedChar;
    }

    public static void removeDuplicates() {
        for (int i = 0; i < first.length(); i++) {
            if (first.contains(Character.toString(second.charAt(i))) && first.charAt(i)!=second.charAt(i)) {
                    first = first.replaceAll(Character.toString(second.charAt(i)), Character.toString(getRandomlyGeneratedChar()));
            }
        }
    }
}
