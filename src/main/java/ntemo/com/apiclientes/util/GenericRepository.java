package ntemo.com.apiclientes.util;

import java.util.List;

public interface GenericRepository<T> {

    List<T> allWithParm(String containers, List<String> uuid_in, List<String> dataRange);

    T one(String uuid);

    T save(T attr);

    void setTimeDelete(T entity);

    String getReferenceKey(T attr);

    void setTimeUpdate(T attr);

    void setTimeCreated(T attr);
}
