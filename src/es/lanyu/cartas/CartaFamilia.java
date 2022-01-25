package es.lanyu.cartas;

public class CartaFamilia extends CartaImpl {

  static {
    CartaImpl.palos = new String[] {"Esquimales", "Europeos"};

  }

  public static String[] getPalos() {
    return palos;
  }


  public CartaFamilia(int palo, int numero) {
    super(palo, numero);
  }

  @Override
  public String getNumeroString() {
    if (getNumero() == 1) {
      return "MADRE";
    } else if (getNumero() == 2) {
      return "PADRE";
    } else if (getNumero() == 3) {
      return "HIJO";
    } else
      return "HIJA";
  }


}


