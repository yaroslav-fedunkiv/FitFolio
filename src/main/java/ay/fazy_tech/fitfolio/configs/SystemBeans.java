package ay.fazy_tech.fitfolio.configs;

import org.modelmapper.*;
import org.modelmapper.convention.NamingConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Configuration
public class SystemBeans {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();
        Provider<LocalDateTime> localDateTimeProvider = new AbstractProvider<LocalDateTime>() {
            @Override
            public LocalDateTime get() {
                return LocalDateTime.now().withNano(0);
            }
        };
        Provider<LocalDate> localDateProvider = new AbstractProvider<LocalDate>() {
            @Override
            public LocalDate get() {
                return LocalDate.now();
            }
        };

        Converter<String, LocalDateTime> toStringDateTime = new AbstractConverter<String, LocalDateTime>() {
            @Override
            protected LocalDateTime convert(String source) {
                DateTimeFormatter format = DateTimeFormatter.ISO_DATE_TIME;
                return LocalDateTime.parse(source, format);
            }
        };

        Converter<String, LocalDate> toStringDate = new AbstractConverter<String, LocalDate>() {
            @Override
            protected LocalDate convert(String source) {
                DateTimeFormatter format = DateTimeFormatter.ISO_DATE;
                return LocalDate.parse(source, format);
            }
        };

        mapper.createTypeMap(String.class, LocalDate.class);
        mapper.addConverter(toStringDateTime);
        mapper.addConverter(toStringDate);
        mapper.getTypeMap(String.class, LocalDateTime.class).setProvider(localDateTimeProvider);
        mapper.getTypeMap(String.class, LocalDate.class).setProvider(localDateProvider);

        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
        return mapper;
    }
}
