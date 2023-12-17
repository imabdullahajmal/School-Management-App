import javax.swing.*;

public class Validation {
    public boolean safety(String username, String password){
        boolean valid = true;
        int len = username.length();
        char space = 32;
        String charSet = "";
        charSet+=space;

        if(username.contains("'") || username.contains("*") || username.contains("\\") || username.contains("-") ||
                password.contains("'") || password.contains("*") || password.contains("\\") || password.contains("-") || password.contains(charSet)) {
            valid = false;
        }
        return valid;
    }
    public boolean validated( String email,String sPhone,
                             String address)
    {
        String message = "Alert";
        boolean valid = true;
        if(address.length()<5 || address.length()>50){
            message+="\n\t- Length of address should be >5 & <50.";
            valid = false;
        }
        if(!(sPhone.matches("\\d+"))){
            message+="\n\t- Phone must have numbers only";
            valid = false;
        }
        if(!email.contains("@") || email.length()<4){
            message+="\n\t- Email must have '@' and must be at least 4 characters long.";
            valid = false;
        }

        if(!valid){
            JOptionPane.showMessageDialog(null, message);
        }
        return valid;
    }
    public boolean validated(String sName,String fName, String email,String sPhone,String cnic,
                             String address)
    {
        String message = "Alert";
        boolean valid = true;
        if(sName.matches("\\d+") || fName.matches("\\d+") ||
                sName.length()<3 || sName.length()>20 || fName.length()<3 ||
                fName.length()>20 || sName.contains("'") || fName.contains("'"))
        {
            message+="\n\t- Length of Names should be >3 & <20 and must contain Alphabets only.";
            valid = false;
        }
        if(cnic.length()!=13 || !(cnic.matches("\\d+"))){
            message+="\n\t- Length of CNIC should be 13 and must contain Numbers only.";
            valid = false;
        }
        if(address.length()<5 || address.length()>50){
            message+="\n\t- Length of address should be >5 & <50.";
            valid = false;
        }
        if(!(sPhone.matches("\\d+"))){
            message+="\n\t- Phone must have numbers only";
            valid = false;
        }
        if(!email.contains("@") || email.length()<4){
            message+="\n\t- Email must have '@' and must be at least 4 characters long.";
            valid = false;
        }

        if(!valid){
            JOptionPane.showMessageDialog(null, message);
        }
        return valid;
    }
}
