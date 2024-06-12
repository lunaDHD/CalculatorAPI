package com.example.Calculator;
import com.example.Calculator.datamodel.Solution;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculatorApplicationTests {

	@Test
	void contextLoads() {
	}
	public static void main(String[] args) {
		System.out.println(testPemdas());
	}
	public static Float testPemdas() {

		return callSolution("1  -(2   + 3) ").getAnswer();
	}
	public static Solution callSolution(String Equasion) {
		return com.example.Calculator.services.Solutionizer.createSolution(Equasion);
	}
}
