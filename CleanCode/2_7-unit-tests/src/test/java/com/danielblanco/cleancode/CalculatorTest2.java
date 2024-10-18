package com.danielblanco.cleancode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest2 {

	private Calculator calculator;
	
	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}
	
	@Test
	void testMultiplyOk() {

		Double respuesta = calculator.multiply(4.0, 7.5);
		
		assertEquals(30, respuesta);
	}
	
	@Test
	void testMultiplyFail() {

		Double respuesta = calculator.multiply(4.0, 7.5);
		
		assertEquals(15, respuesta);
	}

	@Test
	void testDivide() {
		
		Double respuesta = calculator.divide(20.0, 5.0);
		
		assertEquals(4.0, respuesta);
	}
	
	@Test
	void testDivideZero() {	
		
		assertThrows(DivisionByZeroException.class, () -> {
			calculator.divide(20.0, 0.0);
		});
	}

	@Test
	void testAbsPositive() {
		
		Double respuesta = calculator.abs(150.0);
		
		assertEquals(150.0, respuesta);
	}
	
	@Test
	void testAbsNegative() {
		
		Double respuesta = calculator.abs(-65.0);
		
		assertEquals(65.0, respuesta);
	}

}
