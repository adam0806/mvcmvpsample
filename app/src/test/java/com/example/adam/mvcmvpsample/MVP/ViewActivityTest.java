package com.example.adam.mvcmvpsample.MVP;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;


@RunWith(RobolectricTestRunner.class)
public class ViewActivityTest {
    Presenter mPresenter;

    @Before
    public void setUp() {
        System.out.println("test, setup");
    }

    @After
    public void tearDown() {
        System.out.println("test, tearDown");
    }
    //只需要測試presenter, 因為業務邏輯都在這, 基本測完大致OK
    @Test
    public void testPresenter(){
        mPresenter = new Presenter(new Interface() {
            @Override
            public void showText(String message) {
                assertEquals("HI Adam Hsu", message);
            }
        });
        assertNotNull(mPresenter);
        mPresenter.doSomething("Adam", "Hsu");
    }
}