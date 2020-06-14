import java.util.Objects;
public class Point2D {
    private int x;
    private int y;

    public Point2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point2D point2D = (Point2D) o;
        return Double.compare(point2D.x, x) == 0 &&
                Double.compare(point2D.y, y) == 0;
    }

    public Point2D add(int addX, int addY){
        return new Point2D(addX + x, addY + y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public String toString(){
        return "(" + (int)Math.round(x) + "," + (int)Math.round(y) + ")";
    }
}
