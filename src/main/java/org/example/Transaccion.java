package org.example;

import java.time.LocalDate;

public record Transaccion(Integer id, Double monto, String categoria, LocalDate fecha) {
}
