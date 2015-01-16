package cat.udl.eps.softarch.hello.controller;

import java.util.Date;
import cat.udl.eps.softarch.hello.model.Greeting;
import cat.udl.eps.softarch.hello.model.Hosting;
import cat.udl.eps.softarch.hello.repository.GreetingRepository;
import cat.udl.eps.softarch.hello.repository.HostingRepository;
import cat.udl.eps.softarch.hello.utils.XQueryHelper;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by http://rhizomik.net/~roberto/
 */

@Controller
@RequestMapping(value = "/")
public class GreetingController {
    final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @Autowired HostingRepository hostingRepository;

// LOADDB
    @RequestMapping(value = "/loaddb", method=RequestMethod.GET, produces="text/html")
    public ModelAndView loaddbHTML(@RequestParam(required=false, defaultValue="0") int page,
                                 @RequestParam(required=false, defaultValue="10") int size) {

        hostingRepository.save(XQueryHelper.getHostings());

        return new ModelAndView("greetings");
    }

// LIST
    @RequestMapping(value = "/hostings", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Hosting> list(@RequestParam(required=false, defaultValue="0") int page,
                                   @RequestParam(required=false, defaultValue="10") int size) {

        PageRequest request = new PageRequest(page, size);
        return hostingRepository.findAll();
    }
    @RequestMapping(value = "/hostings", method=RequestMethod.GET, produces="text/html")
    public ModelAndView listHTML(@RequestParam(required=false, defaultValue="0") int page,
                                 @RequestParam(required=false, defaultValue="10") int size) {
        return new ModelAndView("greetings", "greetings", list(page, size));
    }


// RETRIEVE
    @RequestMapping(value = "/hostings/{urlname}", method = RequestMethod.GET )
    @ResponseBody
    public Hosting retrieve(@PathVariable( "urlname" ) String urlname) {
        logger.info("Retrieving hosting urlname {}", urlname);
        Preconditions.checkNotNull(hostingRepository.findOne(urlname), "Hosting with urlname %s not found", urlname);
        return hostingRepository.findOne(urlname);
    }
    @RequestMapping(value = "/hostings/{urlname}", method = RequestMethod.GET, produces = "text/html")
    public ModelAndView retrieveHTML(@PathVariable( "urlname" ) String urlname) {
        return new ModelAndView("greeting", "greeting", retrieve(urlname));
    }


}
