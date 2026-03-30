package Bridge;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1. SISTEMA GENERAL (Usamos CatalogoMesas como base general para la prueba) [cite: 188, 199]
        // Nota: Como CatalogoBase es abstracta, instanciamos un hijo.
        CatalogoMesas sistema = new CatalogoMesas();

        sistema.addProveedor(new EmpresaA());
        sistema.addProveedor(new EmpresaB());
        sistema.addProveedor(new EmpresaC());

        System.out.println("=== ORDENADO POR PRECIO (TODOS) ===");
        for (Producto p : sistema.buscarOrdenadoPrecio()) {
            System.out.println(p.getNombre() + " - " + p.getPrecio() + " EUR - stock: " + p.getStock());
        }

        System.out.println("\n=== ORDENADO POR STOCK (TODOS) ===");
        for (Producto p : sistema.buscarOrdenadoStock()) {
            System.out.println(p.getNombre() + " - stock total: " + p.getStock());
        }

        // 2. SISTEMA SOLO MESAS (B + C) [cite: 195, 196, 197]
        // Usamos la clase específica que creamos antes
        CatalogoMesas sistemaMesas = new CatalogoMesas();
        sistemaMesas.addProveedor(new EmpresaB());
        sistemaMesas.addProveedor(new EmpresaC());

        System.out.println("\n=== MESAS (B + C) - Búsqueda Específica ===");
        // Aquí usamos el método nuevo que solo tiene CatalogoMesas 
        for (Producto p : sistemaMesas.buscarPorDimensiones("200x90")) {
             System.out.println(p.getNombre() + " - stock total: " + p.getStock());
        }

        // 3. SISTEMA SOLO SOFÁS (A + C) [cite: 194, 196, 198]
        // Instanciamos la otra abstracción refinada
        CatalogoSofas sistemaSofas = new CatalogoSofas();
        sistemaSofas.addProveedor(new EmpresaA());
        sistemaSofas.addProveedor(new EmpresaC());

        System.out.println("\n=== SOFÁS (A + C) - Búsqueda Específica ===");
        // Usamos el método específico de CatalogoSofas [cite: 187, 384]
        for (Producto p : sistemaSofas.buscarPorPlazas(3)) {
             System.out.println(p.getNombre() + " - stock total: " + p.getStock());
        }

        // 4. BÚSQUEDA SIMPLE POR TIPO [cite: 187]
        System.out.println("\n=== BÚSQUEDA GENERAL POR TIPO (Mesa) ===");
        for (Producto p : sistema.buscarPorTipo("mesa")) {
            System.out.println(p.getNombre());
        }
    }
}