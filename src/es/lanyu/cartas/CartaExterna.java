package es.lanyu.cartas;

import com.github.cards.Card;

public class CartaExterna extends Card implements Carta<Integer> {

  public CartaExterna(int suit, int rank) {
    super(suit, rank);
  }

  @Override
  public Integer getPalo() {
    return getSuit();
  }

  @Override
  public int getNumero() {
    return getRank();
  }


  @Override
  public String getNumeroString() {
    if (getNumero() == 1) {
      return "AS";
    } else if (getNumero() == 11) {
      return "JACK";
    } else if (getNumero() == 12) {
      return "QUEEN";
    } else if (getNumero() == 13) {
      return "KING";
    }
    return getRankString();
  }

  @Override
  public String getPaloString() {
    return getSuitString();
  }

  @Override
  public String toString() {
    return getNumeroString() + " of " + getPaloString();
  }


}
