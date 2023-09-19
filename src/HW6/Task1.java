package HW6;

public class Task1 {

    private Task1() {
    }

    public static boolean isPalindrome(String text) {
        String oneWordFromText = text.toLowerCase().replaceAll("[^a-z0-9]", "");
        if (oneWordFromText.equals("")) {
            return true;
        } else {
            StringBuilder sb = new StringBuilder(oneWordFromText);
            String oneWordFromTextReversed = sb.reverse().toString();
            return oneWordFromText.compareTo(oneWordFromTextReversed) == 0;
        }
    }
}

