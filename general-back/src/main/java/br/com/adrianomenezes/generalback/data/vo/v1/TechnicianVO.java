package br.com.adrianomenezes.generalback.data.vo.v1;

import br.com.adrianomenezes.generalback.model.Technician;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@JsonPropertyOrder({"id","firstName","lastName","cpf","email","address","password","gender","enabled","createdAt"})
@XmlRootElement
public class TechnicianVO extends RepresentationModel<TechnicianVO> implements Serializable {

	private static final long serialVersionUID = 1L;


	@Mapping("id")
	@JsonProperty("id")
	private Long key;

    @NotNull(message = "The field firstName is required")
	private String firstName;
    @NotNull(message = "The field lastName is required")
	private String lastName;
    @NotNull(message = "The field cpf is required")
    @CPF
	private String cpf;
    @NotNull(message = "The field email is required")
    @Email
	private String email;
    @NotNull(message = "The field password is required")
    private String password;
    private String address;
    private String gender;

	private Boolean enabled;
    private LocalDate createdAt = LocalDate.now();

	public TechnicianVO() {

	}

    public TechnicianVO(Long key, String firstName, String lastName, String cpf, String email, String password, String address, String gender, Boolean enabled, LocalDate createdAt) {
        this.key = key;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.address = address;
        this.gender = gender;
        this.enabled = enabled;
        this.createdAt = createdAt;
    }

    public TechnicianVO(Technician obj) {
        this.key = obj.getId();
        this.firstName = obj.getFirstName();
        this.lastName = obj.getLastName();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.address = obj.getAddress();
        this.gender = obj.getGender();
        this.enabled = true;
        this.createdAt = obj.getCreatedAt();
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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
        if (!(o instanceof TechnicianVO that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getKey(), that.getKey()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getCpf(), that.getCpf()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getGender(), that.getGender()) && Objects.equals(getEnabled(), that.getEnabled()) && Objects.equals(getCreatedAt(), that.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getKey(), getFirstName(), getLastName(), getCpf(), getEmail(), getPassword(), getAddress(), getGender(), getEnabled(), getCreatedAt());
    }
}
