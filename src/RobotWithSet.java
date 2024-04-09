import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class RobotWithSet {

    Position pos;
    int directionGrad;

    //Хэшсет всегда работает, но будет работать неправильно, если не переопределен метод equals
    Set<Position> history=new HashSet<>();
    //Трисет выбрасывает исключение, если нет метода compareTo
   // Set<Position> history=new TreeSet<>();

    public RobotWithSet(int x, int y, int directionGrad) {
        this.pos = new Position(x, y);
        this.directionGrad = directionGrad;
    }

    public void turnLeft() {
        directionGrad = (directionGrad + 90) % 360;
    }

    public void turnRight() {
        directionGrad = (directionGrad - 90 + 360) % 360;
    }

    public void stepForward() {
        history.add(pos);       //позиция ушла в историю
        //переход на новую позицию:
        if (directionGrad == 0)   pos = new Position(pos.x+1, pos.y);
        if (directionGrad == 90)  pos = new Position(pos.x, pos.y+1);
        if (directionGrad == 180) pos = new Position(pos.x-1, pos.y);
        if (directionGrad == 270) pos = new Position(pos.x, pos.y-1);

    }

    public void doCommand(char symbol) {
        if (symbol == 'R')
            turnRight();
        if (symbol == 'L')
            turnLeft();
        if (symbol == 'S')
            stepForward();
    }

    public boolean checkIfIWasHere() {
        return history.contains(pos);
    }

    public int runProgramUntilCross(String proga) {
        for (char symbol : proga.toCharArray()) {
            doCommand(symbol);
            if (symbol=='S' && checkIfIWasHere() )
                return this.history.size();
        }
        return -1;
    }
}

