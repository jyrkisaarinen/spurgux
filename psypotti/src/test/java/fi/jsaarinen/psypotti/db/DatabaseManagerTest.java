package fi.jsaarinen.psypotti.db;

import fi.jsaarinen.psypotti.db.DatabaseManager;
import fi.jsaarinen.psypotti.db.DatabaseOperations;
import fi.jsaarinen.psypotti.db.Util;
import fi.jsaarinen.psypotti.entities.Patient;
import fi.jsaarinen.psypotti.entities.User;
import junit.framework.TestCase;

public class DatabaseManagerTest extends TestCase
{
  private DatabaseOperations databaseOperations;
  
  public DatabaseManagerTest()
  {  
  }
  
  public void setUp()
  {
    this.databaseOperations = DatabaseManager.getInstance();
  }
  
  public void testUserLoadAndSave()
  {
    String sotu = "123456-7890";
    String password = "kukka";
    User user = new User(sotu, "jsaarinen", "Jyrki Saarinen", "Tri", password, User.ROLE_NURSE);
    this.databaseOperations.saveUser(user);
    User another = this.databaseOperations.loadUser(sotu);
    String base64password = Util.getSHA1PasswordBase64(password);
    String anotherPassword = another.getPassword();
    System.out.println(another);
    assertTrue(base64password.equals(anotherPassword));
  }
  
  public void testPatientLoadAndSave()
  {
    String sotu = "123456-7890";
    Patient patient = new Patient(sotu, "Jyrki Saarinen", "0501234567", "Valimotie 2", "00580", "Suomi"); 
    this.databaseOperations.savePatient(patient);
    Patient another = this.databaseOperations.loadPatient(sotu);
    System.out.println(another);
  }
}
