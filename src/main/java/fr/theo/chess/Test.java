package fr.theo.chess;

public class Test {

  public static void main(String[] args) {
    StandAloneGame game = new StandAloneGame();
    System.out.println(game.getFEN());
    game.playHalfMove("e4");
    System.out.println(game.getFEN());
    game.playHalfMove("c5");
    System.out.println(game.getFEN());
    game.playHalfMove("e5");
    System.out.println(game.getFEN());
    game.playHalfMove("d5");
    System.out.println(game.getFEN());
    game.playHalfMove("exd6");
    System.out.println(game.getFEN());
    game.playHalfMove("c4");
    System.out.println(game.getFEN());
    game.playHalfMove("d4");
    System.out.println(game.getFEN());
    game.playHalfMove("cxd3");
    System.out.println(game.getFEN());
  }
}
