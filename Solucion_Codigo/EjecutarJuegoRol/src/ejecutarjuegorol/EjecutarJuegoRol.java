package ejecutarjuegorol;

import java.util.Scanner;

public class EjecutarJuegoRol {

    public static void main(String[] args) {
        int opc;
        String ganador;
        Combate combate = new Combate();
        for (int i = 0; i < 2; i++) {
            opc = menu();
            switch (opc) {
                case 1:

                    switch (menu1()) {
                        case 1:
                            Guerrero g1 = new Guerrero(140, 20, 20, "Thorgar", 15);
                            combate.inicializarCombatientes(g1, i);
                            break;
                        case 2:
                            Guerrero g2 = new Guerrero(135, 25, 17, "Brakka", 20F);
                            combate.inicializarCombatientes(g2, i);
                            break;
                        case 3:
                            Guerrero g3 = new Guerrero(150, 15, 15, "Korgan", 25);
                            combate.inicializarCombatientes(g3, i);
                            break;

                    }
                    break;

                case 2:
                    switch (menu2()) {
                        case 1:
                            Mago m1 = new Mago(130, 10, 30, "Elrion", 10);
                            combate.inicializarCombatientes(m1, i);
                            break;
                        case 2:
                            Mago m2 = new Mago(145, 8, 25, "Valtor", 15);
                            combate.inicializarCombatientes(m2, i);
                            break;
                        case 3:
                            Mago m3 = new Mago(135, 15, 26, "Myrddin", 12);
                            combate.inicializarCombatientes(m3, i);
                            break;

                    }
                    break;

                case 3:
                    switch (menu3()) {
                        case 1:
                            Arqueros a1 = new Arqueros(138, 12, 10, "Lira", 19, 87);
                            combate.inicializarCombatientes(a1, i);
                            break;
                        case 2:
                            Arqueros a2 = new Arqueros(133, 18, 15, "Faenor", 20, 89);
                            combate.inicializarCombatientes(a2, i);
                            break;
                        case 3:
                            Arqueros a3 = new Arqueros(145, 8, 18, "Silvar", 25, 95);
                            combate.inicializarCombatientes(a3, i);
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
        ganador = combate.combate();
        System.out.println("\n" + ganador);

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
        System.out.println("[1] Lira   - Vida: 138 |Ataque: 12 | Blindaje: 10");
        System.out.println("[2] Faenor - Vida: 133 |Ataque: 18 | Blindaje: 15");
        System.out.println("[3] Silvar - Vida: 145 |Ataque: 8  | Blindaje: 18");
        System.out.print("Elige tu arquero: ");
        int opcionTipo = sc.nextInt();
        return opcionTipo;
    }

}
