package fi.jsaarinen.spurgux;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class Canvas
{
  private int width, height;
  private int fontSize;
  private char[] canvas;
  private String message;
  
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
    this.canvas = new char[width * height];
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
  
  public void renderMessage()
  {
    char[] stringData = this.message.toCharArray();
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
    graphics2d.setFont(new Font(Font.MONOSPACED, Font.PLAIN , this.fontSize));
    graphics2d.drawChars(this.canvas, 0, this.canvas.length, 0, 0);
    bufferedImage.flush();
    ImageIO.write(bufferedImage, "PNG", outputStream);
  }

  public void setMessage(String message)
  {
    this.message = message;
  }
}