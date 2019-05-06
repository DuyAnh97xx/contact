package com.example.contact.module;

public class contact {
    boolean isMale;

    public boolean isMale ( ) {
        return isMale;
    }

    public void setMale (boolean male) {
        isMale = male;
    }

    private String number;
    private String name;

    public contact (boolean isMale, String number, String name) {
        this.isMale = isMale;
        this.number = number;
        this.name = name;
    }


    public String getNumber ( ) {
        return number;
    }

    public void setNumber (String number) {
        this.number = number;
    }

    public String getName ( ) {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }
}


