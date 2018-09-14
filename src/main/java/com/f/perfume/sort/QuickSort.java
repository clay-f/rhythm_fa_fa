package com.f.perfume.sort;

import static com.f.perfume.helper.Base.*;

public class QuickSort {
    public static void sort(Comparable[] a, Integer lo, Integer hi) {
        if (hi < lo) return;
        Integer p = partition(a, lo, hi);
        sort(a, lo, p - 1);
        sort(a, p + 1, hi);
    }

    public static Integer partition(Comparable[] a, int lo, int hi) {
        Comparable v = a[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (less(a[++i], v)) if (i >= hi) break;
            while (less(v, a[--j])) if (j <= lo) break;
            if (j <= i) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] a = {10, 99, 100, 20, 50, 60, 1, 2, 9, 3, 999, 128, 223, 112, 295, 385};
        sort(a, 0, a.length - 1);
        show(a);
    }
}
