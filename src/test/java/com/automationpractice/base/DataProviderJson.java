package com.automationpractice.base;

import com.automationpractice.model.Address;
import com.automationpractice.model.PersonalInformation;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * Created by 0tanya0 on 5/12/2018.
 */
public class DataProviderJson {
    @DataProvider(name = "getUserData")
    public Object[][] getData() throws FileNotFoundException {
        FileReader reader = new FileReader("src/test/resources/testData.json");
        TypeToken<List<PersonalInformation>> typeToken = new TypeToken<List<PersonalInformation>>() {};
        List<PersonalInformation> testData = new Gson().fromJson(reader, typeToken.getType());
        Object[][] returnValue = new Object[testData.size()][];
        for (int i=0; i<returnValue.length; i++){
            returnValue[i] = new Object[] {testData.get(i)};
        }
        return returnValue;
    }

}
