package com.f.rhythm.sort;

import static com.f.rhythm.helper.SortHelper.exch;
import static com.f.rhythm.helper.SortHelper.show;

public class Quick3way {
    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];

        while (i < gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exch(a, lt++, i++);
            } else if (cmp > 0) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    public static void main(String[] args) {
        Integer[] arr = {10, 20, 9, 8, 3};
        sort(arr, 0, arr.length - 1);
        show(arr);
    }

}
