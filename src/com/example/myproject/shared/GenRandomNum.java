package com.example.myproject.shared;

import java.util.Random;

public class GenRandomNum {

	private int score;

	private String expression;

	private String trueResult;

	private String falseResult;

	Random random = new Random();

	public GenRandomNum() {

	}

	public GenRandomNum(int score) {
		this.score = score;
	}

	public void setMathExpression(int score) {
		int operate = random.nextInt(4);
		int level = score - score % 5 + 4;
		switch (operate) {
		case 0:
			setPlusOperation(level);
			break;
		case 1:
			setMinusOperation(level);
			break;
		case 2:
			setMultipleOperation(level);
			break;
		case 3:
			setDivideOperation(level);
			break;
		default:
			setPlusOperation(level);
			break;
		}
	}

	private void setPlusOperation(int point) {
		int num1 = random.nextInt(point);
		int num2 = random.nextInt(point);
		int falseSum;
		do {
			falseSum = random.nextInt(point);
		} while (falseSum == num1 + num2);

		expression = num1 + " + " + num2 + " =";
		trueResult = String.valueOf(num1 + num2);
		falseResult = String.valueOf(falseSum);
	}

	private void setMinusOperation(int point) {
		int num1 = random.nextInt(point);
		int num2 = random.nextInt(point);
		int falseSum;
		do {
			falseSum = - point + random.nextInt(2 * point);
		} while (falseSum == num1 - num2);

		expression = num1 + " - " + num2 + " =";
		trueResult = String.valueOf(num1 - num2);
		falseResult = String.valueOf(falseSum);
	}

	private void setMultipleOperation(int point) {
		int num1, num2;
		do {
			num1 = random.nextInt(point);
			num2 = random.nextInt(point);
		} while (num1 * num2 > point * point / 2);
		int falseSum;
		do {
			falseSum = random.nextInt(num1 * num2 == 0 ? point : num1 * num2);
		} while (falseSum == num1 * num2);

		expression = num1 + " x " + num2 + " =";
		trueResult = String.valueOf(num1 * num2);
		falseResult = String.valueOf(falseSum);
	}

	private void setDivideOperation(int point) {
		int num1, num2;
		do {
			num1 = random.nextInt(point);
			num2 = random.nextInt(num1 == 0 ? point : num1);
		} while (num2 == 0 || num1 % num2 != 0);
		int falseSum;
		do {
			falseSum = random.nextInt(point);
		} while (falseSum == num1 / num2);

		expression = num1 + " / " + num2 + " =";
		trueResult = String.valueOf(num1 / num2);
		falseResult = String.valueOf(falseSum);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getTrueResult() {
		return trueResult;
	}

	public void setTrueResult(String trueResult) {
		this.trueResult = trueResult;
	}

	public String getFalseResult() {
		return falseResult;
	}

	public void setFalseResult(String falseResult) {
		this.falseResult = falseResult;
	}
}