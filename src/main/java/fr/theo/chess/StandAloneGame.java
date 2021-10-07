
package fr.theo.chess;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class StandAloneGame {

  public static void main(String[] args) {
    StandAloneGame game = new StandAloneGame();
    System.out.println(game.getFEN());
    game.playHalfMove("e4");
    System.out.println(game.getFEN());
    game.playHalfMove("e5");
    System.out.println(game.getFEN());
  }

  private int[]  board;                // piece placement (from white perspective)  
  private char   active;               // active color 
  private String castlingAvailability;  
  private String enPassantTarget;      
  private int    halfMoveClock;
  private int    fullMoveNumber;
  private String fen;

  public StandAloneGame() {
    this.active               = Local.FIRST_ACTIVE;
    this.board                = Local.STARTING_BOARD;
    this.castlingAvailability = Local.STARTING_CASTLING_AVAILABILITY;
    this.enPassantTarget      = Local.STARTING_EN_PASSANT_TARGET;
    this.halfMoveClock        = Local.STARTING_HALF_MOVE_CLOCK;
    this.fullMoveNumber       = Local.STARTING_FULL_MOVE_NUMBER;
    this.fen                  = Local.STARTING_FEN;
  }

  public int[]  getBoard()                {return this.board;}
  public char   getActive()               {return this.active;}
  public String getCastlingAvailability() {return this.castlingAvailability;}
  public String getEnPassantTarget()      {return this.enPassantTarget;}
  public int    getHalfMoveClock()        {return this.halfMoveClock;}
  public int    getFullMoveNumber()       {return this.fullMoveNumber;}
  public String getFEN()                  {return this.fen;}

  private void setActive(char active) {this.active = active;}
  private void setFEN(String fen) {this.fen = fen;}
  private void setEnPassantTarget(String target) {this.enPassantTarget = target;}

  public String notationOf(int file, int rank) {
    return String.format("%c%d", (char) (file + (int)'a'), 8 - rank);
  } 

  public void playHalfMove(String move) {
    int index;
    String tmpEnPassantTarget = getEnPassantTarget();
    setEnPassantTarget(Local.STARTING_EN_PASSANT_TARGET);
    if (Pattern.matches("[a-h][1-8]", move)) {
      // pawn push
      int file = (int)move.charAt(0) - (int)'a';
      int rank = 7 - ((int)move.charAt(1) - (int)'1');
      switch (getActive()) {
        case Local.WHITE:
          index = indexOf(file, rank + 1);
          if (getBoard()[index] == Local.WHITE_PAWN) {
            int fromIndex = index;
            int toIndex = indexOf(file, rank);
            getBoard()[fromIndex] = Local.EMPTY;
            getBoard()[toIndex] = Local.WHITE_PAWN;
            switchActive();
          }
          if (rank == 4) {
            index = indexOf(file, rank + 2);
            if (getBoard()[index] == Local.WHITE_PAWN) {
              int fromIndex = index;
              int toIndex = indexOf(file, rank);
              setEnPassantTarget(notationOf(file, rank + 1));
              getBoard()[fromIndex] = Local.EMPTY;
              getBoard()[toIndex] = Local.WHITE_PAWN;
              switchActive();
            }
          }
        case Local.BLACK:
          index = indexOf(file, rank - 1);
          if (getBoard()[index] == Local.BLACK_PAWN) {
            int fromIndex = index;
            int toIndex = indexOf(file, rank);
            getBoard()[fromIndex] = Local.EMPTY;
            getBoard()[toIndex] = Local.BLACK_PAWN;
            switchActive();
          }
          if (rank == 3) {
            index = indexOf(file, rank - 2);
            if (getBoard()[index] == Local.BLACK_PAWN) {
              int fromIndex = index;
              int toIndex = indexOf(file, rank);
              setEnPassantTarget(notationOf(file, rank - 1));
              getBoard()[fromIndex] = Local.EMPTY;
              getBoard()[toIndex] = Local.BLACK_PAWN;
              switchActive();
            }
          }
      }
    } else if (Pattern.matches("[a-h]x[a-h][1-8]", move)) {
      // pawn taking
      int takerFile = (int)move.charAt(0) - (int)'a';
      int takedFile = (int)move.charAt(2) - (int)'a';
      int takedRank = 7 - ((int)move.charAt(3) - (int)'1');
      if (getActive() == Local.WHITE) {
        if (tmpEnPassantTarget == notationOf(takedFile, takedRank)) {
      
        }
      }
    } 
    if (Pattern.matches("[RNBQK][a-h][1-8]", move)) {
      // TODO piece movement
    } else if (Pattern.matches("[RNBQK][a-h][a-h][1-8]", move)) {
      // TODO
    } else if (Pattern.matches("[RNBQK][1-8][a-h][1-8]", move)) {
      // TODO
    } else if (Pattern.matches("[RNBQK][a-h][1-8][a-h][1-8]", move)) {
      // TODO
    } else if (Pattern.matches("[RNBQK][1-8]x[a-h][1-8]", move)) {
      // TODO
    } else if (Pattern.matches("[RNBQK][a-h]x[a-h][1-8]", move)) {
      // TODO
    } else if (Pattern.matches("[RNBQK][a-h][1-8]x[a-h][1-8]", move)) {
      // TODO
    }
    updateFEN();
  }
      
  private int indexOf(int file, int rank) {return 8 * rank + file;}

  private void switchActive() {
    if (getActive() == Local.WHITE) setActive(Local.BLACK);
    else setActive(Local.WHITE);
  }

  private ArrayList<String> allowedHalfMoves() {
    ArrayList<String> output = new ArrayList<String>();
    switch (getActive()) {
      case Local.WHITE:
        for (int tile: getBoard()) {
          
        }
      case Local.BLACK:
    }
    return output;
  }

  private void updateFEN() {
    StringBuilder builder = new StringBuilder();
    int emptySpaceCounter = 0;
    if (getBoard()[0] == Local.EMPTY) emptySpaceCounter++;
    else builder.append((char) getBoard()[0]);
    for (int i = 1; i < 64; i++) {
      if (i % 8 == 0) {
        if (emptySpaceCounter != 0) {
          builder.append(emptySpaceCounter);
          emptySpaceCounter = 0;
        }
        builder.append("/");
      }
      if (getBoard()[i] == Local.EMPTY) emptySpaceCounter++;
      else {
        if (emptySpaceCounter != 0) {
          builder.append(emptySpaceCounter);
          emptySpaceCounter = 0;
        }
        builder.append((char) getBoard()[i]);
      } 
    }
    builder.append(" " + getActive());
    builder.append(" " + getCastlingAvailability());
    builder.append(" " + getEnPassantTarget());
    builder.append(" " + getHalfMoveClock());
    builder.append(" " + getFullMoveNumber());
    setFEN(builder.toString());
  }
}









