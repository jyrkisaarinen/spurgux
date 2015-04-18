package fi.jsaarinen.spurgux.rakennukset;

import fi.jsaarinen.spurgux.Canvas;
import fi.jsaarinen.spurgux.Player;

public interface Rakennus
{
  void visit(Player player, Canvas canvas);
}
