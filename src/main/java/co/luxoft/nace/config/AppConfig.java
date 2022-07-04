package co.luxoft.nace.config;

import org.springframework.context.annotation.Import;

@Import({
	SwaggerConfig.class,
	CsvParserConfig.class
})
public class AppConfig {

}
