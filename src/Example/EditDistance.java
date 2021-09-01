package Example;

import java.util.Scanner;

public class EditDistance {

    //finds the minimum number between three numbers.
    public static int min(int x, int y, int z) {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else return z;
    }

    /**
     * find and prints the minimum edit distance for two strings
     * @param str1 first string
     * @param str2 second string
     */
    public static void minimumEditDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        final int[][] matrix = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0) {
                    matrix[i][j] = j;
                }
                else if (j == 0) {
                    matrix[i][j] = i;
                }

                else if (str2.charAt(j - 1) == str1.charAt(i - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                }
                else {
                    matrix[i][j] = min(matrix[i - 1][j], matrix[i][j - 1], matrix[i - 1][j - 1]) + 1;
                }

                if (i > 1 && j > 1 && str1.charAt(i - 1) == str2.charAt(j - 2) && str1.charAt(i - 2) == str2.charAt(j - 1)) {
                    matrix[i][j] = Math.min(matrix[i - 2][j - 2] + 1, matrix[i][j]);
                }
            }
        }

            int result = matrix[m][n];
            System.out.println(result);
    }

        public static void main (String[]args){
            Scanner scanner = new Scanner(System.in);
            String str1 = scanner.nextLine();
            str1 = str1.trim();
            String str2 = scanner.nextLine();
            str2 = str2.trim();
            minimumEditDistance(str1, str2);
        }
    }

