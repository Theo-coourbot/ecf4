package com.authentification.authentification.controller;


import com.authentification.authentification.dto.LoginRequestDTO;
import com.authentification.authentification.dto.LoginResponseDTO;
import com.authentification.authentification.dto.RegisterRequestDTO;
import com.authentification.authentification.dto.RegisterResponseDTO;
import com.authentification.authentification.entity.UserApp;
import com.authentification.authentification.security.JWTGenerator;
import com.authentification.authentification.service.UserAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/auth")
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UtilisateurController {
    private final AuthenticationManager authenticationManager;

    private final UserAppService userAppService;
    private final PasswordEncoder passwordEncoder;
    private final JWTGenerator generator;

    public UtilisateurController(AuthenticationManager authenticationManager, UserAppService userAppService, PasswordEncoder passwordEncoder, JWTGenerator generator) {
        this.authenticationManager = authenticationManager;
        this.userAppService = userAppService;
        this.passwordEncoder = passwordEncoder;
        this.generator = generator;
    }


    @PostMapping("login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getPseudo(), loginRequestDTO.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok(LoginResponseDTO.builder().token(generator.generateToken(authentication)).build());
        }catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @PostMapping("register")
    public ResponseEntity<RegisterResponseDTO> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        try {
            UserApp userApp = userAppService.saveUser(registerRequestDTO.getPseudo(), passwordEncoder.encode(registerRequestDTO.getPassword()));
            return ResponseEntity.ok(RegisterResponseDTO.builder().id(userApp.getId()).message("User created").build());
        }catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}
