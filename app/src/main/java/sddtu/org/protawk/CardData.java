package sddtu.org.protawk;

/**
 * Created by ASHISH KUMAR  on 3/15/2017.
 */

public class CardData {
    String t1;

    public Integer getImgRes() {
        return imgRes;
    }

    public void setImgRes(Integer imgRes) {
        this.imgRes = imgRes;
    }

    Integer imgRes;
    CardData(String text1,Integer imgRess){
        imgRes = imgRess;
        t1=text1;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }
}

