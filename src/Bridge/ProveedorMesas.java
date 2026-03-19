package Bridge;

import java.util.List;

public interface ProveedorMesas extends Proveedor {
    List<Producto> buscarPorDimensiones(String dimensiones);
}