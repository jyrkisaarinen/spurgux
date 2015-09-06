package fi.jsaarinen.psypotti.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LABWORKS")
public class LabWork
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
}
