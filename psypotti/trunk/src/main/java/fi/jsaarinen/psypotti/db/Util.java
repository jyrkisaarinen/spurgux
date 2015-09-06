package fi.jsaarinen.psypotti.db;

import java.security.MessageDigest;

import org.apache.wicket.util.crypt.Base64;

import fi.jsaarinen.psypotti.entities.User;

public class Util
{
  /**
   * Returns the Base64 encoded version of the SHA-1 hash of the password string.
   * 
   * @param password
   * @return
   */
  public static String getSHA1PasswordBase64(String password)
  {
    try
    {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
      byte[] digest = messageDigest.digest(password.getBytes("UTF-8"));
      return Base64.encodeBase64String(digest);
    } 
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
  }
  
  /**
   * Returns if the user identified by SOTU matches with password in the database table USERS.
   * 
   * @param SOTU
   * @param password
   * @return
   */
  public static boolean isAuthenticated(String SOTU, String password)
  {
    User user = DatabaseManager.getInstance().loadUser(SOTU);
    return user.getPassword().equals(getSHA1PasswordBase64(password));
  }
}
