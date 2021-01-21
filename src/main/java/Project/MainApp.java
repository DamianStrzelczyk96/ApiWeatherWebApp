package Project;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainApp{




//    private Scanner scanner;

//    private void startApp() {
//        scanner = new Scanner(System.in);
//        System.out.println("Wybierz po czym chcesz znaleźć miejsce dla którego wyświetlisz pogodę \n" +
//                "0 - Zakończ działanie \n1 - Nazwa Miasta \n2 - Kod pocztowy\n" +
//                "3 - Nazwa miasta-prognoza na kilka dni\n4 - Kod pocztowy-prognoza na kilka dni");
//        Integer name = scanner.nextInt();
//        chooseTypeSearching(name);
//    }

//    private void chooseTypeSearching(Integer typeNumber) {
//        switch (typeNumber) {
//            case 0:
//                break;
//            case 1:
//                connectByCityName();
//                startApp();
//                break;
//            case 2:
//                connectByZipCode();
//                startApp();
//                break;

//            case 3:
//                connectByCityForXDays();
//                startApp();
//                break;

//            case 4:
//                connectByZipCodeForXDays();
//                startApp();
//                break;
//        }
//    }

//    private void connectByCityName() {
//      System.out.println("Podaj nazwe miasta: ");
//      String cityName = scanner.next();
//        try {
//            String response = new HttpService().connect(Config.APP_URL + "?q=" + cityName + "&appid=" + Config.APP_ID);
//            parseJson(response);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public String connectByCityName(String cityName) {
//        String response = null;
//        try {
//            response = new HttpService().connect(Config.APP_URL + "?q=" + cityName + "&appid=" + Config.APP_ID);
//            parseJson(response);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return response;
//    }


//    private void connectByZipCode() {
//        System.out.println("Podaj kod pocztowy miasta: ");
//        String zipcode = scanner.next();
//        try {
//            String response = new HttpService().connect(Config.APP_URL + "?zip=" + zipcode + ",pl" + "&appid=" + Config.APP_ID);
//            parseJson(response);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public String connectByZipCode(String zipcode) {
//        String response = null;
//        try {
//             response = new HttpService().connect(Config.APP_URL + "?zip=" + zipcode + ",pl" + "&appid=" + Config.APP_ID);
//            parseJson(response);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return response;
//    }



//    private void parseJson(String json) {
//        double temp;
//        int humidity;
//        int pressure;
//        int clouds;
//
//        JSONObject rootObject = new JSONObject(json);
//        if (rootObject.getInt("cod") == 200) {
//            JSONObject mainObject = rootObject.getJSONObject("main");
//            DecimalFormat df = new DecimalFormat("#.##");
//            temp = mainObject.getDouble("temp");
////            temp = temp - 273;
//
//            humidity = mainObject.getInt("humidity");
//            pressure = mainObject.getInt("pressure");
//            JSONObject cloudsObject = rootObject.getJSONObject("clouds");
//            clouds = cloudsObject.getInt("all");
//
//            System.out.println("Temperatura: " + df.format(temp) + " C");
//            System.out.println("Wilgotność: " + humidity + " %");
//            System.out.println("Zachmurzenie: " + clouds + "%");
//            System.out.println("Ciśnienie: " + pressure + " hPa");
//
//        } else {
//            System.out.println("Error");
//        }
//    }
    public List<Dni> connectByCityForXDays(String cityName, int iloscDni) throws IOException {
        String response = null;
        try {
            response = new HttpService().connect( Config.APP_URL_DAILY+"q="+cityName+"&appid="+Config.APP_ID);


        } catch (IOException e) {
            e.printStackTrace();
              }
        return parseJsonForXDays(response,iloscDni);
    }

//    private void connectByZipCodeForXDays() {
//        System.out.println("Podaj kod pocztowy miasta: ");
//        String zipcode = scanner.next();
//        try {
//            String response = new HttpService().connect(Config.APP_URL_DAILY + "zip=" + zipcode + ",pl"
//                    + "&appid=" + Config.APP_ID);
//            parseJsonForXDays(response,);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public List<Dni> parseJsonForXDays(String json, int iloscDni) throws IOException {
        double temp;
        int humidity;
        int pressure;
        int clouds;
        List<Dni> listadni = new ArrayList<>();
        JSONObject rootObject = new JSONObject(json);
//        System.out.println(rootObject);
        if (rootObject.getInt("cod") == 200) {

            JSONArray listJsonArray = rootObject.getJSONArray("list");

            int ktorydzien=0;
            for (int i=0 ; i<iloscDni*8 ; i++){

                JSONObject one = (JSONObject) listJsonArray.get(i);
                Dni dni = new Dni();
                JSONObject main = one.getJSONObject("main");
//                temp = main.getDouble("temp");
                dni.setTemp(main.getDouble("temp"));
//                humidity = main.getInt("humidity");
                dni.setHumidity(main.getInt("humidity"));
                dni.setPressure(main.getInt("pressure"));
                JSONObject cloud = one.getJSONObject("clouds");
                dni.setClouds(cloud.getInt("all"));
                JSONObject wind = one.getJSONObject("wind");
                dni.setWind(wind.getDouble("speed"));
                dni.setDzien(ktorydzien);
                JSONArray pogoda = one.getJSONArray("weather");
                JSONObject opis = pogoda.getJSONObject(0);
                dni.setOpis(opis.getString("description"));
                dni.setData(one.getString("dt_txt"));

                try {
                    JSONObject snow = one.getJSONObject("snow");
                    dni.setSnow(snow.getDouble("3h"));
                }catch (JSONException e){

                }


                listadni.add(dni);
                ktorydzien++;


            }


        } else {
            System.out.println("Error");
        }

        return listadni;
    }


//    public Object parseJsonForXDays(String json, int iloscDni) throws IOException {
//        double temp=0;
//        JSONObject rootObject = new JSONObject(json);
//        String err = "Error";
//
//        if (rootObject.getInt("cod") == 200) {
////            System.out.println("Podaj ilość dni");
////            iloscDni = scanner.nextInt();
//            JSONArray listJsonArray = rootObject.getJSONArray("list");
//            List<Dni> listadni = new ArrayList<>();
//            int ktorydzien=0;
//            for (int i=0 ; i<iloscDni*8 ; i++){
//
//                JSONObject one = (JSONObject) listJsonArray.get(i);
//                Dni dni = new Dni();
//                JSONObject main = one.getJSONObject("main");
//                temp = main.getDouble("temp");
//                dni.setTemp(main.getDouble("temp"));
//                dni.setHumidity(main.getInt("humidity"));
//                dni.setPressure(main.getInt("pressure"));
//                JSONObject cloud = one.getJSONObject("clouds");
//                dni.setClouds(cloud.getInt("all"));
//                JSONObject wind = one.getJSONObject("wind");
//                dni.setWind(wind.getDouble("speed"));
//                dni.setDzien(ktorydzien);
//                JSONArray pogoda = one.getJSONArray("weather");
//                JSONObject opis = pogoda.getJSONObject(0);
//                dni.setOpis(opis.getString("description"));
//                listadni.add(dni);
//                ktorydzien++;
//                i=i+7;
//
//            }
//            System.out.println(listadni);
//            System.out.println("*Dane podawane są dla tej samej godziny w ciągu dnia o której program został włączony");
//            DrawChart chart = new DrawChart(listadni);
//            chart.LineChartEx();
//            return temp ;
//        } else {
//           return null;
//        }
//
//    }





//    @Override
//    public void run() {
//        startApp();
//    }
}
