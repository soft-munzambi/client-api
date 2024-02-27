package ntemo.com.apiclientes.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;



import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class DataSourceConfig {

    private final Environment env;

    public DataSourceConfig(Environment env) {
        this.env = env;
    }

    public DataSource dataSource() {
        DriverManagerDataSource dataSourceLocal = new DriverManagerDataSource();
        dataSourceLocal.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSourceLocal.setUrl(env.getProperty("DB_URL"));
        dataSourceLocal.setUsername(env.getProperty("DB_USERNAME"));
        dataSourceLocal.setPassword(env.getProperty("DB_PASSWORD"));
        return dataSourceLocal;
    }
}
