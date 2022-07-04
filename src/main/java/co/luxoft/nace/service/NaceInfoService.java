package co.luxoft.nace.service;

import java.io.InputStream;

import org.springframework.stereotype.Service;

import co.luxoft.nace.model.NaceData;
import co.luxoft.nace.model.ResponseStatus;

@Service
public interface NaceInfoService {

	/**
	 * Process CSV input file and store the data
	 * 
	 * @param fileInputStream Input Stream of CSV file
	 * @return ResponseStatus
	 */
	ResponseStatus processCsvFile(InputStream fileInputStream);
	
	/**
	 * Retrieve NACE data based on Order
	 * 
	 * @param order order
	 * @return NaceData
	 */
	NaceData getNaceDetails(final Integer order);
}
