package fi.jsaarinen.spurgux;

public class Context
{
  private Canvas canvas;
  private Player player;
  
  public Context(Canvas canvas, Player player)
  {
    super();
    this.canvas = canvas;
    this.player = player;
  }

  public Canvas getCanvas()
  {
    return this.canvas;
  }

  public Player getPlayer()
  {
    return this.player;
  }
}
