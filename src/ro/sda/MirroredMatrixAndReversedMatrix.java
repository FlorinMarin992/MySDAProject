package ro.sda;
import java.util.Scanner;

public class MirroredMatrixAndReversedMatrix {
    public static void main(String[] args) {
        System.out.println("Enter matrix size :");
        Scanner scanner= new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println("Enter the elements of your " + n + " x " + n + " matrix");
        int [][] a = new int[n][n];
        int [][] b = new int[n][n];
        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                a[i][j] = scanner.nextInt();
            }
        }
        printMatrix(a);
        mirrorMatrix(a,b,n);
        System.out.println();
        printMatrix(b);
        System.out.println();
        reversedMatrix(a,b,n);
        printMatrix(b);
    }

    public static void printMatrix(int[][] myMatrix) {
        for(int i = 0; i < myMatrix.length; i++){
            for(int j = 0; j < myMatrix[i].length; j++){
                System.out.print(myMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void mirrorMatrix(int[][] myMatrix, int[][] mirroredMatrix, int n){
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j++){
                mirroredMatrix[i][n-1-j]=myMatrix[i][j];
            }
        }
    }

    public static void reversedMatrix(int[][] myMatrix, int[][] reversedMatrix, int n) {
        int[][] mirroredMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mirroredMatrix[i][n-1-j]=myMatrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                reversedMatrix[n-1-i][j]=mirroredMatrix[i][j];
            }
        }
    }
}
