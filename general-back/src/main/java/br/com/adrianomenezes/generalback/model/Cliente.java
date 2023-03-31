//package br.com.adrianomenezes.generalback.model;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import br.com.adrianomenezes.generalback.data.vo.v1.ClienteVO;
//import jakarta.persistence.Entity;
//import jakarta.persistence.OneToMany;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import br.com.adrianomenezes.generalback.model.enums.Perfil;
//
//@Entity
//public class Cliente extends Pessoa {
//	private static final long serialVersionUID = 1L;
//
//	@JsonIgnore
//	@OneToMany(mappedBy = "cliente")
//	private List<Chamado> chamados = new ArrayList<>();
//
//	public Cliente() {
//		super();
//		addPerfil(Perfil.CLIENTE);
//	}
//
//	public Cliente(Integer id, String nome, String cpf, String email, String senha) {
//		super(id, nome, cpf, email, senha);
//		addPerfil(Perfil.CLIENTE);
//	}
//
//	public Cliente(ClienteVO obj) {
//		super();
//		this.id = obj.getId();
//		this.nome = obj.getNome();
//		this.cpf = obj.getCpf();
//		this.email = obj.getEmail();
//		this.senha = obj.getSenha();
//		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
//		this.dataCriacao = obj.getDataCriacao();
//	}
//
//	public List<Chamado> getChamados() {
//		return chamados;
//	}
//
//	public void setChamados(List<Chamado> chamados) {
//		this.chamados = chamados;
//	}
//
//}