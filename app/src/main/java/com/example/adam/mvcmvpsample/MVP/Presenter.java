package com.example.adam.mvcmvpsample.MVP;

public class Presenter {
    ModelPerson mModelPerson;
    Interface mInterface;
    public Presenter(final Interface mInterface) {
        mModelPerson = ModelPerson.getInstance();
        this.mInterface = mInterface;
    }
    public void doSomething(String firstName, String secondName){
        //業務邏輯P負責。M與V不直接互通
        mModelPerson.setFirstName(firstName);
        mModelPerson.setSecondName(secondName);
        mInterface.showText(mModelPerson.getPrintMessage());
    }
}
