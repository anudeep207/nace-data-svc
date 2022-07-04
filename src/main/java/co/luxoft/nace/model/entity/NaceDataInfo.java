package co.luxoft.nace.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "nace_info")
public class NaceDataInfo {
	
	@Id
	@Column(name = "order_id")
	private Integer order;
	@Column(name = "level_no")
	private Integer level;
	@Column(name = "code")
	private String code;
	@Column(name = "parent")
	private String parent;
	@Column(name = "description")
	private String description;
	@Column(name = "item_includes")
	@Lob
	private String itemIncludes;
	@Column(name = "item_also_includes")
	@Lob
	private String itemAlsoIncludes;
	@Column(name = "rulings")
	private String rulings;
	@Column(name = "item_excludes")
	@Lob
	private String itemExcludes;
	@Column(name = "reference_to_isic")
	private String referenceToISIC;
}
