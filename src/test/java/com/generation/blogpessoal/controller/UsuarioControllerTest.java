package com.generation.blogpessoal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.generation.blogpessoal.model.Usuario;
import com.generation.blogpessoal.repository.UsuarioRepository;
import com.generation.blogpessoal.service.UsuarioService;
import com.generation.blogpessoal.util.TestBuilder;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class UsuarioControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private static final String BASE_URL = "/usuarios";
	private static final String ADMIN = "root@root.com";
	private static final String SENHA = "rootroot";
	
	@BeforeAll
	void inicio() {
		usuarioRepository.deleteAll();
		usuarioService.cadastrarUsuario(TestBuilder.criarUsuario(
				null, "Root", USUARIO, SENHA));
	}
	
	@Test
	@DisplayName("01 - Deve cadastrar um novo usuário")
	void deveCadastrarNovoUsuario() {
	 
	//Given
	Usuario usuario = TestBuilder.criarUsuario(
			null, "Thuany", "thuany@gmail.com.br", "12345678");
		
	//When
	HttpEntity<Usuario> requisicao = new HttpEntity<Usuario>(usuario);
	ResponseEntity<Usuario> resposta = testRestTemplate
			.exchange(BASE_URL + "/cadastrar", HttpMethod.POST, requisicao, Usuario.class);
		
	//Then
	assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
	assertNotNull(resposta.getBody());

	}
	
}
