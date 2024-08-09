package coding.array;

public class DeadLockImp {

    static class Shared {}
    static class ClassOne implements Runnable{
        Shared shared1;
        Shared shared2;
        ClassOne(Shared shared1,Shared shared2){
            this.shared1 = shared1;
            this.shared2 = shared2;
        }

        @Override
        public void run() {
            synchronized (shared1){
                System.out.println("Class One Outer");
                synchronized (shared2){
                    System.out.println("Class One Inner");
                }
            }
        }
    }
    static class ClassTwo implements Runnable{
        Shared shared1;
        Shared shared2;
        ClassTwo(Shared shared1,Shared shared2){
            this.shared1 = shared1;
            this.shared2 = shared2;
        }

        @Override
        public void run() {
            synchronized (shared2){
                System.out.println("Class Two Outer");
                synchronized (shared1){
                    System.out.println("Class Two Inner");
                }
            }
        }
    }

    public static void main(String[] args) {
        Shared one = new Shared();
        Shared two = new Shared();
        Thread t1 = new Thread(new ClassOne(one,two));
        Thread t2 = new Thread(new ClassTwo(one,two));
        t1.start();
        t2.start();
    }

}
