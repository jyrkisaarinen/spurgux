package fi.jsaarinen.spurgux.rakennukset;

import java.awt.Rectangle;

import fi.jsaarinen.spurgux.Canvas;

public abstract class AbstractRakennus
{
  private int x, y;
  private int width, height;
  private String name;
  
  public AbstractRakennus()
  {
    this.x = 0;
    this.y = 0;
    this.width = 0;
    this.height = 0;
    this.name = null;
  }
  
  public AbstractRakennus(int x, int y, int width, int height, String name)
  {
    super();
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.name = name;
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

  public int getWidth()
  {
    return this.width;
  }

  public void setWidth(int width)
  {
    this.width = width;
  }

  public int getHeight()
  {
    return this.height;
  }

  public void setHeight(int height)
  {
    this.height = height;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }
  
  public Rectangle getRectangle()
  {
    Rectangle rectangle = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    return rectangle;
  }
  
  public void render(Canvas canvas)
  {
    for (int i = 0; i < this.getHeight(); i++)
    {      
      String row = this.getMap()[i];
      canvas.render(row, this.getX(), i + this.getY());
    }
  }
  
  public abstract String[] getMap();
}
