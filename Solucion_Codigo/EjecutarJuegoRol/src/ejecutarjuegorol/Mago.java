package ejecutarjuegorol;

public class Mago extends Personaje {

    public Mago(double hP, double atack, double blind, String nombre) {
        super(hP, atack, blind, nombre);
        this.clase = "Mago";
    }

    @Override
    public double getHability1() {
        double cambios;
        System.out.print("\nDaño: " + atack);
        cambios = atack;     
        System.out.println("\nExperiencia Aumentada en 5 puntos ");
        xP += 5;

        return cambios;
    }

    @Override
    public double[] getHability2() {
        double[] cambios = new double[2];
        System.out.print("\nDaño: " + atack);
        cambios[0] = atack;
        System.out.print("\nBlindaje enemigo reducido en 15%");
        cambios[1] = 0.85;
        System.out.print("\nBlindaje Aumentado en 50%");
        blind *= 1.5;
        System.out.println("\nExperiencia Aumentada en 5 puntos ");
        xP += 5;

        return cambios;
    }

    @Override
    public void getHability3() {
        System.out.println("Habilidad activada: Mana divino");
        System.out.println("El mago tiene aumento de vida %50.....");
        hP *= 1.5;
        System.out.println("El mago tiene aumento de ataque %20.....");
        atack *= 1.2;
    }
}
