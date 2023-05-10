package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;

import model.Oder;
import model.Product;
 
public class OderService extends BaseService {

  public static HashMap<Oder,Product> getOder(String iS)
  {
      HashMap<Oder,Product> map = new HashMap<>();
      String  sql = "SELECT * FROM ";

      return map;
  }

  public static void addNewOder(Oder o)
  {
    String sql = "INSERT INTO oder (id_seller, user, id_product, count) VALUES (?,?,?,?);";
    try (
      Connection connection = getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ) {
      preparedStatement.setString(1, o.getIdSeller());
      preparedStatement.setString(2,  o.getUser());
      preparedStatement.setInt(3, o.getIdProduct());
      preparedStatement.setInt(4, o.getCount());
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      //TODO: handle exception
    }
  }

}
