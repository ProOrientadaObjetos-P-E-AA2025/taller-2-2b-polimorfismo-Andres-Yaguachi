package ejecutarjuegorol;

public abstract class Personaje {

    protected double hP;
    protected double xP;
    protected double atack;
    protected double blind;
    protected int level;
    protected double hability1;
    protected double hability2;
    protected String clase;
    protected String nombre;

    public Personaje(double hP, double atack, double blind, String nombre) {
        this.hP = hP;
        this.xP = 0;
        this.atack = atack;
        this.level = 1;
        this.blind = blind;
        this.nombre = nombre;
    }

    public void sethP(double hP) {
        this.hP = hP;
    }

    public void setAtack(double atack) {
        this.atack = atack;
    }

    public void setBlind(double blind) {
        this.blind = blind;
    }

    public void calcularLevel() {
        if (xP > 150) {
            level++;
            hP *= 1.1;
            atack *= 1.2;
            xP = 0;
        }
    }

    public double gethP() {
        return hP;
    }

    public double getAtack() {
        return atack;
    }

    public double getBlind() {
        return blind;
    }

    public int getLevel() {
        return level;
    }

    public abstract double getHability1();

    public abstract double[] getHability2();

    public abstract void getHability3();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nPersonaje: ").append(nombre);
        sb.append(" \nClase:").append(clase);
        sb.append(" \nVida: ").append(hP);
        sb.append(" \nXp: ").append(xP);
        sb.append(" \nAtaque: ").append(atack);
        sb.append(" \nBlindaje:").append(blind);
        return sb.toString();
    }

}
