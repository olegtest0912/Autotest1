package data;

import java.util.List;

public interface IParamsProvider<T> {
    void saveData( T data);
    T loadData();
}
