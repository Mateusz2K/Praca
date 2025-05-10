package zarzadzanieFinansami.DTO;//package zarzadzanieFinansami.DTO;
//
//
//import zarzadzanieFinansami.modele.*;
//import zarzadzanieFinansami.modele.enumeracje.TypKontaEnum;
//import zarzadzanieFinansami.modele.enumeracje.WalutaEnum;
//
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class KontoResponseDTO {
    private int id;
    private String nazwa;
    private BigDecimal bilans;
    private String typ; // String zamiast enuma dla prostoty w DTO
    private String waluta; // String zamiast enuma
    private LocalDateTime dataUtworzenia;
    private Integer uzytkownikId; // Tylko ID właściciela

    // Konstruktor
    public KontoResponseDTO(int id, String nazwa, BigDecimal bilans, String typ, String waluta, LocalDateTime dataUtworzenia, Integer uzytkownikId) {
        this.id = id;
        this.nazwa = nazwa;
        this.bilans = bilans;
        this.typ = typ;
        this.waluta = waluta;
        this.dataUtworzenia = dataUtworzenia;
        this.uzytkownikId = uzytkownikId;
    }

    // Gettery (Settery zazwyczaj nie są potrzebne dla DTO odpowiedzi)
    public int getId() { return id; }
    public String getNazwa() { return nazwa; }
    public BigDecimal getBilans() { return bilans; }
    public String getTyp() { return typ; }
    public String getWaluta() { return waluta; }
    public LocalDateTime getDataUtworzenia() { return dataUtworzenia; }
    public Integer getUzytkownikId() { return uzytkownikId; }
}