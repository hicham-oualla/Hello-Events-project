package com.HH.Hello_Events.Auth;


import com.HH.Hello_Events.Services.ClientUserDetailsService;
import com.HH.Hello_Events.config.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final ClientUserDetailsService service;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(
            @RequestBody AuthRequest request
    ) {                                                                   
        return ResponseEntity.ok(service.authenticate(request));
    }


//    ________
    @PostMapping("/registerad")
    public ResponseEntity<AuthResponse> registerad(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.registerad(request));
    }
    @PostMapping("/authenticatead")
    public ResponseEntity<AuthResponse> authenticatead(
            @RequestBody AuthRequest request
    ) {
        return ResponseEntity.ok(service.authenticatead(request));
    }


}