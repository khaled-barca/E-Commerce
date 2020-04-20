<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="service.AdminServiceImpl"%>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Add Product - Dashboard HTML Template</title>
    <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:400,700"
    />
    <!-- https://fonts.google.com/specimen/Roboto -->
    <link rel="stylesheet" href="css/fontawesome.min.css"/>
    <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href="jquery-ui-datepicker/jquery-ui.min.css" type="text/css"/>
    <!-- http://api.jqueryui.com/datepicker/ -->
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <!-- https://getbootstrap.com/ -->
    <link rel="stylesheet" href="css/templatemo-style.css">
    <!--
    Product Admin CSS Template
    https://templatemo.com/tm-524-product-admin
    -->
    <script>
        if (!!window.performance && window.performance.navigation.type === 2) {
            // value 2 means "The page was accessed by navigating into the history"
            console.log('Reloading');
            window.location.reload(); // reload whole page

        }
    </script>
</head>

<body onload="">
<nav class="navbar navbar-expand-xl">
    <div class="container h-100">
        <a class="navbar-brand" href="#">
            <h1 class="tm-site-title mb-0">Product Admin</h1>
        </a>
        <button
                class="navbar-toggler ml-auto mr-0"
                type="button"
                data-toggle="collapse"
                data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <i class="fas fa-bars tm-nav-icon"></i>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mx-auto h-100">
                <li class="nav-item">
                    <a class="nav-link active" href="ShowProducts">
                        <i class="fas fa-shopping-cart"></i> Products
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="ShowUsers">
                        <img src="img/user.png" style="width: 30px">
                        <span> ShowCustomers  </span> Accounts
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a
                            class="nav-link dropdown-toggle"
                            href="#"
                            id="navbarDropdown"
                            role="button"
                            data-toggle="dropdown"
                            aria-haspopup="true"
                            aria-expanded="false"
                    >
                        <i class="fas fa-cog"></i>
                        <span> Settings <i class="fas fa-angle-down"></i> </span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Profile</a>
                    </div>
                </li>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link d-block" href="login.jsp">
                        Admin, <b>Logout</b>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container tm-mt-big tm-mb-big">
    <div class="row" >
        <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
            <div class="tm-bg-primary-dark tm-block tm-block-h-auto" >
                <div class="row">
                    <div class="col-12">
                       <center><h2 class="tm-block-title d-inline-block">Add Category</h2></center>
                    </div>
                </div>
                <div class="row tm-edit-product-row" style="align-content: center;align-items: center;alignment: center;">
                    <div class="col-xl-6 col-lg-6 col-md-12">
                        <form action="AddCategory" class="tm-edit-product-form" method="post"
                              >
                            <div class="form-group mb-3">
                                <label
                                        for="name"
                                >Category Name
                                </label>
                                <input
                                        id="name"
                                        name="name"
                                        pattern="^$|^\S+.*" minlength="2" maxlength="50"
                                        type="text"
                                        class="form-control validate"
                                        required
                                />
                            </div>
                            <div class="form-group mb-3">
                                <label
                                        for="desc"
                                        pattern="[a-zA-Z0-9]+" minlength="4" maxlength="50"
                                >Description</label
                                >
                                <textarea
                                        name="desc"
                                        id="desc"
                                        class="form-control validate"
                                        rows="3"
                                        pattern="^$|^\S+.*"
                                        required
                                ></textarea>
                            </div>
                    <div class="col-12" >
                        <input type="submit" id="submit" class="btn btn-primary btn-block text-uppercase"
                               value="Add Category Now">
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%--    <footer class="tm-footer row tm-mt-small">--%>
<%--        <div class="col-12 font-weight-light">--%>
<%--          <p class="text-center text-white mb-0 px-4 small">--%>
<%--            Copyright &copy; <b>2018</b> All rights reserved. --%>
<%--            --%>
<%--            Design: <a rel="nofollow noopener" href="https://templatemo.com" class="tm-footer-link">Template Mo</a>--%>
<%--        </p>--%>
<%--        </div>--%>
<%--    </footer> --%>

<script src="js/jquery-3.3.1.min.js"></script>
<!-- https://jquery.com/download/ -->
<script src="jquery-ui-datepicker/jquery-ui.min.js"></script>
<!-- https://jqueryui.com/download/ -->
<script src="js/bootstrap.min.js"></script>
<!-- https://getbootstrap.com/ -->
<script>
  function refresh(){
        window.refresh();
  };
</script>
</body>
</html>
