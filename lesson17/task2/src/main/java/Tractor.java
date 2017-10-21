/**
 * Created by User on 21.10.2017.
 */
public class Tractor {

    int posX = 0;
    int posY = 0;
    int fieldX = 5;
    int fieldY = 5;

    Orientation orientation = Orientation.NORTH;

    public void move(String command) {
        if (command == "F") {
            moveForwards();
        } else if (command == "T") {
            turnClockwise();
        }
    }

    public void moveForwards() {
        if (orientation == Orientation.NORTH)
            posY++;

        if (orientation == Orientation.EAST)
            posX++;

        if (orientation == Orientation.SOUTH)
            posY--;

        if (orientation == Orientation.WEST)
            posX--;

        if (posX > fieldX || posY > fieldY) {
            throw new TractorInDitchException();
        }
    }

    public void turnClockwise() {
        if (orientation == Orientation.NORTH) {
            orientation = Orientation.EAST;
        } else
        if (orientation == Orientation.EAST) {
            orientation = Orientation.SOUTH;
        } else
        if (orientation == Orientation.SOUTH) {
            orientation = Orientation.WEST;
        } else
        if (orientation == Orientation.WEST) {
            orientation = Orientation.NORTH;
        }
    }

    public int getPositionX() {
        return posX;
    }

    public int getPositionY() {
        return posY;
    }

    public Orientation getOrientation() {
        return orientation;
    }

}
