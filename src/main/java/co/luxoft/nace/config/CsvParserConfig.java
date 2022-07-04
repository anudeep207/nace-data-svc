package co.luxoft.nace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

@Configuration
public class CsvParserConfig {

	@Bean
    public CsvParser getCsvParser() {
		CsvParserSettings settings = new CsvParserSettings();
		settings.setHeaderExtractionEnabled(true);
		settings.detectFormatAutomatically();
		settings.getFormat().setDelimiter("?");
		settings.getFormat().setQuote('\0');
		settings.setMaxCharsPerColumn(100000);
		return new CsvParser(settings);
    }
}
