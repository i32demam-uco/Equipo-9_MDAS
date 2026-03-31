package Bridge;

import java.util.*;

public class ProveedorA implements ProveedorSofas {

    private List<Producto> productos;

    public ProveedorA() {
        productos = new ArrayList<>();

        productos.add(new Producto("Sofa1", 300, 2, "sofa"));
        productos.add(new Producto("Sofa2", 500, 1, "sofa"));
    }

    @Override
    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public List<Producto> buscarPorPlazas(int plazas) {
        return productos; // simplificado
    }
}