/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvelon.web.userscomtroller;

import java.util.Date;
import akvelon.domain.Users;
import akvelon.service.UsersService;
import akvelon.web.validate.UsersValidate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Жека
 */
@Controller
public class UsersController {
    @Autowired
     UsersService userService;
    
    @Autowired
     UsersValidate userValidate;
    
    
    @RequestMapping(value = {"/","/startpage"}, method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView getUsersList(){
        ModelAndView model = new ModelAndView();
        List<Users> uList = userService.getList();
       
        model.setViewName("startpage");
        model.addObject("users", uList);
        return model;
    }
    
    @RequestMapping(value = {"/delete"}, method = {RequestMethod.POST})
           public String deleteUsers(
                @RequestParam("check")Integer[] check){
               List<Users> list = new ArrayList<Users>();
               for(int i = 0; i < check.length; i++){
                   list.add(userService.getById(check[i]));
                   System.out.println(list.get(i));
               }
               userService.remove(list);
             return "redirect:/startpage";
        }
           
           
            @RequestMapping(value = {"/addusers"}, method = {RequestMethod.POST})
           public ModelAndView addUsers(){
               ModelAndView model = new ModelAndView();
               Users user = new Users();
                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                model.setViewName("addupdateuser");
                model.addObject("contr", true);
                model.addObject("user", user);
                model.addObject("date", date.format(new Date()));
              return model;
        }
           
            @RequestMapping(value = {"/update"}, method = {RequestMethod.POST})
           public ModelAndView updateUsers(
                @RequestParam("check")Integer[] check){
               ModelAndView model = new ModelAndView();
               Users user = userService.getById(check[0]);
               
                model.setViewName("addupdateuser");
                model.addObject("contr", false);
                model.addObject("user", user);
                model.addObject("date", user.getRegisterDate());
                return model;
        }
           
             @RequestMapping(value = {"/saveuser"}, method = {RequestMethod.POST})
             public String updateUser(
               @RequestParam("date") String date,
               Model model, @ModelAttribute("user") Users user, 
               BindingResult result
              ) {
                 userValidate.validate(user, result);
                    if(result.hasErrors()){
                        model.addAttribute("contr", false);
                        model.addAttribute("user", user);
                        model.addAttribute("date", date);
                        return "addupdateuser";
                    }

                 SimpleDateFormat format = new SimpleDateFormat();
                 format.applyPattern("yyyy-MM-dd hh:mm:ss");
                  Date datereg;
                try {
                   datereg = format.parse(date);
                   user.setRegisterDate(datereg);
                } catch (ParseException ex) {
                    Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
                }
                         
           System.out.println(user.getRegisterDate());
           
            userService.update(user);
           return "redirect:/startpage";
        }
             
              @RequestMapping(value = {"/savenewuser"}, method = {RequestMethod.POST})
             public String saveUser(
               @RequestParam("date") String date,
               Model model, 
               @ModelAttribute("user") Users user, 
               BindingResult result
              ) {
               
                userValidate.validate(user, result);
                    if(result.hasErrors()){
                        model.addAttribute("contr", true);
                        model.addAttribute("user", user);
                        model.addAttribute("date", date);
                        return "addupdateuser";
                    }

                 SimpleDateFormat format = new SimpleDateFormat();
                 format.applyPattern("yyyy-MM-dd hh:mm:ss");
                  Date datereg;
                try {
                   datereg = format.parse(date);
                   System.out.println(datereg + "///////"); 
                   user.setRegisterDate(datereg);
                } catch (ParseException ex) {
                    Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
                }
                         
           System.out.println(user.getRegisterDate());
           
            userService.save(user);
           return "redirect:/startpage";
        }
}
