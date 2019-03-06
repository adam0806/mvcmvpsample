package com.example.adam.mvcmvpsample.MVP;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.adam.mvcmvpsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Chih-Yuan, Hsi on 2019/3/1
 * 概念: 操作畫面在V, 業務邏輯給P去做, 最後反應在V上, V與M必須透過P
 * Description
 * Model 提供數據
 * View是activity(UI邏輯)及.xml layout  *與MVC不同, activity此時作為V
 * Presenter (業務邏輯)
 */
public class ViewActivity extends Activity implements Interface {
    Presenter mPresenter;
    @BindView(R.id.edittext1)
    EditText mEditText1;
    @BindView(R.id.edittext2)
    EditText mEditText2;
    @BindView(R.id.textview)
    TextView mTextView;
    @OnClick(R.id.button) void submit(){
        //UI操控邏輯是V在控制
        mPresenter.doSomething(mEditText1.getText().toString(),
                mEditText2.getText().toString());
        System.out.println("test, inside submit");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_edit);
        ButterKnife.bind(this);
        mPresenter = new Presenter(this);
    }

    @Override
    public void showText(String message) {
        //M與V必須透過P, 無法直接溝通
        mTextView.setText(message);
        System.out.println("test, inside showText "+message);
    }
}
