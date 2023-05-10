package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Seller;

public class SellerService extends BaseService {

  public static boolean checkSeller(String u)
  {
    String sql=" SELECT * FROM seller WHERE user=?";
    try (
      Connection connection = getConnection();
      PreparedStatement pStatement = connection.prepareStatement(sql);
    ) {
      pStatement.setString(1, u);
      ResultSet resultSet = pStatement.executeQuery();
      if (resultSet.next()) return true;
      
    } catch (Exception e) {
      //TODO: handle exception
    }

    return false;
  }


  // tao nguoi ban hang moi
  public static void createSeller(Seller seller)
  {
    String sql="INSERT INTO seller(user, id_seller, name, address, phone) values (?,?,?,?,?);";
    try (
      Connection connection = getConnection();
      PreparedStatement pStatement = connection.prepareStatement(sql);
    ) {
      pStatement.setString(1, seller.getUser());
      pStatement.setString(2, seller.getIdSeller());
      pStatement.setString(3, seller.getName());
      pStatement.setString(4, seller.getAddress());
      pStatement.setString(5, seller.getPhone());
      pStatement.executeUpdate();
    } catch (Exception e) {
      //TODO: handle exception
    }
  }

  // gọi tài khoản bán hàng 
  public static Seller getSeller(String u)
  {
    Seller s= new Seller("", "", "", "", "");
    String sql = "SELECT * FROM seller WHERE user =?;";
    try (
      Connection connection = getConnection();
      PreparedStatement pStatement = connection.prepareStatement(sql); 

    ) {
      pStatement.setString(1, u);
      ResultSet resultSet = pStatement.executeQuery();
      resultSet.next();
      String user = resultSet.getString("user");
      String idSeller = resultSet.getString("id_seller");
      String name = resultSet.getString("name");
      String address = resultSet  .getString("address");
      String phone = resultSet.getString("phone");
      Seller seller = new Seller(user, idSeller, name, address, phone);
      return seller;
    } catch (Exception e) {
      //TODO: handle exception
    }
    return s;
  }

}
