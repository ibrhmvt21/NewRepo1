package com.cybertek.tests;

public class ExceptionsDemo {

    public static void main(String[] args) {
        //the logic of exception
        //if i teach on tuesday -->normal flow
        //if i get sick,      --->problem ,issue
        //some will replace me ---->alternative flow

        try{
            System.out.println("Maruf is teaching on Tuesdays");
        }catch(Exception e){
            System.out.println("Akbar takes over the class");
        }

    }
}