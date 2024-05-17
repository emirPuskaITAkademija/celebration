package ba.smoki.celebration.servlet.user.registration;

import ba.smoki.celebration.ejb.user.User;
import ba.smoki.celebration.ejb.user.UserServiceLocal;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegistrationController {

    private final UserServiceLocal userServiceLocal;
    private final RegistrationModel registrationModel;

    //EXPLAINED: not needed when we are using @AllArgsConstructor
//    public RegistrationController(UserServiceLocal userServiceLocal, RegistrationModel registrationModel) {
//        this.userServiceLocal = userServiceLocal;
//        this.registrationModel = registrationModel;
//    }

    public boolean usernameOccuppied(){
        User user = userServiceLocal.findByUsername(registrationModel.getUsername());
        return user != null;
    }

    public boolean validInput(RegistrationModel registrationModel){
        return !registrationModel.getName().isBlank()
                && !registrationModel.getSurname().isBlank()
                && !registrationModel.getUsername().isBlank();
    }
}
