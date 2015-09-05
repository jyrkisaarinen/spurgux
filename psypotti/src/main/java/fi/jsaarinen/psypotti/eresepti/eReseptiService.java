package fi.jsaarinen.psypotti.eresepti;

import java.io.IOException;

import fi.jsaarinen.psypotti.entities.Prescription;

public interface eReseptiService
{
  public void sendPrescription(Prescription prescription) throws IOException;
}
