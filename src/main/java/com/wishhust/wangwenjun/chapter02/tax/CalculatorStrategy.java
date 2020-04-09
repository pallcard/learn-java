package com.wishhust.wangwenjun.chapter02.tax;

@FunctionalInterface
public interface CalculatorStrategy {
	double calculate(double salary, double bonus);
}
