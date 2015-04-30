package fi.jsaarinen.spurgux.hahmot;

import fi.jsaarinen.spurgux.Canvas;
import fi.jsaarinen.spurgux.Player;

public class Koira extends Hahmo
{
  public Koira(int x, int y)
  {
    super(x, y);
  }

  @Override
  public void visit(Canvas canvas, Player player)
  {
    canvas.renderFeedbackLine("Potkaiset koiraa.");
  }

  @Override
  public char getFigure()
  {
    return 'D';
  }  
}
