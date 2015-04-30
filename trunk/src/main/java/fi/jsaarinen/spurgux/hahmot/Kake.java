package fi.jsaarinen.spurgux.hahmot;

import fi.jsaarinen.spurgux.Canvas;
import fi.jsaarinen.spurgux.Player;

public class Kake extends Hahmo
{
  public Kake(int x, int y)
  {
    super(x, y);
  }

  @Override
  public void visit(Canvas canvas, Player player)
  {
    canvas.renderFeedbackLine("Kake pummaa kaljaa!");
  }

  @Override
  public char getFigure()
  {
    return 'K';
  } 
}
