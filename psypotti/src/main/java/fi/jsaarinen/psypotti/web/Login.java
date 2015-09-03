package fi.jsaarinen.psypotti.web;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;

public class Login<T> extends WebPage
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public Login()
  {
    Form<T> form = new Form<T>("login-form");
    this.add(new Label("label", "testi"));
  }
}
