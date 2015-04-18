package fi.jsaarinen.spurgux;

public class Player
{
  private double ethanolLevel;
  private int points;
  private int xpos, ypos;
    
  public Player(double ethanolLevel, int points, int xpos, int ypos)
  {
    super();
    this.ethanolLevel = ethanolLevel;
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
