import org.json.JSONObject;
import org.junit.jupiter.api.*;
import java.io.IOException;
public class MainAppTest {
    @BeforeAll
    static void init() {
        System.out.println("Rozpoczęcie testów aplikacji");
    }
    @Test
    @DisplayName("Główny test połączenia")
    @Tag("dev")
    void connectionTest() {
        HttpService httpService = new HttpService();
        JSONObject rootObject = null;
        try {
            String respone = httpService.connect(Config.APP_URL + "?q=" + "Warszawa" + "&appid=" + Config.APP_ID);
            rootObject = new JSONObject(respone);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertTrue(rootObject.getInt("cod") == 200);
    }
    @Test
    @DisplayName("Test pogody dla miasta Warszawa")
     void connectByCityNameTest() {
        MainApp mainApp = new MainApp();
        String responseTest = mainApp.connectByCityName("Warsaw");
        JSONObject jsonObject = new JSONObject(responseTest);
        Assertions.assertEquals(200, jsonObject.getInt("cod"));
        Assertions.assertEquals("Warsaw", jsonObject.getString("name"));
    }

    @Test
    @DisplayName("Test pogody dla miasta Warszawa")
    void connectByZipCodeTest() {
        MainApp mainApp = new MainApp();
        String responseTest = mainApp.connectByZipCode("05-600");
        JSONObject jsonObject = new JSONObject(responseTest);
        Assertions.assertEquals(200, jsonObject.getInt("cod"));
        Assertions.assertEquals("Grójec", jsonObject.getString("name"));
    }
    @Test
//    @Disabled("Nie została obsłużona")
    @DisplayName("Test parseJsonForXDays")
    void parseJsonForXDaysTest() {
        //TODO
        String json = "{\n" +
                "\"cod\": \"200\",\n" +
                "\"message\": 0.0036,\n" +
                "\"cnt\": 40,\n" +
                "\"list\": [\n" +
                "{\n" +
                "\"dt\": 1485799200,\n" +
                "\"main\": {\n" +
                "\"temp\": 261.45,\n" +
                "\"temp_min\": 259.086,\n" +
                "\"temp_max\": 261.45,\n" +
                "\"pressure\": 1023.48,\n" +
                "\"sea_level\": 1045.39,\n" +
                "\"grnd_level\": 1023.48,\n" +
                "\"humidity\": 79,\n" +
                "\"temp_kf\": 2.37\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"02n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 8\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 4.77,\n" +
                "\"deg\": 232.505\n" +
                "},\n" +
                "\"snow\": {},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-01-30 18:00:00\"\n" +
                "},\n" +
                "{},\n" +
                "{\n" +
                "\"dt\": 1485820800,\n" +
                "\"main\": {\n" +
                "\"temp\": 261.76,\n" +
                "\"temp_min\": 260.571,\n" +
                "\"temp_max\": 261.76,\n" +
                "\"pressure\": 1021.34,\n" +
                "\"sea_level\": 1043.21,\n" +
                "\"grnd_level\": 1021.34,\n" +
                "\"humidity\": 84,\n" +
                "\"temp_kf\": 1.18\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 600,\n" +
                "\"main\": \"Snow\",\n" +
                "\"description\": \"light snow\",\n" +
                "\"icon\": \"13n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 68\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 4.71,\n" +
                "\"deg\": 243\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.058\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-01-31 00:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1485831600,\n" +
                "\"main\": {\n" +
                "\"temp\": 261.46,\n" +
                "\"temp_min\": 260.865,\n" +
                "\"temp_max\": 261.46,\n" +
                "\"pressure\": 1019.95,\n" +
                "\"sea_level\": 1041.79,\n" +
                "\"grnd_level\": 1019.95,\n" +
                "\"humidity\": 82,\n" +
                "\"temp_kf\": 0.59\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 600,\n" +
                "\"main\": \"Snow\",\n" +
                "\"description\": \"light snow\",\n" +
                "\"icon\": \"13n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 68\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 4.46,\n" +
                "\"deg\": 244.5\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.05225\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-01-31 03:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1485842400,\n" +
                "\"main\": {\n" +
                "\"temp\": 260.981,\n" +
                "\"temp_min\": 260.981,\n" +
                "\"temp_max\": 260.981,\n" +
                "\"pressure\": 1018.96,\n" +
                "\"sea_level\": 1040.84,\n" +
                "\"grnd_level\": 1018.96,\n" +
                "\"humidity\": 81,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 600,\n" +
                "\"main\": \"Snow\",\n" +
                "\"description\": \"light snow\",\n" +
                "\"icon\": \"13d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 80\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 4.21,\n" +
                "\"deg\": 245.005\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.19625\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-01-31 06:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1485853200,\n" +
                "\"main\": {\n" +
                "\"temp\": 262.308,\n" +
                "\"temp_min\": 262.308,\n" +
                "\"temp_max\": 262.308,\n" +
                "\"pressure\": 1018.1,\n" +
                "\"sea_level\": 1039.77,\n" +
                "\"grnd_level\": 1018.1,\n" +
                "\"humidity\": 91,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 600,\n" +
                "\"main\": \"Snow\",\n" +
                "\"description\": \"light snow\",\n" +
                "\"icon\": \"13d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 88\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 4.1,\n" +
                "\"deg\": 249.006\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.535\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-01-31 09:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1485864000,\n" +
                "\"main\": {\n" +
                "\"temp\": 263.76,\n" +
                "\"temp_min\": 263.76,\n" +
                "\"temp_max\": 263.76,\n" +
                "\"pressure\": 1016.86,\n" +
                "\"sea_level\": 1038.4,\n" +
                "\"grnd_level\": 1016.86,\n" +
                "\"humidity\": 87,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 600,\n" +
                "\"main\": \"Snow\",\n" +
                "\"description\": \"light snow\",\n" +
                "\"icon\": \"13d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 68\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3.87,\n" +
                "\"deg\": 254.5\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.21\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-01-31 12:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1485874800,\n" +
                "\"main\": {\n" +
                "\"temp\": 264.182,\n" +
                "\"temp_min\": 264.182,\n" +
                "\"temp_max\": 264.182,\n" +
                "\"pressure\": 1016.19,\n" +
                "\"sea_level\": 1037.77,\n" +
                "\"grnd_level\": 1016.19,\n" +
                "\"humidity\": 89,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 600,\n" +
                "\"main\": \"Snow\",\n" +
                "\"description\": \"light snow\",\n" +
                "\"icon\": \"13n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 76\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3.67,\n" +
                "\"deg\": 257.001\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.1375\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-01-31 15:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1485885600,\n" +
                "\"main\": {\n" +
                "\"temp\": 264.67,\n" +
                "\"temp_min\": 264.67,\n" +
                "\"temp_max\": 264.67,\n" +
                "\"pressure\": 1015.32,\n" +
                "\"sea_level\": 1036.94,\n" +
                "\"grnd_level\": 1015.32,\n" +
                "\"humidity\": 86,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 600,\n" +
                "\"main\": \"Snow\",\n" +
                "\"description\": \"light snow\",\n" +
                "\"icon\": \"13n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 88\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3.61,\n" +
                "\"deg\": 262.503\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.1425\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-01-31 18:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1485896400,\n" +
                "\"main\": {\n" +
                "\"temp\": 265.436,\n" +
                "\"temp_min\": 265.436,\n" +
                "\"temp_max\": 265.436,\n" +
                "\"pressure\": 1014.27,\n" +
                "\"sea_level\": 1035.76,\n" +
                "\"grnd_level\": 1014.27,\n" +
                "\"humidity\": 90,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 600,\n" +
                "\"main\": \"Snow\",\n" +
                "\"description\": \"light snow\",\n" +
                "\"icon\": \"13n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 80\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3.67,\n" +
                "\"deg\": 266.5\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.1625\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-01-31 21:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1485907200,\n" +
                "\"main\": {\n" +
                "\"temp\": 266.104,\n" +
                "\"temp_min\": 266.104,\n" +
                "\"temp_max\": 266.104,\n" +
                "\"pressure\": 1013.1,\n" +
                "\"sea_level\": 1034.62,\n" +
                "\"grnd_level\": 1013.1,\n" +
                "\"humidity\": 90,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 600,\n" +
                "\"main\": \"Snow\",\n" +
                "\"description\": \"light snow\",\n" +
                "\"icon\": \"13n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 80\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3.81,\n" +
                "\"deg\": 269.004\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.1025\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-01 00:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1485918000,\n" +
                "\"main\": {\n" +
                "\"temp\": 266.904,\n" +
                "\"temp_min\": 266.904,\n" +
                "\"temp_max\": 266.904,\n" +
                "\"pressure\": 1011.96,\n" +
                "\"sea_level\": 1033.47,\n" +
                "\"grnd_level\": 1011.96,\n" +
                "\"humidity\": 89,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 600,\n" +
                "\"main\": \"Snow\",\n" +
                "\"description\": \"light snow\",\n" +
                "\"icon\": \"13n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 76\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 4.26,\n" +
                "\"deg\": 274.002\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.12\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-01 03:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1485928800,\n" +
                "\"main\": {\n" +
                "\"temp\": 268.102,\n" +
                "\"temp_min\": 268.102,\n" +
                "\"temp_max\": 268.102,\n" +
                "\"pressure\": 1011.23,\n" +
                "\"sea_level\": 1032.62,\n" +
                "\"grnd_level\": 1011.23,\n" +
                "\"humidity\": 89,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 600,\n" +
                "\"main\": \"Snow\",\n" +
                "\"description\": \"light snow\",\n" +
                "\"icon\": \"13d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 76\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 4.4,\n" +
                "\"deg\": 283.501\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.13\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-01 06:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1485939600,\n" +
                "\"main\": {\n" +
                "\"temp\": 270.269,\n" +
                "\"temp_min\": 270.269,\n" +
                "\"temp_max\": 270.269,\n" +
                "\"pressure\": 1010.85,\n" +
                "\"sea_level\": 1032.1,\n" +
                "\"grnd_level\": 1010.85,\n" +
                "\"humidity\": 92,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 600,\n" +
                "\"main\": \"Snow\",\n" +
                "\"description\": \"light snow\",\n" +
                "\"icon\": \"13d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 64\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 4.53,\n" +
                "\"deg\": 297.5\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.1875\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-01 09:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1485950400,\n" +
                "\"main\": {\n" +
                "\"temp\": 270.585,\n" +
                "\"temp_min\": 270.585,\n" +
                "\"temp_max\": 270.585,\n" +
                "\"pressure\": 1010.49,\n" +
                "\"sea_level\": 1031.65,\n" +
                "\"grnd_level\": 1010.49,\n" +
                "\"humidity\": 89,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 600,\n" +
                "\"main\": \"Snow\",\n" +
                "\"description\": \"light snow\",\n" +
                "\"icon\": \"13d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 76\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 4.31,\n" +
                "\"deg\": 302.004\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.065\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-01 12:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1485961200,\n" +
                "\"main\": {\n" +
                "\"temp\": 269.661,\n" +
                "\"temp_min\": 269.661,\n" +
                "\"temp_max\": 269.661,\n" +
                "\"pressure\": 1010.22,\n" +
                "\"sea_level\": 1031.49,\n" +
                "\"grnd_level\": 1010.22,\n" +
                "\"humidity\": 89,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 600,\n" +
                "\"main\": \"Snow\",\n" +
                "\"description\": \"light snow\",\n" +
                "\"icon\": \"13n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 68\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 4.91,\n" +
                "\"deg\": 296.5\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.0825\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-01 15:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1485972000,\n" +
                "\"main\": {\n" +
                "\"temp\": 269.155,\n" +
                "\"temp_min\": 269.155,\n" +
                "\"temp_max\": 269.155,\n" +
                "\"pressure\": 1009.95,\n" +
                "\"sea_level\": 1031.3,\n" +
                "\"grnd_level\": 1009.95,\n" +
                "\"humidity\": 89,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 600,\n" +
                "\"main\": \"Snow\",\n" +
                "\"description\": \"light snow\",\n" +
                "\"icon\": \"13n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 80\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 5.7,\n" +
                "\"deg\": 310.501\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.11\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-01 18:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1485982800,\n" +
                "\"main\": {\n" +
                "\"temp\": 268.056,\n" +
                "\"temp_min\": 268.056,\n" +
                "\"temp_max\": 268.056,\n" +
                "\"pressure\": 1011.21,\n" +
                "\"sea_level\": 1032.49,\n" +
                "\"grnd_level\": 1011.21,\n" +
                "\"humidity\": 89,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 600,\n" +
                "\"main\": \"Snow\",\n" +
                "\"description\": \"light snow\",\n" +
                "\"icon\": \"13n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 68\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 5.56,\n" +
                "\"deg\": 333\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.225\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-01 21:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1485993600,\n" +
                "\"main\": {\n" +
                "\"temp\": 265.803,\n" +
                "\"temp_min\": 265.803,\n" +
                "\"temp_max\": 265.803,\n" +
                "\"pressure\": 1013.79,\n" +
                "\"sea_level\": 1035.06,\n" +
                "\"grnd_level\": 1013.79,\n" +
                "\"humidity\": 83,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 600,\n" +
                "\"main\": \"Snow\",\n" +
                "\"description\": \"light snow\",\n" +
                "\"icon\": \"13n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 8\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 4.8,\n" +
                "\"deg\": 355.004\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.03\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-02 00:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1486004400,\n" +
                "\"main\": {\n" +
                "\"temp\": 263.381,\n" +
                "\"temp_min\": 263.381,\n" +
                "\"temp_max\": 263.381,\n" +
                "\"pressure\": 1015.66,\n" +
                "\"sea_level\": 1037.16,\n" +
                "\"grnd_level\": 1015.66,\n" +
                "\"humidity\": 84,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"01n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 0\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 4.2,\n" +
                "\"deg\": 348.503\n" +
                "},\n" +
                "\"snow\": {},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-02 03:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1486015200,\n" +
                "\"main\": {\n" +
                "\"temp\": 261.85,\n" +
                "\"temp_min\": 261.85,\n" +
                "\"temp_max\": 261.85,\n" +
                "\"pressure\": 1017.63,\n" +
                "\"sea_level\": 1039.22,\n" +
                "\"grnd_level\": 1017.63,\n" +
                "\"humidity\": 76,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"01d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 0\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3.81,\n" +
                "\"deg\": 345.502\n" +
                "},\n" +
                "\"snow\": {},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-02 06:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1486026000,\n" +
                "\"main\": {\n" +
                "\"temp\": 263.455,\n" +
                "\"temp_min\": 263.455,\n" +
                "\"temp_max\": 263.455,\n" +
                "\"pressure\": 1019.32,\n" +
                "\"sea_level\": 1040.84,\n" +
                "\"grnd_level\": 1019.32,\n" +
                "\"humidity\": 84,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"01d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 0\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3.06,\n" +
                "\"deg\": 344.004\n" +
                "},\n" +
                "\"snow\": {},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-02 09:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1486036800,\n" +
                "\"main\": {\n" +
                "\"temp\": 264.015,\n" +
                "\"temp_min\": 264.015,\n" +
                "\"temp_max\": 264.015,\n" +
                "\"pressure\": 1020.41,\n" +
                "\"sea_level\": 1041.88,\n" +
                "\"grnd_level\": 1020.41,\n" +
                "\"humidity\": 85,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"01d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 0\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 2.52,\n" +
                "\"deg\": 334.501\n" +
                "},\n" +
                "\"snow\": {},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-02 12:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1486047600,\n" +
                "\"main\": {\n" +
                "\"temp\": 259.684,\n" +
                "\"temp_min\": 259.684,\n" +
                "\"temp_max\": 259.684,\n" +
                "\"pressure\": 1021.52,\n" +
                "\"sea_level\": 1043.21,\n" +
                "\"grnd_level\": 1021.52,\n" +
                "\"humidity\": 76,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"01n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 0\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 2.48,\n" +
                "\"deg\": 320.501\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.0024999999999999\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-02 15:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1486058400,\n" +
                "\"main\": {\n" +
                "\"temp\": 255.188,\n" +
                "\"temp_min\": 255.188,\n" +
                "\"temp_max\": 255.188,\n" +
                "\"pressure\": 1022.09,\n" +
                "\"sea_level\": 1044.09,\n" +
                "\"grnd_level\": 1022.09,\n" +
                "\"humidity\": 66,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 801,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"few clouds\",\n" +
                "\"icon\": \"02n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 24\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 1.23,\n" +
                "\"deg\": 283.003\n" +
                "},\n" +
                "\"snow\": {},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-02 18:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1486069200,\n" +
                "\"main\": {\n" +
                "\"temp\": 255.594,\n" +
                "\"temp_min\": 255.594,\n" +
                "\"temp_max\": 255.594,\n" +
                "\"pressure\": 1022.03,\n" +
                "\"sea_level\": 1044.12,\n" +
                "\"grnd_level\": 1022.03,\n" +
                "\"humidity\": 64,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 802,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"scattered clouds\",\n" +
                "\"icon\": \"03n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 48\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 1.22,\n" +
                "\"deg\": 244.502\n" +
                "},\n" +
                "\"snow\": {},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-02 21:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1486080000,\n" +
                "\"main\": {\n" +
                "\"temp\": 256.96,\n" +
                "\"temp_min\": 256.96,\n" +
                "\"temp_max\": 256.96,\n" +
                "\"pressure\": 1021.8,\n" +
                "\"sea_level\": 1043.77,\n" +
                "\"grnd_level\": 1021.8,\n" +
                "\"humidity\": 66,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 802,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"scattered clouds\",\n" +
                "\"icon\": \"03n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 44\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 1.23,\n" +
                "\"deg\": 237.506\n" +
                "},\n" +
                "\"snow\": {},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-03 00:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1486090800,\n" +
                "\"main\": {\n" +
                "\"temp\": 258.109,\n" +
                "\"temp_min\": 258.109,\n" +
                "\"temp_max\": 258.109,\n" +
                "\"pressure\": 1020.97,\n" +
                "\"sea_level\": 1042.99,\n" +
                "\"grnd_level\": 1020.97,\n" +
                "\"humidity\": 77,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 803,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"broken clouds\",\n" +
                "\"icon\": \"04n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 80\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 1.21,\n" +
                "\"deg\": 234.502\n" +
                "},\n" +
                "\"snow\": {},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-03 03:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1486101600,\n" +
                "\"main\": {\n" +
                "\"temp\": 259.533,\n" +
                "\"temp_min\": 259.533,\n" +
                "\"temp_max\": 259.533,\n" +
                "\"pressure\": 1020.56,\n" +
                "\"sea_level\": 1042.53,\n" +
                "\"grnd_level\": 1020.56,\n" +
                "\"humidity\": 76,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 803,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"broken clouds\",\n" +
                "\"icon\": \"04d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 68\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 1.21,\n" +
                "\"deg\": 229.509\n" +
                "},\n" +
                "\"snow\": {},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-03 06:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1486112400,\n" +
                "\"main\": {\n" +
                "\"temp\": 263.438,\n" +
                "\"temp_min\": 263.438,\n" +
                "\"temp_max\": 263.438,\n" +
                "\"pressure\": 1020.46,\n" +
                "\"sea_level\": 1042.15,\n" +
                "\"grnd_level\": 1020.46,\n" +
                "\"humidity\": 84,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 803,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"broken clouds\",\n" +
                "\"icon\": \"04d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 56\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 1.51,\n" +
                "\"deg\": 242.503\n" +
                "},\n" +
                "\"snow\": {},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-03 09:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1486123200,\n" +
                "\"main\": {\n" +
                "\"temp\": 264.228,\n" +
                "\"temp_min\": 264.228,\n" +
                "\"temp_max\": 264.228,\n" +
                "\"pressure\": 1019.58,\n" +
                "\"sea_level\": 1041.24,\n" +
                "\"grnd_level\": 1019.58,\n" +
                "\"humidity\": 89,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 803,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"broken clouds\",\n" +
                "\"icon\": \"04d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 56\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 1.58,\n" +
                "\"deg\": 242.503\n" +
                "},\n" +
                "\"snow\": {},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-03 12:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1486134000,\n" +
                "\"main\": {\n" +
                "\"temp\": 261.153,\n" +
                "\"temp_min\": 261.153,\n" +
                "\"temp_max\": 261.153,\n" +
                "\"pressure\": 1019.63,\n" +
                "\"sea_level\": 1041.42,\n" +
                "\"grnd_level\": 1019.63,\n" +
                "\"humidity\": 80,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"01n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 76\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 1.21,\n" +
                "\"deg\": 198.501\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.0049999999999999\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-03 15:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1486144800,\n" +
                "\"main\": {\n" +
                "\"temp\": 258.818,\n" +
                "\"temp_min\": 258.818,\n" +
                "\"temp_max\": 258.818,\n" +
                "\"pressure\": 1020.18,\n" +
                "\"sea_level\": 1042.03,\n" +
                "\"grnd_level\": 1020.18,\n" +
                "\"humidity\": 73,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 803,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"broken clouds\",\n" +
                "\"icon\": \"04n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 64\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 1.21,\n" +
                "\"deg\": 209.002\n" +
                "},\n" +
                "\"snow\": {},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-03 18:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1486155600,\n" +
                "\"main\": {\n" +
                "\"temp\": 257.218,\n" +
                "\"temp_min\": 257.218,\n" +
                "\"temp_max\": 257.218,\n" +
                "\"pressure\": 1020.43,\n" +
                "\"sea_level\": 1042.38,\n" +
                "\"grnd_level\": 1020.43,\n" +
                "\"humidity\": 65,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 802,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"scattered clouds\",\n" +
                "\"icon\": \"03n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 44\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 1.17,\n" +
                "\"deg\": 194.501\n" +
                "},\n" +
                "\"snow\": {},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-03 21:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1486166400,\n" +
                "\"main\": {\n" +
                "\"temp\": 255.782,\n" +
                "\"temp_min\": 255.782,\n" +
                "\"temp_max\": 255.782,\n" +
                "\"pressure\": 1020.57,\n" +
                "\"sea_level\": 1042.75,\n" +
                "\"grnd_level\": 1020.57,\n" +
                "\"humidity\": 73,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 803,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"broken clouds\",\n" +
                "\"icon\": \"04n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 56\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 1.21,\n" +
                "\"deg\": 175.001\n" +
                "},\n" +
                "\"snow\": {},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-04 00:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1486177200,\n" +
                "\"main\": {\n" +
                "\"temp\": 254.819,\n" +
                "\"temp_min\": 254.819,\n" +
                "\"temp_max\": 254.819,\n" +
                "\"pressure\": 1020.99,\n" +
                "\"sea_level\": 1043.11,\n" +
                "\"grnd_level\": 1020.99,\n" +
                "\"humidity\": 68,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"01n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 44\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 1.22,\n" +
                "\"deg\": 122.001\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.0049999999999999\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-04 03:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1486188000,\n" +
                "\"main\": {\n" +
                "\"temp\": 257.488,\n" +
                "\"temp_min\": 257.488,\n" +
                "\"temp_max\": 257.488,\n" +
                "\"pressure\": 1021.31,\n" +
                "\"sea_level\": 1043.48,\n" +
                "\"grnd_level\": 1021.31,\n" +
                "\"humidity\": 63,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 600,\n" +
                "\"main\": \"Snow\",\n" +
                "\"description\": \"light snow\",\n" +
                "\"icon\": \"13d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 68\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 2.13,\n" +
                "\"deg\": 155.501\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.04\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-04 06:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1486198800,\n" +
                "\"main\": {\n" +
                "\"temp\": 259.827,\n" +
                "\"temp_min\": 259.827,\n" +
                "\"temp_max\": 259.827,\n" +
                "\"pressure\": 1021.81,\n" +
                "\"sea_level\": 1043.67,\n" +
                "\"grnd_level\": 1021.81,\n" +
                "\"humidity\": 90,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 600,\n" +
                "\"main\": \"Snow\",\n" +
                "\"description\": \"light snow\",\n" +
                "\"icon\": \"13d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 68\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 2.07,\n" +
                "\"deg\": 170.005\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.03\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-04 09:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1486209600,\n" +
                "\"main\": {\n" +
                "\"temp\": 261.256,\n" +
                "\"temp_min\": 261.256,\n" +
                "\"temp_max\": 261.256,\n" +
                "\"pressure\": 1021.31,\n" +
                "\"sea_level\": 1043.05,\n" +
                "\"grnd_level\": 1021.31,\n" +
                "\"humidity\": 86,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"01d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 76\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 2.32,\n" +
                "\"deg\": 175.001\n" +
                "},\n" +
                "\"snow\": {\n" +
                "\"3h\": 0.0049999999999999\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-04 12:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1486220400,\n" +
                "\"main\": {\n" +
                "\"temp\": 260.26,\n" +
                "\"temp_min\": 260.26,\n" +
                "\"temp_max\": 260.26,\n" +
                "\"pressure\": 1021,\n" +
                "\"sea_level\": 1042.96,\n" +
                "\"grnd_level\": 1021,\n" +
                "\"humidity\": 86,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 803,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"broken clouds\",\n" +
                "\"icon\": \"04n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 56\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 2.47,\n" +
                "\"deg\": 180.501\n" +
                "},\n" +
                "\"snow\": {},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2017-02-04 15:00:00\"\n" +
                "}\n" +
                "],\n" +
                "\"city\": {\n" +
                "\"id\": 524901,\n" +
                "\"name\": \"Moscow\",\n" +
                "\"coord\": {\n" +
                "\"lat\": 55.7522,\n" +
                "\"lon\": 37.6156\n" +
                "},\n" +
                "\"country\": \"none\"\n" +
                "}\n" +
                "}" ;

         MainApp mainApp = new MainApp();
         Assertions.assertEquals(261.45,mainApp.parseJsonForXDays(json,1));
//         mainApp.parseJsonForXDays(json,1);

    }
    @AfterAll
    static void done() {
        System.out.println("Zakończenie testów");
    }
}
