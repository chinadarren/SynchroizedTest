/**
 * Created by cl on 2015/9/11.
 */
/**
 * Created by cl on 2015/9/11.
 */

//�����߳�t1��t2������ͬһ��Inner����������������صĲ���,����Ϊt1�Ȼ���˶�Inner�Ķ�������
// ����t2��Inner.m4t2()�ķ���Ҳ����������Ϊm4t2()��Inner�е�һ��ͬ��������
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
            //ʹ�ö�����
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
