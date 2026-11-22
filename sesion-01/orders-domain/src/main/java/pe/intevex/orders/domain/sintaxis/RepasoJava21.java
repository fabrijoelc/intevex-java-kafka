package pe.intevex.orders.domain.sintaxis;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class RepasoJava21 {
    public static void main(String[] args) {
        tiposYvar();
        textBlocks();
        switchExpressions();
        buclesYMetodos();
        dineroConBigDecimal();
    }

    // 1. Tipos primitivos, string y var
    static void tiposYvar(){
        int cantidad = 3;
        double peso = 1.5;
        boolean disponible = true;
        String producto = "teclado mecanico";

        var precio = new BigDecimal("199.90");
        var cliente = "Maria Rojas";

        System.out.println(producto + " x " + cantidad + " | " + peso + " KG | " + disponible);
        System.out.println(cliente + " paga S/ " + precio);
    }

    /** 2. Text blocks (Java 15+): textos de varias líneas sin concatenar. */
    static void textBlocks() {
        String json = """
            {
                "sku": "KB-001",
                "name": "Teclado mecánico",
                "price": 199.90
            }
            """;
        System.out.println(json);
    }

    /** 3. Switch expressions (Java 14+): devuelven un valor, sin break. */
    static void switchExpressions() {
        DayOfWeek hoy = LocalDate.now().getDayOfWeek();

        String despacho = switch (hoy) {
            case SATURDAY, SUNDAY -> "Despacho el lunes";
            case FRIDAY -> "Despacho el lunes si compras después de las 6 p.m.";
            default -> "Despacho mañana";
        };

        System.out.println(hoy + ": " + despacho);
    }

    /** 4. Bucles y métodos. */
    static void buclesYMetodos() {
        String[] productos = {"Mouse", "Teclado", "Monitor"};

        for (String p : productos) {
            System.out.println("- " + p);
        }

        int i = 0;
        while (i < 3) {
            System.out.println("Intento " + (i + 1));
            i++;
        }

        System.out.println("Total con envío: " + sumarEnvio(150));
    }

    static int sumarEnvio(int monto) {
        return monto + 10;
    }

    /** 5. Por qué el dinero NO va en double. */
    static void dineroConBigDecimal() {
        System.out.println("double:    0.1 + 0.2 = " + (0.1 + 0.2));

        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");
        System.out.println("BigDecimal: 0.1 + 0.2 = " + a.add(b));

        // Ojo: new BigDecimal(0.1) (con double) arrastra el error. Usa siempre el String.
        System.out.println("new BigDecimal(0.1) = " + new BigDecimal(0.1));
    }
}
