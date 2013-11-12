package ch.dellensekte.beans;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;

import ch.dellensekte.domain.Post;
import ch.dellensekte.util.BeanHelper;

@ManagedBean
@ViewScoped
public class PostsBean {

    private List<Post> posts;

    @ManagedProperty(name="dBBean", value = "#{dBBean}")
    private DBBean dBBean;

    // needed for bean injection
    public void setdBBean(DBBean dBBean) {
        this.dBBean = dBBean;
    }

    @PostConstruct
    public void init() {
        this.posts = dBBean.getPosts();
        Collections.sort(this.posts);
    }

	public List<Post> getPosts() {
        return this.posts;
	}

}
