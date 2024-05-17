package ba.smoki.celebration.servlet.user.registration;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationModel {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String contact;
    private String email;
    private String town;

    public Integer getTownId(){
        if(town.contains("[")){
            //Zenica[23]   [   )
            int start = town.indexOf("[")+1;
            int end = town.indexOf("]");
            String townIdString = town.substring(start, end);
            return Integer.parseInt(townIdString);
        }
        return Integer.parseInt(town);
    }

}
