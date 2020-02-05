package com.wishhust.lock;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by liuke on 2020/1/10 14:46
 */
public class Test {
  public static void main(String[] args) {

    FutureTask<String> stringFutureTask = new FutureTask<>(() -> "hello");

    new Thread(stringFutureTask).start();

  }
}
