package ch.dellensekte.util;

import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class I18n {
	public static String getString(String value) {
		FacesContext cx = FacesContext.getCurrentInstance();
		ResourceBundle rb = ResourceBundle.getBundle("ch.dellensekte.i18n.strings", cx.getViewRoot().getLocale());
		return rb.getString(value);
	}

}
