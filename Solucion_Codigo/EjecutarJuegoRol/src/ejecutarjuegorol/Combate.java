package ejecutarjuegorol;

import java.util.Random;

public class Combate {

    Personaje[] luchador;

    public Combate() {
        luchador = new Personaje[2];
    }

    public void inicializarCombatientes(Personaje p, int rep) {
        luchador[rep] = p;
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

    public String combate() {
        int c = 0;
        double[] accion;
        double acc;
        System.out.println("Combate entre " + luchador[0].nombre + " y " + luchador[1].nombre);
        while (luchador[0].gethP() > 0 && luchador[1].gethP() > 0) {
            System.out.println("Turno de: " + luchador[0].nombre);
            switch (elegirHabilidad(c)) {
                case 0 -> {
                    acc = luchador[0].getHability1();
                    luchador[1].hP -= acc - (acc * (luchador[1].blind / 100));
                    luchador[0].calcularLevel();
                }
                case 1 -> {
                    accion = luchador[0].getHability2();
                    luchador[1].hP -= accion[0] - (accion[0] * (luchador[1].blind / 100));
                    luchador[1].blind *= accion[1];
                    luchador[0].calcularLevel();

                }
                case 2 -> {
                    luchador[0].getHability3();
                    luchador[0].calcularLevel();
                }
            }
            if (luchador[1].hP <= 0) {
                System.out.println("\nEl combate ha finalizado");
                break;

            }
            System.out.println("\nTurno de: " + luchador[1].nombre);
            switch (elegirHabilidad(c)) {
                case 0 -> {
                    acc = luchador[1].getHability1();
                    luchador[0].hP -= acc - (acc * (luchador[0].blind / 100));
                    luchador[1].calcularLevel();
                }
                case 1 -> {
                    accion = luchador[1].getHability2();
                    luchador[0].hP -= accion[0] - (accion[0] * (luchador[0].blind / 100));
                    luchador[0].blind *= accion[1];
                    luchador[1].calcularLevel();
                    prioridad(false);

                }
                case 2 -> {
                    luchador[1].getHability3();
                    luchador[1].calcularLevel();
                }
            }
            System.out.println("\nParametros Actualizados");
            System.out.println("/////////////////////////");
            System.out.println(luchador[0]);
            System.out.println("/////////////////////////");
            System.out.println(luchador[1] + "\n");

            if (c == 3) {
                c = 0;
            } else {
                c++;
            }
        }
        if (luchador[0].gethP() <= 0 && luchador[1].gethP() <= 0) {
            return ("¡Empate!");
        } else if (luchador[0].gethP() <= 0) {
            return (luchador[1].nombre + " ha ganado!");
        } else {
            return (luchador[0].nombre + " ha ganado!");
        }

    }

    public int elegirHabilidad(int num) {
        Random random = new Random();
        int opc;
        switch (num) {
            case 1:
                opc = 0;
                break;
            case 2:
                opc = random.nextInt(1);
                break;
            case 3:
                opc = random.nextInt(2);
                break;
            default:
                opc = 0;
                break;
        }
        return opc;
    }
}
