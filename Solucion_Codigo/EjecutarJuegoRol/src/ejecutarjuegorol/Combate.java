package ejecutarjuegorol;

import java.util.Scanner;

public class Combate {

    Scanner sc;
    Personaje[] luchador;

    public Combate() {
        sc = new Scanner(System.in);

    }

    public void inicializarCombatientes(int num, double hP, double atack, double blind, String nombre) {
        switch (num) {
            case 1 -> {
                luchador[num] = new Guerrero(hP, atack, blind, nombre);
            }
            case 2 -> {
                luchador[num] = new Mago(hP, atack, blind, nombre);
            }
            case 3 -> {
                luchador[num] = new Arqueros(hP, atack, blind, nombre);
            }
        }
    }

    public void combate() {
        int c = 0;
        double[] accion = new double[2];
        if ((c1 != null) && (c2 != null)) {
            System.out.println("Combate entre Guerrero y mago");
            while (c2.gethP() > 0 && c1.gethP() > 0) {
                System.out.println("Turno de guerrero");
                switch (elegirHabilidad(c)) {
                    case 1 -> {
                        accion = c1.getHability1();
                        c2.hP -= accion[0];
                    }
                    case 2 -> {
                        accion = c1.getHability2();
                        c2.hP -= accion[0];
                        c2.blind = accion[1];
                    }
                    case 3 -> {
                        c1.getHability3();
                    }
                }

                System.out.println("Turno de Mago");
                switch (elegirHabilidad(c)) {
                    case 1 -> {
                        accion = c2.getHability1();
                        c1.hP -= accion[0];
                        c1.blind -= accion[1];
                    }
                    case 2 -> {
                        accion = c2.getHability2();
                        c1.hP -= accion[0];
                    }
                    case 3 -> {
                        c2.getHability3();
                    }
                }
                System.out.println(c1);
                System.out.println(c2);
                c++;
            }
        } else if ((c2 != null) && (c3 != null)) {
            System.out.println("Combate entre Mago y Arquero");
            while (c2.gethP() > 0 && c1.gethP() != 0) {
                System.out.println("Turno de Mago");
                switch (elegirHabilidad(c)) {
                    case 1 -> {
                        accion = c1.getHability1();
                        c2.hP -= accion[0];
                    }
                    case 2 -> {
                        accion = c1.getHability2();
                        c2.hP -= accion[0];
                        c2.blind = accion[1];
                    }
                    case 3 -> {
                        c1.getHability3();
                    }
                }
                System.out.println("Turno de Arquero");
                switch (elegirHabilidad(c)) {
                    case 1 -> {
                        accion = c2.getHability1();
                        c1.hP -= accion[0];
                        c1.blind -= accion[1];
                    }
                    case 2 -> {
                        accion = c2.getHability2();
                        c1.hP -= accion[0];
                    }
                    case 3 -> {
                        c2.getHability3();
                    }
                }
                System.out.println(c2);
                System.out.println(c3);
                c++;
            }
        } else {
            System.out.println("Combate entre Guerrero y Arquero");
            while (c2.gethP() > 0 && c1.gethP() != 0) {
                System.out.println("Turno de Mago");
                switch (elegirHabilidad(c)) {
                    case 1 -> {
                        accion = c1.getHability1();
                        c3.hP -= accion[0];
                    }
                    case 2 -> {
                        accion = c1.getHability2();
                        c3.hP -= accion[0];
                        c3.blind = accion[1];
                    }
                    case 3 -> {
                        c1.getHability3();
                    }
                }
                System.out.println("Turno de guerrero");
                switch (elegirHabilidad(c)) {
                    case 1 -> {
                        accion = c3.getHability1();
                        c1.hP -= accion[0];
                        c1.blind -= accion[1];
                    }
                    case 2 -> {
                        accion = c3.getHability2();
                        c1.hP -= accion[0];
                    }
                    case 3 -> {
                        c3.getHability3();
                    }
                }
                System.out.println(c1);
                System.out.println(c3);
                c++;
            }
        }
    }

    public int elegirHabilidad(int num) {
        int opc;
        if (num == 0) {
            System.out.println("\nHabilidad");
            System.out.println("[1] Ataque normal");
        } else if (num == 1) {
            System.out.println("\nHabilidades");
            System.out.println("[1] Ataque normal");
            System.out.println("[2] Ataque cargado");
        } else {
            System.out.println("\nHabilidades");
            System.out.println("[1] Ataque normal");
            System.out.println("[2] Ataque cargado");
            System.out.println("[3] Habilidad espeecial");
        }
        opc = sc.nextInt();
        sc.nextLine();
        return opc;
    }
}
