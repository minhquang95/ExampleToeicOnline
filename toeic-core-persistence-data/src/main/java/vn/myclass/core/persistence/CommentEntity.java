package vn.myclass.core.persistence;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Admin on 5/7/2017.
 */
@Entity
@Table(name = "commententity")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @Column(name = "content")
    private String content;

    @Column(name = "createddate")
    private Timestamp createdDate;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "listenguidelineid")
    private ListenGuideLineEntity listenGuideLineEntity;

    public ListenGuideLineEntity getListenGuideLineEntity() {
        return listenGuideLineEntity;
    }

    public void setListenGuideLineEntity(ListenGuideLineEntity listenGuideLineEntity) {
        this.listenGuideLineEntity = listenGuideLineEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}
