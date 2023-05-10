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
@WebServlet (urlPatterns = "/pay")
public class Payment extends HttpServlet  {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/page/pay.jsp");
    
    requestDispatcher.forward(req, resp);
  }
}
