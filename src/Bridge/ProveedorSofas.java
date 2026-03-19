package Bridge;

import java.util.List;

public interface ProveedorSofas extends Proveedor {
    List<Producto> buscarPorPlazas(int plazas);
}