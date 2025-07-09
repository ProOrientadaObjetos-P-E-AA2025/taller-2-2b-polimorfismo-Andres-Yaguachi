package ejecutarjuegorol;

public class Arqueros extends Personaje {

    protected double precision;
    protected double desgarro;

    public Arqueros(double hP, double atack, double blind, String nombre, double precision, double desgarro) {
        super(hP, atack, blind, nombre);
        this.clase = "Arquero";
        this.precision = precision;
        this.desgarro = desgarro;
    }

    public double tiroPreciso() {
        int probabilidad = (int) (Math.random() * 100);
        if (probabilidad <= precision) {
            return ((precision / 100) + 1);
        }
        return 1;
    }

    public double desgarro() {
        int probabilidad = (int) (Math.random() * 100);
        if (probabilidad >= desgarro) {
            return (desgarro / 100);
        }
        return 1;
    }

    @Override
    public double getHability1() {
        double cambios;
        System.out.print("\nDaño: " + atack);
        System.out.println("\nExperiencia Aumentada en 15 puntos ");
        xP += 15;
        cambios = atack * tiroPreciso();
        return cambios;
    }

    @Override
    public double[] getHability2() {
        double[] cambios = new double[2];
        System.out.print("\nDaño: " + (atack * 1.5));
        System.out.println("\nExperiencia Aumentada en 25 puntos ");
        xP += 25;
        cambios[0] = (atack * 1.5) * tiroPreciso();
        cambios[1] = 1 * desgarro();
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
