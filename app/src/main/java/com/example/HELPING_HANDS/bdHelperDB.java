package com.example.HELPING_HANDS;

public class bdHelperDB {



    String name;
    String bDay;
    String Wigth;
    String Adress;
    String ladtDonatedate;
    String pone;

    public bdHelperDB(String name, String bDay, String wigth, String gender, String adress, String ladtDonatedate, String pone) {
        this.name = name;
        this.bDay = bDay;
        this.Wigth = wigth;
        this.Adress = adress;
        this.ladtDonatedate = ladtDonatedate;
        this.pone = pone;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getbDay() {
        return bDay;
    }

    public void setbDay(String bDay) {
        this.bDay = bDay;
    }

    public String getWigth() {
        return Wigth;
    }

    public void setWigth(String wigth) {
        Wigth = wigth;
    }


    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getLadtDonatedate() {
        return ladtDonatedate;
    }

    public void setLadtDonatedate(String ladtDonatedate) {
        this.ladtDonatedate = ladtDonatedate;
    }

    public String getPone() {
        return pone;
    }

    public void setPone(String pone) {
        this.pone = pone;
    }



    public bdHelperDB() {

    }


}
