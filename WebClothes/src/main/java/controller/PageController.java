package controller;

import java.io.IOException;
import java.util.ArrayList;

import lib.MD5;
import model.Product;
import model.Seller;
import model.User;
import service.ProductService;
import service.SellerService;
import service.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet (urlPatterns = "/")
public class PageController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String actionString = req.getServletPath();
    switch (actionString)
    {

      case "/login":
        login(req,resp);
        break;
      case "/register":
        register(req,resp);
        break;
      case "/logout":
        logout(req,resp);
        break;
        
      //MT Controller  
      case "/MT":
        getMT(req,resp);
        break;
      case "/registerMT":
        registerMT(req,resp);
        break;

    }

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String actionString = req.getServletPath();
    switch (actionString)
    {
      case "/login":
        submitLogin(req, resp);
        break;
      case "/register":
        submitRegister(req, resp);
        break;
        
      case "/registerMT":
        submitRegisterMT(req, resp);
        break;
    }
  }

  public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/page/login.jsp");
    requestDispatcher.forward(req, resp);
  }
  public void submitLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException{
	    
	    String user=req.getParameter("user");
	    String password = MD5.getMD5(req.getParameter("password"));
	    if(UserService.checkUser(user, password)) 
	    {
	      HttpSession session = req.getSession();
	      session.setAttribute("user", UserService.getUser(user));
	      req.setAttribute("user", UserService.getUser(user));
	      resp.sendRedirect(req.getContextPath()+"/home");
	    }
	    else
	    	resp.sendRedirect(req.getContextPath()+"/login");   
	  }
  
  
  public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	  RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/page/register.jsp");

	  requestDispatcher.forward(req, resp);
	}

	public void submitRegister(HttpServletRequest req, HttpServletResponse resp) throws IOException{
	  String user=req.getParameter("user");
	  String password = MD5.getMD5(req.getParameter("password"));
	  String name = req.getParameter("name");
	  String address=req.getParameter("address");
	  String phone = req.getParameter("phone");
	  String email = req.getParameter("email");
	  User use = new User(email, user, password, name, address, phone);

	  UserService.createUser(use);

	  resp.sendRedirect(req.getContextPath()+"/login");
	}

  public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    HttpSession session = req.getSession();
    session.removeAttribute("seller");
    session.removeAttribute("user");

    resp.sendRedirect(req.getContextPath()+"/home");
  }



//MT Controller
  //getMT
  private void getMT(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    HttpSession session = req.getSession();
    User user= (User) session.getAttribute("user");
    if (SellerService.checkSeller(user.getUser()))
    { 
      Seller seller = (Seller) session.getAttribute("seller");
      if (seller==null)
      {
        seller =SellerService.getSeller(user.getUser());
        session.setAttribute("seller", seller);
      }

      ArrayList<Product> products = ProductService.sellerProduct(seller.getIdSeller());
      req.setAttribute("seller", seller);
      req.setAttribute("products", products);      
      RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/seller/MT.jsp");
      requestDispatcher.forward(req, resp);
    }
    else
    {
      resp.sendRedirect(req.getContextPath()+"/registerMT");
    }
  }

  // registerMT
  private void registerMT(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/seller/registerMT.jsp");

    requestDispatcher.forward(req, resp);
  }

  // đăng kí tài khoản bán hàng
  private  void submitRegisterMT(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    HttpSession session = req.getSession();
    User user = (User) session.getAttribute("user");
    String idSeller = req.getParameter("idSeller");
    String name = req.getParameter("name");
    String address = req.getParameter("address");
    String phone = req.getParameter("phone");
    Seller seller = new Seller(user.getUser(), idSeller, name, address, phone);
    SellerService.createSeller(seller);
    session.setAttribute("seller", seller);

    resp.sendRedirect(req.getContextPath()+"/MT");

  }

}







