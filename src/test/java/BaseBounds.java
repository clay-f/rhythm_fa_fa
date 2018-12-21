import java.awt.*;

public class BaseBounds {
    interface HasColor {
        Color getColor();
    }

    class Dimension {
        public int x, y, z;
    }

    class Bounded extends Dimension implements HasColor, Weight {
        @Override
        public Color getColor() {
            return Color.BLACK;
        }

        @Override
        public int weight() {
            return 0;
        }
    }

    interface Weight {
        int weight();
    }

    class Solid<T extends Dimension & HasColor & Weight> {
        T t;
        public Solid(T item) {
            this.t = item;
        }

        public void setT(T t) {
            this.t = t;
        }

        public int getX() {
            return t.x;
        }

        public int getY() {
            return t.y;
        }

        public int getZ() {
            return t.z;
        }

        public Color getColor() {
            return t.getColor();
        }

        public int getWeight() {
            return t.weight();
        }
    }

}
