package br.com.adrianomenezes.generalback.model;

import br.com.adrianomenezes.generalback.data.vo.v1.TechnicianVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="technician")
@XmlRootElement
public class Technician implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name", nullable = false, length = 80)
	private String firstName;
	@Column(name = "last_name", nullable = false, length = 80)
	private String lastName;
	@Column(nullable = false, 	length = 100)
	private String address;
	@Column(nullable = false, 	length = 6)
	private String gender;

	@Column(unique = true)
	protected String cpf;

	@Column(unique = true)
	protected String email;
	protected String password;

//	@ElementCollection(fetch = FetchType.EAGER)
//	@CollectionTable(name = "PERFIS")
//	protected Set<Integer> perfis = new HashSet<>();

	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate createdAt = LocalDate.now();

	@Column(nullable = false)
	private Boolean enabled;

	public Technician() {
		super();
	}

	public Technician(Long id, String firstName, String lastName, String address, String gender, String cpf, String email, String password, LocalDate createdAt) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.gender = gender;
		this.cpf = cpf;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
		this.enabled = true;
	}

	public Technician(TechnicianVO objDTO) {
		this.id = objDTO.getKey();
		this.firstName = objDTO.getFirstName();
		this.lastName = objDTO.getLastName();
		this.address = objDTO.getAddress();
		this.gender = objDTO.getGender();
		this.cpf = objDTO.getCpf();
		this.email = objDTO.getEmail();
		this.password = objDTO.getPassword();
		this.createdAt = objDTO.getCreatedAt();
		this.enabled = objDTO.getEnabled();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Technician that)) return false;
		return Objects.equals(getId(), that.getId()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getGender(), that.getGender()) && Objects.equals(getCpf(), that.getCpf()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getCreatedAt(), that.getCreatedAt());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getFirstName(), getLastName(), getAddress(), getGender(), getCpf(), getEmail(), getPassword(), getCreatedAt());
	}
}
