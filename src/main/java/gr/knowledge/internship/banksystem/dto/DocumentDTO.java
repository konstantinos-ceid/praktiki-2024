package gr.knowledge.internship.banksystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DocumentDTO {
	private Long id;
	private String name;
	private String size;
	private String description;
	private String uuid;
	private FolderDTO folder;
}
