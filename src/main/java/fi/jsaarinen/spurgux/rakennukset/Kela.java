package fi.jsaarinen.spurgux.rakennukset;

import fi.jsaarinen.spurgux.Canvas;
import fi.jsaarinen.spurgux.Player;
import fi.jsaarinen.spurgux.Renderable;

public class Kela extends AbstractRakennus implements Renderable
{
  public void visit(Player player, Canvas canvas)
  {
    if (Math.random() >= 0.7)
    {
      canvas.renderStatusLine("Saat 20 senttiä toimeentulotukea.");
      player.setMoney(player.getMoney() + 0.2);
    }
    else
    {
      canvas.renderStatusLine("Kaikki liitteesi eivät ole meillä, joten et saa mitään");
    }
  }

  @Override
  public String[] getMap()
  {
    return null;
  }
}
