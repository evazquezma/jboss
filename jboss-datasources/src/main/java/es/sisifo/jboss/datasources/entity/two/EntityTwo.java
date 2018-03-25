package es.sisifo.jboss.datasources.entity.two;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tableTwo")
public class EntityTwo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String code;

	private Date time;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(final String code) {
		this.code = code;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(final Date time) {
		this.time = time;
	}



	@Override
	public String toString() {
		return "EntityTwo [id=" + id + ", code=" + code + ", time=" + time + "]";
	}

}
