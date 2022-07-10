package com.project.jpa.JavaJPA.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.jpa.JavaJPA.model.Cliente;
import com.project.jpa.JavaJPA.repository.Clientes;

/******************************************************
 *************** EDUCACIENCIA FAST CODE ***************
 ***************        API JAVA         **************
 ******************************************************/

@RestController
@RequestMapping("api/JPA/educaciencia/clientes")
public class ClientesController {
	
	@Autowired 
	private Clientes clientes;
	
	@GetMapping("/get")
	public List<Cliente> listar(){
		System.out.println("Quantidade de Registros de Clientes : " + clientes.count());
		return (clientes.findAll());
	}
		
	@PostMapping("/post")
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {	
		System.out.println("Inserido registro com sucesso !");
		return clientes.save(cliente);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<Cliente>> buscar(@PathVariable Long id){
		Optional<Cliente> cliente = clientes.findById(id);
		if (clientes == null) {
			return ResponseEntity.notFound().build();
		}
		System.out.println("Retornando lista Id " + id);
		return ResponseEntity.ok(cliente);
	}
	
	
	@PutMapping("/put/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente)
	{
		Object atualizar = clientes.findById(id);
		if (atualizar == null) {
			return ResponseEntity.notFound().build();
		}		
		BeanUtils.copyProperties(cliente, atualizar, "id");		
		atualizar = clientes.save(cliente);	
		System.out.println("Registro atualizado com sucesso !!" + "ID " + id + " atualizado");
		return ResponseEntity.ok(atualizar);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		Optional<Cliente> cliente = clientes.findById(id);
		if(cliente != null) {
			clientes.deleteById(id);
		}
		System.out.println("Cliente deletado com sucesso ! Id " + id + " deletado");
		return ResponseEntity.noContent().build();
	}
	
	
	
}
