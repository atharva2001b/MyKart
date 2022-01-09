package com.example.mykart.models;

public class ChildProdEntity {

    int ID;
    String prodName;
    String price;
    String OfferPrice;
    String Img;
    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        this.Img = img;
    }



    public int getID() {
        return ID;
    }

    public void setID(int img) {
        this.ID = img;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOfferPrice() {
        return OfferPrice;
    }

    public void setOfferPrice(String offerPrice) {
        OfferPrice = offerPrice;
    }

    public ChildProdEntity(int id, String prodName, String price, String OfferPrice, String Img){
        this.ID = id;
        this.prodName = prodName;
        this.price = price;
        this.OfferPrice = OfferPrice;
        this.Img = Img;
    }
}
