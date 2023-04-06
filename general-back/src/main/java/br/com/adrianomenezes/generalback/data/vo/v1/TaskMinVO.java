package br.com.adrianomenezes.generalback.data.vo.v1;

import br.com.adrianomenezes.generalback.model.Task;
import br.com.adrianomenezes.generalback.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@JsonPropertyOrder({"id","taskName","user_id","targetDate","enabled","createdAt"})
@XmlRootElement
public class TaskMinVO extends RepresentationModel<TaskMinVO> implements Serializable {

	private static final long serialVersionUID = 1L;


    @NotNull(message = "The field taskName is required")
	private String taskName;

	private Boolean checked ;

	public TaskMinVO() {
	}

    public TaskMinVO(String taskName, Boolean checked) {
        this.taskName = taskName;
        this.checked = checked;
    }

    public TaskMinVO(TaskVO task) {
        this.taskName = task.getTaskName();
        this.checked = task.getEnabled();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskMinVO taskMinVO)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getTaskName(), taskMinVO.getTaskName()) && Objects.equals(getChecked(), taskMinVO.getChecked());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTaskName(), getChecked());
    }
}
