package com.example.Calculator.services;

import com.example.Calculator.datamodel.Solution;
import org.springframework.stereotype.Service;

@Service
public class Solutionizer {

    private static final double DEFAULT_ANSWER_THAT_NEEDS_TO_BE_REPLACED = 42.0;

    public Solutionizer() {}

    public Solution createSolution(String equation) {
        Solution solution = new Solution(equation);
        solution.setAnswer(DEFAULT_ANSWER_THAT_NEEDS_TO_BE_REPLACED);
        return solution;
    }
}
