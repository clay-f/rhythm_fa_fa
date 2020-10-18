package com.f.java.stream.tools;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;


public class ListCollector {
 /**
     * 经过优化过的，插入排序，在使用stream的时候，创建排序过的list.
     * <p>
     * jdk 没有在collector中提供创建排序了的list.
     * 以前的解决方案是: 分组然后对分组进行排序, 排序以后进行分组, 现在可以在创建list的时候根据规则创建排序list
     *
     * @param c   比较器
     * @param <T> 输入数据类型
     * @return collector
     * @see <a href="https://stackoverflow.com/questions/35872236/sorting-lists-after-groupingby">分组排序</a>
     */
    public static <T> Collector<T, ?, List<T>> toSortedList(Comparator<? super T> c) {
        return Collector.of(ArrayList::new,
                (l, t) -> l.add(insertPos(l, 0, l.size(), t, c), t),
                (list1, list2) -> merge(list1, list2, c));
    }

    private static <T> List<T> merge(List<T> list1, List<T> list2, Comparator<? super T> c) {
        if (list1.isEmpty()) return list2;
        for (int ix1 = 0, ix2 = 0, num1 = list1.size(), num2 = list2.size(); ix2 < num2; ix2++, num1++) {
            final T element = list2.get(ix2);
            ix1 = insertPos(list1, ix1, num1, element, c);
            list1.add(ix1, element);
            if (ix1 == num1) {
                while (++ix2 < num2) list1.add(list2.get(ix2));
                return list1;
            }
        }
        return list1;
    }

    private static <T> int insertPos(
            List<? extends T> list, int low, int high, T t, Comparator<? super T> c) {
        high--;
        while (low <= high) {
            int mid = (low + high) >>> 1, cmp = c.compare(list.get(mid), t);
            if (cmp < 0) low = mid + 1;
            else if (cmp > 0) high = mid - 1;
            else {
                mid++;
                while (mid <= high && c.compare(list.get(mid), t) == 0) mid++;
                return mid;
            }
        }
        return low;
    }

}
