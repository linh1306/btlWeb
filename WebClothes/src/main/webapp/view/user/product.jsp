<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
   <header class="p-2 bg-dark text-white">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
      

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="/WebClothes/home" class="nav-link px-2 text-secondary">Home</a></li>
          <li><a href="/WebClothes/home?search=Áo sơ mi nam" class="nav-link px-2 text-white">Áo sơ mi nam</a></li>
          <li><a href="/WebClothes/home?search=Áo khoác nam" class="nav-link px-2 text-white">Áo khoác nam</a></li>
          <li><a href="/WebClothes/home?search=Áo nữ" class="nav-link px-2 text-white">Áo nữ</a></li>
          <li><a href="/WebClothes/home?search=Đầm và Chân váy" class="nav-link px-2 text-white">Đầm và Chân váy</a></li>
          <li><a href="/WebClothes/home?search=Đồ đôi" class="nav-link px-2 text-white">Đồ đôi</a></li>
        </ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" method="GET">
          <input name="search" type="search" class="form-control form-control-dark" placeholder="Search..." aria-label="Search">
        </form>
		<c:if test="${user!=null}">
			<button onclick="window.location.href='/WebClothes/${user.getUser()}'" type="button" class="btn btn-outline-light me-2"><c:out value="${user.getUser()}"></c:out></button>
    		<button onclick="window.location.href='/WebClothes/MT'" type="button" class="btn btn-outline-light me-2">Modern Trade</button>
    		<button onclick="window.location.href='/WebClothes/logout'" type="button" class="btn btn-warning">Logout</button>
		</c:if>
		
		<c:if test="${user==null}">
        	<div class="text-end">
          		<button onclick="window.location.href='/WebClothes/login'" type="button" class="btn btn-outline-light me-2">Login</button>
          		<button onclick="window.location.href='/WebClothes/register'" type="button" class="btn btn-warning">Sign-up</button>
        	</div>
        </c:if>
      </div>
    </div>
  </header>
  <div class="container border rounded mt-3 product" >
    <div class="img-product mt-3 mb-3 rounded" >
      <img class="rounded" src="${product.getImg()}" alt="" >
    </div>
    <div class="card-product ms-3">
      <div class="thuoctinh">
        <p class="mt-3 fs-1"> <c:out value="${product.getName()}"></c:out> </p>
        <p class="fs-3"> <c:out value="${product.getDescription()}"></c:out> </p>
        <p class="fs-5"> <c:out value="Mô tả: ${product.getDetail()}"></c:out> </p>
        <p class="fs-1"> <c:out value=" Price: ${product.getPrice()} vnđ" ></c:out> </p>
      </div>
      <form method="POST" >
        <div class="row g-3 align-items-center">
          <div class="col-auto">
            <label for="inputPassword6" class="col-form-label">Số lượng</label>
          </div>
          <div class="col-auto">
            <input type="number" class="form-control" name = "count" value="${count}" >
          </div>
        </div>
        <button type="submit" class="btn btn-primary mt-5">+ Add to cart</button>
      </form>
     </div>
  </div>


</body>

<style>
  .product{
    max-height: 600px;
    width: 100%; 
    display: flex;
  }
  .img-product{
    overflow: hidden;
    max-height: 560px;
    min-width:400px;
  }
  .img-product img{
    width:400px;
 
  }
  .card-product{
  	display: flex;
    flex-direction: column;
    justify-content: space-around;
  }
</style>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</html>