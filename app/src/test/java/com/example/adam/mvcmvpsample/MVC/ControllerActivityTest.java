package com.example.adam.mvcmvpsample.MVC;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.adam.mvcmvpsample.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;


@RunWith(RobolectricTestRunner.class)
public class ControllerActivityTest {
    ControllerActivity mActivity;
    @Before
    public void setUp() {
        System.out.println("test, setup");
        mActivity = Robolectric.setupActivity(ControllerActivity.class);
        assertNotNull(mActivity);
    }

    @After
    public void tearDown() {
        System.out.println("test, tearDown");
    }

    @Test
    public void testPrintMessage(){
        assertNotNull(ModelPerson.getInstance());
        ModelPerson.getInstance().setFirstName("Adam");
        ModelPerson.getInstance().setSecondName("Hsu");

        assertEquals("HI Adam Hsu", ModelPerson.getInstance().getPrintMessage());
    }

    @Test
    public void clickButton(){
        Button button = mActivity.findViewById(R.id.button);
        assertNotNull("test button not found", button);

        ((EditText)mActivity.findViewById(R.id.edittext1)).setText("Adam");
        ((EditText)mActivity.findViewById(R.id.edittext2)).setText("Hsu");
        button.performClick();

        assertEquals("HI Adam Hsu", ((TextView)mActivity.findViewById(R.id.textview)).getText().toString());
    }
}