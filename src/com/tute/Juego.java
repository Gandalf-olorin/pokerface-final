package com.tute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import es.lanyu.cartas.Baraja;
import es.lanyu.cartas.Carta;
import es.lanyu.cartas.CartaImpl;
import es.lanyu.cartas.Mano;

public class Juego {

  public static void main(String[] args) {

    int numeroMaximoBaraja = 10;
    Baraja baraja1 = new Baraja();
    for (int i = 0; i < CartaImpl.getPalos().length; i++) {
      for (int j = 1; j <= numeroMaximoBaraja; j++) {
        baraja1.getCartas().add(new CartaImpl(i, j));
      }
    }

    baraja1.getCartas().forEach(System.out::println);
    baraja1.barajar();
    baraja1.getCartas().forEach(System.out::println);
    CartaImpl cartaParaBuscar =
        new CartaImpl(CartaImpl.getPalos().length - 1, numeroMaximoBaraja - 1);
    System.out.println("Busco " + cartaParaBuscar);
    System.out.println(
        "¿ " + cartaParaBuscar + " esta en la baraja? ==> " + baraja1.contiene(cartaParaBuscar));

    System.out.println("Robo carta " + baraja1.robar(cartaParaBuscar));
    baraja1.getCartas().forEach(System.out::println);
    baraja1.getCartas().sort(null);
    baraja1.getCartas().forEach(System.out::println);
    //
    // int numeroMaximoBarajaExterna = 13;
    // Baraja baraja2 = new Baraja();
    // for (int i = 0; i < CartaExterna.getSuits().length; i++) {
    // for (int j = 1; j <= numeroMaximoBarajaExterna; j++) {
    // baraja2.getCartas().add(new CartaExterna(i, j));
    // }
    // }
    // baraja2.getCartas().forEach(System.out::println);
    // baraja2.barajar();
    // baraja2.getCartas().forEach(System.out::println);
    // CartaExterna cartaSearch =
    // new CartaExterna(CartaExterna.getSuits().length - 1, numeroMaximoBarajaExterna - 1);
    // System.out.println("Busco " + cartaSearch);
    // System.out
    // .println("¿ " + cartaSearch + " esta en la baraja? ==> " + baraja2.contiene(cartaSearch));
    // System.out.println("Robo carta " + baraja2.robar(cartaSearch));
    // baraja2.getCartas().sort(null);
    // baraja2.getCartas().forEach(System.out::println);
    //
    // Baraja baraja3 = new Baraja();
    // int numeroMaximoBarajaFamilia = 4;
    // for (int i = 0; i < CartaFamilia.getPalos().length; i++) {
    // for (int j = 1; j <= numeroMaximoBarajaFamilia; j++) {
    // baraja3.getCartas().add(new CartaFamilia(i, j));
    // }
    // }
    // baraja3.getCartas().forEach(System.out::println);
    // baraja3.barajar();
    // baraja3.getCartas().forEach(System.out::println);
    // CartaFamilia cartaPerdida =
    // new CartaFamilia(CartaFamilia.getPalos().length - 1, numeroMaximoBarajaFamilia - 1);
    // System.out.println("Busco " + cartaPerdida);
    // System.out
    // .println("¿ " + cartaPerdida + " esta en la baraja? ==> " + baraja3.contiene(cartaPerdida));
    // System.out.println("Robo carta " + baraja3.robar(cartaPerdida));
    // baraja3.getCartas().sort(null);
    // baraja3.getCartas().forEach(System.out::println);

    Comparator<Mano> comparador = (m1, m2) -> {
      return getRepeticionesDePalo(m1.getCartas()) - getRepeticionesDePalo(m2.getCartas());
    };

    Mano mano = new Mano(new CartaImpl(0, 0), new CartaImpl(1, 0), new CartaImpl(2, 0),
        new CartaImpl(3, 0));

    // 2 cartas repetidas
    Mano mano2 = new Mano(new CartaImpl(0, 0), new CartaImpl(1, 0), new CartaImpl(2, 1),
        new CartaImpl(3, 1));

    // 3 cartas repetidas
    Mano mano3 = new Mano(new CartaImpl(0, 1), new CartaImpl(1, 1), new CartaImpl(2, 1),
        new CartaImpl(3, 0));

    List<Mano> manos = Arrays.asList(mano, mano2, mano3);
    manos.sort(comparador);
    manos.forEach(System.out::println);;

  }

  private static int getRepeticionesDePalo(Collection<Carta> cartas) {
    List<Carta> m1Ordenada = new ArrayList<>(cartas);
    m1Ordenada.sort(null);
    int maximo = 0;
    int repeticionActual = 0;
    Object paloActual = null;
    for (Carta carta : m1Ordenada) {
      if (carta.getPalo().equals(paloActual)) {
        repeticionActual++;
      } else {
        repeticionActual = 1;
        paloActual = carta.getPalo();
      }
      if (repeticionActual > maximo) {
        maximo = repeticionActual;
      }
    }
    return maximo;

  }
}


