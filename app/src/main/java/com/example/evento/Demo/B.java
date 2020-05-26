package com.example.evento.Demo;

public class B {

    private final MyA a = new MyA();

    private class MyA extends A {
        @Override
        public void run() {
            super.run();
        }
    }
}
