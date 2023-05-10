package controller;

import java.io.IOException;

import model.Cart;
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

@WebServlet(urlPatterns = "/product")
public class ProductController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/user/product.jsp");
    int idProduct = Integer.parseInt(req.getParameter("id"));
    int count = CartService.getCountCart(idProduct);
    req.setAttribute("count", count);
    Product product = ProductService.getProduct(idProduct);
    req.setAttribute("product", product);
    requestDispatcher.forward(req, resp);
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
    HttpSession session = req.getSession();
    User user = (User) session.getAttribute("user");

    if (user==null)
    {
      resp.sendRedirect(req.getContextPath()+"/login");
    }
    else
    {

      int idProduct = Integer.parseInt(req.getParameter("id"));
      int count = Integer.parseInt(req.getParameter("count"));
      if (CartService.checkCart(idProduct))
      {
        Cart cart = new Cart(user.getUser(), idProduct, count);
        CartService.updateCart(cart);
      }
      else
      {
        Cart cart = new Cart(user.getUser(), idProduct, count);
        CartService.addToCart(cart);
      }
      resp.sendRedirect(req.getContextPath()+"/home");
    }
    }
}
