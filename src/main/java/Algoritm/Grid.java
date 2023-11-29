package algoritm;

import java.util.Random;

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
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n * n; j++)
                System.out.print(copytable[i][j] + " ");
            System.out.println();
        }
        return copytable;
    }

    public void showGrid() {
        table = transposing(table);
        table = swapRows(table);
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n * n; j++)
                System.out.print(table[i][j] + " ");
            System.out.println();
        }
    }

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
        int x1 = r.nextInt(n * n - 1);
        int x2 = 0;
        if (x1 % n == 0) {
            x2 = x1 - r.nextInt(1) + 1;
        }
        if (x1 % n == 1) {
            while (true) {
                x2 = r.nextInt(2);
                if (x2 != 1) {
                    x2 -= 1;
                    x2 = x1 - x2;
                    break;
                }
            }
        }
        if (x1 % n == 2) {
            x2 = x1 - r.nextInt(1) - 2;
        }
        System.out.println(x1);
        System.out.println(x2);
        for (int i = 0; i < n * n; i++) {
            copyArea1 = table[x1][i];
            copyArea2 = table[x2][i];
            table[x1][i] = copyArea2;
            table[x2][i] = copyArea1;
        }

        return table;
    }
    public int[][] swapRows(int[][] table) {
        int copyArea1, copyArea2;
        Random r = new Random();
        int x1 = r.nextInt(n * n - 1);
        int x2 = 0;
        if (x1 % n == 0) {
            x2 = x1 - r.nextInt(1) + 1;
        }
        if (x1 % n == 1) {
            while (true) {
                x2 = r.nextInt(2);
                if (x2 != 1) {
                    x2 -= 1;
                    x2 = x1 - x2;
                    break;
                }
            }
        }
        if (x1 % n == 2) {
            x2 = x1 - r.nextInt(1) - 2;
        }
        System.out.println(x1);
        System.out.println(x2);
        for (int i = 0; i < n * n; i++) {
            copyArea1 = table[x1][i];
            copyArea2 = table[x2][i];
            table[x1][i] = copyArea2;
            table[x2][i] = copyArea1;
        }

        return table;
    }
}

