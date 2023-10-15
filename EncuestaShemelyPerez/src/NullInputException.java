import javax.swing.*;

public class NullInputException extends NullPointerException{
    public NullInputException(String message){
        JOptionPane.showMessageDialog(null,message, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

}
