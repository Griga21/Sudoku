package Algoritm;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Grid {
    private int n;
    private int[][] table;

    public Grid(int n) {
        this.n = n;
        table = new int[n * n][n * n];
        for (int i = 0; i < n * n; i++)
            for (int j = 0; j < n * n; j++)
                table[i][j] = (i * n + i / n + j) % (n * n) + 1;

    }

    public int[][] transposing(int[][] table) {
        int[][] copytable = new int[n * n][n * n];
        for (int i = 0; i < n * n; i++)
            for (int j = 0; j < n * n; j++)
                copytable[i][j] = table[j][i];

        return copytable;
    }

    public void showGrid() {
        table = transposing(table);
        table = swapColumsArea(table);
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n * n; j++)
                System.out.print(table[i][j] + " ");
            System.out.println();
        }
    }

    // Блочная смена по 3 столбцам
    public int[][] swapRowsArea(int[][] table) {
        int copyArea1, copyArea2;
        Random r = new Random();
        int x1 = r.nextInt(n);

        int x2 = r.nextInt(n);

        while (true) {
            if (x1 == x2)
                x2 = r.nextInt(n);
            else
                break;
        }

        x1 = 2 * x1 + x1;
        x2 = 2 * x2 + x2;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n * n; i++) {
                copyArea1 = table[i][x1];
                copyArea2 = table[i][x2];
                table[i][x1] = copyArea2;
                table[i][x2] = copyArea1;
            }
            x1 += 1;
            x2 += 1;
        }

        return table;
    }

    public int[][] swapColumsArea(int[][] table) {
        int copyArea1, copyArea2;
        Random r = new Random();
        int x1 = r.nextInt(n);

        int x2 = r.nextInt(n);

        while (true) {
            if (x1 == x2)
                x2 = r.nextInt(n);
            else
                break;
        }

        x1 = 2 * x1 + x1;
        x2 = 2 * x2 + x2;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n * n; i++) {
                copyArea1 = table[x1][i];
                copyArea2 = table[x2][i];
                table[x1][i] = copyArea2;
                table[x2][i] = copyArea1;
            }
            x1 += 1;
            x2 += 1;
        }

        return table;
    }

    public int[][] swapColums(int[][] table) {
        int copyArea1, copyArea2;
        Random r = new Random();
        int x1 = r.nextInt(n*n - 1);

        int x2 = r.nextInt(3);

        while (true) {
            if (x1 == x2)
                x2 = r.nextInt(n);
            else
                break;
        }


        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n * n; i++) {
                copyArea1 = table[x1][i];
                copyArea2 = table[x2][i];
                table[x1][i] = copyArea2;
                table[x2][i] = copyArea1;
            }
            x1 += 1;
            x2 += 1;
        }

        return table;
    }
}
