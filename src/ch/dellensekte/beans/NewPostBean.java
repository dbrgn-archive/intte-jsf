package ch.dellensekte.beans;

import ch.dellensekte.domain.Post;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class NewPostBean {

    @ManagedProperty(name = "userBean", value = "#{userBean}")
    private UserBean userBean;

    @ManagedProperty(name="dBBean", value = "#{dBBean}")
    private DBBean dBBean;

    @ManagedProperty(name="postBean", value = "#{postBean}")
    private PostBean postBean;

    private String title;
    private String url;

    // needed for bean injection
    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    // needed for bean injection
    public void setdBBean(DBBean dBBean) {
        this.dBBean = dBBean;
    }

    // needed for bean injection
    public void setPostBean(PostBean postBean) {
        this.postBean = postBean;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String submit() {
        Post post = new Post(this.url, this.title, 0, 0, this.userBean.user);
        dBBean.addPost(post);
        postBean.setPost(post);
        System.out.println("New post added: "+ post);
        return "post_detail?faces-redirect=true";
    }
}
