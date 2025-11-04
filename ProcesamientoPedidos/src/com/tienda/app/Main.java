package com.tienda.app;

import com.tienda.facade.PedidoFacade;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); // Para usar punto decimal si se necesitara
        PedidoFacade facade = new PedidoFacade();

        System.out.print("Ingrese nombre del cliente: ");
        String cliente = sc.nextLine().trim();

        System.out.print("Ingrese producto: ");
        String producto = sc.nextLine().trim().toLowerCase();

        int cantidad = 0;
        try {
            System.out.print("Ingrese cantidad: ");
            cantidad = sc.nextInt();

            if (cantidad <= 0) {
                System.out.println("❌ La cantidad debe ser mayor que cero.");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("❌ Entrada inválida. Debe ingresar un número entero para la cantidad.");
            return;
        }

        double precioUnitario = obtenerPrecio(producto);

        if (precioUnitario == 0) {
            System.out.println("⚠️ Producto no registrado en el sistema.");
            return;
        }

        System.out.printf("✅ Procesando pedido de %d %s(s) para el cliente %s...%n",
                cantidad, producto, cliente);

        facade.procesarPedido(producto, cantidad, precioUnitario, cliente);

        System.out.println("✅ Pedido procesado correctamente.");
    }

    private static double obtenerPrecio(String producto) {
        switch (producto) {
            case "laptop": return 4000.0;
            case "teclado": return 120.0;
            case "mouse": return 80.0;
            default: return 0.0;
        }
    }
}
