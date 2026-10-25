package com.uem.insw;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;

public class Main {
    // Declaración del logger de Logback
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        // Incluir orders.json en la carpeta resources del proyecto y leerlo
        try (InputStream is = Main.class.getClassLoader().getResourceAsStream("orders.json")) {
            if (is == null) {
                System.out.println("No se pudo encontrar el fichero orders.json en resources.");
                return;
            }

            // Guardar el resultado en una lista de pedidos
            List<Order> orders = mapper.readValue(is, new TypeReference<List<Order>>() {
            });

            // Para cada pedido, hacer un log.debug
            for (Order order : orders) {
                log.debug("Loaded order: {}", order.getId());
            }

        } catch (Exception e) {
            System.err.println("Error al procesar el archivo JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
