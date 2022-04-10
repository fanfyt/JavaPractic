package com.liang.designPattern._01creator.builderMode.eg1;

public class SuitPo {
    private String Coat;
    private String plant;
    private String shoes;

    public SuitPo() {
    }


    public String getCoat() {
        return Coat;
    }

    public void setCoat(String coat) {
        Coat = coat;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getShoes() {
        return shoes;
    }

    public void setShoes(String shoes) {
        this.shoes = shoes;
    }

    @Override
    public String toString() {
        return "SuitPo{" +
                "Coat='" + Coat + '\'' +
                ", plant='" + plant + '\'' +
                ", shoes='" + shoes + '\'' +
                '}';
    }
}
