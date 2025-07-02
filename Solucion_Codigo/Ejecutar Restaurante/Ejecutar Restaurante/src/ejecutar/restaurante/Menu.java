
package ejecutar.restaurante;

public abstract class Menu {
    protected String nombrePlato;
    protected double valorMenu;
    protected double valorMenuInicial;
    protected double subtotal;
    protected double iva;
    protected double valorTotal;

    public Menu(String nombrePlato, double valorMenu, double valorMenuInicial) {
        this.nombrePlato = nombrePlato;
        this.valorMenu = valorMenu;
        this.valorMenuInicial = valorMenuInicial;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public double getValorMenu() {
        return valorMenu;
    }

    public void setValorMenu(double valorMenu) {
        this.valorMenu = valorMenu;
    }

    public double getValorMenuInicial() {
        return valorMenuInicial;
    }

    public void setValorMenuInicial(double valorMenuInicial) {
        this.valorMenuInicial = valorMenuInicial;
    }

    public abstract double getcalcularSubtotal();

    public abstract double getcalcularIva();
    
    public abstract double getcalcularValorTotal();


}


