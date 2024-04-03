package gr.knowledge.internship.banksystem.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DocumentDTO implements Serializable {
	private Long id;
	private String name;
	private String size;
	private String description;
	private String uuid;
	private FolderDTO folder;
}
