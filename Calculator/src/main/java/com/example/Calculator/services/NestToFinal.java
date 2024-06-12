package com.example.Calculator.services;

import com.example.Calculator.datamodel.AtomizedObject;

import java.util.ArrayList;
import java.util.function.Function;

public class NestToFinal {
    public static AtomizedObject NestToFinal (ArrayList Nested) {
        Function operand = (Function) Nested.remove(0);
        ArrayList args = new ArrayList();
        for (Object arg : Nested) {
            if (arg instanceof AtomizedObject) {
                args.add(arg);
            } else {
                args.add(NestToFinal((ArrayList) arg));
            }
        }
        AtomizedObject Returnt = new AtomizedObject();
        Returnt.setAtomFloat((float) operand.apply(args));
        return Returnt;
    }
}
