

public class Dni {
    double temp;
    int humidity;
    int pressure;
    int clouds;
    double wind;
    int dzien;
    String opis;

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        this.wind = wind;
    }

    public Dni() {
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public int getDzien() {
        return dzien;
    }

    public void setDzien(int dzien) {
        this.dzien = dzien;
    }

    @Override
    public String toString() {
        return "Dzień" +dzien + ": " +
                "Temperatura= " + temp +"F"+
                ", wilgotność= " + humidity +
                ", ciśnienie= " + pressure + "hPa"+
                ", chmury= " + clouds +
                ", wiatr= " + wind +"km/h."+", Opis="+opis + "\n";
    }
}
