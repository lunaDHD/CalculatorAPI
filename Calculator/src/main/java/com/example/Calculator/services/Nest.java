package com.example.Calculator.services;

import com.example.Calculator.datamodel.AtomizedObject;

import javax.management.AttributeList;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Nest {
    public static ArrayList Nester (ArrayList<AtomizedObject> Splitlist) {
        ArrayList ReturnArray = new ArrayList<>();
        int MaxValue = 1000000000;
        int MaxIndex = -1;
        for (AtomizedObject operand : Splitlist) {
            if (operand.getAtomList() != null) {
                if (((int) operand.getAtomList().get(1)) <= MaxValue) {
                    MaxIndex = Splitlist.indexOf(operand);
                    MaxValue = ((int) operand.getAtomList().get(1));
                }
            }
        }
        ReturnArray.add(Splitlist.remove(MaxIndex).getAtomList().get(0));
        ArrayList DebugVar = new ArrayList<AtomizedObject>(Splitlist.subList(0, MaxIndex));
        if (new ArrayList<AtomizedObject>(Splitlist.subList(0, MaxIndex)).size() == 1) {
            ReturnArray.add(Splitlist.subList(0, MaxIndex).get(0));
        } else {
            ReturnArray.add(Nester(new ArrayList<AtomizedObject>(Splitlist.subList(0, MaxIndex))));
        }
        if (new ArrayList<AtomizedObject>(Splitlist.subList(MaxIndex, Splitlist.size())).size() == 1) {
            ReturnArray.add(Splitlist.subList(MaxIndex, Splitlist.size()).get(0));
        } else {
            ReturnArray.add(Nester(new ArrayList<AtomizedObject>(Splitlist.subList(MaxIndex, Splitlist.size()))));
        }
        return ReturnArray;
    }
}
