package fi.jsaarinen.spurgux;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

import fi.jsaarinen.spurgux.esineet.Esine;
import fi.jsaarinen.spurgux.hahmot.Hahmo;
import fi.jsaarinen.spurgux.rakennukset.AbstractRakennus;

public class Canvas implements Steppable
{
  private int width, height;
  private int fontSize;
  private char[] canvas;
  private List<AbstractRakennus> buildings;
  private List<Hahmo> characters;
  private List<Esine> items;
  
  public Canvas(int width, int height, int fontSize)
  {
    if (width <= 0 || height <= 0 || fontSize <= 0)
    {
      throw new IllegalArgumentException();
    }
    this.width = width;
    this.height = height;
    this.fontSize = fontSize;
    this.reset();
  }
  
  public void reset()
  {
    this.canvas = new char[this.width * this.height];
    this.buildings = new LinkedList<AbstractRakennus>();
    this.characters = new LinkedList<Hahmo>();
    this.items = new LinkedList<Esine>();
  }
  
  public void addBuilding(AbstractRakennus rakennus)
  {
    this.buildings.add(rakennus);
  }
  
  public void addCharacter(Hahmo hahmo)
  {
    this.characters.add(hahmo);
  }
  
  public void render(char c, int x, int y)
  {
    this.canvas[x * y + x] = c;
  }
  
  public void render(String data, int x, int y)
  {
    if (x < 0)
    {
      throw new IllegalArgumentException("x < 0");
    }
    if (x >= this.width)
    {
      throw new IllegalArgumentException("x >= width");
    }
    
    if (y < 0)
    {
      throw new IllegalArgumentException("y < 0");
    }
    if (y >= this.height)
    {
      throw new IllegalArgumentException("y >= height");
    }
    
    char[] stringData = data.toCharArray();
    System.arraycopy(stringData, 
                     0, 
                     this.canvas, 
                     x * y + x, 
                     stringData.length);
  }
  
  public void renderStatusLine(String message)
  {
    char[] stringData = message.toCharArray();
    System.arraycopy(stringData, 
                     0, 
                     this.canvas, 
                     0, 
                     stringData.length);
  }
  
  public String getMIMEType()
  {
    return "image/png";
  }

  public void render(OutputStream outputStream) throws IOException
  {
    BufferedImage bufferedImage = new BufferedImage(this.width * this.fontSize, 
                                                    this.height * this.fontSize, 
                                                    BufferedImage.TYPE_BYTE_BINARY);
    Graphics2D graphics2d = bufferedImage.createGraphics();
    graphics2d.setColor(Color.YELLOW);
    graphics2d.setFont(new Font(Font.MONOSPACED, Font.PLAIN, this.fontSize));
    graphics2d.drawChars(this.canvas, 0, this.canvas.length, 0, bufferedImage.getHeight());
    bufferedImage.flush();
    ImageIO.write(bufferedImage, "PNG", outputStream);
  }

  public boolean canBeSteppedOver(int x, int y)
  {
    for (AbstractRakennus r : this.buildings)
    {
      if (r.canBeSteppedOver(x, y))
      {
        return true;
      }
    }
    for (Hahmo h : this.characters)
    {
      if (h.canBeSteppedOver(x, y))
      {
        return true;
      }
    }
    for (Esine e : this.items)
    {
      if (e.canBeSteppedOver(x, y))
      {
        return true;
      }
    }
    return false;
  }

  public void removeCharacter(Hahmo hahmo)
  {    
    boolean removed = this.characters.remove(hahmo);
    if (!removed)
    {
      throw new IllegalArgumentException("Characters is not in canvas!");
    }
  }

  public void removeObject(Esine item)
  {    
    boolean removed = this.items.remove(item);
    if (!removed)
    {
      throw new IllegalArgumentException("Item is not in canvas!");
    }
  }
}