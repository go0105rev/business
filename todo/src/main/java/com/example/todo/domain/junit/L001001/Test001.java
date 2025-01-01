package com.example.todo.domain.junit.L001001;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.todo.domain.junit.StandardInputStream;
import com.example.todo.domain.junit.StandardOutputStream;


public class Test001{

    private StandardInputStream in = new StandardInputStream();
    private StandardOutputStream out = new StandardOutputStream();

    @Before
    public void before() {
        System.setIn(in);
        System.setOut(out);
    }

    @After
    public void after() {
        System.setIn(null);
        System.setOut(null);
    }

    @Test
    public void test01() {
        in.inputln("1");
        in.inputln("2 3");
        in.inputln("hoge");
        Main.main(null);
        Assert.assertEquals("5 hoge",out.readLine());
    }

    @Test
    public void test02() {
        in.inputln("2");
        in.inputln("3 5");
        in.inputln("plus");
        Main.main(null);
        Assert.assertEquals("10 plus",out.readLine());
    }
}
