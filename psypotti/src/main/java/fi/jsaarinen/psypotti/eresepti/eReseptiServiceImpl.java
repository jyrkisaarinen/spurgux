package fi.jsaarinen.psypotti.eresepti;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import fi.jsaarinen.psypotti.entities.Prescription;

public class eReseptiServiceImpl implements eReseptiService
{
  private OutputStream outputStream;
  
  public eReseptiServiceImpl()
  {
    super();
    try
    {
      this.outputStream = new FileOutputStream("prescriptions.txt");
    } 
    catch (FileNotFoundException e)
    {
      throw new RuntimeException(e);
    }
  }


  @Override
  public void sendPrescription(Prescription prescription) throws IOException
  {    
    this.outputStream.write(prescription.toString().getBytes("UTF-8"));
  }
}
