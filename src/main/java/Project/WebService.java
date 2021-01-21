package Project;

import Project.service.CanvasjsChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static org.jfree.chart.ChartUtils.writeChartAsJPEG;

@Controller
public class WebService{

public List<Dni>days = new ArrayList<>();




    String cityName;


    @RequestMapping("/")
    public String indexGet(){

        return "main";
    }

    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public ModelAndView getCityName(@RequestParam(value = "cityName") String cityName) throws IOException {
        this.cityName = cityName;
        System.out.println(cityName);
        MainApp mainApp = new MainApp();
       days = mainApp.connectByCityForXDays(cityName,5);

        return new ModelAndView("redirect:/setCityName");
    }
    int number = 0;
    String FullFileSend;
    @RequestMapping(value = "/setCityName")
    public String setCityName(Model model){
        model.addAttribute("weather",days);
//        DrawChart drawChart = new DrawChart();
//        BufferedImage image = drawChart.DrawChart(days);
//        String filename = "image";
//        String fileEnd = ".png";
//        String path = new File("").getAbsolutePath();
//        StringBuffer fileN = new StringBuffer();
//        fileN.append(filename);
//        fileN.append(number);
//        fileN.append(fileEnd);
//        String fullFileName = fileN.toString();
//        System.out.println(fullFileName);
//        File inputfile = new File(path + File.separator +"src" +File.separator +"main" + File.separator + "resources" + File.separator + "Static" + File.separator + "Image" + File.separator + fullFileName);
//
//        String sendFile = "Image/image";
//        StringBuffer fileS = new StringBuffer();
//        fileS.append(sendFile);
//        fileS.append(number);
//        fileS.append(fileEnd);
//        FullFileSend = fileS.toString();
//        System.out.println(FullFileSend);
//        ImageIO.write(image,"png",inputfile);
//        number = number + 1;

        return "main";

    }
    Image img = null;
    String bytes;
DrawChart drawChart = new DrawChart();
    @RequestMapping(value = "/drawImage")
    public String drawImage(ModelMap model) throws IOException {
        if(days!=null) {

//                img = ImageIO.read(new File("image2.png"));
//            } catch (IOException e) {
//            }

        int number = drawChart.DrawChart(days);
        String sendFile = "Image/image";
            String fileEnd = ".png";
        StringBuffer fileS = new StringBuffer();
        fileS.append(sendFile);
        fileS.append(number);
        fileS.append(fileEnd);
        FullFileSend = fileS.toString();

            System.out.println(FullFileSend);
           model.addAttribute("photoLink",FullFileSend);


        }else {return "main";}



        return "image";
    }

//    @GetMapping("/image/display")
//    @ResponseBody
//    void showImage(HttpServletResponse response)
//            throws ServletException, IOException {
//
//
//
//        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
//        response.getOutputStream().write(Integer.parseInt(bytes));
//        response.getOutputStream().close();
//    }


    @RequestMapping(value = "/back")
    public String back(){
        return "main";
    }


//    @RequestMapping(value = "/drawImage" ,method = RequestMethod.GET)
//    public String springMVC(ModelMap modelMap) {
//        List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData(days);
//        modelMap.addAttribute("dataPointsList", canvasjsDataList);
//        return "Test";
//    }


}
