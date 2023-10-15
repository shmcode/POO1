public class User {
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;


    //Constructors
    public User(){

    }

    public User(String primerNombre, String primerApellido, String correoElectronico, Integer edad) {
        this.firstName = primerNombre;
        this.lastName = primerApellido;
        this.email = correoElectronico;
        this.age = edad;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Información Ingresada: " +
                "\n Primer Nombre -> " + firstName +
                "\n Primer Apellido -> " + lastName +
                "\n Correo Electronico -> " + email +
                "\n Edad -> " + age;
    }
}
