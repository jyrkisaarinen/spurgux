package fi.jsaarinen.psypotti.web;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

public class LoginForm extends Form 
{
  private TextField<String> usernameField;
  private PasswordTextField passwordField;
  private Label loginStatus;
  
  public LoginForm(String id) {
    super(id);

    this.usernameField = new TextField<String>("loginUsername", Model.of(""));
    this.passwordField = new PasswordTextField("loginPassword", Model.of(""));      
    this.loginStatus = new Label("loginStatus", Model.of(""));
    
    this.add(usernameField);
    this.add(passwordField);
    this.add(new Button("loginSubmit"));
    this.add(loginStatus);
  }

  public final void onSubmit() 
  {
    String username = (String)usernameField.getDefaultModelObject();
    String password = (String)passwordField.getDefaultModelObject();

    if(username.equals("test") && password.equals("test"))
      loginStatus.setDefaultModelObject("Congratulations!");
    else
      loginStatus.setDefaultModelObject("Wrong username or password!");     
  }
}
