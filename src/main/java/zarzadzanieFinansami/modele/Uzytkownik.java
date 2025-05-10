package zarzadzanieFinansami.modele;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Uzytkownik{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String nazwa;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String haslo;
    @Column(nullable = false)
    private boolean aktywny;
    @Column(nullable = false)
    private String rola;
    @Column(nullable = false)
    private int błędneLogowanie = 0;

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
        aktywny = true;//TODO:tworzenie potwierdzenia przez email o aktywacji konta
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
    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
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

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
    public boolean isAktywny() {
        return aktywny;
    }
    public void setAktywny(boolean aktywny) {
        this.aktywny = aktywny;
    }

    public int getBłędneLogowanie(){
        return błędneLogowanie;
    }
    public void dodajBłędneLogowanie(){
        this.błędneLogowanie++;
    }
    public void resetBłędneLogowanie(){
        this.błędneLogowanie = 0;
    }

}
