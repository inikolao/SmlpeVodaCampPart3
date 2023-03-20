package iniko.Voda.Controlers;


import iniko.Voda.DTO.StarterElent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class ExampleX {

    @RequestMapping("/ex")
    public @ResponseBody Iterable<StarterElent> Getit()
    {
        ArrayList<StarterElent> list =new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            list.add(new StarterElent(i,"papaki"));
        }


        return list;
    }
    @RequestMapping("/index")
    public String Getit(Model model)
    {
         return "kati";
    }
}
