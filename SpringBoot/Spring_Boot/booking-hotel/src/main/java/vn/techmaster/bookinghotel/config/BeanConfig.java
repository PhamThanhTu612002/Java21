package vn.techmaster.bookinghotel.config;

import com.github.slugify.Slugify;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BeanConfig {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public Slugify slugify(){
        return Slugify.builder().build();
    }
    @Bean
    public ModelMapper modelMapper() {
        // Tạo object và cấu hình
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
