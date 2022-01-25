package es.lanyu.cartas;

import java.util.Objects;

public class CartaImpl implements Carta<Integer> {

  static String[] palos = {"OROS", "ESPADAS", "COPAS", "BASTOS"};
  private final Integer palo;
  private final int numero;

  public static String[] getPalos() {
    return palos;
  }

  @Override
  public Integer getPalo() {
    return palo;
  }

  @Override
  public int getNumero() {
    return numero;
  }

  public CartaImpl(int palo, int numero) {
    this.palo = palo;
    this.numero = numero;
  }


  @Override
  public String getNumeroString() {
    if (getNumero() == 1) {
      return "AS";
    } else if (getNumero() == 8) {
      return "SOTA";
    } else if (getNumero() == 9) {
      return "CABALLO";
    } else if (getNumero() == 10) {
      return "REY";
    } else {
      return String.valueOf(getNumero());
    }
  }

  @Override
  public String getPaloString() {
    return getPalos()[getPalo()];
  }

  public String toString() {
    return getNumeroString() + " de " + getPaloString();
  }

  public int hashCode() {
    return Objects.hash(numero, palo);
  }

  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CartaImpl other = (CartaImpl) obj;
    return numero == other.numero && palo == other.palo;
  }

}
