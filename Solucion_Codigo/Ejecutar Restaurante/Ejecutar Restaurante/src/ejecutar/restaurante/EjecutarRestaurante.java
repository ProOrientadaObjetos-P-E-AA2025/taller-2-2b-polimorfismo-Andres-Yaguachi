package ejecutar.restaurante;

import java.util.ArrayList;
import java.util.Scanner;

public class EjecutarRestaurante {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Menu> listaMenus = new ArrayList<>();

        System.out.print("Cuantos menus desea ingresar: ");
        int cantidad = sc.nextInt();

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Menu " + (i + 1) + " ---");
            System.out.println("1. Menu Nino");
            System.out.println("2. Menu del Dia");
            System.out.println("3. Menu Economico");
            System.out.println("4. Menu a la Carta");
            System.out.print("Seleccione tipo de menu: ");
            int tipo = sc.nextInt();
            sc.nextLine();

            System.out.print("Nombre del plato: ");
            String nombre = sc.nextLine();
            System.out.print("Valor del menu: ");
            double valorMenu = sc.nextDouble();
            System.out.print("Valor inicial del menu: ");
            double valorInicial = sc.nextDouble();

            switch (tipo) {
                case 1:
                    System.out.print("Valor porcion de helado: ");
                    double helado = sc.nextDouble();
                    System.out.print("Valor porcion de pastel: ");
                    double pastel = sc.nextDouble();
                    MenuNino mn = new MenuNino(helado, pastel, nombre, valorMenu, valorInicial);
                    mn.getcalcularSubtotal();
                    mn.getcalcularIva();
                    mn.getcalcularValorTotal();
                    listaMenus.add(mn);
                    break;
                case 2:
                    System.out.print("Valor postre: ");
                    double postre = sc.nextDouble();
                    System.out.print("Valor bebida: ");
                    double bebidaDia = sc.nextDouble();
                    MenuDia md = new MenuDia(postre, bebidaDia, nombre, valorMenu, valorInicial);
                    md.getcalcularSubtotal();
                    md.getcalcularIva();
                    md.getcalcularValorTotal();
                    listaMenus.add(md);
                    break;
                case 3:
                    MenuEconomico me = new MenuEconomico(nombre, valorMenu, valorInicial);
                    me.getcalcalcularPorceDescuento();
                    me.getcalcularSubtotal();
                    me.getcalcularIva();
                    me.getcalcularValorTotal();
                    listaMenus.add(me);
                    break;
                case 4:
                    System.out.print("Valor guarnicion: ");
                    double guarnicion = sc.nextDouble();
                    System.out.print("Valor bebida: ");
                    double bebidaCarta = sc.nextDouble();
                    MenuCarta mc = new MenuCarta(guarnicion, bebidaCarta, nombre, valorMenu, valorInicial);
                    mc.getcalcularPorcentajeAdi();
                    mc.getcalcularSubtotal();
                    mc.getcalcularIva();
                    mc.getcalcularValorTotal();
                    listaMenus.add(mc);
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }
        double total = 0;
        for (int i = 0; i < listaMenus.size(); i++) {
            total += listaMenus.get(i).valorTotal;
        }
        System.out.printf("\nEl total de su compra es: %f.2", total);

        System.out.println("\n--- MENUS INGRESADOS ---");
        for (int i = 0; i < listaMenus.size(); i++) {
            Menu m = listaMenus.get(i);
            System.out.println("Menu #" + (i + 1));
            System.out.println(m);
            System.out.println("------------------------");
        }
    }
}
