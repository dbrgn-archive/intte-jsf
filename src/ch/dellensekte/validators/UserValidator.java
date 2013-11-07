package ch.dellensekte.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import ch.dellensekte.util.BeanHelper;
import ch.dellensekte.util.I18n;

@FacesValidator("ch.dellensekte.validators.UserValidator")
public class UserValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		FacesMessage msg;
		if (arg2 == null) {
			msg = new FacesMessage(I18n.getString("username.empty"));
			throw new ValidatorException(msg);
		}
		
		boolean userExists = BeanHelper.getDBBean().userExists(arg2.toString());
		if (userExists) {
			msg = new FacesMessage(I18n.getString("username.alreadyExists"));
			throw new ValidatorException(msg);
		}
		if (!arg2.toString().matches("([a-z]|[A-Z]){6,20}")) {
			msg = new FacesMessage(I18n.getString("username.constraintsNotMatched"));
			throw new ValidatorException(msg);
		}

	}
}
