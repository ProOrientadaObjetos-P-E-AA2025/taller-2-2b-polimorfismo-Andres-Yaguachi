
package ejecutar.restaurante;

public class MenuNino extends Menu {
    protected double porcionHelado;
    protected double procionPastel;

    public MenuNino(double porcionHelado, double procionPastel, String nombrePlato, double valorMenu, double valorMenuInicial) {
        super(nombrePlato, valorMenu, valorMenuInicial);
        this.porcionHelado = porcionHelado;
        this.procionPastel = procionPastel;
    }

    public double getPorcionHelado() {
        return porcionHelado;
    }

    public void setPorcionHelado(double porcionHelado) {
        this.porcionHelado = porcionHelado;
    }

    public double getProcionPastel() {
        return procionPastel;
    }

    public void setProcionPastel(double procionPastel) {
        this.procionPastel = procionPastel;
    }

    @Override
    public double getcalcularSubtotal() {
         return subtotal = valorMenu + valorMenuInicial + porcionHelado + procionPastel;
    }

    @Override
    public double getcalcularIva() {
        return iva = (subtotal / 0.12);    
    }

    @Override
    public double getcalcularValorTotal() {
       return valorTotal = subtotal + iva;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nMenu Ninos");
        sb.append("\nNombre del plato: ").append(nombrePlato);
        sb.append("\nValor del menu: ").append(valorMenu);
        sb.append("\nValor menu inicial: ").append(valorMenuInicial);
        sb.append("\nvalor pocion de helado: ").append(porcionHelado);
        sb.append("\nValor porcion de pastel: ").append(procionPastel);
        sb.append("\nIva: ").append(iva);
        sb.append("\nSubtotal: ").append(subtotal);
        sb.append("\nTotal a pagar: ").append(valorTotal);
        return sb.toString();
    }
    
}
