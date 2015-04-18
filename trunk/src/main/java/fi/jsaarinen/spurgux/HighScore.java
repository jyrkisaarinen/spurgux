package fi.jsaarinen.spurgux;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class HighScore
{
  private String dbURL;
  private String dbUsername;
  private String dbPassword;
  
  public HighScore(String dbURL, String dbUsername, String dbPassword) throws SQLException
  {
    super();
    this.dbURL = dbURL;
    this.dbUsername = dbUsername;
    this.dbPassword = dbPassword;    
  } 
  
  public void addHighScore(String player, int score) throws SQLException
  {
    Connection connection = null;
    java.sql.PreparedStatement preparedStatement = null;
    try
    {
      connection = DriverManager.getConnection(this.dbURL,this.dbUsername, this.dbPassword);
      preparedStatement = connection.prepareStatement("INSERT INTO highscore (player, highscore) VALUES (" + player + ", " + score + ")");
      int n = preparedStatement.executeUpdate();
      if (n != 1)
      {
        throw new SQLException();
      }
    }
    finally
    {
      if (preparedStatement != null)
      {
        preparedStatement.close();
      }
      if (connection != null)
      {
        connection.close();
      }
    }
  }
  
  public static void main(String[] args) throws SQLException
  {
    HighScore highScore = new HighScore("jdbc:mysql://localhost:3306/spurgux", "root", "root");
    highScore.addHighScore("jorma", 2);
  }
}
