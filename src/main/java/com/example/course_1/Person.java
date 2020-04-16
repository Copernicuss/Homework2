package com.example.course_1;

import java.util.ArrayList;

public class Person {
    private String personName;
    private String personPassword;
    private int imageID;

    public Person(){
    }

    public Person(String personName, String personPassword, int imageID) {
        this.personName = personName;
        this.personPassword = personPassword;
        this.imageID = imageID;
    }

    public int getImageID() {
        return imageID;
    }
    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getPersonName() {
        return personName;
    }
    public void setPersonName(String personName) {
        this.personName = personName;
    }
    public String getPassword() {
        return personPassword;
    }
    public void setPassword(String personPassword) {
        this.personPassword = personPassword;
    }

    public static ArrayList<Person> getData(){
        ArrayList<Person> personList = new ArrayList<Person>();
        int Images[] = {R.drawable.housearryn,R.drawable.housebaratheon,R.drawable.houselannister,R.drawable.housestark,R.drawable.housetargaryen,R.drawable.housetyrell};
        String[] personNames = {"emre","selim","duygu","fatma","korkut","toprak"};
        String[] personpasswords = {"emre123","selim123","duygu123","fatma123","korkut123","toprak123"};
        for (int i = 0; i < personNames.length; i++) {
            Person temp = new Person();
            temp.setImageID(Images[i]);
            //temp.setImageID(Images[0]);
            temp.setPersonName(personNames[i]);
            temp.setPassword(personpasswords[i]);

            personList.add(temp);

        }
        return personList;
    }
}

