package ch.dellensekte.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ch.dellensekte.util.BeanHelper;

@ManagedBean
@ViewScoped
public class RegisterBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String referer;

	public RegisterBean() {
		super();
		this.setReferer(FacesContext.getCurrentInstance().getExternalContext().getRequestHeaderMap().get("referer"));
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String doRegister() {
		if (this.username == null || this.password == null) {
			return "register.xhtml";
		}
		if (BeanHelper.getDBBean().userExists(username)) {
			return "register.xhtml";
		}
		BeanHelper.getDBBean().db.registerNewUser(username, password);
		return this.getReferer();
	}

	public String getReferer() {
		return referer.substring(referer.lastIndexOf("/"), referer.length());
	}

	public void setReferer(String referer) {
		if (this.referer == null) {
			this.referer = "/index.xhtml";
		} else {
			this.referer = referer;
		}
	}

}
