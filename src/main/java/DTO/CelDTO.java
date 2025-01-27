package DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CelDTO(String nazwa, BigDecimal okreslonaKwota, BigDecimal zebranaKwota, LocalDateTime termin, int idKonto) {
}
