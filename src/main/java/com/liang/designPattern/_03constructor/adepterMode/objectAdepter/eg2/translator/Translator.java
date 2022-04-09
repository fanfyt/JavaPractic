package com.liang.designPattern._03constructor.adepterMode.objectAdepter.eg2.translator;

import com.liang.designPattern._03constructor.adepterMode.objectAdepter.eg2.ForeignCenter;
import com.liang.designPattern._03constructor.adepterMode.objectAdepter.eg2.Player;

public class Translator extends Player {

    private ForeignCenter wjzf = new ForeignCenter();

    public Translator(String name) {
        super(name);
    }

    @Override
    public void attack() {
        wjzf.jingong();
    }

    @Override
    public void defense() {
        wjzf.fangshou();
    }
}
