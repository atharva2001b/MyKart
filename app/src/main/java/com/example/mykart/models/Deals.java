package com.example.mykart.models;

public class Deals {

    private String itemName;
    private String desc;
    private int itemId;
    private int img;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Deals(String itemName, String desc, int itemId, int img) {
        this.itemName = itemName;
        this.desc = desc;
        this.itemId = itemId;
        this.img = img;
    }

}
