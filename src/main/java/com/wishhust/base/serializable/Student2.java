package com.wishhust.base.serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Student2 implements Externalizable {

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
    return "name:" + name + ", age:" + age;
  }

  @Override
  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeObject(name);
//    out.writeInt(age);
  }

  @Override
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    name = (String) in.readObject();
//    age = in.readInt();
  }
}
