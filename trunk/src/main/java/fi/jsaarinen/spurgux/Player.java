package fi.jsaarinen.spurgux;

public class Player
{
  private double ethanolLevel;
  private double money;
  private int points;
  private int xpos, ypos;
    
  public Player(double ethanolLevel, double money, int points, int xpos, int ypos)
  {
    super();
    this.ethanolLevel = ethanolLevel;
    this.money = money;
    this.points = points;
    this.xpos = xpos;
    this.ypos = ypos;
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
  
  public int getXpos()
  {
    return this.xpos;
  }
  
  public void setXpos(int xpos)
  {
    this.xpos = xpos;
  }
  
  public int getYpos()
  {
    return this.ypos;
  }
  
  public void setYpos(int ypos)
  {
    this.ypos = ypos;
  }  
}
