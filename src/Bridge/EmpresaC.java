package Bridge;

import java.util.*;

public class EmpresaC implements ProveedorMesas, ProveedorSofas {

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

    @Override
    public List<Producto> buscarPorDimensiones(String dimensiones) {
        return productos;
    }

    @Override
    public List<Producto> buscarPorPlazas(int plazas) {
        return productos;
    }
}