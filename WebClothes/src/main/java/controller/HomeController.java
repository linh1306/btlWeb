package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import model.Product;
import model.User;
import service.CartService;
import service.ProductService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet (urlPatterns = "/home")
public class HomeController extends HttpServlet  {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/user/home.jsp");
    
    String search = req.getParameter("search");
    if (search==null) search ="";

    ArrayList<Product> products = ProductService.searchProduct(search);
    req.setAttribute("products", products);
    HttpSession session = req.getSession();
    User user = (User) session.getAttribute("user");
    if (user!= null)
    { 
      HashMap<Product,Integer> map = CartService.getProductCart(user.getUser());
      req.setAttribute("cart", map);
    }
    requestDispatcher.forward(req, resp);
  }
}
