import HW9.ArrayDataException;
import HW9.ArraySizeException;
import HW9.ArrayValueCalculator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        doHW9();
    }

    private static void doHW9() {
        String[][] normalData = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        String[][] wrongSize = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}};
        String[][] wrongElement = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "ork", "12"}, {"13", "14", "15", "16"}};

        try {
            System.out.println(ArrayValueCalculator.doCalc(normalData));
        } catch (ArraySizeException e) {
            System.out.println("Size of two-dimensional array is wrong, it must be 4x4");
        } catch (ArrayDataException e) {
            System.out.println("Some element(s) is wrong, strings must have only numbers");
            System.out.println(e.getMessage());
        }
    }
}