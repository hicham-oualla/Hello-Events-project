package com.HH.Hello_Events.Services;


import com.HH.Hello_Events.Auth.AuthRequest;
import com.HH.Hello_Events.Auth.AuthResponse;
import com.HH.Hello_Events.Model.Entity.Client;
import com.HH.Hello_Events.Model.Entity.Role;
import com.HH.Hello_Events.Repository.ClientRepository;
import com.HH.Hello_Events.config.JwtService;
import com.HH.Hello_Events.config.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class ClientUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private JwtService jwtService;

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {

        return clientRepository.findClientByEmail(Email);
    }

    public AuthResponse register(RegisterRequest request) {
        var client = Client.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        clientRepository.save(client);
        var jwtToken = jwtService.generateToken(client);
        return AuthResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = clientRepository.findClientByEmail(request.getEmail());
        var jwtToken = jwtService.generateToken(user);

        return AuthResponse.builder()
                .accessToken(jwtToken)
                .build();
    }
    public AuthResponse registerad(RegisterRequest request) {
        var client = Client.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .build();
        clientRepository.save(client);
        var jwtToken = jwtService.generateToken(client);
        return AuthResponse.builder()
                .accessToken(jwtToken)
                .build();
    }
    public AuthResponse authenticatead(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = clientRepository.findClientByEmail(request.getEmail());
        var jwtToken = jwtService.generateToken(user);

        return AuthResponse.builder()
                .accessToken(jwtToken)
                .build();
    }
}