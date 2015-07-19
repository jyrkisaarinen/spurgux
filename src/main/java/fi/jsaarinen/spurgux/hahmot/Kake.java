package fi.jsaarinen.spurgux.hahmot;

import fi.jsaarinen.spurgux.Canvas;
import fi.jsaarinen.spurgux.Player;

public class Kake extends Hahmo
{
  public Kake(int x, int y)
  {
    super(x, y);
  }

  public void visit(Canvas canvas, Player player)
  {
    canvas.renderFeedbackLine("Kake pummaa kaljaa!");
  }

  public char getFigure()
  {
    return 'K';
  } 
}
