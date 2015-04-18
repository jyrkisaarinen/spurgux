package fi.jsaarinen.spurgux.buildings;

import fi.jsaarinen.spurgux.Canvas;
import fi.jsaarinen.spurgux.Player;

public class Alko implements Building
{
  private double LONKERO_PRICE = 3;
  private double BEER_PRICE = 2;
  public void visit(Player player, Canvas canvas)
  {
    if (player.getEthanolLevel() >= 0.5)
    {
      canvas.setMessage("Emme myy päihtyneille.");
    }
    else
    {
      if (player.getMoney() >= LONKERO_PRICE)
      {
        canvas.setMessage("Ostit lonkeron");
        player.setEthanolLevel(player.getEthanolLevel() + 0.5);
        double money = player.getMoney();
        money -= LONKERO_PRICE;
        player.setMoney(money);
      }
      else
      if (player.getMoney() >= BEER_PRICE)
      {
        canvas.setMessage("Ostit oluen");
        player.setEthanolLevel(player.getEthanolLevel() + 0.4);
        double money = player.getMoney();
        money -= BEER_PRICE;
        player.setMoney(money);
      }
      else
      {
        canvas.setMessage("Sinulla ei ole fyrkkaa meidän tuotteisiimme");
      }
    }
  }
}
