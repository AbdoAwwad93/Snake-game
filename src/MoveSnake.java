package snake;

public class MoveSnake {
    static final int UNITE_SIZE = 25;
    int x[];
    int y[];
      int bodyParts;
     char deriction='R';

    public MoveSnake(int[]x,int[]y,int bodyParts) {
        this.x=x;
        this.y=y;
        this.bodyParts = bodyParts;
        
    }
    public void move(){
    for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (deriction) {
            case 'U' -> y[0] =y[0] - UNITE_SIZE;
            case 'D' -> y[0] =y[0] + UNITE_SIZE;
            case 'R' -> x[0] =x[0] + UNITE_SIZE;
            case 'L' -> x[0] =x[0] - UNITE_SIZE;
        }
      }
    }
    
    

