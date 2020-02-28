package com.wishhust.exception;

public class TestException {
  public static int NoException(){
    int i=10;
    try{
      System.out.println("i in try block is"+i);
      return i=i-2;
    }catch(Exception e){
      --i;
      System.out.println("i in catch - form try block is"+i);
      return --i;
    }finally{
      System.out.println("i in finally - from try or catch block is"+i);
      return --i;
    }
  }

  public static int NoException2(){
    int i=10;
    try{
      System.out.println("i in try block is--"+i);
      return --i;
    }catch(Exception e){
      --i;
      System.out.println("i in catch - form try block is--"+i);
      return --i;
    }finally{

      System.out.println("i in finally - from try or catch block is--"+i);
      --i;
      System.out.println("i in finally block is--"+i);
      //return --i;
    }
  }

  public static int WithException(){
    int i=10;
    try{
      System.out.println("i in try block is--"+i); // 10
      i = i/0;
      System.out.println("i in try block and after exception");
      return --i;
    }catch(Exception e){
      System.out.println("i in catch - form try block is--"+i); // 10
      --i;
      System.out.println("i in catch block is--"+i);  // 9
      return --i; // 8
    }finally{
      System.out.println("i in finally - from try or catch block is--"+i);  // 8
      --i;
      System.out.println("i in finally block is--"+i);  // 7
      return --i; // 6
    }
  }

  public static int CatchException(){
    int i=10;
    try{
      System.out.println("i in try block is--"+i); // 10
      i=i/0;
      return --i;
    }catch(Exception e){
      System.out.println("i in catch - form try block is--"+i); //10
      int j = i/0;
      return --i;
    }finally{

      System.out.println("i in finally - from try or catch block is--"+i); // 10
      --i;
      System.out.println("i in finally block is--"+i); //9
      return --i;  // 8
    }
  }

  public static int CatchException2(){
    int i=10;
    try{
      System.out.println("i in try block is--"+i); // 10
      i=i/0;
      return --i;
    }catch(Exception e){
      System.out.println("i in catch - form try block is--"+i); // 10
      int j = i/0;
      return --i;
    }finally{

      System.out.println("i in finally - from try or catch block is--"+i);  //10
      --i;
      System.out.println("i in finally block is--"+i); // 9
//      return --i; // 8 这里若无return， catch里的异常抛错
    }
  }

  public static void main(String[] args) {
    System.out.println("---------1---------");
    int i1 = NoException();
    System.out.println(i1);
    System.out.println("---------2--------");
    int i2 = NoException2();
    System.out.println(i2);
    System.out.println("---------3---------");
    int i3 = WithException();
    System.out.println(i3);
    System.out.println("---------4--------");
    int i4 = CatchException();
    System.out.println(i4);
    System.out.println("---------5--------");
    int i5 = CatchException2();
    System.out.println(i5);
  }
}
