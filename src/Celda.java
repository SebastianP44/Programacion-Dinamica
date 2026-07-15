public class Celda {

    private int x;
    private int y;

    public Celda(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Celda))
            return false;

        Celda otra = (Celda) obj;
        return x == otra.x && y == otra.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}