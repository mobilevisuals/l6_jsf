import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
@FacesValidator("passValidate")
public class PassValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        String pass=(String)value;
        char[] chars=pass.toCharArray();
        boolean text=false;
        boolean numbers=false;

        for(char c:chars)
        {
            if(Character.isLetter(c))
                text=true;
            if(Character.isDigit(c))
                numbers=true;
        }

        if((!text)||(!numbers))
        {
            String messageText = "Both digits and chars needed!";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    messageText, messageText));
        }


    }

}



