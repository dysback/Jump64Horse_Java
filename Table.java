public class Table {
    final int TABLE_SIZE = 8;

    private int[][] moves = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

    private int[][] table = new int[TABLE_SIZE + 4][TABLE_SIZE + 4];
    
    Table() {
        //Table *table = (Table *)malloc(sizeof(Table));
        
        for(int i = 0; i < TABLE_SIZE + 4; i++) {
            for (int j = 0; j < TABLE_SIZE + 4; j++) {
                table[i][j] = -1;
            }
        }
       for(int i = 2; i < TABLE_SIZE + 2; i++) {
            for (int j = 2; j < TABLE_SIZE + 2; j++) {
                table[i][j] = 0;
            }
        }
        table[2][2] = 1;
    }
    
    void print(String descr, int severity) {
        if(severity <= Helpers.LOG_LEVEL || descr.charAt(0) == '*') {
            System.out.println("\n" + descr);
            if(severity <= Helpers.LOG_LEVEL) {
                System.out.print("   x | y      ");
                for(int i = 0; i < TABLE_SIZE; i++) {
                    System.out.format("%4d", i + 1);
                }
                
                System.out.print("\n-----+-----------");
                for(int i = 0; i < TABLE_SIZE; i++) {
                    System.out.print("----");
                }
                System.out.println("------+");
    
                for(int i = 0; i < TABLE_SIZE + 4; i++) {
                    if(i > 1 && i < TABLE_SIZE + 2) {
                        System.out.format("%4d |", i - 1);
                    } else {
                        System.out.print("     |");
                    }
                    for (int j = 0; j < TABLE_SIZE + 4; j++) {
                        System.out.format("%4d", table[i][j]);
                    }
                    System.out.println(" |");
                }
                System.out.print("-----+-----------");
                for(int i = 0; i < TABLE_SIZE; i++) {
                    System.out.print("----");
                }
                System.out.println("------+");
            }
        }
    
    }
    
    void print(String descr) {
        print(descr, 5);
    }
    
    
    boolean canMove(int x, int y, int direction) {
        return table[x + moves[direction][0]][y + moves[direction][1]] == 0 ? true : false;
    }
    
    void setMove(int x, int y, int direction, int value) {
        table[x + moves[direction][0]][y + moves[direction][1]] = value;
    }
    
    boolean jump(int x, int y, int move) {
        int lastMove = -1;
        print("Potez: " +  Integer.toString(move), 7);
        if(move >= Helpers.MOVES) {
            return true;
        }
    
        for(int i = 0; i < 8; i++) {
            if(canMove(x, y, i)) {
                setMove(x, y, i, move + 1);
                if(lastMove > -1) {
                    setMove(x, y, lastMove, 0);
                    //sprintf(text, "%s %d %s %d, %s %d", "Brisanje:", move, "Direction:", i, "Last move,", lastMove);
                    print("Brisanje: " + Integer.toString(move) + " Direction: " + Integer.toString(i) + " Last move: " + Integer.toString(lastMove), 66);
                }
                lastMove = i;
                if(jump(x + moves[i][0], y + moves[i][1], move + 1)) {
                    print("Kraj:");
                    return true;
                }
                
            }
        }
        if(lastMove > -1) {
            setMove(x, y, lastMove, 0);
            //sprintf(text, "%s %d", "Kraj poteza:", move);
            print("Kraj poteza: " + move, 6);
        }
        return false;
    }
        
}

