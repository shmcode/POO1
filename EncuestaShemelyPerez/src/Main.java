import javax.swing.*;
import java.util.LinkedList;
import java.util.regex.*;

interface GeneralDeclarations{

        LinkedList<User> surveyList = new LinkedList<User>();
        User user = new User();
}

public class Main implements  GeneralDeclarations {
    public static void main(String[] args) throws AgeRangeException {
        boolean validate = false;

        JOptionPane.showMessageDialog(null, "Estimado usuario:\n" +
                        "\n" +
                        "Estamos llevando a cabo el desarrollo de un proyecto de excepciones personalizadas en Java. El objetivo de la presente encuesta es conocerte. \n" +
                        "\n" +
                        "» La información a brindar es confidencial y será usada para validar y defender este proyecto.\n",
                "ENCUESTA", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/cat-icon.png"));

        String firstName = JOptionPane.showInputDialog(null, " Primer Nombre: ", "ENCUESTA", JOptionPane.PLAIN_MESSAGE);
        validateNullInput(firstName);
        user.setFirstName(firstName);

        String lastName = JOptionPane.showInputDialog(null, " Primer Apellido: ", "ENCUESTA", JOptionPane.PLAIN_MESSAGE);
        validateNullInput(lastName);
        user.setLastName(lastName);

        String email = JOptionPane.showInputDialog(null, " Email: ", "ENCUESTA", JOptionPane.PLAIN_MESSAGE);
        validate = validateEmail(email);
        if (validate){
            user.setEmail(email);
        }

        int age = Integer.parseInt(JOptionPane.showInputDialog(null, " Edad: ", "ENCUESTA", JOptionPane.PLAIN_MESSAGE));
        validateAge(age);
        user.setAge(age);

        surveyList.add(user);
        /*for (User user: surveyList) {
            JOptionPane.showMessageDialog(null,user.toString(),"ENCUESTA", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/cat-icon.png"));
        }*/
        JOptionPane.showMessageDialog(null,user.toString(),"ENCUESTA", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/cat-icon.png"));

    }

    public static void validateAge( int age) throws AgeRangeException{
        if (age > 30 && age < 50  ){
        }else{
            throw new AgeRangeException("\"ERROR. El rango de edad es de 30 a 50 años.\"");
        }
    }

    public static void validateNullInput(String input){
        if (!input.isEmpty() && input != null ) {
        }else{
            if(input.length()>30){
                throw new NullInputException("ERROR. El límite es de 30 caracteres");
            }
            throw new NullInputException("ERROR. No hay información que añadir.");
        }
    }

    public static boolean validateEmail(String email){
        if (email == null || email.isEmpty()){
            throw new NullInputException("ERROR. No hay información que añadir");
        }else{
            String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" +
                    "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";

            Pattern pattern = Pattern.compile(emailPattern);

            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return true;

            }else {
                throw new EmailException("ERROR. Verifica si tu correo electrónico contiene @ y .(dominio)");
            }
        }
    }

}