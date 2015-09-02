package fi.jsaarinen.spurgux.hahmot;

import fi.jsaarinen.spurgux.Canvas;
import fi.jsaarinen.spurgux.Player;

public class Koira extends Hahmo
{
  public Koira(int x, int y)
  {
    super(x, y, 'D');
  }

  public void visit(Player player, Canvas canvas)
  {
    canvas.renderStatusLine("Potkaiset koiraa, koira uinahtaa");
    canvas.removeCharacter(this);
  }

  @Override
  public boolean canBeSteppedOver(Player player, int x, int y)
  {
    return true;
  }
}
