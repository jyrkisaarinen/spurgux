package fi.jsaarinen.psypotti.web;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class LoginApplication extends WebApplication
{
  public LoginApplication()
  {
    super();
  }
  
  @Override
  public Class<? extends Page> getHomePage()
  {
    return Login.class;
  }  
}
