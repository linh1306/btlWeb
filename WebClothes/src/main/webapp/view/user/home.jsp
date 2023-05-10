<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>

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
    		<button onclick="window.location.href='/WebClothes/logout'" type="button" class="btn btn-warning">Log out</button>
		</c:if>
		
		<c:if test="${user==null}">
        	<div class="text-end">
          		<button onclick="window.location.href='/WebClothes/login'" type="button" class="btn btn-outline-light me-2">Log-in</button>
          		<button onclick="window.location.href='/WebClothes/register'" type="button" class="btn btn-warning">Sign-up</button>
        	</div>
        </c:if>
      </div>
    </div>
  </header>

<main>


<div class="container" style="max-width: 50%; max-height: 50rem;overflow: hidden;">
  <div id="myCarousel" class="carousel slide top-slide" data-bs-ride="carousel">
    <div class="carousel-indicators">
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
      <div class="carousel-item active slide-item">
        <img class="bd-placeholder-img img-icon" src="https://banghenhahangcafe.com/wp-content/uploads/2021/03/thiet-ke-shop-quan-ao-18.jpg" alt="" width="100%" height="100%">
        <div class="container">
          <div class="carousel-caption">
            HELLO EVERYONE
          </div>
        </div>
      </div>
      <div class="carousel-item slide-item">
        <img class="bd-placeholder-img img-icon" src="https://top10tphcm.com/wp-content/uploads/2019/05/top-shop-ban-hoodie-dep-va-chat-o-hcm-1.jpg" alt="" width="100%" height="100%">
        <div class="container">
          <div class="carousel-caption">
          </div>
        </div>
      </div>
      <div class="carousel-item slide-item">
        <img class="bd-placeholder-img img-icon" src="https://bpackingapp.com/wp-content/uploads/2021/10/celeb-store.png" alt="" width="100%" height="100%">

        <div class="container">
          <div class="carousel-caption">
          </div>
        </div>
      </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
  </div>
</div>



  <!-- Marketing messaging and featurettes
  ================================================== -->
  <!-- Wrap the rest of the page in another container to center all the content. -->

  <div class="container marketing mt-3">

    <!-- Three columns of text below the carousel -->
    <div class="container">

      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
      
      <c:forEach items="${products}" var="product" >
        <div class="col">
          <div class="card shadow-sm">
            <!-- <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg> -->
              <img class="item" src="${product.getImg()}" alt="">

            <div class="card-body">
              <h3> <c:out value="${product.getName() }"></c:out> </h3>
              <p class="card-text"> <c:out value="${product.getDescription() }"></c:out> </p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button onclick="window.location.href='/WebClothes/product?id=${product.getIdProduct()}'" type="button"  class="btn btn-sm btn-outline-secondary">View</button>
                </div>
                <small class="text-muted"> <c:out value="${product.getPrice() }"></c:out> </small>
              </div>
            </div>
          </div>
        </div>
      </c:forEach>
      
        <!-- <div class="col">
          <div class="card shadow-sm">
            <img class="item" src="https://i.pinimg.com/236x/50/6f/f6/506ff63e8293222dd54f9971f307f140.jpg" alt="">
            <div class="card-body">
              <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                  <button type="button" class="btn btn-sm btn-outline-secondary btn-dark">Add</button>
                </div>
                <small class="text-muted">9 mins</small>
              </div>
            </div>
          </div>
        </div> -->
      </div>
    </div>

    

  </div><!-- /.container -->


  <!-- FOOTER -->
 <header class="p-2 bg-dark text-white">
  <footer class="container">
    <p class="float-end"><a href="#">Back to top</a></p>
    <p>&copy; Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
  </footer>
 </header>
  <!-- SOPPING CART -->
  <button class="btn btn-primary shopping-cart" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">Shopping Cart</button>
  <div class="offcanvas offcanvas-end " tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
    <div class="offcanvas-header">
      <h5 id="offcanvasRightLabel">Shopping Cart</h5>
      <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div class="offcanvas-body">
      <div class="card mb-3 border-bottom-0" style="max-width: 540px;">
	<c:forEach items="${cart}" var="product">
      <div class="row g-0 mb-3 border-bottom">
        <div class="col-md-4 cart">
        <button type="button" class="btn-close text-reset delete-product" aria-label="Close" onclick="location.href='/WebClothes/delete-cart?id=${product.key.getIdProduct()}';"></button>
          <img src="${product.key.getImg()}" class="img-fluid rounded-start" alt="...">
        </div>
        <div class="col-md-8">
          <div class="card-body">
            <h5 class="card-title"> <c:out value="${product.key.getName()}"></c:out> </h5>
            <p class="card-text"> <c:out value="${product.key.getDescription()}"></c:out> </p>
              <div class="col-auto">
                <p> Số lượng: <c:out value="${product.value}"></c:out> </p>
              </div>
              <div class="col-auto">
                <button type="submit" class="btn btn-primary mb-3 mt-3" onclick="location.href='/WebClothes/product?id=${product.key.getIdProduct()}';">thay đổi số lượng</button>
              </div>
            <p class="card-text"><small class="text-muted"> <c:out value="Tổng giá : ${product.key.getPrice()*product.value}"></c:out> vnđ </small></p>
          </div>
        </div>
      </div>
	</c:forEach>
  

	</div>
    </div>
    <button onclick="window.location.href='/WebClothes/pay'" type="button" class="btn btn-primary btn-sm btn-info">Pay</button>
  </div>
</main>
  <style>
    .shopping-cart{
      position: fixed;
      top:93%;
      left:45%;
    }
    .img-icon{
      object-fit: cover;
    }

    .slide-item{
      overflow: hidden;
      width:100%;
      height: 800px;
      object-fit: cover;
    }
    /* .slide-test{
      width: 500px;
      height: 500px;
      overflow: hidden;
    } */
    .delete-product{
    	position: absolute;
      	right:0;
    }
    .top-slide{
      border-radius: 5px;
      overflow: hidden;
    }
  </style>
    <script src="/docs/5.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
      

</body>
</html>