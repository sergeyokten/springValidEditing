package ua.com.owu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.com.owu.entity.Car;
import ua.com.owu.entity.Customer;
import ua.com.owu.entity.RegUser;
import ua.com.owu.entity.User;
import ua.com.owu.service.CustomerService;
import ua.com.owu.service.MailService;
import ua.com.owu.service.RegUserService;
import ua.com.owu.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.security.Principal;

@Controller
public class MainController {


    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(Model model, HttpServletRequest request,
                       Principal principal

    ) {
        System.out.println(principal);

//        model.addAttribute("userModel", new User());
//        model.addAttribute("carModel", new Car());

        model.addAttribute("x", "hello");
        return "index";
    }

    @GetMapping("/join")
    public String join(Model model) {

        model.addAttribute("users", userService.findAll());
        return "join";
    }


    @ModelAttribute("userModel")
    public User user() {
        return new User();
    }

    @ModelAttribute("carModel")
    public Car car() {
        return new Car();
    }


//    @ModelAttribute("carModelx")
//    public Car carx() {
//        return new Car();
//    }


    @Autowired
    private CustomerService customerService;

    @Autowired
    private MailService mailService;

    @PostMapping("/sc")
    public String sc(Customer customer,
                     @RequestParam("file") MultipartFile file
    ) throws IOException {

        String path = System.getProperty("user.home") + File.separator + "pics" + File.separator;
        file.transferTo(new File(path + file.getOriginalFilename()));

        customer.setAvatar("/avatarka/" + file.getOriginalFilename());
        customerService.save(customer);
        mailService.sendEmail(customer);

        return "redirect:/";
    }


    @GetMapping("/allCustomers")
    public String allCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "allCusts";
    }

    @GetMapping("/rest")
    public String rest() {
        return "rest";
    }


    @GetMapping("/xxx")
    public String xxx() {
        return "redirect:/";
    }


    @GetMapping("/loginPage")
    public String loginPage() {
        return "loginPage";
    }


    @PostMapping("/asd")
    public String asd() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return "redirect:/";
    }


    @Autowired
    private RegUserService regUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/saveMe")
    public String saveMe(RegUser regUser) {


        regUser.setPassword(passwordEncoder.encode(regUser.getPassword()));
        regUserService.save(regUser);


        return "redirect:/";
    }

}
