package fi.jsaarinen.spurgux.hahmot;

import fi.jsaarinen.spurgux.Canvas;
import fi.jsaarinen.spurgux.Renderable;
import fi.jsaarinen.spurgux.Steppable;
import fi.jsaarinen.spurgux.Visitable;

public abstract class Hahmo implements Renderable, Steppable, Visitable
{
  private int x, y;
  private char figure;

  public Hahmo(int x, int y, char figure)
  {
    super();
    this.x = x;
    this.y = y;
    this.figure = figure;
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

  public char getFigure()
  {
    return this.figure;
  }

  @Override
  public void render(Canvas canvas)
  {  
    canvas.render(figure, x, y);
  }  
}
