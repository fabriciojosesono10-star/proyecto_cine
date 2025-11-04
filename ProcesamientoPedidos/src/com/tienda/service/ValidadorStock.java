package com.tienda.service;

public class ValidadorStock {

    private static final int STOCK_DISPONIBLE = 10;

   
     @param producto
     @param cantidad
     @return 
    
    public boolean validar(String producto, int cantidad) {
        if (cantidad <= 0) {
            System.out.println("❌ Error: la cantidad ingresada no es válida.");
            return false;
        }

        if (cantidad > STOCK_DISPONIBLE) {
            System.out.printf("❌ Error: stock insuficiente para '%s' (disponible: %d unidades).%n",
                    producto, STOCK_DISPONIBLE);
            return false;
        }

        System.out.printf("✅ Stock validado correctamente para '%s'.%n", producto);
        return true;
    }
}
