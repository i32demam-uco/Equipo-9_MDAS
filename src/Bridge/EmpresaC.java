package Bridge;

import java.util.*;

public class EmpresaC implements Proveedor {

    private List<Producto> productos;

    public EmpresaC() {
        productos = new ArrayList<>();

        productos.add(new Producto("Mesa1", 150, 2, "mesa"));
        productos.add(new Producto("Sofa1", 300, 3, "sofa"));
    }

    @Override
    public List<Producto> getProductos() {
        return productos;
    }
}
