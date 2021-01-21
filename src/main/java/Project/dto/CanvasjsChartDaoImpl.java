package Project.dto;

import Project.Dni;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CanvasjsChartDaoImpl implements  CanvasjsChartDao{
    @Override
    public List<List<Map<Object, Object>>> getCanvasjsChartData(List<Dni>days) {
        return CanvasjsChartData.getCanvasjsDataList(days);
    }

}
