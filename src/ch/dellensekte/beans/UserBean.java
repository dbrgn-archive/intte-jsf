package ch.dellensekte.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ch.dellensekte.domain.User;
import ch.dellensekte.util.BeanHelper;

@ManagedBean(eager = true)
@SessionScoped
public class UserBean {
	public User user;
	public String username;
	public String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
		System.out.println("username set to " + username);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void doLogin() {
		this.user = BeanHelper.getDBBean().getUser(this.username);
	}

	public boolean isLoggedIn() {
		if (this.user == null)
			return false;
		if (this.password.equals(this.user.getPassword())) {
			return true;
		}
		return false;
	}

	public String doLogout() {
		this.user = null;
		this.username = null;
		this.password = null;
		return "template.xhtml";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
