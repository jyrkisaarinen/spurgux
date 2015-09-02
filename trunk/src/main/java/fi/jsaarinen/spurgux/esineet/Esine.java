package fi.jsaarinen.spurgux.esineet;

import fi.jsaarinen.spurgux.Pickable;
import fi.jsaarinen.spurgux.Renderable;
import fi.jsaarinen.spurgux.Steppable;
import fi.jsaarinen.spurgux.Visitable;

public abstract class Esine implements Pickable, Visitable, Steppable, Renderable
{
  private int x, y;
  private char figure;
  
  public Esine(int x, int y, char figure)
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
}