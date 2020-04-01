package com.wishhust.base;

import java.util.Objects;

public class HashMapTestEntiry {
  private String test;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HashMapTestEntiry that = (HashMapTestEntiry) o;
    return Objects.equals(test, that.test);
  }

  @Override
  public int hashCode() {
    return 1;
//    return Objects.hash(test);
  }
}
