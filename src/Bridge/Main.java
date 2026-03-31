package Bridge;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        CatalogoMesas sistema = new CatalogoMesas();

        sistema.addProveedor(new ProveedorA());
        sistema.addProveedor(new ProveedorB());
        sistema.addProveedor(new ProveedorC());

        System.out.println("=== ORDENADO POR PRECIO (TODOS) ===");
        for (Producto p : sistema.buscarOrdenadoPrecio()) {
            System.out.println(p.getNombre() + " - " + p.getPrecio() + " EUR - stock: " + p.getStock());
        }

        System.out.println("\n=== ORDENADO POR STOCK (TODOS) ===");
        for (Producto p : sistema.buscarOrdenadoStock()) {
            System.out.println(p.getNombre() + " - stock total: " + p.getStock());
        }

        CatalogoMesas sistemaMesas = new CatalogoMesas();
        sistemaMesas.addProveedor(new ProveedorB());
        sistemaMesas.addProveedor(new ProveedorC());

        System.out.println("\n=== MESAS (B + C) - Búsqueda Específica ===");
        for (Producto p : sistemaMesas.buscarPorDimensiones("200x90")) {
             System.out.println(p.getNombre() + " - stock total: " + p.getStock());
        }


        CatalogoSofas sistemaSofas = new CatalogoSofas();
        sistemaSofas.addProveedor(new ProveedorA());
        sistemaSofas.addProveedor(new ProveedorC());

        System.out.println("\n=== SOFÁS (A + C) - Búsqueda Específica ===");
        for (Producto p : sistemaSofas.buscarPorPlazas(3)) {
             System.out.println(p.getNombre() + " - stock total: " + p.getStock());
        }

        System.out.println("\n=== BÚSQUEDA GENERAL POR TIPO (Mesa) ===");
        for (Producto p : sistema.buscarPorTipo("mesa")) {
            System.out.println(p.getNombre());
        }
    }
}