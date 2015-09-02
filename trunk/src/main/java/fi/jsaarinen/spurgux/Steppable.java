package fi.jsaarinen.spurgux;

public interface Steppable
{
  boolean canBeSteppedOver(Player player, int x, int y);
}
