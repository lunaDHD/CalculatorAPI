package com.example.Calculator.services;


public class Sterilizer {

    public String Sterilize (String equation) {
        String[] equationlist = equation.split(" ");
        StringBuilder return2 = new StringBuilder();
        for (String element : equationlist) {
            if (element != "") {
                return2.append(element);
                return2.append(' ');
            }
        }
        return2.deleteCharAt(return2.length() - 1);
        return return2.toString();
    }
}