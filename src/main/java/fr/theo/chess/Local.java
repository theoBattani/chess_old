
package fr.theo.chess;

public class Local {

  // Memo indices 
  //
  //      0    1    2    3    4    5    6    7
  //   ┌────┬────┬────┬────┬────┬────┬────┬────┐
  // 0 │  0 │  1 │  2 │  3 │  4 │  5 │  6 │  7 │ 8
  //   ├────┼────┼────┼────┼────┼────┼────┼────┤ 
  // 1 │  8 │  9 │ 10 │ 11 │ 12 │ 13 │ 14 │ 15 │ 7
  //   ├────┼────┼────┼────┼────┼────┼────┼────┤
  // 2 │ 16 │ 17 │ 18 │ 19 │ 20 │ 21 │ 22 │ 23 │ 6
  //   ├────┼────┼────┼────┼────┼────┼────┼────┤
  // 3 │ 24 │ 25 │ 26 │ 27 │ 28 │ 29 │ 30 │ 31 │ 5
  //   ├────┼────┼────┼────┼────┼────┼────┼────┤
  // 4 │ 32 │ 33 │ 34 │ 35 │ 36 │ 37 │ 38 │ 39 │ 4
  //   ├────┼────┼────┼────┼────┼────┼────┼────┤
  // 5 │ 40 │ 41 │ 42 │ 43 │ 44 │ 45 │ 46 │ 47 │ 3
  //   ├────┼────┼────┼────┼────┼────┼────┼────┤
  // 6 │ 48 │ 49 │ 50 │ 51 │ 52 │ 53 │ 54 │ 55 │ 2
  //   ├────┼────┼────┼────┼────┼────┼────┼────┤
  // 7 │ 56 │ 57 │ 58 │ 59 │ 60 │ 61 │ 62 │ 63 │ 1
  //   └────┴────┴────┴────┴────┴────┴────┴────┘
  //      a    b    c    d    e    f    g    h

  // tile notation tab
  // public static final String[] TILES = {
  //   "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8",
  //   "a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7",
  //   "a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6",
  //   "a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5",
  //   "a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4",
  //   "a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3",
  //   "a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2",
  //   "a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1"
  // };

  // initial values
  public static final char   FIRST_ACTIVE                   = 'w';
  public static final String STARTING_CASTLING_AVAILABILITY = "KQkq";
  public static final String STARTING_EN_PASSANT_TARGET     = "-";
  public static final int    STARTING_HALF_MOVE_CLOCK       = 0;
  public static final int    STARTING_FULL_MOVE_NUMBER      = 1;
  public static final String STARTING_FEN                   = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
  public static final int[]  STARTING_BOARD                 = {
    114, 110,  98, 113, 107,  98, 110, 114,
    112, 112, 112, 112, 112, 112, 112, 112,
      0,   0,   0,   0,   0,   0,   0,   0,
      0,   0,   0,   0,   0,   0,   0,   0,
      0,   0,   0,   0,   0,   0,   0,   0,
      0,   0,   0,   0,   0,   0,   0,   0,
     80,  80,  80,  80,  80,  80,  80,  80,
     82,  78,  66,  81,  75,  66,  78,  82
  };

  // possible active character
  public static final char WHITE = 'w';
  public static final char BLACK = 'b';

  // empty tile
  public static final int EMPTY = 0;

  // black pieces codes
  public static final int BLACK_ROOK   = 114; // ascii code for 'r'
  public static final int BLACK_KNIGHT = 110; // ascii code for 'n'
  public static final int BLACK_BISHOP =  98; // ascii code for 'b'
  public static final int BLACK_QUEEN  = 113; // ascii code for 'q'
  public static final int BLACK_KING   = 107; // ascii code for 'k'
  public static final int BLACK_PAWN   = 112; // ascii code for 'p'
  
  // white pieces codes
  public static final int WHITE_ROOK   =  82; // ascii code for 'R'
  public static final int WHITE_KNIGHT =  78; // ascii code for 'N'
  public static final int WHITE_BISHOP =  66; // ascii code for 'B'
  public static final int WHITE_QUEEN  =  81; // ascii code for 'Q'
  public static final int WHITE_KING   =  75; // ascii code for 'K'
  public static final int WHITE_PAWN   =  80; // ascii code for 'P'


}










