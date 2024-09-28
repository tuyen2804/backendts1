package com.hlt.tshust.controller;

import com.hlt.tshust.dto.accounts.LoginRequest;
import com.hlt.tshust.dto.accounts.LoginResponse;
import com.hlt.tshust.dto.accounts.RegisterRequest;
import com.hlt.tshust.model.Accounts;
import com.hlt.tshust.security.JwtTokenProvider;
import com.hlt.tshust.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AccountService accountService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    // Đăng ký tài khoản với role mặc định là USER
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        // Kiểm tra email đã tồn tại chưa
        Accounts existingAccount = accountService.findByUseremail(registerRequest.getEmail());
        if (existingAccount != null) {
            return ResponseEntity.badRequest().body("Email đã được đăng ký!");
        }

        // Tạo tài khoản mới
        Accounts newAccount = new Accounts();
        newAccount.setStudentName(registerRequest.getStudentName());
        newAccount.setEmail(registerRequest.getEmail());
        newAccount.setPhoneNumber(registerRequest.getPhoneNumber());
        newAccount.setPassword(registerRequest.getPassword()); // Mật khẩu sẽ được mã hóa trong AccountService
        newAccount.setRole("ROLE_USER"); // Gán vai trò mặc định là USER

        // Lưu tài khoản mới vào cơ sở dữ liệu
        accountService.save(newAccount);

        return ResponseEntity.ok("Đăng ký thành công!");
    }

    // Đăng nhập và trả về JWT token, account_id và role
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        // Xác thực thông tin đăng nhập
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

            // Lưu thông tin xác thực vào SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Tạo JWT token
            String accessToken = jwtTokenProvider.generateAccessToken(authentication);
            String refreshToken=jwtTokenProvider.generateRefreshToken(authentication);

            // Lấy tài khoản từ email
            Accounts account = accountService.findByUseremail(loginRequest.getEmail());

            // Tạo đối tượng phản hồi
            LoginResponse response = new LoginResponse(true,accessToken,refreshToken, account.getAccountId(), account.getRole());

            // Trả về JWT token cùng với account_id và role
            return ResponseEntity.ok(response);

        }
        catch (BadCredentialsException ex) {
            // Trả về phản hồi thất bại khi thông tin đăng nhập sai
            return ResponseEntity.ok(new LoginResponse(false,null, null, null, null));
        }
    }

    // Admin thêm tài khoản với role bất kỳ (không phải là USER)
    @PostMapping("/admin/add-account")
    public ResponseEntity<String> addAccountByAdmin(@RequestBody Accounts account) {
        // Kiểm tra email đã tồn tại chưa
        Accounts existingAccount = accountService.findByUseremail(account.getEmail());
        if (existingAccount != null) {
            return ResponseEntity.badRequest().body("Email đã được đăng ký!");
        }

        // Lưu tài khoản với role được chỉ định
        accountService.save(account);

        return ResponseEntity.ok("Tài khoản đã được thêm thành công!");
    }
}
