package fi.jsaarinen.spurgux;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fi.jsaarinen.spurgux.rakennukset.Alko;

@SuppressWarnings("serial")
public class SpurguXservlet extends HttpServlet
{
  private static byte[] header, footer;

  @Override
  public void init() throws ServletException
  {
    try
    {
      ServletContext servletContext = this.getServletContext();
      InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/header.html");
      header = new byte[inputStream.available()];
      inputStream.read(header);
      inputStream.close();
      
      inputStream = servletContext.getResourceAsStream("/WEB-INF/footer.html");
      footer = new byte[inputStream.available()];
      inputStream.read(footer);
      inputStream.close();     
    } catch (IOException e)
    {
      throw new ServletException(e);
    }
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
  {
    String mode = req.getParameter("mode");
    System.out.println(mode);
    OutputStream outputStream = resp.getOutputStream();
    if (mode.equals("img"))
    {
      long t1 = System.currentTimeMillis();

      Context context;
      HttpSession httpSession = req.getSession(false);
      if (httpSession == null)
      {
        httpSession = req.getSession(true);
        Canvas canvas = new Canvas(60, 40, 16);
        Player player = new Player(1.0, 10, 0, 10, 10);
        context = new Context(canvas, player);
        httpSession.setAttribute("CONTEXT", context);
      }
      context = (Context)httpSession.getAttribute("CONTEXT");
      Canvas canvas = context.getCanvas();
      Player player = context.getPlayer();
      int keyCode = Integer.parseInt(req.getParameter("key"));
      player.step(keyCode, canvas);
      player.render(canvas);
      canvas.renderStatusLine("testi jee " + keyCode);
      Alko alko = new Alko();
      alko.setX(10);
      alko.setY(10);
      alko.render(canvas);
      resp.setContentType(canvas.getMIMEType());
      canvas.render(outputStream);
      outputStream.close();
      long t2 = System.currentTimeMillis();
      this.log("dtime: " + (t2 - t1) + " ms.");
    }
    else
    if (mode.equals("html"))
    {
      resp.setContentType("text/html");
      outputStream.write(header);
      outputStream.write(footer);
      outputStream.close();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException
  {
  }  
}
