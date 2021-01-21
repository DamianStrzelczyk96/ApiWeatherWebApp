package Project;

public class CheckDay {
    Dni dni;

    public CheckDay(Dni day) {
        this.dni =day;
    }
    public Double WitchHour(){
      String data =  dni.getData();
String[] split = data.split(" ");
        String hours = split[1];
        System.out.println(hours);

        char hour0 = hours.charAt(0);
        char hour1 = hours.charAt(1);

        StringBuilder times = new StringBuilder();
        times.append(hour0);
        times.append(hour1);
        String realtime = times.toString();

        double time = Double.parseDouble(realtime);
        System.out.println(time);
        return time;
    }
}
