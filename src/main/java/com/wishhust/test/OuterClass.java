package com.wishhust.test;

/**
 * Created by liuke on 2020/1/2 18:02
 */
public class OuterClass {
  private String name ;
  private int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public class InnerClass{

    private String name;
    private int age2;

    public InnerClass(){
      name = "chenssy";
      age = 23;
      age2 = 231;
    }
    public String getName(){
      return "11";
    }

    public void display(){
      System.out.println("name：" + getName() +"   ;age：" + getAge() + age2);
    }
  }

  public static void main(String[] args) {
    OuterClass outerClass = new OuterClass();
    OuterClass.InnerClass innerClass = outerClass.new InnerClass();
    innerClass.display();
  }
}
