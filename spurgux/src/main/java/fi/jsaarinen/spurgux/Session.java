package fi.jsaarinen.spurgux;

import java.util.ArrayList;
import java.util.List;

import fi.jsaarinen.spurgux.characters.Player;
import fi.jsaarinen.spurgux.characters.Shape;
import fi.jsaarinen.spurgux.items.Item;

public class Session
{
  private Canvas canvas;
  private Player player;
  private List<Shape> shapes;
  private List<Item> items;
  
  public Session(int width, int height, int fontSize)
  {
    this.canvas = new Canvas(width, height, fontSize);
    this.player = new Player();
    this.shapes = new ArrayList<Shape>();
    this.items = new ArrayList<Item>();
  }; 
}
