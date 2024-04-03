package gr.knowledge.internship.banksystem.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name = "document")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Document implements Serializable {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_id_seq")
	@SequenceGenerator(name = "document_id_seq", sequenceName = "document_id_seq")
	private Long id;
	@Size(max = 50)
	@Column(name = "name")
	private String name;
	@Size(max = 50)
	@Column(name = "size")
	private String size;
	@Size(max = 1024)
	@Column(name = "description")
	private String description;
	@Size(max = 50)
	@Column(name = "uuid")
	private String uuid;
	@ManyToOne
	@JoinColumn(name = "folder_id", nullable = false)
	private Folder folder;
}
