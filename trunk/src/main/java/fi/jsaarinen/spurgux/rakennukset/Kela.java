package fi.jsaarinen.spurgux.rakennukset;

import fi.jsaarinen.spurgux.Canvas;
import fi.jsaarinen.spurgux.Player;

public class Kela extends AbstractRakennus implements Rakennus
{
  public void visit(Player player, Canvas canvas)
  {
    if (Math.random() >= 0.7)
    {
      canvas.renderFeedbackLine("Saat 20 senttiä toimeentulotukea.");
      player.setMoney(player.getMoney() + 0.2);
    }
    else
    {
      canvas.renderFeedbackLine("Kaikki liitteesi eivät ole meillä, joten et saa mitään");
    }
  }

  @Override
  public String[] getMap()
  {
    return null;
  }
}
