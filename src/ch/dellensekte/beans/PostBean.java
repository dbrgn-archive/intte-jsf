package ch.dellensekte.beans;

import ch.dellensekte.domain.Post;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PostBean {

    private Post post;

    public Post getPost() {
        return post;
    }

    public String setPost(Post post) {
        this.post = post;
        return "post_detail?faces-redirect=true";
    }
}
