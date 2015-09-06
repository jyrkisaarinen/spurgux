package fi.jsaarinen.psypotti.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import fi.jsaarinen.psypotti.db.Util;

@Entity
@Table(name = "USERS")
public class User
{  
  @Column(name = "HETU", length=11, nullable=false)
  private String HETU;

  @Id
  @Column(name = "Username", length=32, nullable=false)
  private String username;
  
  @Column(name = "Name", length=64, nullable=false)
  private String name;
  
  @Column(name = "PasswordSHA1Base64", length=64, nullable=false)
  private String password;

  @Column(name = "Role", nullable=false)
  private int role;
  
  @Column(name = "Title", length=32, nullable=false)
  private String title;
  
  public static final int ROLE_DOCTOR = 1;
  public static final int ROLE_NURSE = 2;
  
  public User()
  {
    super();
  }

  public User(String HETU, String username, String name, String title, String password, int role)
  {
    super();
    this.HETU = HETU;
    this.username = username;
    this.name = name;
    this.title  = title;
    this.password = Util.getSHA1PasswordBase64(password);
    this.role = role;
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.HETU == null) ? 0 : this.HETU.hashCode());
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.password == null) ? 0 : this.password.hashCode());
    result = prime * result + this.role;
    result = prime * result + ((this.title == null) ? 0 : this.title.hashCode());
    result = prime * result + ((this.username == null) ? 0 : this.username.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User) obj;
    if (this.HETU == null)
    {
      if (other.HETU != null)
        return false;
    } else if (!this.HETU.equals(other.HETU))
      return false;
    if (this.name == null)
    {
      if (other.name != null)
        return false;
    } else if (!this.name.equals(other.name))
      return false;
    if (this.password == null)
    {
      if (other.password != null)
        return false;
    } else if (!this.password.equals(other.password))
      return false;
    if (this.role != other.role)
      return false;
    if (this.title == null)
    {
      if (other.title != null)
        return false;
    } else if (!this.title.equals(other.title))
      return false;
    if (this.username == null)
    {
      if (other.username != null)
        return false;
    } else if (!this.username.equals(other.username))
      return false;
    return true;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getTitle()
  {
    return this.title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getHETU()
  {
    return this.HETU;
  }
  
  public void setHETU(String HETU)
  {
    this.HETU = HETU;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setUsername(String username)
  {
    this.username = username;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = Util.getSHA1PasswordBase64(password);
  }
  
  public int getRole()
  {
    return this.role;
  }
  
  public void setRole(int role)
  {
    this.role = role;
  }
}
