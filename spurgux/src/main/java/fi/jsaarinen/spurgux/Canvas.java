package fi.jsaarinen.spurgux;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Canvas
{
  private int width, height;
  private int fontSize;
  private byte[] canvas;
  
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
    this.canvas = new byte[this.width * this.height];
    Arrays.fill(this.canvas, (byte)' ');
  }
  
  public void render(byte c, int x, int y)
  {
    this.canvas[this.width * y + x] = c;
  }
  
  public void render(String data, int x, int y)
  {
    try
    {
      byte[] stringData = data.getBytes("US-ASCII");
      System.arraycopy(stringData, 
                       0, 
                       this.canvas, 
                       this.width * y + x, 
                       stringData.length);
    } 
    catch (UnsupportedEncodingException e)
    {
      throw new IllegalArgumentException();
    }
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
    graphics2d.setBackground(Color.BLACK);
    graphics2d.setColor(Color.YELLOW);
    graphics2d.setFont(new Font(Font.MONOSPACED, Font.PLAIN , this.fontSize));

    for (int i = 0; i < this.height; i++)
    {
      int offset = i * this.width;
      int length = this.width;
      int xOffset = 0;
      int yOffset = (i + 1) * this.fontSize;
      graphics2d.drawBytes(this.canvas, 
                           offset, 
                           length, 
                           xOffset, 
                           yOffset);
    }
    //graphics2d.drawBytes(this.canvas, 0, this.width * this.height, this.fontSize, this.fontSize);
    //graphics2d.drawChars(this.canvas, 0, this.canvas.length, 0, 0);
    bufferedImage.flush();
    ImageIO.write(bufferedImage, "PNG", outputStream);
  }

  public void render(char c, int x, int y)
  {
    this.render((byte)c, x, y);
  }
}