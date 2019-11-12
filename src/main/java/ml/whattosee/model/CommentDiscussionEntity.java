package ml.whattosee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "comment_discussion")
public class CommentDiscussionEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "description")
    private String description;
    @Column(nullable = false, name = "creation")
    private Date creation;
    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private UserEntity userEntity;
    @ManyToOne
    @JoinColumn(nullable = false, name = "discussion_id")
    private DiscussionEntity discussionEntity;

    public CommentDiscussionEntity() {
    }

    public CommentDiscussionEntity(Long id, String description, Date creation, UserEntity userEntity, DiscussionEntity discussionEntity) {
        this.id = id;
        this.description = description;
        this.creation = creation;
        this.userEntity = userEntity;
        this.discussionEntity = discussionEntity;
    }
    
    public CommentDiscussionEntity(Long id, String description, Date creation, UserEntity userEntity) {
        this.id = id;
        this.description = description;
        this.creation = creation;
        this.userEntity = userEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public DiscussionEntity getDiscussionEntity() {
        return discussionEntity;
    }

    public void setDiscussionEntity(DiscussionEntity discussionEntity) {
        this.discussionEntity = discussionEntity;
    }
}
