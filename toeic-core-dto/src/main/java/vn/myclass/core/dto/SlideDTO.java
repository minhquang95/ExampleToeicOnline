package vn.myclass.core.dto;

public class SlideDTO {

    private String slidename;

    private String slidecontent;

    private String slideimage;

    private int slideid;

    public int getSlideid() {
        return slideid;
    }

    public void setSlideid(int slideid) {
        this.slideid = slideid;
    }

    public String getSlidename() {
        return slidename;
    }

    public void setSlidename(String slidename) {
        this.slidename = slidename;
    }

    public String getSlidecontent() {
        return slidecontent;
    }

    public void setSlidecontent(String slidecontent) {
        this.slidecontent = slidecontent;
    }

    public String getSlideimage() {
        return slideimage;
    }

    public void setSlideimage(String slideimage) {
        this.slideimage = slideimage;
    }
}
