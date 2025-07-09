package ejecutarjuegorol;

public class Guerrero extends Personaje {

    protected double critico;

    public Guerrero(double hP, double atack, double blind, String nombre, double critico) {
        super(hP, atack, blind, nombre);
        this.clase = "Guerrero";
        this.critico = critico;
    }

    public double critico() {
        int probabilidad = (int) (Math.random() * 100);
        if (probabilidad <= critico) {
            return ((critico / 100) + 1);
        }
        return 1;
    }

    @Override
    public double getHability1() {
        double cambios;
        System.out.print("\nDaño: " + atack);
        System.out.println("\nExperiencia Aumentada en 30 puntos ");
        xP += 30;
        cambios = atack * critico();
        return cambios;
    }

    @Override
    public double[] getHability2() {
        double[] cambios = new double[2];
        System.out.print("\nDaño: " + (atack * 2));
        cambios[0] = (atack * 2) * critico();
        System.out.print("\nBlindaje reducido en 90%");
        cambios[1] = 0.9;
        System.out.println("\nExperiencia Aumentada en 65 puntos ");
        xP += 65;
        return cambios;
    }

    @Override
    public void getHability3() {
        System.out.println("Habilidad furia Total");
        System.out.println("El guerero ahora hara daño x2");
        atack *= 2;
    }
}
