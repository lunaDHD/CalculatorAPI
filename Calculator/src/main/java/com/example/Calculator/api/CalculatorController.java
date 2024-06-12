package com.example.Calculator.api;


import com.example.Calculator.datamodel.Solution;
import com.example.Calculator.services.Solutionizer;
import com.example.Calculator.services.Sterilizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.Base64;

@RestController
class CalculatorController {
    private final Solutionizer solutionizer;

    @Autowired
    CalculatorController(Solutionizer solutionizer) {
        this.solutionizer = solutionizer;
    }

    //TODO: To use this, we need to encode the special characters in the equation.
    //For example, + must be represented as %2B.
    //So the request will be http://localhost:8080/calculate?equation=MSs5'
    //You can also get around this by using a POST request instead of a GET request.
    @GetMapping("/calculate")
    Solution getSolution(@RequestParam String string64) {
        byte[] decoded = Base64.getDecoder().decode(string64);
        String equation = new String(decoded);
        Solution solution = solutionizer.createSolution(equation);
        return solution;
    }
}

