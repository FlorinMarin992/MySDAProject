package ro.sda;

import java.util.Scanner;

public class TicTacToe {

    static int n = 3;
    static int[][] game = new int[n][n];

    static boolean win = false;
    static boolean finished = false;

    //jucatorul X
    static String player1;
    //jucatorul 0
    static String player2;

    static final String SIGN_X = "X";
    static final String SIGN_0 = "0";

    static String boxSign(int value){
        if(2== value){
            return SIGN_0;
        }else if(1==value){
            return SIGN_X;
        }else{
            return" ";
        }
    }
    public static int boxValue(String sign){
        if(SIGN_X == sign){
            return 1;
        }else if (SIGN_0 == sign) {
            return 2;

        }else{
            return 0;
        }
    }
    public static String getPlayerSign(String player){
        if(player1 == player){
            return SIGN_X;
    }else {
            return SIGN_0;
        }
    }



    static void printGame(){
        System.out.println(".......");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                String sign = boxSign(game[i][j]);
                System.out.print("|" + sign);
            }
            System.out.println("|");
            System.out.println(".......");
        }
    }

    public static boolean isWinLine(int lineNumber, int value){
        boolean winL=true;
        int i = 0;
        while(winL==true && i<n){
            if(game[lineNumber][i]!=value){
                winL=false;
            }
            i++;
        }
        return winL;
    }
    public static boolean isWinCol(int colNumber, int value){
        boolean winC=true;
        int i = 0;
        while(winC==true && i<n){
            if(game[i][colNumber]!=value){
                winC=false;
            }
            i++;
        }
        return winC;

    }

    public static boolean isWinDiags(int value){
        boolean winD1 = true;
        boolean winD2 = true;
        int i = 0;
        while((winD1 == true || winD2 == true) && i<n){
            if (game[i][i] !=value){
                winD1 = false;
            }
            if(game[i][n-1-i]!=value){
                winD2=false;
                }
                i++;
        }
        return (winD1||winD2);

    }

    public static boolean isWin(int value){

        boolean gameWin = false;

        //testam linii
        int i = 0;
        while(i < n && false == gameWin){
            gameWin = isWinLine(i, value);
            i++;
        }
        //testamcoloeane
        i = 0;
        while(i < n && false == gameWin){
            gameWin = isWinCol(i, value);
            i++;
        }
        while (false==gameWin){
            gameWin=isWinDiags(value);
        }
        //testamdiagonale
        return gameWin;
    }

    public static void main(String[] args){
        System.out.println("Tic Tac Toe");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Numele jucatorului X");
        player1 = scanner.nextLine();
        System.out.println("Numele jucatorului 0");
        player2 = scanner.nextLine();
        System.out.println("Numele jucatorilor sunt: " + player1 + "/" + player2);

        printGame();
        String currentPlayer = player1;
        int numberOfMoves=0;
        while(!(win || finished)){

            //play game
            System.out.println("Jucatorul " + currentPlayer + " muta: ");

            //jucatorul face mutarea
            System.out.println(" Linia: ");
            int mLine = scanner.nextInt();
            System.out.println(" Coloana: ");
            int mCol =  scanner.nextInt();
            //determinarea semnului jucatorului
            String currentPlayerSign = getPlayerSign(currentPlayer);
            //determinam ce valoare trebuie sa ramnan in matrice(1sau2)
            int valueOfMove = boxValue(currentPlayerSign);
            //efectuam mutarea
            game[mLine][mCol] = valueOfMove;
            //s a efectuat o mutare incrementeaza numarul de mutari
            numberOfMoves++;
            //finished=test pentru finished
            if(numberOfMoves == (n*n)){
                finished = true;
            }//win=testpentru win
            win = isWin(valueOfMove);

            if(!(win || finished)){
                //schimbam jucatorul
                if (currentPlayer == player1) {
                    currentPlayer=player2;
                }else{
                    currentPlayer = player1;
                }

            }
            if(true == win){
                System.out.println("Jucatorul " + currentPlayer + " este castigator !");
            }else{
                    if(true == finished) {
                        System.out.println("Remiza!");
                    }
                }
                printGame();




        }

    }
}
