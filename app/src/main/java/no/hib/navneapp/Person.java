package no.hib.navneapp;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bromle on 23.01.2015.
 */
public class Person {
    private String navn;
    private Drawable bilde;

    public Person() {
    }

    public Person(String navn, Drawable bilde) {
        this.navn = navn;
        this.bilde = bilde;
    }


    public String getNavn() {
        return navn;
    }

    public Drawable getBilde() {
        return bilde;
    }

    public boolean equals (String navn) {
        if (this.navn == navn) {
            return true;
        }
        else return false;
    }


}
