package com.example.adam.mvcmvpsample.MVC;

public class ModelPerson {
    private static ModelPerson instance;
    String mFirstName;
    String mSecondName;
    private ModelPerson(){
    }
    public static ModelPerson getInstance(){
        if(instance == null){
            synchronized(ModelPerson.class){
                if(instance == null){
                    instance = new ModelPerson();
                }
            }
        }
        return instance;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public void setSecondName(String mSecondName) {
        this.mSecondName = mSecondName;
    }

    public void doSomething(Interface mInterface){
        //業務邏輯M負責。透過C去溝通V
        mInterface.showText(getPrintMessage());
    }
    public String getPrintMessage(){
        return "HI "+mFirstName+" "+mSecondName;
    }
}
