package com.theja.book.java;

public class BooksTest {
    public static void main(String args[]){

        Books[] myBooks = new Books[100];
        myBooks[0]= new Books();
        myBooks[1]= new Books();
        myBooks[2]= new Books();
        myBooks[0].title = "c";
        myBooks[1].title = "java";
        myBooks[2].title = "php";
        myBooks[0].author = "dennis ritche";
        myBooks[1].author = "jan";
        myBooks[2].author ="sue";

        int x = 0;
        while (x<3){
            System.out.println(myBooks[x].title);
            System.out.println("by");
            System.out.println(myBooks[x].author);
            x=x+1;
        }
    }

}
