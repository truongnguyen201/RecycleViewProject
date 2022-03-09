package topica.edu.vn.recycleviewproject;

public class ExampleItem {
    private int imageResuurce;
    private String mText1;
    private String mText2;


    public ExampleItem(int imageResuurce, String mText1, String mText2) {
        this.imageResuurce = imageResuurce;
        this.mText1 = mText1;
        this.mText2 = mText2;
    }

    public ExampleItem() {
    }

    public int getImageResuurce() {
        return imageResuurce;
    }

    public void setImageResuurce(int imageResuurce) {
        this.imageResuurce = imageResuurce;
    }

    public String getmText1() {
        return mText1;
    }

    public void setmText1(String mText1) {
        this.mText1 = mText1;
    }

    public String getmText2() {
        return mText2;
    }

    public void setmText2(String mText2) {
        this.mText2 = mText2;
    }
    public void changeText1(String text)
    {
        mText1=text;
    }
}
