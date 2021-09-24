package com.example.HELPING_HANDS;

public class RegisterModel {
    int mCount, fCount, tCount;
    String place, address, phone, type;

    RegisterModel(){

    }

    public RegisterModel(int mCount, int fCount, String place, String address, String phone, String type ) {
        this.mCount = mCount;
        this.fCount = fCount;
        this.place = place;
        this.address = address;
        this.phone = phone;
        this.type = type;

    }

    public int getmCount() {
        return mCount;
    }

    public void setmCount(int mCount) {
        this.mCount = mCount;
    }

    public int getfCount() {
        return fCount;
    }

    public void setfCount(int fCount) {
        this.fCount = fCount;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int gettCount(){
        tCount = mCount + fCount;
        return tCount;
    }
}
