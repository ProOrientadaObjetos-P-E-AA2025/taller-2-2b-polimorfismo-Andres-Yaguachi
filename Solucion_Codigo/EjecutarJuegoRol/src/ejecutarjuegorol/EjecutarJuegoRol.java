package ejecutarjuegorol;

import java.util.Scanner;

public class EjecutarJuegoRol {

    public static void main(String[] args) {
        int opc;
        Combate combate = new Combate();
        for (int i = 0; i < 2; i++) {
            opc = menu();
            switch (opc) {
                case 1:

                    switch (menu1()) {
                        case 1:
                            combate.inicializarCombatientes(opc, 140, 20, 20, "Thorgar", i);
                            break;
                        case 2:
                            combate.inicializarCombatientes(opc, 135, 25, 17, "Brakka", i);
                            break;
                        case 3:
                            combate.inicializarCombatientes(opc, 150, 15, 15, "Korgan", i);
                            break;

                    }
                    break;

                case 2:
                    switch (menu2()) {
                        case 1:
                            combate.inicializarCombatientes(opc, 130, 10, 30, "Elrion", i);
                            break;
                        case 2:
                            combate.inicializarCombatientes(opc, 145, 8, 25, "Valtor", i);
                            break;
                        case 3:
                            combate.inicializarCombatientes(opc, 135, 15, 26, "Myrddin", i);
                            break;

                    }
                    break;

                case 3:
                    switch (menu3()) {
                        case 1:
                            combate.inicializarCombatientes(opc, 138, 12, 10, "Lira", i);
                            break;
                        case 2:
                            combate.inicializarCombatientes(opc, 133, 18, 15, "Faenor", i);
                            break;
                        case 3:
                            combate.inicializarCombatientes(opc, 145, 8, 18, "Silvar", i);
                            break;

                    }
                    break;

                default:
                    System.out.println("Opcion no valida");
                    return;
            }
            if ((combate.luchador[1] != null) && (combate.luchador[0].nombre.equals(combate.luchador[1].nombre))) {
                System.out.println("\nNo puede seleccionar el mismo personaje dos veces, seleccione otro...");
                i--;
            }
        }
        combate.prioridad(true);
        combate.combate();

    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== Seleccion de tipo de personaje ===");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.println("3. Arquero");
        System.out.print("Ingrese una opcion: ");
        int opcionTipo = sc.nextInt();
        return opcionTipo;
    }

    public static int menu1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== Seleccion de Guerrero ===");
        System.out.println("[1] Thorgar - Vida: 140 | Ataque: 20 | Blindaje: 20");
        System.out.println("[2] Brakka  - Vida: 135 | Ataque: 25 | Blindaje: 17");
        System.out.println("[3] Korgan  - Vida: 150 | Ataque: 15 | Blindaje: 15");
        System.out.print("Elige tu guerrero: ");
        int opcionTipo = sc.nextInt();
        return opcionTipo;
    }

    public static int menu2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== Seleccion de Mago ===");
        System.out.println("[1] Elrion  - Vida: 130 | Ataque: 10 | Blindaje: 30");
        System.out.println("[2] Valtor  - Vida: 145 | Ataque: 8  | Blindaje: 25");
        System.out.println("[3] Myrddin - Vida: 135 | Ataque: 15 | Blindaje: 26");
        System.out.print("Elige tu mago: ");
        int opcionTipo = sc.nextInt();
        return opcionTipo;
    }

    public static int menu3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== Seleccion de Arquero ===");
        System.out.println("[1] Lira   - Vida: 138 | Ataque: 12 | Blindaje: 10");
        System.out.println("[2] Faenor - Vida: 133 |Ataque: 18 | Blindaje: 15");
        System.out.println("[3] Silvar - Vida: 145 |Ataque: 8 | Blindaje: 18");
        System.out.print("Elige tu arquero: ");
        int opcionTipo = sc.nextInt();
        return opcionTipo;
    }

}
