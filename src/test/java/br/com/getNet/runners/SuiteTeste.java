package br.com.getNet.runners;


import br.com.getNet.tests.reqres.tests.PostCreateUserTest;
import junit.framework.JUnit4TestAdapter;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;

@RunWith(AllTests.class)
public class SuiteTeste {
    public static TestSuite suite(){
        TestSuite suite = new TestSuite();
        suite.addTest(new JUnit4TestAdapter(PostCreateUserTest.class));
        return suite;
    }
}
