package com.tienda.adapter;


public class FacturaAdapter implements FacturaService {

    private final LegacyBillingSystem legacySystem = new LegacyBillingSystem();

    
      @param cliente 
      @param total   


    @Override
    public void generarFactura(String cliente, double total) {
        System.out.println("🔄 Generando factura con el sistema legado...");
        legacySystem.createInvoice(cliente, total);
        System.out.println("✅ Factura generada correctamente.\n");
    }
}
