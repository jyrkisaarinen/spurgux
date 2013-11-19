package fi.jsaarinen.spurgux.characters;

import fi.jsaarinen.spurgux.Canvas;
import fi.jsaarinen.spurgux.Renderable;

public interface Shape extends Renderable
{
  public char getCharacterCode();
  public void step(Canvas canvas, Player player);
}
