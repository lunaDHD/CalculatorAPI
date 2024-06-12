package com.example.Calculator.services;

import com.example.Calculator.datamodel.AtomizedObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

public class Attomize {
    public static Object Atomizer (String Item, Integer Prencount) {
        HashMap<String, Function<ArrayList<AtomizedObject>, Float>> Opers = new HashMap<>(5);
        Opers.put("+", (x) -> x.get(0).getAtomFloat() + x.get(1).getAtomFloat());
        Opers.put("-", (x) -> x.get(0).getAtomFloat() - x.get(1).getAtomFloat());
        Opers.put("*", (x) -> x.get(0).getAtomFloat() * x.get(1).getAtomFloat());
        Opers.put("/", (x) -> x.get(0).getAtomFloat() / x.get(1).getAtomFloat());
        Opers.put("^", (x) -> (float) Math.pow(x.get(0).getAtomFloat(), x.get(1).getAtomFloat()));
        HashMap<String, Integer> Priorities = new HashMap<>(5);
        Priorities.put("+", 0);
        Priorities.put("-", 0);
        Priorities.put("*", 1);
        Priorities.put("/", 1);
        Priorities.put("^", 2);
        if (Opers.containsKey(Item)) {
            AtomizedObject obj = new AtomizedObject();
            obj.setAtomList(Opers.get(Item), Priorities.get(Item) + Prencount);
            return obj;
        }
        else {
            AtomizedObject obj = new AtomizedObject();
            obj.setAtomFloat(Float.parseFloat(Item));
            return obj;
        }
    }
}
