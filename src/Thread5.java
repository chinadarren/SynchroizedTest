/**
 * Created by cl on 2015/9/11.
 */

//尽管线程t1获得了对Inner的对象锁，但由于线程t2访问的是同一个Inner中的非同步部分。所以两个线程互不干扰。
public class Thread5 {

    class Inner {
        private void m4t1() {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + "Inner.m4t1()=" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }

        private void m4t2() {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + "Inner.m4t2()=" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException id) {
                }
            }
        }
    }

    private void m4t1(Inner inner) {
        synchronized (inner) {
            //使用对象锁
            inner.m4t1();
        }
    }

    private void m4t2(Inner inner) {
        inner.m4t2();

    }

    public static void main(String[] args) {
        final Thread5 myt3 = new Thread5();
        final Inner inner = myt3.new Inner();
        Thread t1 = new Thread(new Runnable() {@Override public void run() {myt3.m4t1(inner);}});
        Thread t2 = new Thread(new Runnable() {@Override public void run() {myt3.m4t2(inner);}});
        t1.start();
        t2.start();
    }
}
