package br.com.getNet.core;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.RunListener;

public class AllureJunit extends RunListener {

    public static void main(String[] args) {
        JUnitCore runner = new JUnitCore();
        runner.addListener(new AllureJunit());
    }
}
