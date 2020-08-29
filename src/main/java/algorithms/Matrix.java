package algorithms;

public class Matrix {
    public static int[][] multiplication(int[][] a, int[][] b) {
        int aRows = a.length;
        int aColumns = a[0].length;

        int bRows = b.length;
        int bColumns = b[0].length;

        int c[][] = new int[aRows][bColumns];

        if (aColumns != bRows) {
            return null;
        }

        for(int i = 0; i < aRows; ++i) {
            for(int j = 0; j < bColumns; ++j) {
                for(int k = 0; k < bRows; ++k) {
                    c[i][j] += (a[i][k] * b[k][j]);
                }

            }
        }

        return c;
    }
}
