package com.tienda.facade;

import com.tienda.model.Pedido;
import com.tienda.service.ValidadorStock;
import com.tienda.adapter.FacturaService;
import com.tienda.adapter.FacturaAdapter;

public class PedidoFacade {

    private final ValidadorStock validador = new ValidadorStock();
    private final FacturaService facturaService = new FacturaAdapter();

  
     @param producto      
     @param cantidad       
     @param precioUnitario 
     @param cliente        
    
    public void procesarPedido(String producto, int cantidad, double precioUnitario, String cliente) {

        if (!validador.validar(producto, cantidad)) {
            System.out.println("❌ No se pudo procesar el pedido por falta de stock.");
            return;
        }


        Pedido pedido = new Pedido(producto, cantidad, precioUnitario);
        System.out.printf("✅ Pedido registrado: %s x%d%n", producto, cantidad);

    
        facturaService.generarFactura(cliente, pedido.getTotal());

        mostrarComprobante(cliente, pedido);
    }

   
    private void mostrarComprobante(String cliente, Pedido pedido) {
        System.out.println("\n===== 🧾 COMPROBANTE DE PAGO =====");
        System.out.println("Cliente  : " + cliente);
        System.out.println("Producto : " + pedido.getProducto());
        System.out.printf("Subtotal : S/ %.2f%n", pedido.getSubtotal());
        System.out.printf("IGV (18%%): S/ %.2f%n", pedido.getIgv());
        System.out.printf("Total    : S/ %.2f%n", pedido.getTotal());
        System.out.println("==================================\n");
    }
}
