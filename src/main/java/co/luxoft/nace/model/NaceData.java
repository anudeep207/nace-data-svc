package co.luxoft.nace.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@JsonInclude(Include.NON_NULL)
public class NaceData {

	private Integer order;
	private Integer level;
	private String code;
	private String parent;
	private String description;
	private String itemIncludes;
	private String itemAlsoIncludes;
	private String rulings;
	private String itemExcludes;
	private String referenceToISIC;
}
