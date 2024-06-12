package com.example.Calculator.services;

import com.example.Calculator.datamodel.Solution;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Solutionizer {

    public Solutionizer() {}
    private static final Sterilizer sterilizer = new Sterilizer();

    public static Solution createSolution(String equation) {
        equation = equation.replace("(", " ( ")
                .replace(")", " ) ")
                .replace("+", " + ")
                .replace("-", " - ")
                .replace("/", " / ")
                .replace("*", " * ")
                .replace("^", " ^ ")
                .replace("]"," ] ")
                .replace("["," [ ")
                .replace("}"," } ")
                .replace("{"," { ");
        Solution solution = new Solution(sterilizer.Sterilize(equation));
        solution.setAnswer(NestToFinal.NestToFinal(Nest.Nester(SplitNonNested.SplitNonNested(equation))).getAtomFloat());
        return solution;
    }
}
