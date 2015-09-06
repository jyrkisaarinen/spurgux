package fi.jsaarinen.psypotti.web;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;

public class Login extends WebPage
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public Login()
  {
    this.add(new Label("login", "Sisäänkirjautuminen"));
//    LoginForm form = new LoginForm("loginForm");
//    this.add(form);
  }
}
