package Arrays;

import java.util.*;

public class MatrixMultiplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

 
        int r = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();

        int[][] A = new int[r][k];
        int[][] B = new int[k][c];
        int[][] C = new int[r][c];

    
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < k; j++) {
                A[i][j] = sc.nextInt();
            }
        }

       
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < c; j++) {
                B[i][j] = sc.nextInt();
            }
        }

       
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int x = 0; x < k; x++) {
                    C[i][j] += A[i][x] * B[x][j];
                }
            }
        }
       
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}

