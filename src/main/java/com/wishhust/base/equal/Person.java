package com.wishhust.base.equal;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
public class Person {
  private int age;
  private int sex;    //0：男，1：女
  private String name;

  private final int PRIME = 37;

  Person(int age ,int sex ,String name){
    this.age = age;
    this.sex = sex;
    this.name = name;
  }


  @Override
  public int hashCode() {
    System.out.println("调用hashCode方法...........");

    int hashResult = 1;
    hashResult = (hashResult + Integer.valueOf(age).hashCode() + Integer.valueOf(sex).hashCode()) * PRIME;
    hashResult = PRIME * hashResult + ((name == null) ? 0 : name.hashCode());
    System.out.println("name:"+name +" hashCode:" + hashResult);

    return hashResult;
  }

  /**
   * 重写hashCode()
   */
  public boolean equals(Object obj) {
    System.out.println("调用equals方法...........");

    if(obj == null){
      return false;
    }
    if(obj.getClass() != this.getClass()){
      return false;
    }
    if(this == obj){
      return true;
    }

    Person person = (Person) obj;

    if(getAge() != person.getAge() || getSex()!=   person.getSex()){
      return false;
    }

    if(getName() != null){
      if(!getName().equals(person.getName())){
        return false;
      }
    }
    else if(person != null){
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Set<Person> set = new HashSet<Person>();

    Person p1 = new Person(11, 1, "张三");
    Person p2 = new Person(12, 1, "李四");
    Person p3 = new Person(11, 1, "张三");
    Person p4 = new Person(11, 1, "李四");

    //只验证p1、p3
    System.out.println("p1 == p3? :" + (p1 == p3));
    System.out.println("p1.equals(p3)?:"+p1.equals(p3));
    System.out.println("-----------------------分割线--------------------------");
    set.add(p1);
    set.add(p2);
    set.add(p3);
    set.add(p4);
    System.out.println("set.size()="+set.size());
  }
}
