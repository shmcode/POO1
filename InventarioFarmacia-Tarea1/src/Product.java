import java.util.Date;

public class Product {

    private Integer id;
    private String name;
    private ProductCategory category;
    private Integer quantity;
    private Double price;

    public Product() {
    }

    public Product(Integer id, String name, ProductCategory category, Integer quantity, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                "ID: " + id +
                "\n Nombre: " + name +
                "\n Categoría: " + category +
                "\n Cantidad: " + quantity +
                "\n Precio: " + price ;
    }
}
