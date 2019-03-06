package com.example.adam.mvcmvpsample.MVC;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.adam.mvcmvpsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Chih-Yuan, Hsi on 2019/3/1
 * 概念: 操作畫面在C, 業務邏輯給M去做, 最後反應在V上
 * Description
 * Model是介面,資料(業務邏輯)
 * View是.xml layout
 * Controller是Activity(UI邏輯)
 */
public class ControllerActivity extends Activity implements Interface {
    ModelPerson mModelPerson;
    @BindView(R.id.edittext1)
    EditText mEditText1;
    @BindView(R.id.edittext2)
    EditText mEditText2;
    @BindView(R.id.textview)
    TextView mTextView;
    @OnClick(R.id.button) void submit(){
        //UI操控邏輯是C在控制
        mModelPerson.setFirstName(mEditText1.getText().toString());
        mModelPerson.setSecondName(mEditText2.getText().toString());
        mModelPerson.doSomething(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_edit);
        ButterKnife.bind(this);
        mModelPerson = ModelPerson.getInstance();
    }

    @Override
    public void showText(String message) {
        //M與V溝通透過C
        mTextView.setText(message);
    }
}
