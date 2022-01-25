package es.lanyu.cartas;

import java.util.Arrays;

public class Mano extends GrupoCartas {
  public Mano(Carta... cartas) {
    getCartas().addAll(Arrays.asList(cartas));
  }

  @Override
  public String toString() {
    return getCartas().toString();
  }
}
