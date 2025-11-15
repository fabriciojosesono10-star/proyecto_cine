package com.tienda.adapter;

public class FacturaAdapter implements FacturaService {

    private LegacyBillingSystem legacySystem = new LegacyBillingSystem();

    @Override
    public void generarFactura(String cliente, double total) {
        legacySystem.createInvoice(cliente, total);
    }
}
