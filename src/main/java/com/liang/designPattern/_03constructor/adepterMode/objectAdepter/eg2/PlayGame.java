package com.liang.designPattern._03constructor.adepterMode.objectAdepter.eg2;

import com.liang.designPattern._03constructor.adepterMode.objectAdepter.eg2.translator.Translator;

public class PlayGame {
    public static void main(String[] args) {
        Player ym = new Translator("yaoming");
        Player md = new Forwards("md");

        ym.attack();

    }
}
