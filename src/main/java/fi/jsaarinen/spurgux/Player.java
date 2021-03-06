package fi.jsaarinen.spurgux;

import fi.jsaarinen.spurgux.hahmot.Hahmo;

public class Player extends Hahmo
{
  private double ethanolLevel;
  private double money;
  private int points;
  private int wellBeing;
  
  private boolean onTrip;
  
  public Player(double ethanolLevel, double money, int points, int xpos, int ypos)
  {
    super(xpos, ypos, '@');
    this.ethanolLevel = ethanolLevel;
    this.money = money;
    this.points = points;
    this.onTrip = false;
  }
  
  public int getWellBeing()
  {
    return this.wellBeing;
  }

  public void setWellBeing(int wellBeing)
  {
    this.wellBeing = wellBeing;
  }

  public double getEthanolLevel()
  {
    return this.ethanolLevel;
  }
  
  public void setEthanolLevel(double ethanolLevel)
  {
    this.ethanolLevel = ethanolLevel;
  }
    
  public double getMoney()
  {
    return this.money;
  }
  
  public void setMoney(double money)
  {
    this.money = money;
  }
  
  public int getPoints()
  {
    return this.points;
  }
  
  public void setPoints(int points)
  {
    this.points = points;
  }

  public boolean isOnTrip()
  {
    return this.onTrip;
  }

  public void setOnTrip(boolean onTrip)
  {
    this.onTrip = onTrip;
  }

  public void visit(Player player, Canvas canvas)
  {   
    throw new IllegalArgumentException("Player can't visit itself!");
  }

  public char getFigure()
  {
    return '@';
  }

  public void step(int keyCode, Canvas canvas)
  {
    int x = this.getX();
    int y = this.getY();
    switch (keyCode)
    {
      case 1:
        x--;
        y++;
        break;
        
      case 2:
        y++;
        break;
        
      case 3:
        x++;
        y++;
        break;
        
      case 4:      
        x--;
        break;
        
      case 5:
        break;
        
      case 6:
        x++;
        break;
        
      case 7:
        x--;
        y--;
        break;
        
      case 8:
        y--;
        break;
        
      case 9:
        x++;
        y++;
        break;
        
      default:
        break;
    }
    
    if (canvas.canBeSteppedOver(this, x, y))
    {
      this.setX(x);
      this.setY(y);
    }
  }

  @Override
  public boolean canBeSteppedOver(Player player, int x, int y)
  {
    throw new IllegalStateException("Player can't step over him/herself");
  }

  /**
   * Chain of responsibility pattern.
   */
  @Override
  public void render(Canvas canvas)
  {
    canvas.render(this.getFigure(), this.getX(), this.getY());
  }
}
