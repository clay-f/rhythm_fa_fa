package com.f.java.concurrent.example;

public class Pair {
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public void incrementX() {
        x++;
    }

    public int getY() {
        return y;
    }

    public void incrementY() {
        y++;
    }

    public class ParirValuesNotEqualsException extends RuntimeException {
        public ParirValuesNotEqualsException() {
            super("Pai values not equals: " + Pair.this);
        }
    }

    public void checkState() {
        if (x != y)
            throw new ParirValuesNotEqualsException();
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
