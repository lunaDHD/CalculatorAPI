package com.example.Calculator.datamodel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class AtomizedObject {
    private ArrayList<?> AtomList;
    private Float AtomFloat;

    public AtomizedObject() {
    }

    public ArrayList<?> getAtomList() {
        return AtomList;
    }

    public void setAtomList(Function operand, Integer priority) {
        AtomList = new ArrayList<>(List.of(operand, priority));
    }

    public Float getAtomFloat() {
        return AtomFloat;
    }

    public void setAtomFloat(Float atomFloat) {
        AtomFloat = atomFloat;
    }
}
