
package ejecutar.restaurante;

public class MenuDia extends Menu {
    protected double valorPostre;
    protected double valorBebida;

    public MenuDia(double valorPostre, double valorBebida, String nombrePlato, double valorMenu, double valorMenuInicial) {
        super(nombrePlato, valorMenu, valorMenuInicial);
        this.valorPostre = valorPostre;
        this.valorBebida = valorBebida;
    }

    public double getValorPostre() {
        return valorPostre;
    }

    public void setValorPostre(double valorPostre) {
        this.valorPostre = valorPostre;
    }

    public double getValorBebida() {
        return valorBebida;
    }

    public void setValorBebida(double valorBebida) {
        this.valorBebida = valorBebida;
    }

    @Override
    public double getcalcularSubtotal() {
         return subtotal = valorMenu + valorMenuInicial + valorPostre + valorBebida;
    }

    @Override
    public double getcalcularIva() {
       return iva = (subtotal / 0.12);
    }

    @Override
    public double getcalcularValorTotal() {
        return valorTotal = subtotal + iva;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nMenu Ninos");
        sb.append("\nNombre del plato: ").append(nombrePlato);
        sb.append("\nValor del menu: ").append(valorMenu);
        sb.append("\nValor menu inicial: ").append(valorMenuInicial);
        sb.append("\nvalor postre: ").append(valorPostre);
        sb.append("\nValor bebida: ").append(valorBebida);
        sb.append("\nIva: ").append(iva);
        sb.append("\nSubtotal: ").append(subtotal);
        sb.append("\nTotal a pagar: ").append(valorTotal);
        return sb.toString();
    }
    
}
