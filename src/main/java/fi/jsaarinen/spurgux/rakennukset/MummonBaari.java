package fi.jsaarinen.spurgux.rakennukset;

import fi.jsaarinen.spurgux.Canvas;
import fi.jsaarinen.spurgux.Player;

public class MummonBaari extends AbstractRakennus
{
  private String[] map =
  {
    "####**###",
    "#       #",
    "# BAARI #",
    "#       #",
    "#########"    
  };
  
  
  public MummonBaari(int x, int y, int width, int height)
  {
    super(x, y, width, height, "Mummon baari");
  }

  @Override
  public String[] getMap()
  {
    return this.map;
  }

  @Override
  public void visit(Player player, Canvas canvas)
  {    
    canvas.renderStatusLine("Ei tänään");
  }
}
