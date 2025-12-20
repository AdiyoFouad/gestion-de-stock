package com.gestion_de_stock.security.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gestion_de_stock.security.dto.AuthResponse;
import com.gestion_de_stock.security.dto.LoginRequest;
import com.gestion_de_stock.security.dto.RegisterRequest;
import com.gestion_de_stock.security.jwt.JwtService;
import com.gestion_de_stock.security.model.Role;
import com.gestion_de_stock.security.model.RoleName;
import com.gestion_de_stock.security.model.User;
import com.gestion_de_stock.security.repository.RoleRepository;
import com.gestion_de_stock.security.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;

	public AuthResponse register(RegisterRequest request) {
		if (userRepository.existsByUsername(request.getUsername())) {
			throw new RuntimeException("Ce nom d'utilisateur est déjà utilisé");
		}

		RoleName roleName = RoleName.valueOf("ROLE_" + request.getRole().toUpperCase());
		Role role = roleRepository.findByName(roleName)
				.orElseThrow(() -> new RuntimeException("Rôle introuvable : " + request.getRole()));

		User user = User.builder().username(request.getUsername())
				.password(passwordEncoder.encode(request.getPassword())).build();
		user.getRoles().add(role);

		User saved = userRepository.save(user);
		String token = jwtService.generateToken(saved);

		return new AuthResponse(token);
	}

	public AuthResponse login(LoginRequest request) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		User user = (User) authentication.getPrincipal();
		String token = jwtService.generateToken(user);

		return new AuthResponse(token);
	}
}
