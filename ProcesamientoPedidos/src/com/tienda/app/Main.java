package com.tienda.app;

import com.tienda.facade.PedidoFacade;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PedidoFacade facade = new PedidoFacade();

        System.out.print("Ingrese nombre del cliente: ");
        String cliente = sc.nextLine();

        System.out.print("Ingrese producto: ");
        String producto = sc.nextLine().toLowerCase();

        System.out.print("Ingrese cantidad: ");
        int cantidad = sc.nextInt();

        double precioUnitario = obtenerPrecio(producto);

        if (precioUnitario == 0) {
            System.out.println("Producto no registrado en el sistema.");
            return;
        }

        facade.procesarPedido(producto, cantidad, precioUnitario, cliente);
    }

    private static double obtenerPrecio(String producto) {
        switch (producto) {
            case "laptop": return 4000;
            case "teclado": return 120;
            case "mouse": return 80;
            default: return 0;
        }
    }
}
