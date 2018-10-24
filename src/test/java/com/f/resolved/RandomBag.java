package com.f.resolved;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

import static com.f.rhythm.helper.SortHelper.shuffle;

public class RandomBag<T> implements Iterable<T> {
    private T[] bag;
    private int n;

    public RandomBag() {
        bag = (T[]) new Object[10];
        n = 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return n;
    }

    public void add(T t) {
        Objects.requireNonNull(t);
        if (n == bag.length) resize(2 * bag.length);
        bag[n++] = t;
    }

    private void resize(int max) {
        T[] newBag = (T[]) new Object[max];
        for (int i = 0; i < bag.length; i++) {
            newBag[i] = bag[i];
        }
        bag = newBag;
    }

    @Override
    public Iterator<T> iterator() {
        return Arrays.stream(shuffle(bag)).filter(p -> Objects.nonNull(p)).iterator();
    }

    public static void main(String[] args) {
        RandomBag<Integer> randomBag = new RandomBag<>();
        randomBag.add(1);
        randomBag.add(2);
        randomBag.add(3);
        randomBag.add(4);
        randomBag.add(5);

        randomBag.iterator().forEachRemaining(x -> {
            System.out.println(x);
        });

        System.out.println();
    }

}
