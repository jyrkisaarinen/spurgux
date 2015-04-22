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

import fi.jsaarinen.spurgux.hahmot.Hahmo;
import fi.jsaarinen.spurgux.rakennukset.Rakennus;

public class Canvas
{
  private int width, height;
  private int fontSize;
  private char[] canvas;
  private List<Rakennus> buildings;
  private List<Hahmo> characters;
  
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
    this.buildings = new LinkedList<Rakennus>();
    this.characters = new LinkedList<Hahmo>();
  }
  
  public void addBuilding(Rakennus rakennus)
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
    char[] stringData = data.toCharArray();
    System.arraycopy(stringData, 
                     0, 
                     this.canvas, 
                     x * y + x, 
                     stringData.length);
  }
  
  public void renderFeedbackLine(String message)
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
}