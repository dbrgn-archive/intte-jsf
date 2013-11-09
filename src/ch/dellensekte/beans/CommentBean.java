package ch.dellensekte.beans;

import ch.dellensekte.domain.Comment;
import ch.dellensekte.domain.User;
import ch.dellensekte.util.BeanHelper;


// managed bean, configured in faces-config.xml
// annotations don't work on this bean, don't know why
public class CommentBean {

    private Comment comment;
    private String commentText;
    private boolean visible = false;

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
        this.createComment();
        c.addComment(this.comment);
        this.commentText = null;
    }

    private void createComment() {
        UserBean ub = BeanHelper.getUserBean();
        User u = ub.getUser();
        this.comment = new Comment(this.commentText, 0, 0, u);
    }

    public void makeReplyVisible() {
        this.visible = true;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
