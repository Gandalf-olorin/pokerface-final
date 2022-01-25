package es.lanyu.cartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrupoCartas {

  private List<Carta> cartas = new ArrayList<Carta>();

  public GrupoCartas() {
    super();
  }

  public List<Carta> getCartas() {
    return cartas;
  }

  public void barajar() {
    Collections.shuffle(getCartas());
  }

  public Carta<Integer> robar(Carta<Integer> cartaBuscada) {
    Carta<Integer> encontrada = null;
    if (getCartas().size() == 0)
      System.out.println("Añada una baraja");
    else if (cartaBuscada == null)
      encontrada = getCartas().get(0);
    else {
      for (Carta<Integer> carta : getCartas()) {
        if (carta.equals(cartaBuscada)) {
          encontrada = carta;
        }
      }
    }
    getCartas().remove(encontrada);
    return encontrada;
  }

  public boolean contiene(Carta<Integer> buscada) {
    return getCartas().contains(buscada);
  }



}
