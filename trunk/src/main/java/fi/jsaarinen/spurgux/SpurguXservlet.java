package fi.jsaarinen.spurgux;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SpurguXservlet extends HttpServlet
{
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
    Canvas canvas = new Canvas(10, 10, 16);
    canvas.render("testi", 0, 0);
    resp.setContentType(canvas.getMIMEType());
    OutputStream outputStream = resp.getOutputStream();
    canvas.render(outputStream);
    outputStream.close();
	}

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException
  {
  }  
}
