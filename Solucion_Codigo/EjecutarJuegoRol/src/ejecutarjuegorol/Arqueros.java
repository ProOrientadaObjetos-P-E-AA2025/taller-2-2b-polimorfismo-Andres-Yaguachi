package ejecutarjuegorol;

public class Arqueros extends Personaje {

    public Arqueros(double hP, double atack, double blind, String nombre) {
        super(hP, atack, blind, nombre);
        this.clase = "Arquero";
    }

    @Override
    public double getHability1() {
        double cambios;
        System.out.print("\nDaño: " + atack);
        System.out.println("\nExperiencia Aumentada en 15 puntos ");
        xP += 15;
        cambios = atack;
        return cambios;
    }

    @Override
    public double[] getHability2() {
        double[] cambios = new double[1];
        System.out.print("\nDaño: " + (atack * 1.5));
        System.out.println("\nExperiencia Aumentada en 25 puntos ");
        xP += 25;
        cambios[0] = (atack * 1.5);
        return cambios;
    }

    @Override
    public void getHability3() {
        System.out.println("El Arquero tiene aumento de vida 30%.....");
        hP *= 1.3;
        System.out.println("El Arquero tiene aumento de ataque 20%.....");
        atack *= 1.2;
    }

}
