package com.theja.book.chap18.java;

public class SimpleGen<U,V> {
    private U objUreff;
    private V objVreff;

    public SimpleGen(U objU, V objV){
        this.objUreff = objU;
        this.objVreff = objV;
    }

    public void printTypes(){
        System.out.println("U Type: "+this.objUreff.getClass().getName());
        System.out.println("V Type: "+this.objVreff.getClass().getName());
    }
}

 class MySimpleTwoGenerics {

    public static void main(String a[]){

        SimpleGen<String, Integer> sample
                = new SimpleGen<String, Integer>("JAVA2NOVICE", 100);
        sample.printTypes();
    }
}

