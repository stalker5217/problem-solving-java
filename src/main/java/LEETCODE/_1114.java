package LEETCODE;

import java.util.concurrent.CountDownLatch;

public class _1114 {
    private static class Foo {
        private final CountDownLatch countDownLatch12;
        private final CountDownLatch countDownLatch23;

        public Foo() {
            countDownLatch12 = new CountDownLatch(1);
            countDownLatch23 = new CountDownLatch(1);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            countDownLatch12.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            countDownLatch12.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            countDownLatch23.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            countDownLatch23.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
