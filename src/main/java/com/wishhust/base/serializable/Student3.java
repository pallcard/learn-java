package com.wishhust.base.serializable;

import java.io.Serializable;

public class Student3 implements Serializable {

  private String name;
  private int age;
  transient String[] hobby;

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
    return "name:" + name + ",age:" + age + ",hobby:" + sb;
  }


  // 仿照ArrayList写的序列化方法
  private void writeObject(java.io.ObjectOutputStream s)
      throws java.io.IOException {

    s.defaultWriteObject();

    // Write out size as capacity for behavioural compatibility with clone()
    s.writeInt(hobby.length);

    // Write out all elements in the proper order.
    for (int i = 0; i < hobby.length; i++) {
      s.writeObject(hobby[i]);
    }
  }

  // 反序列化数组
  private void readObject(java.io.ObjectInputStream s)
      throws java.io.IOException, ClassNotFoundException {

    s.defaultReadObject();

    int size = s.readInt();
    if (size > 0) {

      hobby = new String[size];
      for (int i = 0; i < size; i++) {
        hobby[i] = (String) s.readObject();
      }
    }
  }

}
