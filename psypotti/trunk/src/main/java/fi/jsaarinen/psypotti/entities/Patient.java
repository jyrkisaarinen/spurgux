package fi.jsaarinen.psypotti.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PATIENTS")
public class Patient
{
  @Id
  @Column(name = "HETU", length=11, nullable=false)
  private String HETU;
  
  @Column(name = "Name", length=64, nullable=false)
  private String name;
  
  @Column(name = "Phone", length=20, nullable=true)
  private String phone;
  
  @Column(name = "Address", length=64, nullable=false)
  private String address;
  
  @Column(name = "ZipCode", length=20, nullable=false)
  private String zipCode;
  
  @Column(name = "Country", length=20, nullable=false)
  private String country;

  public Patient(String HETU, String name, String phone, String address, String zipCode, String country)
  {
    super();
    this.HETU = HETU;
    this.name = name;
    this.phone = phone;
    this.address = address;
    this.zipCode = zipCode;
    this.country = country;
  }

  public Patient()
  {
  }

  public String getSOTU()
  {
    return this.HETU;
  }

  public void setSOTU(String sOTU)
  {
    this.HETU = sOTU;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getPhone()
  {
    return this.phone;
  }

  public void setPhone(String phone)
  {
    this.phone = phone;
  }

  public String getAddress()
  {
    return this.address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String getZipCode()
  {
    return this.zipCode;
  }

  public void setZipCode(String zipCode)
  {
    this.zipCode = zipCode;
  }

  public String getCountry()
  {
    return this.country;
  }

  public void setCountry(String country)
  {
    this.country = country;
  }
}
