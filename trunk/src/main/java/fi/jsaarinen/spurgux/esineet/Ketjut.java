package fi.jsaarinen.spurgux.esineet;

import fi.jsaarinen.spurgux.Canvas;
import fi.jsaarinen.spurgux.Player;

public class Ketjut extends Esine
{ 
  public Ketjut(int x, int y, char figure)
  {
    super(x, y, figure);
  }
  
  public void pick(Player player)
  {
  }

  @Override
  public void visit(Player player, Canvas canvas)
  {
    canvas.renderStatusLine("Poimit ketjut talteen");
    canvas.removeObject(this);
  }

  @Override
  public boolean canBeSteppedOver(int x, int y)
  {
    return true;
  }

  
  @Override
  public void render(Canvas canvas)
  {
    canvas.render(this.getFigure(), this.getX(), this.getY());
  }
  
  
}
