package blog.data;

// Generated 2016-3-31 0:33:16 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Menuinfo generated by hbm2java
 */
@Entity
@Table(name = "menuinfo", catalog = "tymitecblog")
public class Menuinfo implements java.io.Serializable {

	private Integer id;
	private String name;

	public Menuinfo() {
	}

	public Menuinfo(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "Name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
