package ch.dellensekte.util;

import javax.faces.context.FacesContext;

import ch.dellensekte.beans.DBBean;

public class BeanHelper {

	public static Object getApplicationBean(String name) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getApplicationMap().get(name);
	}

	public static DBBean getDBBean(){
		return (DBBean) BeanHelper.getApplicationBean("dBBean");
	}
}
