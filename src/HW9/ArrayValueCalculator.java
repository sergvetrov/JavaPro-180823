package HW9;

import java.util.Arrays;

public class ArrayValueCalculator {

    public static int doCalc(String[][] data) throws ArraySizeException, ArrayDataException {
        if (data.length != 4 || data[0].length != 4) {
            throw new ArraySizeException();
        }
        int sum = 0;
        for (String[] datum : data) {
            for (String d : datum) {
                try {
                    sum += Integer.parseInt(d);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("["
                            + findIndexInArray(datum, d) + ","
                            + findIndexOfArrayInMArray(data, datum)
                            + "] - wrong element");
                }
            }
        }
        return sum;
    }

    private static int findIndexInArray(String[] array, String target) {
        return Arrays.asList(array).indexOf(target);
    }

    private static int findIndexOfArrayInMArray(String[][] array, String[] target) {
        return Arrays.asList(array).indexOf(target);
    }
}
