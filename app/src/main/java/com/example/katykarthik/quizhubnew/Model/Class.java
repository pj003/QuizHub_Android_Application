package com.example.katykarthik.quizhubnew.Model;


public class Class {
    private String Name;
    private String Image;

    public Class() {
    }

    public Class(String name, String image) {
        Name = name;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
