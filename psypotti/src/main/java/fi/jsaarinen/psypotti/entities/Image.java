package fi.jsaarinen.psypotti.entities;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IMAGES")
public class Image
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @Column(name = "Image")
  private byte[] image;
  
  @Column(name = "ImageType")
  private int imageType;

  @Column(name = "ImageMIMEType")
  private int imageMimeType;
  
  @Column(name = "Statement")
  private String statement;
  
  @Column(name = "PatientSOTU")
  private String patientSOTU;

  public static final int TYPE_CT = 1;
  public static final int TYPE_MRI = 2;
  public static final int TYPE_RÖNTGEN = 3;
  
  public Image(long id, byte[] image, int imageType, int imageMimeType, String statement, String patientSOTU)
  {
    super();
    this.id = id;
    this.image = image;
    this.imageType = imageType;
    this.imageMimeType = imageMimeType;
    this.statement = statement;
    this.patientSOTU = patientSOTU;
  }
  
  public Image()
  {
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (this.id ^ (this.id >>> 32));
    result = prime * result + Arrays.hashCode(this.image);
    result = prime * result + this.imageMimeType;
    result = prime * result + this.imageType;
    result = prime * result + ((this.patientSOTU == null) ? 0 : this.patientSOTU.hashCode());
    result = prime * result + ((this.statement == null) ? 0 : this.statement.hashCode());
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
    Image other = (Image) obj;
    if (this.id != other.id)
      return false;
    if (!Arrays.equals(this.image, other.image))
      return false;
    if (this.imageMimeType != other.imageMimeType)
      return false;
    if (this.imageType != other.imageType)
      return false;
    if (this.patientSOTU == null)
    {
      if (other.patientSOTU != null)
        return false;
    } else if (!this.patientSOTU.equals(other.patientSOTU))
      return false;
    if (this.statement == null)
    {
      if (other.statement != null)
        return false;
    } else if (!this.statement.equals(other.statement))
      return false;
    return true;
  }

  public long getId()
  {
    return this.id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public byte[] getImage()
  {
    return this.image;
  }

  public void setImage(byte[] image)
  {
    this.image = image;
  }

  public int getImageType()
  {
    return this.imageType;
  }

  public void setImageType(int imageType)
  {
    this.imageType = imageType;
  }

  public int getImageMimeType()
  {
    return this.imageMimeType;
  }

  public void setImageMimeType(int imageMimeType)
  {
    this.imageMimeType = imageMimeType;
  }

  public String getStatement()
  {
    return this.statement;
  }

  public void setStatement(String statement)
  {
    this.statement = statement;
  }

  public String getPatientSOTU()
  {
    return this.patientSOTU;
  }

  public void setPatientSOTU(String patientSOTU)
  {
    this.patientSOTU = patientSOTU;
  }
}
