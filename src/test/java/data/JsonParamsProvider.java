package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

public class JsonParamsProvider<T> implements IParamsProvider<T> {

    private String mFileName;
    private Type mType;

    public JsonParamsProvider(String fileName, Type mType) {
        this.mFileName = fileName;
        this.mType = mType;
    }

    @Override
    public void saveData(T data) {
        String json = new Gson().toJson(data);

        try {
            File file = new File(mFileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(mFileName);
            fileWriter.write(json);
            fileWriter.close();
            System.out.println("Param data saved in json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T loadData() {
        try {
            File file = new File(mFileName);
            if (!file.exists()) {
                return null;
            }

            FileReader fileReader = new FileReader(mFileName);
            return new Gson().fromJson(fileReader, mType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
