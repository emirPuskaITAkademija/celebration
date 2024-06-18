package ba.smoki.celebration.servlet.user.login;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationModel {

    private String username;
    private String plainPassword;

    public char[] getPlainPasswordAsCharArray(){
        return plainPassword.toCharArray();
    }
}
