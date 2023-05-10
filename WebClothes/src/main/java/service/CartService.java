package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import model.Cart;
import model.Product;
 
public class CartService extends BaseService {

  public static void addToCart(Cart cart)
  {
    String sql = "INSERT INTO cart(user,id_product,count) value (?,?,?);";
    try (
      Connection connection = getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ) {
      preparedStatement.setString(1, cart.getUser());
      preparedStatement.setInt(2, cart.getIdProduct());
      preparedStatement.setInt(3, cart.getCount());
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      //TODO: handle exception
    }
  }

  public static void updateCart(Cart cart)
  {
    String sql = "UPDATE cart SET count="+cart.getCount()+" where id_product="+cart.getIdProduct()+";";
    try (
      Connection connection = getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ) {
      preparedStatement.execute();
    } catch (Exception e) {
      //TODO: handle exception
    }
  }

  public static boolean checkCart(int iP)
  {
    String sql = "select * from cart where id_product =?;";
    try (
      Connection connection = getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ) {
      preparedStatement.setInt(1, iP);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) return true;
    } catch (Exception e) {
      //TODO: handle exception
    }
    return false;
  }

  public static int getCountCart(int iP)
  {
    String sql = "SELECT * FROM cart WHERE id_product=?;";
    try (
      Connection connection = getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ) {
      preparedStatement.setInt(1, iP);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) return resultSet.getInt("count");
    } catch (Exception e) {
      //TODO: handle exception
    }
    return 1;
  }

  

  


  public static HashMap<Product,Integer> getProductCart(String user)
  {
    HashMap<Product,Integer> map = new HashMap<>();
    String sql = "SELECT * FROM cart, product WHERE cart.id_product = product.id_product and cart.user = ?;";
    try (
      Connection connection = getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ) {
      preparedStatement.setString(1,user);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next())
      {
        int idProduct = resultSet.getInt("id_product");
        String idSeller = resultSet.getString("id_seller");
        String img = resultSet.getString("img");
        String name= resultSet.getString("name");
        String description = resultSet.getString("description");
        String company = resultSet.getString("company");
        String detail = resultSet.getString("detail");
        int price = resultSet.getInt("price");
        int count = resultSet.getInt("count");

        Product product = new Product(idProduct,idSeller,img,name,company,description,detail,price);
        map.put(product, count);
      }
    } catch (Exception e) {
      //TODO: handle exception
    }
    return map;
  }

}
