package ntemo.com.apiclientes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class DataSourceService {
  
    private final DataSource dataSource;

    @Autowired
    public DataSourceService(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
