
package ejecutar.restaurante;

public class MenuEconomico extends Menu {
    protected double porceDescuento;

    public MenuEconomico(String nombrePlato, double valorMenu, double valorMenuInicial) {
        super(nombrePlato, valorMenu, valorMenuInicial);
    }

    public double getcalcalcularPorceDescuento() {
        return porceDescuento = valorMenuInicial * 0.90 ;
    }

    @Override
    public double getcalcularSubtotal() {
         return subtotal = (valorMenu + valorMenuInicial) - porceDescuento ;
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
        sb.append("\nIva: ").append(iva);
        sb.append("\nSubtotal: ").append(subtotal);
        sb.append("\nDescuento: ").append(porceDescuento);
        sb.append("\nTotal a pagar: ").append(valorTotal);
        return sb.toString();
    }

}
