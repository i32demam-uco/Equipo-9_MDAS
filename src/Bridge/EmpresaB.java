package Bridge;

import java.util.*;

public class EmpresaB implements ProveedorMesas {

    private List<Producto> productos;

    public EmpresaB() {
        productos = new ArrayList<>();

        productos.add(new Producto("Mesa1", 150, 3, "mesa"));
        productos.add(new Producto("Mesa2", 200, 2, "mesa"));
    }

    @Override
    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public List<Producto> buscarPorDimensiones(String dimensiones) {
        return productos; 
    }
}