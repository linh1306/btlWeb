<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Update Product</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

    
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  </head>
  <body>
    <div class="container col-md-6">
    <div class="col-md-7 col-lg-8">
      <h4 class="mb-3">Update Product</h4>
      <form class="needs-validation" method="POST">
        <div class="row g-3">

          <div class="col-12">
            <label  class="form-label">Photo Link</label>
            <div class="input-group has-validation">
              <input name="img" type="text" class="form-control" placeholder="Photo Link" required>
            </div>
          </div>

          <div class="col-12">
            <label class="form-label">Name</label>
            <div class="input-group has-validation">
              <input name="name" type="text" class="form-control" placeholder="Name" required>
            </div>
          </div>

          <div class="col-12">
            <label class="form-label">Description</label>
            <div class="input-group has-validation">
              <input name="description" type="text" class="form-control" placeholder="Description" required>
            </div>
          </div>

          <select class="form-select" aria-label="Default select example" name="company">
            <option selected name="company" >Category</option>
            <option value="Áo sơ mi nam">Áo sơ mi nam</option>
            <option value="Áo khoác nam">Áo khoác nam</option>
            <option value="Áo nữ">Áo nữ</option>
            <option value="Đầm và Chân váy">Đầm và Chân váy</option>
            <option value="Đồ đôi">Đồ đôi</option>
          </select>

          <div class="col-12">
            <div class="input-group has-validation">
              <label class="form-label me-3">Detail</label>
              <textarea name="detail" class="form-control" aria-label="With textarea"></textarea>
            </div>
          </div>

          <div class="col-12">
            <label class="form-label">Price</label>
            <div class="input-group has-validation">
              <input name="price" type="number" class="form-control" placeholder="Price" required>
            </div>
          </div>

        <hr class="my-4">

        <button class="w-50 btn btn-primary btn-lg" type="submit">submit</button>
      </form>
    </div>
  </div>
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script> -->

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
   
  </body>
</html>