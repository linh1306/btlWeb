package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;

public class UserService extends BaseService   {
  
  // kiểm tra user có trong csdl không
  public static boolean checkUser(String user, String password)
  {
    String sql = "SELECT * FROM user WHERE user=? AND password=?;";
    try (
      Connection connection = getConnection();
      PreparedStatement pStatement = connection.prepareStatement(sql);
    ) {
      pStatement.setString(1, user);
      pStatement.setString(2, password);;
      ResultSet resultSet = pStatement.executeQuery();
      if (resultSet.next())    return true;
      return false;
    } catch (Exception e) {
      //TODO: handle exception
      e.printStackTrace();
    }

    return false;
  }

  // tạo user mới
  public static void createUser(User user)
  {
    String sql ="INSERT INTO user(user,password,email,name,address,phone) values (?,?,?,?,?,?);";
    try (
      Connection connection = getConnection();
      PreparedStatement pStatement = connection.prepareStatement(sql);
    ) {
      pStatement.setString(1, user.getUser());
      pStatement.setString(2, user.getPassword());
      pStatement.setString(3, user.getEmail());
      pStatement.setString(4, user.getName());
      pStatement.setString(5, user.getAddress());
      pStatement.setString(6, user.getPhone());
      pStatement.executeUpdate();
    } catch (Exception e) {
      //TODO: handle exception
    }
  }

  // gọi ra user chỉ định

  public static User getUser(String u)
  {
    User use = new User("", "", "", "", "", "");
    String sql = "SELECT * FROM user WHERE user=?;";
    try (
      Connection connection = getConnection();
      PreparedStatement pStatement = connection.prepareStatement(sql);
    ) {
      pStatement.setString(1, u);
      ResultSet resultSet = pStatement.executeQuery();
      resultSet.next();
      String user = resultSet.getString("user");
      String password = resultSet.getString("password");
      String email = resultSet.getString("email");
      String name = resultSet.getString("name");
      String address = resultSet.getString("address");
      String phone = resultSet.getString("phone");

      User user2 =  new User(email, user, password, name, address, phone);
      return user2;

    } catch (Exception e) {
      //TODO: handle exception
    }

    return use;
  }

}
