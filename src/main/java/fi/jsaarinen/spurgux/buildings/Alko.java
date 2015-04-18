package fi.jsaarinen.spurgux.buildings;

import fi.jsaarinen.spurgux.Canvas;
import fi.jsaarinen.spurgux.Player;

public class Alko implements Building
{

  public void visit(Player player, Canvas canvas)
  {
    if (player.getEthanolLevel() >= 0.5)
    {
      canvas.setMessage("Emme myy päihtyneille.");
    }
    else
    {
      if (player.getMoney() >= 3)
      {
        canvas.setMessage("Ostit lonkeron");
        player.setEthanolLevel(player.getEthanolLevel() + 0.5);
      }
    }
  }
}
