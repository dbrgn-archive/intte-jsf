package ch.dellensekte.validators;

import ch.dellensekte.util.I18n;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.net.MalformedURLException;
import java.net.URL;


@FacesValidator("ch.dellensekte.validators.URLValidator")
public class URLValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        FacesMessage msg;
        if (o == null) {
            msg = new FacesMessage(I18n.getString("url.empty"));
            throw new ValidatorException(msg);
        }

        try {
            final String url = (String) o;
            new URL(url);

        } catch (MalformedURLException malformedURLException) {
            msg = new FacesMessage(I18n.getString("url.constraintsNotMatched"));
            throw new ValidatorException(msg);
        }
    }
}
