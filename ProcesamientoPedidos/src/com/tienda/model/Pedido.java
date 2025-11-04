package com.tienda.model;


public class Pedido {

    private final String producto;
    private final int cantidad;
    private final double precioUnitario;
    private double subtotal;
    private double igv;
    private double total;

    
     @param producto       
     @param cantidad      
     @param precioUnitario 
    
    public Pedido(String producto, int cantidad, double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        calcularTotales();
    }

  
    private void calcularTotales() {
        this.subtotal = cantidad * precioUnitario;
        this.igv = subtotal * 0.18;
        this.total = subtotal + igv;
    }

    public String getProducto() {
        return producto;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getIgv() {
        return igv;
    }

    public double getTotal() {
        return total;
    }

  
    @Override
    public String toString() {
        return String.format("Producto: %s | Cantidad: %d | Total: S/ %.2f",
                producto, cantidad, total);
    }
}
