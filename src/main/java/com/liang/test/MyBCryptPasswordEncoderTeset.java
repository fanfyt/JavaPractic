package com.liang.test;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class MyBCryptPasswordEncoderTeset {

    @Test
    public void bcrypt(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String psd = encoder.encode("Liang2202");
        System.out.println("pwd"+psd);
    }
}

