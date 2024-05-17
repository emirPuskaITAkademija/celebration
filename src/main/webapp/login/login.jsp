<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div style="padding: 100px">
    <%
        String basePath = request.getContextPath();
        String registrationPath = basePath+"/register";
    %>
    <section class=" text-center text-lg-start">
        <style>
            .rounded-t-5 {
                border-top-left-radius: 0.5rem;
                border-top-right-radius: 0.5rem;
            }

            @media (min-width: 992px) {
                .rounded-tr-lg-0 {
                    border-top-right-radius: 0;
                }

                .rounded-bl-lg-5 {
                    border-bottom-left-radius: 0.5rem;
                }
            }
        </style>
        <div class="card mb-3">
            <div class="row g-0 d-flex align-items-center">
                <div class="col-lg-4 d-none d-lg-flex">
                    <img src="https://mdbootstrap.com/img/new/ecommerce/vertical/004.jpg" alt="Trendy Pants and Shoes"
                         class="w-100 rounded-t-5 rounded-tr-lg-0 rounded-bl-lg-5"/>
                </div>
                <div class="col-lg-8">
                    <div class="card-body py-5 px-md-5">

                        <form>
                            <!-- Username input -->
                            <div data-mdb-input-init class="form-outline mb-4">
                                <input type="email" name="username" id="form2Example1" class="form-control"/>
                                <label class="form-label" for="form2Example1">Username</label>
                            </div>

                            <!-- Password input -->
                            <div data-mdb-input-init class="form-outline mb-4">
                                <input type="password" name="password" id="form2Example2" class="form-control"/>
                                <label class="form-label" for="form2Example2">Password</label>
                            </div>


                            <!-- Submit button -->
                            <button type="button" data-mdb-button-init data-mdb-ripple-init
                                    class="btn btn-primary btn-block mb-4">Sign in
                            </button>

                            <!-- 2 column grid layout for inline styling -->
                            <div class="row mb-4">
                                <div class="col">
                                    <!-- Simple link -->
                                    <a href=<%=registrationPath%>>Do you want to register ?</a>
                                </div>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
</body>
</html>
