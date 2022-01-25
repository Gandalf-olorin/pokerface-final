package es.lanyu.cartas;



public interface Carta<T extends Comparable<T>> extends Comparable<Carta<T>> {

  T getPalo();

  int getNumero();

  String getNumeroString();

  String getPaloString();


  default int compareTo(Carta<T> otraCarta) {
    int resultado = getPalo().compareTo(otraCarta.getPalo());
    if (resultado == 0) {
      resultado = Integer.compare(getNumero(), otraCarta.getNumero());
    }

    return resultado;

  }



}
