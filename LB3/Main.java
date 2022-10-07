package ai221.shevchenko;

/**
 * Contains methods for working with class String
 *
 * @author Keiichi-Kun
 * @version openjdk-19 7 Oct 2022
 */
public class Main {

    /**
     * Generates a number in the specified range
     *
     * @param min  - Minimum number of the range
     * @param max - Maximum number of the range
     */
    private static int randomRange(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    /**
     * Calculates the product of the positive elements of an array
     *
     * @param arr  - One dimensional array with numbers
     */
    private static int arrayPositiveProduct(int[] arr) {
        int product = 1;

        for (int i : arr) {
            if (i > 0)
                product *= i;
        }
        return product;
    }

    /**
     * Finds the minimum number in a one-dimensional array
     *
     * @param arr  - One dimensional array with numbers
     */
    public static int findMin(int[] arr) {

        int min = arr[0]; // initial minimum value is first element of the array
        for (int i : arr) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    /**
     * Calculates the sum of array elements up to the minimum element
     *
     * @param arr  - One dimensional array with numbers
     */
    private  static  int calcSumToMin(int[] arr)
    {
        int min = findMin((arr));
        int sum = 0;

        for(int i : arr){
            if(i != min){
                sum +=i;
            }else{
                return sum;
            }
        }

        return sum;
    }

    /**
     * Calculates the sum of array elements up to the minimum element
     *
     * @param m  - Number of rows in matrix
     * @param n  - Number of columns in matrix
     */
    public static int[][] CreateRectMatrix(final int m, final int n) {
        int[][] matrix = new int[m][n];

        System.out.println("Matrix");
        for (int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j)
            {
                matrix[i][j] = randomRange(-10, 10);
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.print("\n");
        }
        return  matrix;
    }

    /**
     * Determines the number of negative elements in those rows that
     * contain at least one null element.
     *
     * @param m  - Number of rows in matrix
     * @param n  - Number of columns in matrix
     */
    public static int findNumNegativeElem(int[][] arr, final int m, final int n){
        boolean zeroLine = false; // Indicates whether the row contains zero
        int numNegativeElem = 0; // Number of the negative elements in the row with zero

        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                //If zero was found in this row and the current element is less than zero
                if(zeroLine && arr[i][j] < 0){
                    ++numNegativeElem;
                }
                //If zero wasn`t found in this row and the current element is zero
                if(!zeroLine && arr[i][j] == 0) {
                    zeroLine = true;
                    j = -1; // Jump to the first column after loop update.
                }
            }
            zeroLine = false;
        }
        return numNegativeElem;
    }

    /**
     * Specifies the maximum value among the averages in each column of the matrix
     *
     * @param m  - Number of rows in matrix
     * @param n  - Number of columns in matrix
     */
    public static double findMaxAverageInColumns(int[][] arr, final int m, final int n){
        int sum = 0;
        double maxAverage = 0, currentAverage;

        // Looping through the columns of the matrix
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                sum += arr[j][i];
            }
            currentAverage = (double) sum / m; // Calculates the average of the current column
            if(currentAverage > maxAverage){
                maxAverage = currentAverage;
            }
            sum = 0;
        }
        return maxAverage;
    }

        /**
         * Displays all the tasks and creates One dimensional array with random numbers.
         */
    public static void main(String[] args) {
        final int arraySize = 10;
        int[] numbers = new int[arraySize];

        System.out.println("Task 1");
        System.out.print("Array: { ");
        for (int i = 0; i < arraySize; ++i) {
            numbers[i] = randomRange(-10, 10);
            System.out.print(numbers[i]);
            if (i != arraySize - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");

        System.out.println("Product of positive array numbers: " + arrayPositiveProduct(numbers));
        System.out.println("the sum of array elements up to the min. element: " + calcSumToMin(numbers));

        System.out.print("\n");
        System.out.println("Task 2");
        final int m = 3;
        final int n = 5;
        int [][] matrix = CreateRectMatrix(m,n);

        System.out.println("The number of negative elements in strings that contain at least one zero element");
        System.out.println(findNumNegativeElem(matrix, m, n));

        System.out.println("The maximum value among the average in each column of the matrix");
        System.out.println(findMaxAverageInColumns(matrix, m, n));

    }
}