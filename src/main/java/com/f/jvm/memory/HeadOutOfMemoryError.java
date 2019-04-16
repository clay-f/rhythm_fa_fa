package com.f.jvm.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//vm args: -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+HeapDumpOnOutOfMemoryError -XX:SurvivorRatio=8
public class HeadOutOfMemoryError {
    public static void main(String[] args) {
        List<Map<String, String>> list = new ArrayList<>();
        while (true)
            list.add(new HashMap());
    }
}
