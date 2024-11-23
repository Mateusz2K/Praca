package model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.List;

@Entity
public class Uzytkownik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String hasło;

    //Połączenie Kont
    @OneToMany(mappedBy = "uzytkownik", cascade = CascadeType.ALL,orphanRemoval = true)
    List<Konto> konta;
    //połączenie raport oszczedności
    @OneToMany(mappedBy = "uzytkownik", cascade = CascadeType.ALL, orphanRemoval = true)
    List<RaportOszczednosci> raportYOszczednosciowe;
    //połaczenie powiadomień
    @OneToMany(mappedBy = "uzytkownik", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Powiadomienia> powiadomienia;

    public Uzytkownik() {
    }

    public Uzytkownik(String name, String email, String hasło) {
        this.name = name;
        this.email = email;
        this.hasło = hasło;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHasło() {
        return hasło;
    }

    public void setHasło(String hasło) {
        this.hasło = hasło;
    }

    public List<Konto> getKonta() {
        return konta;
    }

    public void setKonta(List<Konto> konta) {
        this.konta = konta;
    }

    public List<RaportOszczednosci> getRaportYOszczednosciowe() {
        return raportYOszczednosciowe;
    }

    public void setRaportYOszczednosciowe(List<RaportOszczednosci> raportYOszczednosciowe) {
        this.raportYOszczednosciowe = raportYOszczednosciowe;
    }

    public List<Powiadomienia> getPowiadomienia() {
        return powiadomienia;
    }

    public void setPowiadomienia(List<Powiadomienia> powiadomienia) {
        this.powiadomienia = powiadomienia;
    }
}
