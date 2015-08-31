package fi.jsaarinen.spurgux.rakennukset;

import fi.jsaarinen.spurgux.Canvas;
import fi.jsaarinen.spurgux.Player;

public class Alko extends AbstractRakennus implements Rakennus
{
  private String[] map =
  {
    "###**###",
    "#      #",
    "# ALKO #",
    "#      #",
    "########"    
  };
  
  private static final double LONKERO_PRICE = 3;
  private static final double BEER_PRICE = 2;
  
  public void visit(Player player, Canvas canvas)
  {
    if (player.getEthanolLevel() >= 1.5)
    {
      canvas.renderFeedbackLine("Emme myy päihtyneille.");
    }
    else
    {
      if (player.getMoney() >= LONKERO_PRICE)
      {
        canvas.renderFeedbackLine("Ostit lonkeron");
        player.setEthanolLevel(player.getEthanolLevel() + 0.5);
        double money = player.getMoney();
        money -= LONKERO_PRICE;
        player.setMoney(money);
      }
      else
      if (player.getMoney() >= BEER_PRICE)
      {
        canvas.renderFeedbackLine("Ostit oluen");
        player.setEthanolLevel(player.getEthanolLevel() + 0.4);
        double money = player.getMoney();
        money -= BEER_PRICE;
        player.setMoney(money);
      }
      else
      {
        canvas.renderFeedbackLine("Sinulla ei ole fyrkkaa virvokkeisiin.");
      }
    }
  }

  public String[] getMap()
  {
    return this.map;
  }
}
