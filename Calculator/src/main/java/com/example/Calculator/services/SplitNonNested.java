package com.example.Calculator.services;

import java.util.ArrayList;

public class SplitNonNested {
    public static ArrayList SplitNonNested (String Equasion) {
        String[] SplitEquasion = Equasion.split(" ");
        ArrayList ReturnItem = new ArrayList<>();
        Integer PrenCount = 0;
        for (String s : SplitEquasion) {
            if (s != "") {
                if (IsOpenParren(s)) {
                    PrenCount += 5;
                } else if (IsCloseParren(s)) {
                    PrenCount -= 5;
                } else {
                    ReturnItem.add(Attomize.Atomizer(s, PrenCount));
                }
            }
        }
        return ReturnItem;

    }
    public static Boolean IsCloseParren(String s) {
        return ")".equals(s) || "]".equals(s) || "}".equals(s);
    }
    public static Boolean IsOpenParren(String s) {
        return "(".equals(s) || "[".equals(s) || "{".equals(s);
    }
}
