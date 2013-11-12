package ch.dellensekte.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import ch.dellensekte.util.I18n;

@FacesValidator("ch.dellensekte.validators.PasswordValidator")
public class PasswordValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		Object pw2 = arg0.getExternalContext().getRequestParameterMap().get("form:password2");
		FacesMessage msg;
		if (arg2.equals("") && pw2.equals("")) {
			msg = new FacesMessage(I18n.getString("password.empty"));
			throw new ValidatorException(msg);
		}
		if (arg2.equals("") || pw2.equals("") || !arg2.toString().equals(pw2.toString())) {
			msg = new FacesMessage(I18n.getString("password.match"));
			throw new ValidatorException(msg);
		}

	}
}
