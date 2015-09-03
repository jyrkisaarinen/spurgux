package fi.jsaarinen.psypotti.db;

import fi.jsaarinen.psypotti.entities.Image;
import fi.jsaarinen.psypotti.entities.Patient;
import fi.jsaarinen.psypotti.entities.User;

public interface DatabaseOperations
{
  public User loadUser(String SOTU);
  public void saveUser(User user);
  public void deleteUser(User user);
  
  public Patient loadPatient(String SOTU);
  public void savePatient(Patient patient);
  public void deletePatient(Patient patient);

  public Image loadImage(long id);
  public void saveImage(Image image);
  public void deleteImage(Image image);
}
