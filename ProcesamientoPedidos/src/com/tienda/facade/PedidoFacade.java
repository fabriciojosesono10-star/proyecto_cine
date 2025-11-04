package com.tienda.facade;

import com.tienda.model.Pedido;
import com.tienda.service.ValidadorStock;
import com.tienda.adapter.FacturaService;
import com.tienda.adapter.FacturaAdapter;

public class PedidoFacade {

    private ValidadorStock validador = new ValidadorStock();
    private FacturaService facturaService = new FacturaAdapter();

    public void procesarPedido(String producto, int cantidad, double precioUnitario, String cliente) {
        if (!validador.validar(producto, cantidad)) {
            return;
        }

        Pedido pedido = new Pedido(producto, cantidad, precioUnitario);

        System.out.println("Pedido registrado: " + producto + " x" + cantidad);
        facturaService.generarFactura(cliente, pedido.getTotal());
        mostrarComprobante(cliente, pedido);
    }

    private void mostrarComprobante(String cliente, Pedido pedido) {
        System.out.println("Comprobante para " + cliente);
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Subtotal: S/ " + pedido.getSubtotal());
        System.out.println("IGV: S/ " + pedido.getIgv());
        System.out.println("Total: S/ " + pedido.getTotal());
    }
}
