import javax.swing.*;

public class EmailException extends RuntimeException{
    public EmailException(String message){
        JOptionPane.showMessageDialog(null,message, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}
