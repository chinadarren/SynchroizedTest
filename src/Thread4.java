/**
 * Created by cl on 2015/9/11.
 */
/**
 * Created by cl on 2015/9/11.
 */

//��һ���̷߳���object��һ��synchronized(this)ͬ�������ʱ��
// ���ͻ�������object�Ķ�����������������̶߳Ը�object��������ͬ�����벿�ֵķ��ʶ�����ʱ������
public class Thread4 {

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
    public synchronized void m4t2(){
        int i = 5;
        while(i -- >0){
            System.out.println(Thread.currentThread().getName()+":"+i);
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
    public static void main(String[] args){
        final Thread4 myt2 = new Thread4();
        Thread t1 = new Thread(new Runnable() {@Override public void run() {myt2.m4t1();}});
        Thread t2 = new Thread(new Runnable() {@Override public void run() {myt2.m4t2();}});
        t1.start();
        t2.start();
    }

}