package com.theja.book.chap9.java;

import java.util.ArrayList;


public class TestLifeSupportSim {

    public static void main(String args[]){

            ArrayList aList = new ArrayList();
            V2Radiator V2 = new V2Radiator(aList);
            V3Radiator V3 = new V3Radiator(aList);
            for (int z=0;z<20; z++){
                RetentionBot ret = new RetentionBot(aList);
            }
        }
    }

