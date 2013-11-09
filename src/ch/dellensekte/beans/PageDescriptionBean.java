package ch.dellensekte.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class PageDescriptionBean {

    public static final String DESC = "Desc";
    private static final String TITLE = "Title";

    public String getTitleKey() {
        final FacesContext facesContext = FacesContext.getCurrentInstance();
        final String viewId = facesContext.getViewRoot().getViewId();
        return viewId + TITLE;
    }

    public String getDescKey() {
        final FacesContext facesContext = FacesContext.getCurrentInstance();
        final String viewId = facesContext.getViewRoot().getViewId();
        return viewId + DESC;
    }
}
