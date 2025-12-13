package com.iss.springboot.Controllers;

import com.iss.springboot.Models.Calculate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Math")
public class MathController {

    @PostMapping("/sum")
//    @ResponseBody  use the responsebody very wisely and that too for testing
    public String sum(Model model, Calculate calculate)//int a,int b
    {
        //return "<h1>"+(a + b)+"</h1>";// this is without view and with using the @ResponseBody annotation
        // or we can create a view inside the resource folder if we want a html template
        // we must use the webapp/WEB-INF/views if we want our views to be jsp
        // return "sumview";
        // by simply creating a html view inside the resources directory and returing the name of that view
        // wont do the job we have to make configurations ViewResolver configurations
        // check out the application.properties for view configurations which need to be thymeleaf config for html templates

        //similarly if we have jsp templates we have to configure differently ....
        // even after configuring the jsp view we will not get the view for that we have to import the jasper jar
        // after that too we will get error because of thymleaf jars
        // so we have to comment out the thymelead dependencies in order to run the jsp templates


        // we want the result to be send to the template and displayed in the template
        // for that we have two ways 1)Model 2)ModelAndView
        calculate.setTotal(calculate.getA() + calculate.getB());
//        model.addAttribute("a", calculate.getA());
//        model.addAttribute("b", calculate.getB());
//        model.addAttribute("total", calculate.getTotal());
        model.addAttribute("calculate", calculate );
        //or
        // model.setViewName("sumview");
        // model.addObject("sum", a + b);
        // we must return the modelandview object with return type ModelandView
        return "mathindex";
    }

    @GetMapping
    public String index()
    {
        return "index";
    }
}

//NOTES:
// the Controllers folder must always be inside the main directory which is com.iss.springboot
// that is it must lie under the SpringbootApplication
// the parameters for any action must be matched with the queryparamaters for url which you are sending
// so therefore the url for this will be http://localhost:8080/Math/sum?a=10&b=10


//@ReponseBody annotation is for telling the spring that the return string is not a view but its a Response object
