package fi.jsaarinen.spurgux;

import fi.jsaarinen.spurgux.hahmot.Hahmo;

public class Player extends Hahmo
{
  private double ethanolLevel;
  private double money;
  private int points;
  private boolean onTrip;
  
  public Player(double ethanolLevel, double money, int points, int xpos, int ypos)
  {
    super(xpos, ypos);
    this.ethanolLevel = ethanolLevel;
    this.money = money;
    this.points = points;
    this.onTrip = false;
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

  @Override
  public void visit(Canvas canvas, Player player)
  {   
  }

  @Override
  public char getFigure()
  {
    return '@';
  }  
}
