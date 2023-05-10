package controller;

import java.io.IOException;

import model.Product;
import model.Seller;
import service.ProductService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet (urlPatterns = "/new-product")
public class AddNewProductController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/seller/add-product.jsp");
    requestDispatcher.forward(req, resp);
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String img= req.getParameter("img");
    String name= req.getParameter("name");
    String description= req.getParameter("description");
    String company= req.getParameter("company");
    String detail= req.getParameter("detail");
    int price = Integer.parseInt(req.getParameter("price"));
    HttpSession session = req.getSession();
    Seller seller = (Seller) session.getAttribute("seller");
    
    Product product = new Product(seller.getIdSeller(), img, name, company, description, detail, price);

    ProductService.newProduct(product);

    resp.sendRedirect(req.getContextPath()+"/MT");
  }
}