package com.elte;

import java.util.Comparator;
import java.util.Map;

public class ComparatorInts implements Comparator<String> {

    Map<String, Integer> base;

    public ComparatorInts(Map<String, Integer> base) {
        this.base = base;
    }

    @Override
    public int compare(String s1, String s2) {
        return base.get(s1).compareTo(base.get(s2));
    }
}
