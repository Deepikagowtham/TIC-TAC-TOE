package game;
import  board.Board;
import player.Player;
import java.util.*;

public class Game {
    Player[] players;
    Board board;
    int turn;
    int noOfMoves;
    boolean gameOver;
    String zero;
    String  cross;

    public Game(Player[] players, Board board){
        this.players = players;
        this.board=board;
        this.turn=0;
        this.noOfMoves = 0;
        this.gameOver = false;

        StringBuilder z = new StringBuilder();
        StringBuilder c = new StringBuilder();

        for(int i=0;i<board.size;i++) {
            z.append('0');
            c.append('X');
        }

        this.zero = z.toString();
        this.cross = c.toString();
    }

    public void printBoardConfig() {
        int sz = this.board.size;
        for(int i=0;i<sz;i++) {
            for(int j=0;j<sz;j++) {
                System.out.println(board.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }    

    public void play() {
        printBoardConfig();
        int sz = board.size;
        while(!gameOver) {
            noOfMoves++;
            int index = getIndex();
            int row = index/sz;
            int col = index%sz;

            board.matrix[row][col]=players[turn].getPlayerSymbol();

            if(noOfMoves>=sz*sz){
                System.out.println("Game draw");
                return ;
            }

            if(noOfMoves>=sz*sz && checkCombination()== true) {
                gameOver = true;
                printBoardConfig();
                System.out.println("Winner is "+ players[turn].getPlayerName());
                return ;
            }
        
            turn = (turn+1)%players.length;
            printBoardConfig();



        }

    }

    
    public int getIndex() {
        while(true) {
            System.out.println("Player: " + players[turn].getPlayerName() + " give one postion");
            Scanner sc = new Scanner(System.in);
            int pos = sc.nextInt()-1;
            sc.close();

            int sz=board.size;
            int row = pos/sz;
            int col = pos%sz;

            if(row<0 || row>=sz || col<0 || col>=sz) {
                System.out.println("Invalid position");
                continue;
            }

            if(board.matrix[row][col] !='-') {
                System.out.println("Postion already occupied");
            }
            
            return pos;

        }
    
    }

    public boolean checkCombination() {
        int sz = board.size;
        
        for(int i=0;i<sz;i++){
            StringBuilder sp = new StringBuilder();
            for(int j=0;j<sz;j++){
                sp.append(board.matrix[i][j]);
 
            }
            String p1 = sp.toString();
            if(p1.equals(zero) || p1.equals(cross)  ) {
                return true;
            }
        }
        
        
        for(int i=0;i<sz;i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<sz;j++) {
                sb.append(board.matrix[i][j]);
            }
            String p = sb.toString();
            if(p.equals(zero) || p.equals(cross)  ) {
                return true;
            }
        }
        
        int i=0,j=0;
        StringBuilder ss = new StringBuilder();
        while(i<sz) {
            ss.append(board.matrix[i][j]);
            i++;
            j++;
        }
        String pat = ss.toString();
        if(pat.equals(zero) || pat.equals(cross)  ) {
            return true;
        }
        

        i=0;
        j=sz-1;
        ss = new StringBuilder();
        while(i<sz) {
            ss.append(board.matrix[i][j]);
            i++;
            j--;
        }
        pat = ss.toString();
        if(pat.equals(zero) || pat.equals(cross)  ) {
            return true;
        }


        return false;

    }
}


