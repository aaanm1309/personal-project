package br.com.adrianomenezes.generalback.data.vo.v1;

import br.com.adrianomenezes.generalback.model.Task;
import br.com.adrianomenezes.generalback.model.Technician;
import br.com.adrianomenezes.generalback.model.User;
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

@JsonPropertyOrder({"id","taskName","user_id","targetDate","enabled","createdAt"})
@XmlRootElement
public class TaskVO extends RepresentationModel<TaskVO> implements Serializable {

	private static final long serialVersionUID = 1L;


	@Mapping("id")
	@JsonProperty("id")
	private Long key;

    @NotNull(message = "The field taskName is required")
	private String taskName;

    private User user;

    @NotNull(message = "The field targetDate is required")
    private LocalDate targetDate = LocalDate.now();

	private Boolean enabled = true;
    private LocalDate createdAt = LocalDate.now();

	public TaskVO() {
	}

    public TaskVO(Long key, String taskName, User user, LocalDate targetDate, Boolean enabled, LocalDate createdAt) {
        this.key = key;
        this.taskName = taskName;
        this.user = user;
        this.targetDate = targetDate;
        this.enabled = enabled;
        this.createdAt = createdAt;
    }

    public TaskVO(Task task) {
        this.key = task.getId();
        this.taskName = task.getTaskName();
        this.user = task.getUser();
        this.targetDate = task.getTargetDate();
        this.enabled = task.getEnabled();
        this.createdAt = task.getCreatedAt();
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
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
        if (!(o instanceof TaskVO taskVO)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getKey(), taskVO.getKey()) && Objects.equals(getTaskName(), taskVO.getTaskName()) && Objects.equals(getUser(), taskVO.getUser()) && Objects.equals(getTargetDate(), taskVO.getTargetDate()) && Objects.equals(getEnabled(), taskVO.getEnabled()) && Objects.equals(getCreatedAt(), taskVO.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getKey(), getTaskName(), getUser(), getTargetDate(), getEnabled(), getCreatedAt());
    }
}
