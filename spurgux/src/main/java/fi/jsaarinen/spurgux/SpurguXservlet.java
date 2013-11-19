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
    Canvas canvas = new Canvas(20, 10, 18);
    canvas.render("0123456789", 0, 0);
    canvas.render("9876543210", 0, 1);
    resp.setHeader("Cache-Control", "no-cache");
    resp.setContentType(canvas.getMIMEType());
    OutputStream outputStream = resp.getOutputStream();
    canvas.render(outputStream);
    outputStream.close();
	}
	
}
