package com.cybertek.work;

import com.cybertek.work.Singleton;

public class singletonExample {

    public static void main(String[] args) {
        String one = Singleton.get();
        System.out.println("one " + one);

        String too = Singleton.get();
        System.out.println("too " + too);
    }
}
