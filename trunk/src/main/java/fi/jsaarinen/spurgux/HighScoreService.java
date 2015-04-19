package fi.jsaarinen.spurgux;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.PreparedStatement;

public class HighScoreService
{
  private String dbURL;
  private String dbUsername;
  private String dbPassword;
  
  public HighScoreService(String dbURL, String dbUsername, String dbPassword) throws SQLException
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
      preparedStatement = connection.prepareStatement("INSERT INTO highscore (player, highscore) VALUES (" 
                          + player + ", " 
                          + score + ")");
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
  
  public HighScoreEntry[] getHighScoreEntries(int limit) throws SQLException
  {
    if (limit <= 0)
    {
      throw new IllegalArgumentException();
    }
    Connection connection = null;
    java.sql.PreparedStatement preparedStatement = null;
    try
    {
      connection = DriverManager.getConnection(this.dbURL,this.dbUsername, this.dbPassword);
      preparedStatement = connection.prepareStatement("SELECT * FROM highscore LIMIT 0," + limit + " ORDER BY highscore;");
      ResultSet resultSet = preparedStatement.executeQuery();
      List<HighScoreEntry> scores = new LinkedList<HighScoreEntry>();      
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
    return null;
  }
  
  public static void main(String[] args) throws SQLException
  {
    HighScoreService highScore = new HighScoreService("jdbc:mysql://localhost:3306/spurgux", "root", "root");
    highScore.addHighScore("jorma", 2);
  }
}
