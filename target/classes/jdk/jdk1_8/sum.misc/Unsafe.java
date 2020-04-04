package sum.misc;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

//package sun.misc;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.ProtectionDomain;
import sun.misc.VM;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;
// 从sum.misc 中Unsafe.class 里复制过来，仅仅是看一下代码
public final class Unsafe {
//  通常，我们在Java中创建的对象都处于堆内内存（heap）中，堆内内存是由JVM所管控的Java进程内存，并且它们遵循JVM的内存管理机制，JVM会采用垃圾回收机制统一管理堆内存。
//  与之相对的是堆外内存，存在于JVM管控之外的内存区域，Java中对堆外内存的操作，依赖于Unsafe提供的操作堆外内存的native方法。
  // 单例对象
  private static final Unsafe theUnsafe;
  public static final int INVALID_FIELD_OFFSET = -1;
  public static final int ARRAY_BOOLEAN_BASE_OFFSET;
  public static final int ARRAY_BYTE_BASE_OFFSET;
  public static final int ARRAY_SHORT_BASE_OFFSET;
  public static final int ARRAY_CHAR_BASE_OFFSET;
  public static final int ARRAY_INT_BASE_OFFSET;
  public static final int ARRAY_LONG_BASE_OFFSET;
  public static final int ARRAY_FLOAT_BASE_OFFSET;
  public static final int ARRAY_DOUBLE_BASE_OFFSET;
  public static final int ARRAY_OBJECT_BASE_OFFSET;
  public static final int ARRAY_BOOLEAN_INDEX_SCALE;
  public static final int ARRAY_BYTE_INDEX_SCALE;
  public static final int ARRAY_SHORT_INDEX_SCALE;
  public static final int ARRAY_CHAR_INDEX_SCALE;
  public static final int ARRAY_INT_INDEX_SCALE;
  public static final int ARRAY_LONG_INDEX_SCALE;
  public static final int ARRAY_FLOAT_INDEX_SCALE;
  public static final int ARRAY_DOUBLE_INDEX_SCALE;
  public static final int ARRAY_OBJECT_INDEX_SCALE;
  public static final int ADDRESS_SIZE;
  private static final sun.misc.VM VM = null; // 新增目的是使得代码不报错

  private static native void registerNatives();

  private Unsafe() {
  }

  @CallerSensitive
  public static Unsafe getUnsafe() {
    Class var0 = Reflection.getCallerClass();
    // 仅在引导类加载器`BootstrapClassLoader`加载时才合法
    if (!VM.isSystemDomainLoader(var0.getClassLoader())) {
      throw new SecurityException("Unsafe");
    } else {
      return theUnsafe;
    }
  }

  /**
   * 内存操作2
   *
   */
  public native int getInt(Object var1, long var2);

  public native void putInt(Object var1, long var2, int var4);
  // 获取给定地址值，忽略修饰限定符的访问限制。与此类似操作还有: getInt，getDouble，getLong，getChar等
  public native Object getObject(Object var1, long var2);
  // 为给定地址设置值，忽略修饰限定符的访问限制，与此类似操作还有: putInt,putDouble，putLong，putChar等
  public native void putObject(Object var1, long var2, Object var4);

  public native boolean getBoolean(Object var1, long var2);

  public native void putBoolean(Object var1, long var2, boolean var4);
  // 获取给定地址的byte类型的值（当且仅当该内存地址为allocateMemory分配时，此方法结果为确定的）
  public native byte getByte(Object var1, long var2);
  // 为给定地址设置byte类型的值（当且仅当该内存地址为allocateMemory分配时，此方法结果才是确定的）
  public native void putByte(Object var1, long var2, byte var4);

  public native short getShort(Object var1, long var2);

  public native void putShort(Object var1, long var2, short var4);

  public native char getChar(Object var1, long var2);

  public native void putChar(Object var1, long var2, char var4);

  public native long getLong(Object var1, long var2);

  public native void putLong(Object var1, long var2, long var4);

  public native float getFloat(Object var1, long var2);

  public native void putFloat(Object var1, long var2, float var4);

  public native double getDouble(Object var1, long var2);

  public native void putDouble(Object var1, long var2, double var4);

  /** @deprecated */
  @Deprecated
  public int getInt(Object var1, int var2) {
    return this.getInt(var1, (long)var2);
  }

  /** @deprecated */
  @Deprecated
  public void putInt(Object var1, int var2, int var3) {
    this.putInt(var1, (long)var2, var3);
  }

  /** @deprecated */
  @Deprecated
  public Object getObject(Object var1, int var2) {
    return this.getObject(var1, (long)var2);
  }

  /** @deprecated */
  @Deprecated
  public void putObject(Object var1, int var2, Object var3) {
    this.putObject(var1, (long)var2, var3);
  }

  /** @deprecated */
  @Deprecated
  public boolean getBoolean(Object var1, int var2) {
    return this.getBoolean(var1, (long)var2);
  }

  /** @deprecated */
  @Deprecated
  public void putBoolean(Object var1, int var2, boolean var3) {
    this.putBoolean(var1, (long)var2, var3);
  }

  /** @deprecated */
  @Deprecated
  public byte getByte(Object var1, int var2) {
    return this.getByte(var1, (long)var2);
  }

  /** @deprecated */
  @Deprecated
  public void putByte(Object var1, int var2, byte var3) {
    this.putByte(var1, (long)var2, var3);
  }

  /** @deprecated */
  @Deprecated
  public short getShort(Object var1, int var2) {
    return this.getShort(var1, (long)var2);
  }

  /** @deprecated */
  @Deprecated
  public void putShort(Object var1, int var2, short var3) {
    this.putShort(var1, (long)var2, var3);
  }

  /** @deprecated */
  @Deprecated
  public char getChar(Object var1, int var2) {
    return this.getChar(var1, (long)var2);
  }

  /** @deprecated */
  @Deprecated
  public void putChar(Object var1, int var2, char var3) {
    this.putChar(var1, (long)var2, var3);
  }

  /** @deprecated */
  @Deprecated
  public long getLong(Object var1, int var2) {
    return this.getLong(var1, (long)var2);
  }

  /** @deprecated */
  @Deprecated
  public void putLong(Object var1, int var2, long var3) {
    this.putLong(var1, (long)var2, var3);
  }

  /** @deprecated */
  @Deprecated
  public float getFloat(Object var1, int var2) {
    return this.getFloat(var1, (long)var2);
  }

  /** @deprecated */
  @Deprecated
  public void putFloat(Object var1, int var2, float var3) {
    this.putFloat(var1, (long)var2, var3);
  }

  /** @deprecated */
  @Deprecated
  public double getDouble(Object var1, int var2) {
    return this.getDouble(var1, (long)var2);
  }

  /** @deprecated */
  @Deprecated
  public void putDouble(Object var1, int var2, double var3) {
    this.putDouble(var1, (long)var2, var3);
  }

  public native byte getByte(long var1);

  public native void putByte(long var1, byte var3);

  public native short getShort(long var1);

  public native void putShort(long var1, short var3);

  public native char getChar(long var1);

  public native void putChar(long var1, char var3);

  public native int getInt(long var1);

  public native void putInt(long var1, int var3);

  public native long getLong(long var1);

  public native void putLong(long var1, long var3);

  public native float getFloat(long var1);

  public native void putFloat(long var1, float var3);

  public native double getDouble(long var1);

  public native void putDouble(long var1, double var3);

  public native long getAddress(long var1);

  public native void putAddress(long var1, long var3);


  /**
   * 内存操作1
   */
  // 分配内存, 相当于C++的malloc函数
  public native long allocateMemory(long var1);
  // 扩充内存
  public native long reallocateMemory(long var1, long var3);
  // 在给定的内存块中设置值
  public native void setMemory(Object var1, long var2, long var4, byte var6);

  public void setMemory(long var1, long var3, byte var5) {
    this.setMemory((Object)null, var1, var3, var5);
  }
  //内存拷贝
  public native void copyMemory(Object var1, long var2, Object var4, long var5, long var7);

  public void copyMemory(long var1, long var3, long var5) {
    this.copyMemory((Object)null, var1, (Object)null, var3, var5);
  }
  // 释放内存
  public native void freeMemory(long var1);



  /** @deprecated */
  @Deprecated
  public int fieldOffset(Field var1) {
    return Modifier.isStatic(var1.getModifiers()) ? (int)this.staticFieldOffset(var1) : (int)this.objectFieldOffset(var1);
  }

  /** @deprecated */
  @Deprecated
  public Object staticFieldBase(Class<?> var1) {
    Field[] var2 = var1.getDeclaredFields();

    for(int var3 = 0; var3 < var2.length; ++var3) {
      if (Modifier.isStatic(var2[var3].getModifiers())) {
        return this.staticFieldBase(var2[var3]);
      }
    }

    return null;
  }

  /**
   * Class相关
   */
  // 获取给定静态字段的内存地址偏移量，这个值对于给定的字段是唯一且固定不变的
  public native long staticFieldOffset(Field var1);
  // 返回对象成员属性在内存地址相对于此对象的内存地址的偏移量
  public native long objectFieldOffset(Field var1);
  // 获取一个静态类中给定字段的对象指针
  public native Object staticFieldBase(Field var1);
  // 判断是否需要初始化一个类，通常在获取一个类的静态属性的时候（因为一个类如果没初始化，它的静态属性也不会初始化）使用。 当且仅当ensureClassInitialized方法不生效时返回false。
  public native boolean shouldBeInitialized(Class<?> var1);
  // 检测给定的类是否已经初始化。通常在获取一个类的静态属性的时候（因为一个类如果没初始化，它的静态属性也不会初始化）使用。
  public native void ensureClassInitialized(Class<?> var1);
// 返回数组中第一个元素的偏移地址
  public native int arrayBaseOffset(Class<?> var1);
  //返回数组中一个元素占用的大小
  public native int arrayIndexScale(Class<?> var1);

  /**
   * 系统相关
   * @return
   */

  // 返回系统指针的大小。返回值为4（32位系统）或 8（64位系统）。
  public native int addressSize();
  //内存页的大小，此值为2的幂次方。
  public native int pageSize();



  // 定义一个类，此方法会跳过JVM的所有安全检查，默认情况下，ClassLoader（类加载器）和ProtectionDomain（保护域）实例来源于调用者
  public native Class<?> defineClass(String var1, byte[] var2, int var3, int var4, ClassLoader var5, ProtectionDomain var6);
  // 定义一个匿名类
  public native Class<?> defineAnonymousClass(Class<?> var1, byte[] var2, Object[] var3);
  // 绕过构造方法、初始化代码来创建对象
//  而Unsafe中提供allocateInstance方法，仅通过Class对象就可以创建此类的实例对象，而且不需要调用其构造函数、初始化代码、JVM安全检查等。它抑制修饰符检测，也就是即使构造器是private修饰的也能通过此方法实例化，只需提类对象即可创建相应的对象。
  public native Object allocateInstance(Class<?> var1) throws InstantiationException;

  //获得对象锁（可重入锁）
  /** @deprecated */
  @Deprecated
  public native void monitorEnter(Object var1);
  // 释放对象锁
  /** @deprecated */
  @Deprecated
  public native void monitorExit(Object var1);
  // 尝试获取对象锁
  /** @deprecated */
  @Deprecated
  public native boolean tryMonitorEnter(Object var1);

  public native void throwException(Throwable var1);

  /**
   * CAS 比较并替换， 底层为原子操作
   * @param var1  包含要修改field的对象
   * @param var2  对象中某field的偏移量
   * @param var4  期望值
   * @param var5  更新值
   * @return      true | false
   */
  public final native boolean compareAndSwapObject(Object var1, long var2, Object var4, Object var5);

  public final native boolean compareAndSwapInt(Object var1, long var2, int var4, int var5);

  public final native boolean compareAndSwapLong(Object var1, long var2, long var4, long var6);


  // 从对象的指定偏移量处获取变量的引用，使用volatile的加载语义
  public native Object getObjectVolatile(Object var1, long var2);
  // 存储变量的引用到对象的指定的偏移量处，使用volatile的存储语义
  public native void putObjectVolatile(Object var1, long var2, Object var4);

  public native int getIntVolatile(Object var1, long var2);

  public native void putIntVolatile(Object var1, long var2, int var4);

  public native boolean getBooleanVolatile(Object var1, long var2);

  public native void putBooleanVolatile(Object var1, long var2, boolean var4);

  public native byte getByteVolatile(Object var1, long var2);

  public native void putByteVolatile(Object var1, long var2, byte var4);

  public native short getShortVolatile(Object var1, long var2);

  public native void putShortVolatile(Object var1, long var2, short var4);

  public native char getCharVolatile(Object var1, long var2);

  public native void putCharVolatile(Object var1, long var2, char var4);

  public native long getLongVolatile(Object var1, long var2);

  public native void putLongVolatile(Object var1, long var2, long var4);

  public native float getFloatVolatile(Object var1, long var2);

  public native void putFloatVolatile(Object var1, long var2, float var4);

  public native double getDoubleVolatile(Object var1, long var2);

  public native void putDoubleVolatile(Object var1, long var2, double var4);
  // 有序、延迟版本的putObjectVolatile方法，不保证值的改变被其他线程立即看到。只有在field被volatile修饰符修饰时有效
  public native void putOrderedObject(Object var1, long var2, Object var4);

  public native void putOrderedInt(Object var1, long var2, int var4);

  public native void putOrderedLong(Object var1, long var2, long var4);

  /**
   * 线程调度
   */
  // 取消阻塞线程
  public native void unpark(Object var1);
  // 阻塞线程
  public native void park(boolean var1, long var2);

  public native int getLoadAverage(double[] var1, int var2);

  public final int getAndAddInt(Object var1, long var2, int var4) {
    int var5;
    do {
      var5 = this.getIntVolatile(var1, var2);
    } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));

    return var5;
  }

  public final long getAndAddLong(Object var1, long var2, long var4) {
    long var6;
    do {
      var6 = this.getLongVolatile(var1, var2);
    } while(!this.compareAndSwapLong(var1, var2, var6, var6 + var4));

    return var6;
  }

  public final int getAndSetInt(Object var1, long var2, int var4) {
    int var5;
    do {
      var5 = this.getIntVolatile(var1, var2);
    } while(!this.compareAndSwapInt(var1, var2, var5, var4));

    return var5;
  }

  public final long getAndSetLong(Object var1, long var2, long var4) {
    long var6;
    do {
      var6 = this.getLongVolatile(var1, var2);
    } while(!this.compareAndSwapLong(var1, var2, var6, var4));

    return var6;
  }

  public final Object getAndSetObject(Object var1, long var2, Object var4) {
    Object var5;
    do {
      var5 = this.getObjectVolatile(var1, var2);
    } while(!this.compareAndSwapObject(var1, var2, var5, var4));

    return var5;
  }

  /**
   * 内存屏障
   * 在Java 8中引入，用于定义内存屏障（也称内存栅栏，内存栅障，屏障指令等，是一类同步屏障指令，是CPU或编译器在对内存随机访问的操作中的一个同步点，
   * 使得此点之前的所有读写操作都执行后才可以开始执行此点之后的操作），避免代码重排序。
   */
  // 内存屏障，禁止load操作重排序。屏障前的load操作不能被重排序到屏障后，屏障后的load操作不能被重排序到屏障前
  public native void loadFence();
  // 内存屏障，禁止store操作重排序。屏障前的store操作不能被重排序到屏障后，屏障后的store操作不能被重排序到屏障前
  public native void storeFence();
  // 内存屏障，禁止load、store操作重排序
  public native void fullFence();

  private static void throwIllegalAccessError() {
    throw new IllegalAccessError();
  }

  static {
    registerNatives();
    Reflection.registerMethodsToFilter(Unsafe.class, new String[]{"getUnsafe"});
    theUnsafe = new Unsafe();
    ARRAY_BOOLEAN_BASE_OFFSET = theUnsafe.arrayBaseOffset(boolean[].class);
    ARRAY_BYTE_BASE_OFFSET = theUnsafe.arrayBaseOffset(byte[].class);
    ARRAY_SHORT_BASE_OFFSET = theUnsafe.arrayBaseOffset(short[].class);
    ARRAY_CHAR_BASE_OFFSET = theUnsafe.arrayBaseOffset(char[].class);
    ARRAY_INT_BASE_OFFSET = theUnsafe.arrayBaseOffset(int[].class);
    ARRAY_LONG_BASE_OFFSET = theUnsafe.arrayBaseOffset(long[].class);
    ARRAY_FLOAT_BASE_OFFSET = theUnsafe.arrayBaseOffset(float[].class);
    ARRAY_DOUBLE_BASE_OFFSET = theUnsafe.arrayBaseOffset(double[].class);
    ARRAY_OBJECT_BASE_OFFSET = theUnsafe.arrayBaseOffset(Object[].class);
    ARRAY_BOOLEAN_INDEX_SCALE = theUnsafe.arrayIndexScale(boolean[].class);
    ARRAY_BYTE_INDEX_SCALE = theUnsafe.arrayIndexScale(byte[].class);
    ARRAY_SHORT_INDEX_SCALE = theUnsafe.arrayIndexScale(short[].class);
    ARRAY_CHAR_INDEX_SCALE = theUnsafe.arrayIndexScale(char[].class);
    ARRAY_INT_INDEX_SCALE = theUnsafe.arrayIndexScale(int[].class);
    ARRAY_LONG_INDEX_SCALE = theUnsafe.arrayIndexScale(long[].class);
    ARRAY_FLOAT_INDEX_SCALE = theUnsafe.arrayIndexScale(float[].class);
    ARRAY_DOUBLE_INDEX_SCALE = theUnsafe.arrayIndexScale(double[].class);
    ARRAY_OBJECT_INDEX_SCALE = theUnsafe.arrayIndexScale(Object[].class);
    ADDRESS_SIZE = theUnsafe.addressSize();
  }
}
