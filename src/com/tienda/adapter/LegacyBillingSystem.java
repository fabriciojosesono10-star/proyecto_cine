package com.tienda.adapter;

public class LegacyBillingSystem {
    public void createInvoice(String clientName, double totalAmount) {
        System.out.println("[LegacyBilling] Factura generada para " + clientName + " por S/ " + totalAmount);
    }
}
