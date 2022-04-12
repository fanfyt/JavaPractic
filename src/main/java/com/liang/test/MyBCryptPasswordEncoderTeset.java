package com.liang.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;


public class MyBCryptPasswordEncoderTeset {

    public void bcrypt(){
       try{   BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
           String psd = encoder.encode("Liang2202");
           System.out.println("pwd"+psd);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    ArrayList list = new ArrayList();
    LinkedList list2 = new LinkedList();

    Queue queue = new ArrayBlockingQueue(2);
    ConcurrentHashMap<String,String> s = new ConcurrentHashMap();

    public  static final  Integer a = 6;
    void testThread(){

        synchronized (a){

        }

    }


}

