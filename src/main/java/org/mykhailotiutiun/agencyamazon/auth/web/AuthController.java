package org.mykhailotiutiun.agencyamazon.auth.web;

import jakarta.validation.Valid;
import org.mykhailotiutiun.agencyamazon.auth.AuthService;
import org.mykhailotiutiun.agencyamazon.auth.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/token")
    public ResponseEntity<TokenResponse> getToken(@RequestBody @Valid GetTokenRequest getTokenRequest){
        User user = User.builder()
                .username(getTokenRequest.username())
                .password(getTokenRequest.password())
                .build();
        TokenResponse tokenResponse = new TokenResponse(authService.getToken(user));
        return new ResponseEntity<>(tokenResponse, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest registerRequest){
        User user = User.builder()
                .username(registerRequest.username())
                .password(registerRequest.password())
                .build();
        authService.register(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
