package com.wishhust.base.serializable;

import java.io.Serializable;

public class Student implements Serializable {

  private String name;
  private int age;
  public static int test;
  private String[] hobby;

  public String[] getHobby() {
    return hobby;
  }

  public void setHobby(String[] hobby) {
    this.hobby = hobby;
  }

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

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    if (hobby != null && hobby.length > 0) {
      for (String h : hobby) {
        sb.append(h + ",");
      }
    }
    return "name:" + name + ",age:" + age + ",hobby:" + sb + ",test" + test;
  }

}
