package com.example.myproject.shared;

public class Test {
	public static void main(String[] args) {
		GenRandomNum random = new GenRandomNum(0);
		random.setMathExpression(0);
		System.out.println(random.getExpression());
		System.out.println(random.getTrueResult());
		System.out.println(random.getFalseResult());
	}
}