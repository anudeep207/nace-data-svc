package co.luxoft.nace.service;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;

import co.luxoft.nace.mapper.NaceDataInfoMapper;
import co.luxoft.nace.model.NaceData;
import co.luxoft.nace.model.ResponseStatus;
import co.luxoft.nace.model.entity.NaceDataInfo;
import co.luxoft.nace.repository.NaceDetailsRepository;
import co.luxoft.nace.utils.Constant;

@Service
public class NaceInfoServiceImpl implements NaceInfoService {
	
	@Autowired
	private CsvParser csvParser;
	
	@Autowired
	private NaceDataInfoMapper mapper;
	
	@Autowired
	private NaceDetailsRepository repo;

	@Override
	public ResponseStatus processCsvFile(InputStream inputStream) {
		final List<Record> parseAllRecords = csvParser.parseAllRecords(inputStream);
		parseAllRecords.forEach(record -> {
			repo.save(mapper.mapFromCsv(record));
		});
		return ResponseStatus.builder()
				.status(Constant.ResponseStatus.SUCCESS.name())
				.build();
	}

	@Override
	public NaceData getNaceDetails(@NotNull final Integer order) {
		final Optional<NaceDataInfo> optionalNaceEntity = repo.findById(order);
		if (optionalNaceEntity.isPresent()) {
			return mapper.mapFromNaceEntity(optionalNaceEntity.get());
		}
		return null;
	}
}
