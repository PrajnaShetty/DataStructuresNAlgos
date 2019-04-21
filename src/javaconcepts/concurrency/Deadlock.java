package javaconcepts.concurrency;

/**
 * Created by prajnashetty on 4/14/19.
 */
public class Deadlock {

    public static void main(String[] args) {

        Deadlock deadlock = new Deadlock();

        A a = deadlock.new A();
        B b = deadlock.new B();

        Thread thread1 = new Thread(() -> {
           synchronized (b) {
               try {
                   // Adding delay so that both threads can start trying to
                   // lock resources
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

               synchronized (a) {
                   System.out.println("In block 1");
               }
           }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (b) {

                synchronized (a) {
                    System.out.println("In block 2");
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    private class A {

        int i;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }

    private class B {

        int i;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }


    }
}



