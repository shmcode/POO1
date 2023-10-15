import javax.swing.*;

public class AgeRangeException extends Exception {
//Unchecked Exception
public AgeRangeException(String message){
    JOptionPane.showMessageDialog(null,message, "ERROR", JOptionPane.ERROR_MESSAGE);
}
}
