package com.example.Calculator.datamodel;

public class Solution {

    private String equation;
    private Float answer;

    public Solution(String equation, Float answer) {
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

    public Float getAnswer() {
        return answer;
    }

    public void setAnswer(Float answer) {
        this.answer = answer;
    }





}
