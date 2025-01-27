package modele;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Uzytkownik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;
    @Column(nullable = false)
    private String nazwa;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String haslo;

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

    public Uzytkownik(String nazwa, String email, String haslo) {
        this.nazwa = nazwa;
        this.email = email;
        this.haslo = haslo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return nazwa;
    }

    public void setName(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHasło() {
        return haslo;
    }

    public void setHasło(String haslo) {
        this.haslo = haslo;
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
