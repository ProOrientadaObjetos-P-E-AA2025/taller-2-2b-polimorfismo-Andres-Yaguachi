package ejecutarjuegorol;

import java.util.Scanner;

public class Combate {

    Scanner sc;
    Personaje[] luchador;

    public Combate() {
        sc = new Scanner(System.in);
        luchador = new Personaje[2];
    }

    public void inicializarCombatientes(int num, double hP, double atack, double blind, String nombre, int rep) {
        switch (num) {
            case 1 -> {
                luchador[rep] = new Guerrero(hP, atack, blind, nombre);
            }
            case 2 -> {
                luchador[rep] = new Mago(hP, atack, blind, nombre);
            }
            case 3 -> {
                luchador[rep] = new Arqueros(hP, atack, blind, nombre);
            }
        }
    }

    public void prioridad(boolean momento) {
        Personaje aux;
        if (momento) {
            if ((luchador[0].getClass().equals(luchador[1].getClass())) && (luchador[0].getBlind() > luchador[1].getBlind())) {
                aux = luchador[0];
                luchador[0] = luchador[1];
                luchador[1] = aux;
            } else if ((luchador[0].clase.equals("Mago")) && (luchador[1].clase.equals("Guerrero"))
                    || (luchador[0].clase.equals("Arquero")) && (luchador[1].clase.equals("Mago"))
                    || (luchador[0].clase.equals("Guerrero")) && (luchador[1].clase.equals("Arquero"))) {
                aux = luchador[0];
                luchador[0] = luchador[1];
                luchador[1] = aux;
            }
        } else {
            if (luchador[1].blind < luchador[0].blind) {
                aux = luchador[0];
                luchador[0] = luchador[1];
                luchador[1] = aux;
            }
        }

    }

    public void combate() {
        int c = 0;
        double[] accion = new double[2];
        double acc;
        System.out.println("Combate entre " + luchador[0].nombre + " y " + luchador[1].nombre);
        while (luchador[0].gethP() > 0 && luchador[1].gethP() > 0) {
            System.out.println("Turno de: " + luchador[0].nombre);
            switch (elegirHabilidad(c)) {
                case 1 -> {
                    acc = luchador[0].getHability1();
                    luchador[1].hP -= acc - (acc * (luchador[1].blind / 100));
                    luchador[0].calcularLevel();
                }
                case 2 -> {
                    accion = luchador[0].getHability2();
                    luchador[1].hP -= accion[0] - (accion[0] * (luchador[1].blind / 100));
                    if (!luchador[0].clase.equals("Arquero")) {
                        luchador[1].blind *= accion[1];
                    }
                    luchador[0].calcularLevel();
                    prioridad(false);
                }
                case 3 -> {
                    luchador[0].getHability3();
                    luchador[0].calcularLevel();
                }
            }

            System.out.println("Turno de: " + luchador[1].nombre);
            switch (elegirHabilidad(c)) {
                case 1 -> {
                    acc = luchador[1].getHability1();
                    luchador[0].hP -= acc - (acc * (luchador[0].blind / 100));
                    luchador[1].calcularLevel();
                }
                case 2 -> {
                    accion = luchador[1].getHability2();
                    luchador[0].hP -= accion[0] - (accion[0] * (luchador[0].blind / 100));
                    if (!luchador[1].clase.equals("Arquero")) {
                        luchador[0].blind *= accion[1];
                    }
                    luchador[1].calcularLevel();
                    prioridad(false);

                }
                case 3 -> {
                    luchador[1].getHability3();
                    luchador[1].calcularLevel();
                }
            }
            System.out.println("\nParametros Actualizados");
            System.out.println("/////////////////////////");
            System.out.println(luchador[0]);
            System.out.println("/////////////////////////");
            System.out.println(luchador[1]);

            if (c == 3) {
                c = 0;
            } else {
                c++;
            }
        }
        if (luchador[0].gethP() <= 0 && luchador[1].gethP() <= 0) {
            System.out.println("¡Empate!");
        } else if (luchador[0].gethP() <= 0) {
            System.out.println(luchador[1].nombre + " ha ganado!");
        } else {
            System.out.println(luchador[0].nombre + " ha ganado!");
        }

    }

    public int elegirHabilidad(int num) {
        int opc;
        switch (num) {
            case 0:
                System.out.println("\nHabilidad");
                System.out.println("[1] Ataque normal");
                break;
            case 2:
                System.out.println("\nHabilidades");
                System.out.println("[1] Ataque normal");
                System.out.println("[2] Ataque cargado");
                break;
            case 3:
                System.out.println("\nHabilidades");
                System.out.println("[1] Ataque normal");
                System.out.println("[3] Habilidad espeecial");
                break;
            default:
                System.out.println("\nHabilidad");
                System.out.println("[1] Ataque normal");
                break;
        }
        opc = sc.nextInt();
        sc.nextLine();
        return opc;
    }
}
