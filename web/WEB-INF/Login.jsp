<%-- 
    Document   : Login
    Created on : Feb 24, 2025, 12:47:04 AM
    Author     : Nguyen Dinh Quoc - CE181874
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login - G4 Store</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="styles/Login.css">
     <link rel="stylesheet" href="Login.css">
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>
        <form action="Login" method="post">
            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" id="username" name="username" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" id="password" name="password" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Login</button>
        </form>

        <!-- Thông báo lỗi -->
        <% String error = (String) request.getAttribute("error");
           if (error != null) { %>
            <div class="alert alert-danger mt-2"><%= error %></div>
        <% } %>
                <!-- Đăng nhập bằng Google -->
        <div class="social-login text-center mt-3">
            <a href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile
            &redirect_uri=http://localhost:8080/G4-Store/GoogleLogin
            &response_type=code
            &client_id=YOUR_GOOGLE_CLIENT_ID
            &approval_prompt=force" class="btn btn-danger">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-google" viewBox="0 0 16 16">
                    <path d="M15.545 6.558a9.42 9.42 0 0 1 .139 1.626c0 2.434-.87 4.492-2.384 5.885h.002C11.978 15.292 10.158 16 8 16A8 8 0 1 1 8 0a7.689 7.689 0 0 1 5.352 2.082l-2.284 2.284A4.347 4.347 0 0 0 8 3.166c-2.087 0-3.86 1.408-4.492 3.304a4.792 4.792 0 0 0 0 3.063h.003c.635 1.893 2.405 3.301 4.492 3.301 1.078 0 2.004-.276 2.722-.764h-.003a3.702 3.702 0 0 0 1.599-2.431H8v-3.08h7.545z"/>
                </svg>
                Sign in with Google
            </a>
        </div>
        <!-- Quên mật khẩu -->
        <div class="text-center mt-3">
            <a href="ForgotPassword.jsp" class="text-decoration-none">Forgot Password  </a>
            
        </div>
          <div class="text-center mt-3">
            <a href="Register" class="text-decoration-none">Register</a>    
        </div>



    </div>
</body>
</html>
