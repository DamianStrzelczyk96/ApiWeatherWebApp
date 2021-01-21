package Project.dto;

import Project.Dni;

import java.util.List;
import java.util.Map;

public interface CanvasjsChartDao {
    List<List<Map<Object, Object>>> getCanvasjsChartData(List<Dni> days);
}
