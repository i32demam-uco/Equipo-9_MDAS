package Bridge;

import java.util.List;

public interface ProveedorSofas extends IUProveedor {
    List<Producto> buscarPorPlazas(int plazas);
}