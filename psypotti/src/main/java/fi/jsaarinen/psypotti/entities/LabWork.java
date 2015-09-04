package fi.jsaarinen.psypotti.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LABWORKS")
public class LabWork
{
  @Id
  private long id;
}
