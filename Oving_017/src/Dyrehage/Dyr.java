package Dyrehage;

/**
 *
 * @author erlend.lokken
 */
public class Dyr {
  private final String norskNavn; // "vanlig" navn på
  private final String latNavn;  // latinsk artsnavn
  private final String latFamilie;  // artsfamilie
  private final int ankommetDato;  // dato ankommet dyrehagen
  protected String adresse; // innhegning, bur, akvarium el.l. (unikt innad i dyrehagen)

  /* Enkel konstruktør, ingen datakontroll */
  public Dyr(String norskNavn, String latNavn, String latFamilie,
             int ankommetDato, String adresse) {
	this.norskNavn = norskNavn;
	this.latNavn = latNavn;
	this.latFamilie = latFamilie;
	this.ankommetDato = ankommetDato;
	this.adresse = adresse;
  }

  public String getNorskNavn(){
    return norskNavn;
  }

  public String getLatNavn() {
    return latNavn;
  }

  public String getLatFamilie() {
    return latFamilie;
  }

  public int getAnkommetDato() {
    return ankommetDato;
  }

  public String getAdresse(){
    return adresse;
  }

  public void setAdresse(String nyAdresse){
    adresse = nyAdresse;
  }

  public String toString() {
    return "Norsk navn: " + norskNavn + "\nLatinsk navn og familie: " + latNavn
	+ ", " + latFamilie + "\nAdresse: "+adresse;
  }
}