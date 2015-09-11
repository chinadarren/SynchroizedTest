/**
 * Created by cl on 2015/9/11.
 */
/**
 * Created by cl on 2015/9/11.
 */

//����ؼ����ǣ���һ���̷߳���object��һ��synchronized(this)ͬ�������ʱ��
// �����̶߳�object����������synchronized(this)ͬ�������ķ��ʽ���������
public class Thread3 {

    public void m4t1(){
        synchronized (this){
            int i = 5;
            while(i -- > 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
                try{
                    Thread.sleep(500);
                }catch (InterruptedException ie){
                }
            }
        }
    }
    public void m4t2(){
        synchronized (this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
    public static void main(String[] args){
        final Thread3 myt2 = new Thread3();
        Thread t1 = new Thread(new Runnable() {@Override public void run() {myt2.m4t1();}});
        Thread t2 = new Thread(new Runnable() {@Override public void run() {myt2.m4t2();}});
        t1.start();
        t2.start();
    }

}