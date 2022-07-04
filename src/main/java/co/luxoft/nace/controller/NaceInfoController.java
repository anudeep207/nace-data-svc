package co.luxoft.nace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.luxoft.nace.model.NaceData;
import co.luxoft.nace.model.ResponseStatus;
import co.luxoft.nace.service.NaceInfoService;
import co.luxoft.nace.utils.Constant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(
		name = "Nace Info controller",
		description = "To receive any Nace details Info calls"
)
public class NaceInfoController {
	
	@Autowired
	private NaceInfoService naceInfoService;

	@Operation(description = "To receive CSV file and persist NACE deatais")
	@ApiResponse(responseCode = "200", description = "Successfully saved the NACE details from CSV file")
	@ApiResponse(responseCode = "400", description = "If the file is not valid")
	@ApiResponse(responseCode = "500", description = "Unexpected error")
	@PostMapping(value = Constant.NACE_INFO_SAVE_URL, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ResponseStatus> putNaceDetails(
			@Parameter(description = "NACE details file", required = true)
			@RequestParam("nace_file") MultipartFile file) throws Exception {
		ResponseStatus response = naceInfoService.processCsvFile(file.getInputStream());
		return ResponseEntity.ok(response);
	}
	
	@Operation(description = "To retrieve NACE deatais based on order")
	@ApiResponse(responseCode = "200", description = "Successfully extracted NACE details for the given order")
	@ApiResponse(responseCode = "400", description = "If the order is invalid")
	@ApiResponse(responseCode = "500", description = "Unexpected error")
	@GetMapping(value = Constant.NACE_GET_ORDER, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getNaceDetails(
			@Parameter(description = "NACE order", required = true)
			@PathVariable("order") Integer order) {
		final NaceData naceData = naceInfoService.getNaceDetails(order);
		return null == naceData ? 
				ResponseEntity.ok(
						ResponseStatus.builder()
							.status(Constant.ResponseStatus.FAIL.name())
							.code("400")
							.cause("No data present for this order " + order)
							.build()) 
				: ResponseEntity.ok(naceData);
	}
}
