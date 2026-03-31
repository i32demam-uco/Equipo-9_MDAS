package Bridge;

import java.util.List;

public interface ProveedorMesas extends IUProveedor {
    List<Producto> buscarPorDimensiones(String dimensiones);
}