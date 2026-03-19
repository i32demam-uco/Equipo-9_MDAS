package Bridge;

import java.util.*;

public class SistemaEmpresa {

    private List<Proveedor> proveedores;

    public SistemaEmpresa() {
        proveedores = new ArrayList<>();
    }

    public void addProveedor(Proveedor p) {
        proveedores.add(p);
    }

    // ORDENAR POR PRECIO
    public List<Producto> buscarOrdenadoPrecio() {
        List<Producto> lista = new ArrayList<>();

        for (Proveedor p : proveedores) {
            lista.addAll(p.getProductos());
        }

        lista.removeIf(prod -> prod.getStock() <= 0);

        lista.sort(Comparator.comparingDouble(Producto::getPrecio));

        return lista;
    }

    // ORDENAR POR STOCK (SUMANDO)
    public List<Producto> buscarOrdenadoStock() {

        Map<String, Producto> mapa = new HashMap<>();

        for (Proveedor p : proveedores) {
            for (Producto prod : p.getProductos()) {

                if (prod.getStock() <= 0) continue;

                if (mapa.containsKey(prod.getNombre())) {
                    Producto existente = mapa.get(prod.getNombre());
                    existente.setStock(existente.getStock() + prod.getStock());
                } else {
                    mapa.put(prod.getNombre(),
                        new Producto(prod.getNombre(), prod.getPrecio(), prod.getStock(), prod.getTipo()));
                }
            }
        }

        List<Producto> lista = new ArrayList<>(mapa.values());

        lista.sort((a, b) -> Integer.compare(b.getStock(), a.getStock()));

        return lista;
    }
        public List<Producto> buscarPorTipo(String tipo) {
        List<Producto> lista = new ArrayList<>();

        for (Proveedor p : proveedores) {
            for (Producto prod : p.getProductos()) {
                if (prod.getTipo().equalsIgnoreCase(tipo) && prod.getStock() > 0) {
                    lista.add(prod);
                }
            }
        }

        return lista;
    }

}