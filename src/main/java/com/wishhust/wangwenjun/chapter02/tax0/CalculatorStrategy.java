package com.wishhust.wangwenjun.chapter02.tax0;

@FunctionalInterface
public interface CalculatorStrategy {
	double calculate(double salary, double bonus);
}
