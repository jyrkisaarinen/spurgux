package fi.jsaarinen.spurgux.rakennukset;

import fi.jsaarinen.spurgux.Canvas;
import fi.jsaarinen.spurgux.Player;

public class Apteekki
{
  private String[] map =
  {
    "############",
    "# APTEEKKI #",
    "#          #",
    "#          #",
    "############"    
  };
    
  public void visit(Player player, Canvas canvas)
  {
    if (player.getEthanolLevel() >= 1.5)
    {
      canvas.renderFeedbackLine("Pameja ei voi vetää viinan kanssa sekaisin!");
    }
    else
    {        
      canvas.renderFeedbackLine("Diatsepaami parantaa oloasi.");
      player.setWellBeing(player.getWellBeing() + 2);
    }
  }

  public String[] getMap()
  {
    return this.map;
  }
}
