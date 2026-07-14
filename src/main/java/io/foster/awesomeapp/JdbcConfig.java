package io.foster.awesomeapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;

import java.util.List;

@Configuration
public class JdbcConfig {
    @Bean
    public JdbcCustomConversions jdbcCustomConversions() {
        return new JdbcCustomConversions(List.of(
                Jsr310Converters.DateToLocalDateConverter.INSTANCE,
                Jsr310Converters.LocalDateToDateConverter.INSTANCE,

                Jsr310Converters.DateToLocalDateTimeConverter.INSTANCE,
                Jsr310Converters.LocalDateTimeToDateConverter.INSTANCE,

                Jsr310Converters.InstantToLocalDateTimeConverter.INSTANCE,
                Jsr310Converters.LocalDateTimeToInstantConverter.INSTANCE

        ));
    }
}
