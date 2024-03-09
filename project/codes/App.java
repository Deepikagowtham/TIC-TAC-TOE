import board.Board;
import player.Player;
import game.Game;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("First Project-> Tic Tac Toe");

        Board b = new Board(4,'-');
        //b.setDefaultSymbol('-');
        b.printBoardConfig();
        Player p1 = new Player();
        Player p2 = new Player();
        p1.setPlayerDetails("deepi", 'O', "Erode", 638155355, "deepi@gmail.com", 19);
        p2.setPlayerDetails("nagul", 'X', "salem", 1431431438, "nagul@gmail.com", 20);
        p1.getPlayerDetails();
        p2.getPlayerDetails();

        Game game = new game (new Player[] (p1 ,p2), b);
        game.play();
    }
}
