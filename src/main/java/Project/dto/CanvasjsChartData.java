package Project.dto;

import Project.CheckDay;
import Project.Dni;
import jdk.internal.dynalink.beans.StaticClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanvasjsChartData {
    public List<Dni> dniList;
    static Map<Object,Object> map = null;
    static List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
    static List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();

    public void  getList(List<Dni> list){
        this.dniList = list;

    }

    public void putDataInList(){

        int days = 0;
        for (Dni day:dniList) {
            CheckDay day1 = new CheckDay(day);
            if(day1.WitchHour()==00){
                days = days + 1;}
            map = new HashMap<Object,Object>();
            map.put("x", (days+((day1.WitchHour()/3)*0.125)));
            map.put("y", day.getTemp());
            dataPoints1.add(map);
        }
        list.add(dataPoints1);
    }

    public static List<List<Map<Object,Object>>> getCanvasjsDataList(List<Dni> lista) {
        int days = 0;
        for (Dni day:lista) {
            CheckDay day1 = new CheckDay(day);
            if(day1.WitchHour()==00){
                days = days + 1;}
            map = new HashMap<Object,Object>();
            map.put("x", (days+((day1.WitchHour()/3)*0.125)));
            map.put("y", day.getTemp());
            dataPoints1.add(map);
        }
        list.add(dataPoints1);
        return list;
    }
}
