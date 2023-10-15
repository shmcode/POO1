import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface GeneralDeclarationsGUI{

    LinkedList<User> surveyList = new LinkedList<User>();
    User user = new User();
}

public class GUI implements ActionListener, GeneralDeclarationsGUI {
        boolean validate = false;
        private static JLabel title;
        private static JLabel firstNameLabel;
        private static JTextField firstNameText;
        private static JLabel lastNameLabel;
        private static JTextField lastNameText;
        private static JLabel emailLabel;
        private static JTextField emailText;
        private static JLabel ageLabel;
        private static JTextField ageText;
        private static JButton sendButton;
        private static JLabel success;

        public static void main(String[] args){

            JFrame frame = new JFrame();
            JPanel panel = new JPanel();

            frame.setSize(550,400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(panel);

            panel.setLayout(null);

            title = new JLabel("ENCUESTA JAVA");
            title.setBounds(210,30,150,30);
            panel.add(title);

            firstNameLabel = new JLabel("Primer Nombre: ");
            firstNameLabel.setBounds(115,90,150,25);
            panel.add(firstNameLabel);

            firstNameText = new JTextField();
            firstNameText.setBounds(250,90,175,25);
            panel.add(firstNameText);

            lastNameLabel = new JLabel("Primer Apellido: ");
            lastNameLabel.setBounds(115,140,150,25);
            panel.add(lastNameLabel);

            lastNameText = new JTextField();
            lastNameText.setBounds(250,140,175,25);
            panel.add(lastNameText);

            emailLabel = new JLabel("Email: ");
            emailLabel.setBounds(115,190,150,25);
            panel.add(emailLabel);

            emailText = new JTextField();
            emailText.setBounds(250,190,170,25);
            panel.add(emailText);

            ageLabel = new JLabel("Edad: ");
            ageLabel.setBounds(115,240,150,25);
            panel.add(ageLabel);

            ageText = new JTextField();
            ageText.setBounds(250,240,170,25);
            panel.add(ageText);

            sendButton = new JButton("Enviar");
            sendButton.setBounds(215,290,100,27);
            sendButton.addActionListener(new GUI());
            panel.add(sendButton);

            success = new JLabel();
            success.setBounds(215,350,100,27);
            panel.add(success);

            frame.setVisible(true);

        }

        @Override
        public void actionPerformed(ActionEvent e){
            String firstName = firstNameText.getText();
            String lastName = lastNameText.getText();
            String email = emailText.getText();
            int age = Integer.parseInt(ageText.getText());
            String ageT = ageText.getText();

            validateNullInput(firstName);
            user.setFirstName(firstName);

            validateNullInput(lastName);
            user.setLastName(lastName);

            validate = validateEmail(email);
            if (validate){
                user.setEmail(email);
            }

            try {
                validateAge(age);
            } catch (AgeRangeException ex) {
                throw new RuntimeException(ex);
            }
            user.setAge(age);

            surveyList.add(user);
            for (User user: surveyList) {
                JOptionPane.showMessageDialog(null,user.toString(),"ENCUESTA", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/cat-icon.png"));
            }
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
