package fi.jsaarinen.spurgux;

public class HighScoreEntry
{
  private String player;
  private int score;
  
  public HighScoreEntry(String player, int score)
  {
    super();
    this.player = player;
    this.score = score;
  }
  
  public String getPlayer()
  {
    return this.player;
  }
  
  public void setPlayer(String player)
  {
    this.player = player;
  }
  
  public int getScore()
  {
    return this.score;
  }
  
  public void setScore(int score)
  {
    this.score = score;
  }
}
