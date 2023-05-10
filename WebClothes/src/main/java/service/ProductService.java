package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Product;

public class ProductService extends BaseService {


  public static ArrayList<Product> getAll()
  {
    ArrayList<Product> list = new ArrayList<>();
    String sql = "SELECT * FROM product ;";
    try (
      Connection connection = getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ) {
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next())
      {
        int idProduct =  resultSet.getInt("id_product");
        String idSeller = resultSet.getString("id_seller");
        String img = resultSet.getString("img");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        String detail = resultSet.getString("detail");
        String company = resultSet.getString("company");
        int price =resultSet.getInt("price");
        Product product = new Product(idProduct, idSeller, img, name, company, description, detail, price);

        list.add(product);

      }
    } catch (Exception e) {
      //TODO: handle exception
      e.printStackTrace();
    }
    return list;
  }

  public static ArrayList<Product> searchProduct(String search)
  {
    ArrayList<Product> list = new ArrayList<>();
    String sql = "SELECT * FROM product WHERE name LIKE \"%"+search+"%\" OR company LIKE \"%"+search+"%\" OR description LIKE \"%"+search+"%\" ;";
    try (
      Connection connection = getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ) {
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next())
      {
        int idProduct =  resultSet.getInt("id_product");
        String idSeller = resultSet.getString("id_seller");
        String img = resultSet.getString("img");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        String detail = resultSet.getString("detail");
        String company = resultSet.getString("company");
        int price =resultSet.getInt("price");
        Product product = new Product(idProduct, idSeller, img, name, company, description, detail, price);

        list.add(product);

      }
    } catch (Exception e) {
      //TODO: handle exception
      e.printStackTrace();
    }
    return list;
  }

  public static void newProduct(Product product)
  {
    String sql = "INSERT INTO product(id_seller,img,name,description,company,detail,price) VALUES (?,?,?,?,?,?,?);";
    try (
      Connection connection = getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ) {
      preparedStatement.setString(1, product.getIdSeller());
      preparedStatement.setString(2, product.getImg());
      preparedStatement.setString(3, product.getName());
      preparedStatement.setString(4, product.getDescription());
      preparedStatement.setString(5, product.getCompany());
      preparedStatement.setString(6, product.getDetail());
      preparedStatement.setInt(7, product.getPrice());
      preparedStatement.executeUpdate();
      
    } catch (Exception e) {
      
    }
  }

  public static ArrayList<Product> sellerProduct(String iS)
  {
    ArrayList<Product> list = new ArrayList<>();
    String sql = "SELECT * FROM product WHERE id_seller=?";
    try (
      Connection connection = getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ) {
      preparedStatement.setString(1, iS);
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

        Product product = new Product(idProduct,idSeller,img,name,company,description,detail,price);
        list.add(product);
      }
    } catch (Exception e) {
      //TODO: handle exception
      e.printStackTrace();
    }
    return list;
  }

// goi ra product co id chi dinh
  public static Product getProduct(int iP)
  {
    Product pro = new Product("", "", "", "", "", "", 0);
    String sql = "SELECT * FROM product WHERE id_product=?";
    try (
      Connection connection = getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ) {
      preparedStatement.setInt(1, iP);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next())
      {
        int idProduct = resultSet.getInt("id_product");
        String idSeller = resultSet.getString("id_seller");
        String img = resultSet.getString("img");
        String name= resultSet.getString("name");
        String description = resultSet.getString("description");
        String company = resultSet.getString("company");
        String detail = resultSet.getString("detail");
        int price = resultSet.getInt("price");

        Product product = new Product(idProduct,idSeller,img,name,company,description,detail,price);
        return product;
      }
    } catch (Exception e) {
      //TODO: handle exception
      e.printStackTrace();
    }
    return pro;
  }

  // public static boolean checkProduct(int iP)
  // {
  //   String sql = "SELECT * FROM product WHERE id_product=?";
  //   try (
  //     Connection connection = getConnection();
  //     PreparedStatement preparedStatement = connection.prepareStatement(sql);
  //   ) {
  //     preparedStatement.setInt(1, iP);
  //     ResultSet resultSet = preparedStatement.executeQuery();
  //     if (resultSet.next()) return true;
  //   } catch (Exception e) {
  //     //TODO: handle exception
  //     e.printStackTrace();
  //   }
  //   return false;
  // }


  public static void deleteProduct(int iP)
  {
    String sql = "DELETE FROM product WHERE id_product=?";
    try (
      Connection connection = getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ) {
      preparedStatement.setInt(1, iP);
      preparedStatement.execute();
    } catch (Exception e) {
      //TODO: handle exception
      e.printStackTrace();
    }
  }
  
  public static void updateProduct(Product product, int iP) {
	    String sql = "Update product SET id_seller = ?, img = ?, name = ?, description = ?, company = ? ,detail = ? ,price = ? WHERE id_product = ?;";
	    try (
	    	      Connection connection = getConnection();
	    	      PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    	    ) {
	    	      preparedStatement.setString(1, product.getIdSeller());
	    	      preparedStatement.setString(2, product.getImg());
	    	      preparedStatement.setString(3, product.getName());
	    	      preparedStatement.setString(4, product.getDescription());
	    	      preparedStatement.setString(5, product.getCompany());
	    	      preparedStatement.setString(6, product.getDetail());
	    	      preparedStatement.setInt(7, product.getPrice());
	    	      preparedStatement.setInt(8, iP);
	    	      preparedStatement.executeUpdate();
	    	      
	    	    } catch (Exception e) {
	    	      e.printStackTrace();
	    	    }
  }
  
}
