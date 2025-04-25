package my.code.chapter3.Item_10;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /*
     * getClass() != obj.getClass() — це строгий варіант (на відміну від instanceof)
     * і захищає від порушення симетричності.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof Point;
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}
