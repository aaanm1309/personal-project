package br.com.adrianomenezes.generalback.model;

import br.com.adrianomenezes.generalback.data.vo.v1.TaskVO;
import br.com.adrianomenezes.generalback.services.UserService;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="tasks")
@XmlRootElement
public class Task implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_name", nullable = false, length = 80)
    private String TaskName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private Boolean enabled;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate targetDate = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdAt = LocalDate.now();

    public Task() {
    }

    public Task(Long id, String taskName, User user, Boolean enabled, LocalDate targetDate, LocalDate createdAt) {
        this.id = id;
        TaskName = taskName;
        this.user = user;
        this.enabled = enabled;
        this.targetDate = targetDate;
        this.createdAt = createdAt;
    }

    public Task(TaskVO taskVO) {
        this.id = taskVO.getKey();
        TaskName = taskVO.getTaskName();
        this.user = taskVO.getUser();
        this.enabled = taskVO.getEnabled();
        this.targetDate = taskVO.getTargetDate();
        this.createdAt = taskVO.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(String taskName) {
        TaskName = taskName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
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
        if (!(o instanceof Task task)) return false;
        return Objects.equals(getId(), task.getId()) && Objects.equals(getTaskName(), task.getTaskName()) && Objects.equals(getUser(), task.getUser()) && Objects.equals(getEnabled(), task.getEnabled()) && Objects.equals(getTargetDate(), task.getTargetDate()) && Objects.equals(getCreatedAt(), task.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTaskName(), getUser(), getEnabled(), getTargetDate(), getCreatedAt());
    }
}
