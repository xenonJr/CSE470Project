package com.example.pd.Model;

public class Doner {
    public String name,jela,bg,upojela,gender;
    public int number;
    public Doner(){

    }
    public Doner(String name, String jela, String bg, String upojela, String gender, int number) {
        this.name = name;
        this.jela = jela;
        this.bg = bg;
        this.upojela = upojela;
        this.gender = gender;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getJela() {
        return jela;
    }

    public String getBg() {
        return bg;
    }

    public int getNumber() {
        return number;
    }

    public String getUpojela() {
        return upojela;
    }

    public String getGender() {
        return gender;
    }


}