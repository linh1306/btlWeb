package controller;

import java.io.IOException;

import service.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/MT/delete-product")
public class DeleteProductController extends HttpServlet{
  @Override 
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int idProduct = Integer.parseInt( req.getParameter("idProduct"));
    ProductService.deleteProduct(idProduct);
    resp.sendRedirect(req.getContextPath()+"/MT");
  }
}