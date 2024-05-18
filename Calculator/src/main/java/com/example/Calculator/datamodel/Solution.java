package com.example.Calculator.datamodel;

public class Solution {

    private String equation;
    private double answer;

    public Solution(String equation, double answer) {
        this.equation = equation;
        this.answer = answer;
    }

    public Solution (String equation) {
        this.equation = equation;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }





}
