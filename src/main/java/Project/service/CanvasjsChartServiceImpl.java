package Project.service;

import Project.dto.CanvasjsChartDao;
import Project.Dni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CanvasjsChartServiceImpl implements CanvasjsChartService{
    @Autowired
    private CanvasjsChartDao canvasjsChartDao;

    public void setCanvasjsChartDao(CanvasjsChartDao canvasjsChartDao) {
        this.canvasjsChartDao = canvasjsChartDao;
    }


    @Override
    public List<List<Map<Object, Object>>> getCanvasjsChartData(List<Dni> days) {
        return canvasjsChartDao.getCanvasjsChartData(days);
    }
}
