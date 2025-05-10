package zarzadzanieFinansami.konwertery; // lub inny odpowiedni pakiet

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import zarzadzanieFinansami.modele.enumeracje.TypKontaEnum; // Upewnij się, że import jest poprawny

@Converter // Możesz dodać (autoApply = true) jeśli chcesz, by konwerter był automatycznie stosowany do wszystkich pól typu TypKontaEnum
public class TypKontaConverter implements AttributeConverter<TypKontaEnum, String> {

    @Override
    public String convertToDatabaseColumn(TypKontaEnum attribute) {
        // Kiedy zapisujesz do bazy, użyj nazwy enuma (która jest wielkimi literami)
        // lub przekonwertuj na małe litery, jeśli definicja ENUM w MySQL tego wymaga.
        // Jeśli MySQL ENUM jest zdefiniowany małymi literami, to zapisuj małymi.
        if (attribute == null) {
            return null;
        }
        return attribute.name().toLowerCase(); // Zapisuj małymi literami, aby pasowało do definicji ENUM w MySQL
    }

    @Override
    public TypKontaEnum convertToEntityAttribute(String dbData) {
        // Kiedy odczytujesz z bazy (dbData będzie małymi literami, np. "firmowe")
        if (dbData == null || dbData.trim().isEmpty()) {
            return null;
        }
        try {
            // Przekonwertuj odczytaną wartość na wielkie litery przed próbą dopasowania do enuma
            return TypKontaEnum.valueOf(dbData.toUpperCase());
        } catch (IllegalArgumentException e) {
            // Możesz tu dodać logowanie lub rzucić bardziej szczegółowy wyjątek,
            // albo zwrócić domyślną wartość, jeśli to ma sens.
            // To miejsce jest ważne, jeśli w bazie pojawią się wartości, których nie ma w enumie.
            System.err.println("Nie można przekonwertować wartości z bazy: '" + dbData + "' na TypKontaEnum. Sprawdź definicję enuma i dane w bazie.");
            // Możesz rzucić własny wyjątek lub zwrócić null/wartość domyślną
            // throw new IllegalStateException("Nieznana wartość dla TypKontaEnum w bazie: " + dbData, e);
            return null; // Lub jakaś wartość domyślna, jeśli to odpowiednie
        }
    }
}
