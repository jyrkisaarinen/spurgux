package fi.jsaarinen.psypotti.entities;

import java.sql.Date;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
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
  
  @Column(name = "Image", nullable=false)
  private byte[] image;
  
  @Column(name = "ImageType", nullable=false)
  private int imageType;
  
  @Column(name="Date", nullable=false)
  private Date date;

  @Column(name = "ImageMIMEType", length=20, nullable=false)
  private String imageMimeType;
  
  @Column(name = "Statement", length=2000, nullable=false)
  private String statement;
  
  @Column(name = "PatientHETU", length=11, nullable=false)
  private String patientHETU;

  public static final int TYPE_CT = 1;
  public static final int TYPE_MRI = 2;
  public static final int TYPE_RÖNTGEN = 3;
  public static final int TYPE_ULTRASOUND = 4;
  
  
  public Image(long id, byte[] image, int imageType, String imageMimeType, String statement, String patientHETU)
  {
    super();
    this.id = id;
    this.image = image;
    this.imageType = imageType;
    this.imageMimeType = imageMimeType;
    this.statement = statement;
    this.patientHETU = patientHETU;
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
    result = prime * result + ((this.imageMimeType == null) ? 0 : this.imageMimeType.hashCode());
    result = prime * result + this.imageType;
    result = prime * result + ((this.patientHETU == null) ? 0 : this.patientHETU.hashCode());
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
    if (this.imageMimeType == null)
    {
      if (other.imageMimeType != null)
        return false;
    } else if (!this.imageMimeType.equals(other.imageMimeType))
      return false;
    if (this.imageType != other.imageType)
      return false;
    if (this.patientHETU == null)
    {
      if (other.patientHETU != null)
        return false;
    } else if (!this.patientHETU.equals(other.patientHETU))
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

  public String getImageMimeType()
  {
    return this.imageMimeType;
  }

  public void setImageMimeType(String imageMimeType)
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

  public String getPatientHETU()
  {
    return this.patientHETU;
  }

  public void setPatientHETU(String patientHETU)
  {
    this.patientHETU = patientHETU;
  }
}
