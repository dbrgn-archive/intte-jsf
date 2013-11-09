package ch.dellensekte.beans;

import ch.dellensekte.domain.Comment;
import ch.dellensekte.domain.User;
import ch.dellensekte.util.BeanHelper;


// managed bean, configured in faces-config.xml
// annotations don't work on this bean, don't know why
public class CommentBean {

    private Comment comment;
    private String commentText;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public void addComment(PostBean pb) {
        this.createComment();
        pb.getPost().addComment(this.comment);
        this.commentText = null;
    }

    public void addComment(Comment c) {
        System.out.println("commentTheComment");
        this.createComment();
        c.addComment(this.comment);
        this.commentText = null;
    }

    private void createComment() {
        DBBean db = BeanHelper.getDBBean();
        User u = db.getUser("chrigi");
        this.comment = new Comment(this.commentText, 0, 0, u);
    }
}
