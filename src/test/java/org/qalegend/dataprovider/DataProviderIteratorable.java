package org.qalegend.dataprovider;

public class DataProviderIteratorable {
    @org.testng.annotations.DataProvider(name="InvalidUserCredentials")
    public Object[][] userCredentialData() {
        Object[][] data = new Object[3][2];
        data[0][0] = "vinitha.edwin.test@gmail.com";
        data[0][1] = "Simple@123";
        data[1][0] = "vinithaedwin.test123@gmail.com";
        data[1][1] = "Simple@123";
        data[2][0] = "vinithaedwin.test@gmail.com";
        data[2][1] = "Simple@123456";
        return data;
    }
    }
