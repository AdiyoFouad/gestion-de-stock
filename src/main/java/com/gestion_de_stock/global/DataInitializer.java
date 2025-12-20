package com.gestion_de_stock.global;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gestion_de_stock.security.model.Role;
import com.gestion_de_stock.security.model.RoleName;
import com.gestion_de_stock.security.repository.RoleRepository;

@Configuration
public class DataInitializer {

	@Bean
	public CommandLineRunner initRoles(RoleRepository roleRepository) {
		return args -> {
			if (roleRepository.findByName(RoleName.ROLE_ADMIN).isEmpty()) {
				roleRepository.save(Role.builder().name(RoleName.ROLE_ADMIN).build());
			}
			if (roleRepository.findByName(RoleName.ROLE_USER).isEmpty()) {
				roleRepository.save(Role.builder().name(RoleName.ROLE_USER).build());
			}
			if (roleRepository.findByName(RoleName.ROLE_MANAGER).isEmpty()) {
				roleRepository.save(Role.builder().name(RoleName.ROLE_MANAGER).build());
			}
		};
	}
}
