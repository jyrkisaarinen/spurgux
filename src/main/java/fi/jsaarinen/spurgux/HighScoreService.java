package fi.jsaarinen.spurgux;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class HighScoreService
{
  private String dbURL;
  private String dbUsername;
  private String dbPassword;
  private MysqlConnectionPoolDataSource dataSource;
  
  public HighScoreService(String dbURL, String dbUsername, String dbPassword) throws SQLException
  {
    super();
    this.dbURL = dbURL;
    this.dbUsername = dbUsername;
    this.dbPassword = dbPassword;    
    this.dataSource = new MysqlConnectionPoolDataSource();
    this.dataSource.setUser(dbUsername);
    this.dataSource.setPassword(dbPassword);
    this.dataSource.setURL(dbURL);
  } 
  
  public void addHighScore(String player, int score) throws SQLException
  {
    Connection connection = null;
    java.sql.PreparedStatement preparedStatement = null;
    try
    {
      connection = this.dataSource.getConnection();
      preparedStatement = connection.prepareStatement("INSERT INTO highscore (player, score) VALUES ('"
                          + player + "', " 
                          + score + ");");
      System.out.println(preparedStatement.toString());
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
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try
    {
      connection = DriverManager.getConnection(this.dbURL, this.dbUsername, this.dbPassword);
      preparedStatement = (PreparedStatement) connection.prepareStatement("SELECT * FROM highscore LIMIT 0," + limit + ";");
      resultSet = preparedStatement.executeQuery();
      System.out.println(resultSet.toString());
      List<HighScoreEntry> scores = new ArrayList<HighScoreEntry>();      
      HighScoreEntry[] highScoreEntries = new HighScoreEntry[scores.size()];
      for (int i = 0; i< scores.size(); i++)
      {
        highScoreEntries[i] = scores.get(i);
      }
      return highScoreEntries;
    }
    finally
    {
      if (resultSet != null)
      {
        resultSet.close();
      }
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
    HighScoreService highScore = new HighScoreService("jdbc:mysql://localhost:3306/spurgux", "root", "root");
    highScore.addHighScore("jorma", 2);
    highScore.addHighScore("aku", 1);
    highScore.addHighScore("kalle", 4);
    highScore.addHighScore("jallu", 10);
    HighScoreEntry[] hse = highScore.getHighScoreEntries(10);
    for (int i = 0; i < hse.length; i++)
    {
      System.out.println(hse[i]);
    }
  }
}
