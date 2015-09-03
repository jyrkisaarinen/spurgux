package fi.jsaarinen.psypotti.db;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import fi.jsaarinen.psypotti.entities.Image;
import fi.jsaarinen.psypotti.entities.Patient;
import fi.jsaarinen.psypotti.entities.User;

public class DatabaseManager implements DatabaseOperations
{
  private EntityManager entityManager;
  
  private final static DatabaseManager SINGLETON = new DatabaseManager();
  
  public static DatabaseManager getInstance()
  {
    return SINGLETON;
  }
  
  private DatabaseManager()
  {
    this.entityManager = Persistence.createEntityManagerFactory("psypotti").createEntityManager();
  }

  public User loadUser(String SOTU)
  {
    User user = this.entityManager.find(User.class, SOTU);
    return user;
  }

  public void saveUser(User user)
  {
    this.entityManager.persist(user);   
  } 

  public void deleteUser(User user)
  {
    this.entityManager.remove(user);
 
  }

  public Patient loadPatient(String SOTU)
  {
    Patient patient = this.entityManager.find(Patient.class, SOTU);
    return patient;
  }

  public void savePatient(Patient patient)
  {
    this.entityManager.persist(patient);   
  }

  public void deletePatient(Patient patient)
  {
    this.entityManager.remove(patient); 
  } 
  
  public Image loadImage(long id)
  {
    Image image = this.entityManager.find(Image.class, id);
    return image;
  }

  public void saveImage(Image image)
  {
    this.entityManager.persist(image);   
  }

  public void deleteImage(Image image)
  {
    this.entityManager.remove(image);      
  } 
}
