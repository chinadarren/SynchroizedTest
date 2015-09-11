/**
 * Created by cl on 2015/9/11.
 */
/**
 * Created by cl on 2015/9/11.
 */

//尽管线程t1与t2访问了同一个Inner对象中两个毫不相关的部分,但因为t1先获得了对Inner的对象锁，
// 所以t2对Inner.m4t2()的访问也被阻塞，因为m4t2()是Inner中的一个同步方法。
public class Thread6 {

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

        private synchronized void m4t2() {
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
        final Thread6 myt3 = new Thread6();
        final Inner inner = myt3.new Inner();
        Thread t1 = new Thread(new Runnable() {@Override public void run() {myt3.m4t1(inner);}});
        Thread t2 = new Thread(new Runnable() {@Override public void run() {myt3.m4t2(inner);}});
        t1.start();
        t2.start();
    }
}
