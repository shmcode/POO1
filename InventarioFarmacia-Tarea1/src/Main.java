import java.util.*;

interface GlobalVariables {
    Scanner cin = new Scanner(System.in);

    //Creación de un Linked List para los productos del inventario
    LinkedList<Product> listaEnlazada = new LinkedList<Product>();
    //Creación de Array List para el personal
    List<Worker> listaPersonal = new ArrayList<Worker>();

    DrugStore farmacia = new DrugStore("Farmacia El Ahorro", "Frente a Supermercado La Unión", "12345678");


}

public class Main implements GlobalVariables {

    public static void main(String[] args) {

        //Registro de 2 trabajadores
        listaPersonal.add(new Worker(1,"Alicia","Cristina","Alvarez","acalvarez@farmacia.ni", "12345678", "holamundo"));
        listaPersonal.add(new Worker(2, "Ernesto", "Jose", "Alvarez","ejalvarez@farmacia.ni","12345678", "holamundo2"));
        int op;

        do{
            System.out.println("\n\n\t\t Sistema de Gestión de Inventarios para Farmacias");
            System.out.println("\t\t  -> Te damos la bienvenida a " + farmacia.getName().toUpperCase());
            System.out.println("\n\n MENU: \n 1. Iniciar Sesión \n 2. Salir");
            System.out.println("\n -> Elige una opción (1-2): ");
            op = cin.nextByte();

            switch (op){
                case 1:
                    logIn(listaPersonal);
                    break;
                case 2:
                    break;
                default:
                    System.out.println(" \n (!) Error. Digita una opción válida.");
                    break;
            }
        }while (op != 2);

    }

    public static void logIn(List<Worker> listaPersonal){

        boolean inOut = false;

        System.out.println("\n >> Usuario: ");
        Integer username = cin.nextInt();

        //Tomar el último\n
        cin.nextLine();

        System.out.println("\n >> PIN: ");
        String pin = cin.nextLine();

        //Verificación de Identidad
        for (Worker personal:listaPersonal) {
            if(username.equals(personal.getId())){
                if(pin.equals(personal.getPassword())){
                    System.out.println(" \n\n >> TE DAMOS LA BIENVENIDA " + personal.getFirstName().toUpperCase());
                    inOut = true;
                }
            }
        }

        if(!inOut){
            System.out.println("\n (!) El usuario o el PIN son incorrectos.");
        }else{
            inventario();
        }

    }

    public static void inventario(){

        byte op;

        do{
            System.out.println("\n\n MENU: \n 1. Agregar Producto \n 2. Ver Inventario \n 3. Aumentar Inventario \n 4. Realizar Orden \n 5. Salir");
            op = cin.nextByte();

            switch (op){
                case 1:
                    agregarProd(listaEnlazada);
                    break;

                case 2:
                    verInven(listaEnlazada);
                    break;
                case 3:
                    aumentarInven();
                    break;
                case 4:
                    realizarCompra(listaEnlazada);
                    break;
                case 5:
                    break;
                default:
                    System.out.println(" \n (!) Error. Digita una opción válida.");
                    break;
            }

        }while(op != 5);
    }

    public static void  agregarProd(LinkedList<Product> listaEnlazada){
        //Creación del nuevo Objeto productoN de tipo Product por medio del constructor vacío
        Product productoN = new Product();
        //Creación de un objeto category para la clase Enum ProductCategory
        ProductCategory category;

        System.out.println("\n ID (solo números): ");
        Integer id = cin.nextInt();
        productoN.setId(id);

        cin.nextLine();

        System.out.println("\n >> PRODUCTO \n Nombre: ");
        String name = cin.nextLine();
        productoN.setName(name);

        System.out.println("\n Categoría (Antihipertensivo, Antimicotico u otro): ");
        String categoria = cin.nextLine();
        try {
            category = ProductCategory.valueOf(categoria.toLowerCase());
            productoN.setCategory(category);
        }catch (IllegalArgumentException e){
            System.out.println("La categoría se ha ingresados como OTRO");
            category = ProductCategory.otro;
            productoN.setCategory(category);
        }

        System.out.println("\n Cantidad en Existencia: ");
        Integer quantity = cin.nextInt();
        productoN.setQuantity(quantity);

        System.out.println("\n Precio Unitario: ");
        Double price = cin.nextDouble();
        productoN.setPrice(price);

        listaEnlazada.add(new Product(productoN.getId(), productoN.getName(), productoN.getCategory(), productoN.getQuantity(), productoN.getPrice()));
        System.out.println(productoN.toString());

    }

    public static void realizarCompra(LinkedList<Product> listaEnlazada){
        System.out.println("\n >> Elige el producto a vender: ");
        for (Product producto:listaEnlazada) {
            System.out.println("\n ID:" + producto.getId() + " - " + producto.getName() + " - $" + producto.getPrice() + " - CANT: " + producto.getQuantity());
        }

        System.out.println(" >> Digita el ID: ");
        Integer id = cin.nextInt();

        Integer cant;
        int restante;

        for (Product producto:listaEnlazada) {
            if (id.equals(producto.getId())){
                cin.nextLine();
                do{
                    System.out.println("\n -> Cantidad: ");
                    cant = cin.nextInt();
                    if (cant > producto.getQuantity()){
                        System.out.println("\n ERROR. Cantidad de Producto Insuficiente.");
                    }else{
                        restante = producto.getQuantity() - cant;
                        producto.setQuantity(restante);
                    }
                }while(cant > producto.getQuantity());

                System.out.println("\n >> DETALLE DE VENTA \n ID: " + id + "\n Producto: " + producto.getName() + " - " + cant);
                System.out.println("\n TOTAL  $" + producto.getPrice()*cant);

            }else{
                System.out.println("\n (!) ERROR. No se encontró el producto.");
            }

        }
    }

    public static void verInven(List<Product> listaEnlazada){
        int cont = 1;

        System.out.println("\n >> INVENTARIO: \n");

        for (Product producto:listaEnlazada) {
            System.out.println("(" + cont + ")\n" + producto.toString());
            cont++;
        }
    }

    public static void aumentarInven(){
        System.out.println("\n >> Elige el producto a aumentar (cantidad): ");
        for (Product producto:listaEnlazada) {
            System.out.println("\n ID:" + producto.getId() + " - " + producto.getName() + " - $" + producto.getPrice() + " - CANT: " + producto.getQuantity());
        }

        System.out.println(" >> Digita el ID: ");
        Integer id = cin.nextInt();

        Integer cant;
        int total;

        for (Product producto:listaEnlazada) {
            if (id.equals(producto.getId())){
                cin.nextLine();

                System.out.println("\n -> Cantidad: ");
                cant = cin.nextInt();
                total = producto.getQuantity() + cant;
                producto.setQuantity(total);

            }else{
                System.out.println("\n (!) ERROR. No se encontró el producto.");
            }

        }
    }

}