package com.wishhust.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListTest {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    List<String> list = new ArrayList<>();
    String [] strings = new String[1];
    Class<? extends String[]> aClass = strings.getClass();
    int n = 1 >> 1; // 右移 / 2

    list.add(null);
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");
    list.add("e");
    list.add("f");

//    ArrayList<Integer> list2 = new ArrayList<Integer>();
//    list2.add(10);
//    Iterator<Integer> iterator2 = list2.iterator();
//    while(iterator2.hasNext()){
//      Integer integer = iterator2.next();
//      if(integer==10)
//        list2.remove(integer);   //报错
//    }

    Iterator<String> iterator = list.iterator();
    iterator.next();
    iterator.remove(); // 清掉null
    String next = iterator.next();
    System.out.println(next);

    ListIterator<String> stringListIterator = list.listIterator();
    stringListIterator.add("g");
    String next1 = stringListIterator.next();
    System.out.println(next1);

    // 操作的还是原list
    List<String> strings1 = list.subList(0, 2);
    strings1.add("i");
    strings1.get(1);


    ArrayList list3 = new ArrayList();
    list3.addAll(list);
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listFile"));
    oos.writeObject(list3);

    ObjectInputStream oin = new ObjectInputStream(new FileInputStream("listFile"));
    list3 = (ArrayList) oin.readObject();
    System.out.println(list3);
  }
}
