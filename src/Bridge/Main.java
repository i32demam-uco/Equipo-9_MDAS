package Bridge;

public class Main {

    public static void main(String[] args) {

        // SISTEMA GENERAL (A + B + C)
        SistemaEmpresa sistema = new SistemaEmpresa();

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

        //  SISTEMA SOLO MESAS (B + C)
        SistemaEmpresa sistemaMesas = new SistemaEmpresa();
        sistemaMesas.addProveedor(new EmpresaB());
        sistemaMesas.addProveedor(new EmpresaC());

        System.out.println("\n=== MESAS (B + C) ===");
        for (Producto p : sistemaMesas.buscarOrdenadoStock()) {
            if (p.getTipo().equalsIgnoreCase("mesa")) {
                System.out.println(p.getNombre() + " - stock total: " + p.getStock());
            }
        }

        //  SISTEMA SOLO SOFÁS (A + C)
        SistemaEmpresa sistemaSofas = new SistemaEmpresa();
        sistemaSofas.addProveedor(new EmpresaA());
        sistemaSofas.addProveedor(new EmpresaC());

        System.out.println("\n=== SOFÁS (A + C) ===");
        for (Producto p : sistemaSofas.buscarOrdenadoStock()) {
            if (p.getTipo().equalsIgnoreCase("sofa")) {
                System.out.println(p.getNombre() + " - stock total: " + p.getStock());
            }
        }

        //  BÚSQUEDA SIMPLE POR TIPO
        System.out.println("\n=== SOLO MESAS (BÚSQUEDA SIMPLE) ===");
        for (Producto p : sistema.buscarPorTipo("mesa")) {
            System.out.println(p.getNombre());
        }
    }
}