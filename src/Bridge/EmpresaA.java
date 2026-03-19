package Bridge;

import java.util.*;

public class EmpresaA implements Proveedor {

    private List<Producto> productos;

    public EmpresaA() {
        productos = new ArrayList<>();

        productos.add(new Producto("Sofa1", 300, 2, "sofa"));
        productos.add(new Producto("Sofa2", 500, 1, "sofa"));
    }

    @Override
    public List<Producto> getProductos() {
        return productos;
    }
}