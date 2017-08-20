package vn.myclass.core.persistence;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Admin on 5/7/2017.
 */
@Entity
@Table(name = "listenguidelineentity")
public class ListenGuideLineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer listenGuideLineId;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @Column(name = "context")
    private String context;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @Column(name = "createddate")
    private Timestamp creattedDate;

    @OneToMany(mappedBy = "listenGuideLineEntity", fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntityList;

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

    public List<CommentEntity> getCommentEntityList() {
        return commentEntityList;
    }

    public void setCommentEntityList(List<CommentEntity> commentEntityList) {
        this.commentEntityList = commentEntityList;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}

