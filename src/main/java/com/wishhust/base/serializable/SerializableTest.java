package com.wishhust.base.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializableTest {

  public static void main(String[] args) throws Exception {
//    ArrayList<Integer> list3 = new ArrayList();
//    list3.add(1);
//    list3.add(1);
//    list3.add(1);
//    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listFile"));
//    oos.writeObject(list3);
//
//    ObjectInputStream oin = new ObjectInputStream(new FileInputStream("listFile"));
//    list3 = (ArrayList) oin.readObject();
//    System.out.println(list3);

    // 测试序列化
    //初始化对象
    System.out.println("--------- serializable -----------");
    Student student = new Student();
    student.setName("lk");
    student.setAge(23);
    student.setHobby(new String[]{"read", "run"});
    // 设置静态变量test=5
    Student.test = 5;
    System.out.println(student);
    //序列化对象到文件中
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test"));
    oos.writeObject(student);
    oos.close();
//    Student.test = 10;
    //反序列化
    File file = new File("test");
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
    Student newStudent = (Student) ois.readObject();
    System.out.println(newStudent.toString());
    ois.close();

    System.out.println("--------- externalizable ------------");
    Student2 student2 = new Student2();
    student2.setName("lk");
    student2.setAge(23);
    student2.setHobby(new String[]{"read", "run"});
    System.out.println(student2);
    //序列化对象到文件中
    ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("test2"));
    oos2.writeObject(student2);
    oos2.close();
    //反序列化
    File file2 = new File("test2");
    ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(file2));
    Student2 newStudent2 = (Student2) ois2.readObject();
    System.out.println(newStudent2.toString());
    ois2.close();

    System.out.println("-------- serializable2 ----------");
    Student3 student3 = new Student3();
    student3.setName("lk");
    student3.setAge(23);
    student3.setHobby(new String[]{"read", "run"});
    System.out.println(student3);
    //序列化对象到文件中
    ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream("test3"));
    oos3.writeObject(student3);
    oos3.close();
    //反序列化
    File file3 = new File("test3");
    ObjectInputStream ois3 = new ObjectInputStream(new FileInputStream(file3));
    Student3 newStudent3 = (Student3) ois3.readObject();
    System.out.println(newStudent3.toString());
    ois3.close();


  }
}
