package model;

import androidx.room.TypeConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListConverter {

    @TypeConverter
    public static String fromFloatList(List<Float> list) {
        if (list == null) return null;
        StringBuilder stringBuilder = new StringBuilder();
        for (Float weight : list) {
            stringBuilder.append(weight).append(",");
        }
        return stringBuilder.toString();
    }

    @TypeConverter
    public static List<Float> toFloatList(String data) {
        if (data == null) return null;
        List<String> stringList = Arrays.asList(data.split(","));
        List<Float> floatList = new ArrayList<>();
        for (String s : stringList) {
            floatList.add(Float.parseFloat(s));
        }
        return floatList;
    }
}
