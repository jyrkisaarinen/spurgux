package fi.jsaarinen.spurgux.hahmot;

import fi.jsaarinen.spurgux.Canvas;
import fi.jsaarinen.spurgux.Player;

public class Kake extends Hahmo
{
  public Kake(int x, int y)
  {
    super(x, y, 'K');
  }

  public void visit(Player player, Canvas canvas)
  {
    canvas.renderStatusLine("Kake pummaa kaljaa!");
  }

  @Override
  public boolean canBeSteppedOver(Player player, int x, int y)
  {
    return false;
  }
}
