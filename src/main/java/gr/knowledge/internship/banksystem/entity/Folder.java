package gr.knowledge.internship.banksystem.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "folder")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Folder implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "folder_id_seq")
	@SequenceGenerator(name = "folder_id_seq", sequenceName = "folder_id_seq")
	@NotNull
	private Long id;

	@Size(max = 1024)
	@Column(name = "description")
	private String description;
}
