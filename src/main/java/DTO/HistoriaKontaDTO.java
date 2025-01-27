package DTO;

import modele.Konto;
import modele.Transakcja;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record HistoriaKontaDTO(LocalDateTime dataZmiany, BigDecimal kwotaZmiany, BigDecimal bilans, Konto konto, Transakcja transakcja) {
}
