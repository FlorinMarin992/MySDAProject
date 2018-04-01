package ro.sda;
import java.util.Scanner;

public class TestNumarPrimNMaiMareCaM {
    static int n;
    static int m;
    static void printArray(int[] myArray){
        for(int j=0;j<n;j++){
            System.out.println(myArray[j]);
        }
    }
    public static void testNrPrim(int[] myArray){
        int nrtotest=m;
        int counter=0;
        while (counter < n) {
            int i=2;
            int divizori=0;
            while(i <= (nrtotest/2)) {
                if (nrtotest % i == 0) {
                    divizori++;
                }
                i++;
            }
            if(divizori==0){
                myArray[counter]=nrtotest;
                counter++;
            }
            nrtotest++;
        }
    }
    public static void main (String[] args){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Introduceti n: ");
        n = scanner.nextInt();
        int[] sirulDeNumerePrime = new int [n];
        System.out.println("Introduceti m: ");
        m = scanner.nextInt();
        testNrPrim(sirulDeNumerePrime);
        printArray(sirulDeNumerePrime);
    }
}

