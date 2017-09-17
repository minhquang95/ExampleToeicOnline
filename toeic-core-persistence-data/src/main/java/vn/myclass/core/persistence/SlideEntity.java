package vn.myclass.core.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "slidebannerentity")
public class SlideEntity {

    @Column(name = "slidename")
    private String slidename;

    @Column(name = "slidecontent")
    private String slidecontent;

    @Column(name = "slideimage")
    private String slideimage;

    @Id
    @Column(name = "slideid")
    private int slideid;

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

    public int getSlideid() {
        return slideid;
    }

    public void setSlideid(int slideid) {
        this.slideid = slideid;
    }
}
