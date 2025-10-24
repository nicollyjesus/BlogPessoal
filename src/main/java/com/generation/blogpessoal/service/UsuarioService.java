package com.generation.blogpessoal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.generation.blogpessoal.model.Usuario;
import com.generation.blogpessoal.repository.UsuarioRepository;
import com.generation.blogpessoal.security.JwtService;

@Service	
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	public AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	};
		
	public Optional<Usuario> getById(Long id){
		return usuarioRepository.findById(id);
	}
	
	public Optional<Usuario> cadastrarUsuario(Usuario usuario){
		if(usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			return Optional.empty();
		
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		return Optional.of(usuarioRepository.save(usuario));
		
	}
}
