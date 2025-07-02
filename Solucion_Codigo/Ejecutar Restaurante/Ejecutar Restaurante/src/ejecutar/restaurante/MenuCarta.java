
package ejecutar.restaurante;

public class MenuCarta extends Menu {
    protected double valorGuarnicion;
    protected double valorBebida;
    protected double PorcentajeAdi;

    public MenuCarta(double valorGuarnicion, double valorBebida, String nombrePlato, double valorMenu, double valorMenuInicial) {
        super(nombrePlato, valorMenu, valorMenuInicial);
        this.valorGuarnicion = valorGuarnicion;
        this.valorBebida = valorBebida;
    }

    public double getValorGuarnicion() {
        return valorGuarnicion;
    }

    public void setValorGuarnicion(double valorGuarnicion) {
        this.valorGuarnicion = valorGuarnicion;
    }

    public double getValorBebida() {
        return valorBebida;
    }

    public void setValorBebida(double valorBebida) {
        this.valorBebida = valorBebida;
    }

    public double getcalcularPorcentajeAdi() {
        return PorcentajeAdi = valorMenuInicial + valorGuarnicion + valorBebida + (valorMenuInicial * 0.20 / 100)   ;
    }

    @Override
    public double getcalcularSubtotal() {
        return subtotal = valorMenu + valorMenuInicial + valorGuarnicion + valorBebida + PorcentajeAdi;
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
        sb.append("\nMenu a la Carta");
        sb.append("\nNombre del plato: ").append(nombrePlato);
        sb.append("\nValor del menu: ").append(valorMenu);
        sb.append("\nValor menu inicial: ").append(valorMenuInicial);
        sb.append("\nvalor Guarnicion: ").append(valorGuarnicion);
        sb.append("\nValor Bebida: ").append(valorBebida);
        sb.append("\nPorcentaje Adicional: ").append(PorcentajeAdi);
        sb.append("\nIva: ").append(iva);
        sb.append("\nSubtotal: ").append(subtotal);
        sb.append("\nTotal a pagar: ").append(valorTotal);
        return sb.toString();
    }
    


}

