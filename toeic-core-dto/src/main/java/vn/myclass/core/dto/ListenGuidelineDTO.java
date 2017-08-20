package vn.myclass.core.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class ListenGuidelineDTO implements Serializable {

    private Integer listenGuideLineId;

    private String title;

    private String image;

    private String content;

    private Timestamp modifiedDate;

    private Timestamp creattedDate;

    public Integer getListenGuideLineId() {
        return listenGuideLineId;
    }

    public void setListenGuideLineId(Integer listenGuideLineId) {
        this.listenGuideLineId = listenGuideLineId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Timestamp getCreattedDate() {
        return creattedDate;
    }

    public void setCreattedDate(Timestamp creattedDate) {
        this.creattedDate = creattedDate;
    }
}