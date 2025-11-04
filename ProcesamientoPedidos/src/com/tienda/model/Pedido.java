package com.tienda.model;

public class Pedido {
    private String producto;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
    private double igv;
    private double total;

    public Pedido(String producto, int cantidad, double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        calcularTotales();
    }

    private void calcularTotales() {
        subtotal = cantidad * precioUnitario;
        igv = subtotal * 0.18;
        total = subtotal + igv;
    }

    public String getProducto() { return producto; }
    public double getSubtotal() { return subtotal; }
    public double getIgv() { return igv; }
    public double getTotal() { return total; }
}
