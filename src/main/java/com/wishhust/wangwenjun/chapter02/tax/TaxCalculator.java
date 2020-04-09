package com.wishhust.wangwenjun.chapter02.tax;

public class TaxCalculator {
  // 工资
  private final double salary;
  // 奖金
  private final double bonus;

  private CalculatorStrategy calculatorStrategy;

  public TaxCalculator(double salary, double bonus, CalculatorStrategy calculatorStrategy) {
    this.salary = salary;
    this.bonus = bonus;
    this.calculatorStrategy = calculatorStrategy;
  }

  protected double calcTax(){
    return calculatorStrategy.calculate(salary,bonus);
  }

  public double calculate(){
    return this.calcTax();
  }

  public double getSalary() {
    return salary;
  }

  public double getBonus() {
    return bonus;
  }

}
