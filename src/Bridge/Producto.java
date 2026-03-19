package Bridge;

public class Producto {

    private String nombre;
    private double precio;
    private int stock;
    private String tipo;

    public Producto(String nombre, double precio, int stock, String tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.tipo = tipo;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public String getTipo() { return tipo; }

    public void setStock(int stock) {
        this.stock = stock;
    }
}