package fi.jsaarinen.spurgux.buildings;

import fi.jsaarinen.spurgux.Canvas;
import fi.jsaarinen.spurgux.Player;

public interface Building
{
  void visit(Player player, Canvas canvas);
}
