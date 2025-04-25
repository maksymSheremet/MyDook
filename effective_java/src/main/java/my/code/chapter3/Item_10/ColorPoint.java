package my.code.chapter3.Item_10;

public class ColorPoint extends Point {
    private final String color;

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ColorPoint)) return false;

        ColorPoint other = (ColorPoint) obj;
        return other.canEqual(this)
               && super.equals(other)
               && color.equals(other.color);
    }

    @Override
    public boolean canEqual(Object obj) {
        return obj instanceof ColorPoint;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 31 + color.hashCode();
    }

    @Override
    public String toString() {
        return "ColorPoint(" + super.toString() + ", color=" + color + ")";
    }
}
