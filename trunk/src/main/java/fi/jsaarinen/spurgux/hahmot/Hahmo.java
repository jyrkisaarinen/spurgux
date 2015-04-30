package fi.jsaarinen.spurgux.hahmot;

import fi.jsaarinen.spurgux.Canvas;
import fi.jsaarinen.spurgux.Player;

public abstract class Hahmo
{
  private int x, y;
  public abstract void visit(Canvas canvas, Player player);
  public abstract char getFigure();
  
  public Hahmo(int x, int y)
  {
    super();
    this.x = x;
    this.y = y;
  }
  public int getX()
  {
    return this.x;
  }
  
  public void setX(int x)
  {
    this.x = x;
  }
  
  public int getY()
  {
    return this.y;
  }
  
  public void setY(int y)
  {
    this.y = y;
  }
}
