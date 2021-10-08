
package fr.theo.chess;

import java.util.regex.Pattern;

public class StandAloneGame {

  private int[]  board;                // piece placement (from white perspective)  
  private char   active;               // active color 
  private String castlingAvailability; //  
  private String enPassantTarget;      // 
  private int    halfMoveClock;        //
  private int    fullMoveNumber;       //
  private String fen;                  // Forsyth-Edwards Notation 

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

  public void playHalfMove(String move) {
    if (Pattern.matches("[a-h]x[a-h][1-8]", move)) takeWithPawn(move);
    setEnPassantTarget(Local.STARTING_EN_PASSANT_TARGET);
    if (Pattern.matches("[a-h][1-8]", move)) pushPawn(move);
    else if (Pattern.matches("[RNBQK][a-h][1-8]", move)) movePiece(move);
    else if (Pattern.matches("[RNBQK][a-h][a-h][1-8]", move)) {
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
      
  private void setActive(char active) {this.active = active;}
  private void setFEN(String fen) {this.fen = fen;}
  private void setEnPassantTarget(String target) {this.enPassantTarget = target;}
  private void incrementFullMoveNumber() {this.fullMoveNumber++;}
  private void incrementHalfMoveClock() {this.halfMoveClock++;}
  private void resetHalfMoveClock() {this.halfMoveClock = 0;}
  private  int indexOf(int file, int rank) {return 8 * rank + file;}

  private String notationOf(int file, int rank) {
    return String.format("%c%d", (char) (file + (int)'a'), 8 - rank);
  } 

  private void switchActive() {
    if (getActive() == Local.WHITE) setActive(Local.BLACK);
    else setActive(Local.WHITE);
  }

  private void updateFEN() {
    StringBuilder builder = new StringBuilder();
    int emptySpaceCounter = 0;
    if (getBoard()[0] == Local.EMPTY_SQUARE) emptySpaceCounter++;
    else builder.append((char) getBoard()[0]);
    for (int i = 1; i < 64; i++) {
      if (i % 8 == 0) {
        if (emptySpaceCounter != 0) {
          builder.append(emptySpaceCounter);
          emptySpaceCounter = 0;
        }
        builder.append("/");
      }
      if (getBoard()[i] == Local.EMPTY_SQUARE) emptySpaceCounter++;
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

  private void doMove(int fromIndex, int toIndex) {
    getBoard()[toIndex] = getBoard()[fromIndex];
    getBoard()[fromIndex] = Local.EMPTY_SQUARE;
  }

  private void pushPawn(String move) {
    int index;
    int file = (int)move.charAt(0) - (int)'a';
    int rank = 7 - ((int)move.charAt(1) - (int)'1');
    switch (getActive()) {
      case Local.WHITE:
        index = indexOf(file, rank + 1);
        if (getBoard()[index] == Local.WHITE_PAWN) {
          int fromIndex = index;
          int toIndex = indexOf(file, rank);
          doMove(fromIndex, toIndex);
          switchActive();
        }
        if (rank == 4) {
          index = indexOf(file, rank + 2);
          if (getBoard()[index] == Local.WHITE_PAWN) {
            int fromIndex = index;
            int toIndex = indexOf(file, rank);
            setEnPassantTarget(notationOf(file, rank + 1));
            doMove(fromIndex, toIndex);
            switchActive();
          }
        }
        break;
      case Local.BLACK:
        index = indexOf(file, rank - 1);
        if (getBoard()[index] == Local.BLACK_PAWN) {
          int fromIndex = index;
          int toIndex = indexOf(file, rank);
          doMove(fromIndex, toIndex);
          switchActive();
        }
        if (rank == 3) {
          index = indexOf(file, rank - 2);
          if (getBoard()[index] == Local.BLACK_PAWN) {
            int fromIndex = index;
            int toIndex = indexOf(file, rank);
            setEnPassantTarget(notationOf(file, rank - 1));
            doMove(fromIndex, toIndex);
            switchActive();
          }
        }
        incrementFullMoveNumber();
        break;
    }
    resetHalfMoveClock();
  }

  private void takeWithPawn(String move) {
    int takerFile = (int)move.charAt(0) - (int)'a';
    int takedFile = (int)move.charAt(2) - (int)'a';
    int takedRank = 7 - ((int)move.charAt(3) - (int)'1');
    if (Math.abs(takerFile - takedFile) != 1) return;
    switch (getActive()) {
      case Local.WHITE:
        if (getEnPassantTarget().equals(notationOf(takedFile, takedRank))) {
          if (getBoard()[indexOf(takerFile, takedRank + 1)] == Local.WHITE_PAWN) {
            int fromIndex = indexOf(takerFile, takedRank + 1);
            int toIndex = indexOf(takedFile, takedRank);
            doMove(fromIndex, toIndex);
            getBoard()[indexOf(takedFile, takedRank + 1)] = Local.EMPTY_SQUARE;
            switchActive();
          }
        } 
        else {
          if (getBoard()[indexOf(takerFile, takedRank + 1)] == Local.WHITE_PAWN) {
            int fromIndex = indexOf(takerFile, takedRank + 1);
            int toIndex = indexOf(takedFile, takedRank);
            doMove(fromIndex, toIndex);
            switchActive();
          }
        }
        break;
      case Local.BLACK:
        if (getEnPassantTarget().equals(notationOf(takedFile, takedRank))) {
          if (getBoard()[indexOf(takerFile, takedRank - 1)] == Local.BLACK_PAWN) {
            int fromIndex = indexOf(takerFile, takedRank - 1);
            int toIndex = indexOf(takedFile, takedRank);
            doMove(fromIndex, toIndex);
            getBoard()[indexOf(takedFile, takedRank - 1)] = Local.EMPTY_SQUARE;
            switchActive();
          }
        }
        else {
          if (getBoard()[indexOf(takerFile, takedRank - 1)] == Local.BLACK_PAWN) {
            int fromIndex = indexOf(takerFile, takedRank - 1);
            int toIndex = indexOf(takedFile, takedRank);
            doMove(fromIndex, toIndex);
            switchActive();
          }
        }
        incrementFullMoveNumber();
        break;
    }
  }

  private void movePiece(String move) {
    char piece = move.charAt(0);
    int toFile = (int)move.charAt(1) - (int)'a';
    int toRank = 7 - ((int)move.charAt(2) - (int)'1');
    switch (getActive()) {
      case Local.WHITE:
        switch (piece) {
          case Local.WHITE_ROOK:
            moveRook(toFile, toRank, Local.WHITE_ROOK);
            break;
          case Local.WHITE_KNIGHT:
            break;
          case Local.WHITE_BISHOP:
            break;
          case Local.WHITE_QUEEN:
            break;
          case Local.WHITE_KING:
            break;
        }
        break;
      case Local.BLACK:
        switch (piece) {
          case Local.BLACK_ROOK:
            moveRook(toFile, toRank, Local.BLACK_ROOK);
            break;
          case Local.BLACK_KNIGHT:
            break;
          case Local.BLACK_BISHOP:
            break;
          case Local.BLACK_QUEEN:
            break;
          case Local.BLACK_KING:
            break;
        }
        incrementFullMoveNumber();
        break;
    }
  }

  private void moveRook(int toFile, int toRank, int type) {
    for (int i = 0; i < 8; i++) {
      if (getBoard()[indexOf(toFile, i)] == type) {
        int fromFile = toFile;
        int fromRank = i;
        doMove(indexOf(fromFile, fromRank), indexOf(toFile, toRank));
        incrementHalfMoveClock();
        switchActive();
        break;
      }
      else if (getBoard()[indexOf(i, toRank)] == type) {
        int fromFile = i;
        int fromRank = toRank;
        doMove(indexOf(toFile, toRank), indexOf(fromFile, fromRank));
        incrementHalfMoveClock();
        switchActive();
        break;
      }
    }
  }

}









