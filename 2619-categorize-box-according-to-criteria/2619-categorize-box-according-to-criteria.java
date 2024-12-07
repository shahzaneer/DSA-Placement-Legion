class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
    double volume = (double) length * width * height;
    boolean isBulky = false;
    boolean isHeavy = false;

    if(volume >= Math.pow(10,9) || ( length >= Math.pow(10,4) || width >= Math.pow(10,4) || height >= Math.pow(10,4) || mass >= Math.pow(10,4))) isBulky = true;

    if(mass >= 100) isHeavy = true;

    String category = "";

    if(isBulky && isHeavy) category = "Both";
    else if(isBulky) category = "Bulky";
    else if(isHeavy) category = "Heavy";
    else category = "Neither";

    return category;

    }
}