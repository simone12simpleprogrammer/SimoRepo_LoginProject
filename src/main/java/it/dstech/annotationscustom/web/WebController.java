package it.dstech.annotationscustom.web;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.TimeZone;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.dstech.annotationscustom.model.Task;
import it.dstech.annotationscustom.model.User;
import it.dstech.annotationscustom.service.TaskService;
import it.dstech.annotationscustom.service.UserService;


@EnableScheduling
@Controller
public class WebController {
	
	@Autowired
	private UserService userService;	
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private TaskScheduler scheduler;

	@RequestMapping(value = {"/login", "/"}, method=RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

	@RequestMapping(value = {"/user/home"}, method=RequestMethod.GET)
    public String userIndex(Model model, Task task) throws MessagingException {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    User user = userService.findByEmail(auth.getName());   	    
	    List<Task> tasks = user.getTasks();
        for(Task act:tasks) {
        	LocalDateTime dateTime = act.getExpiredDate();
    		int minute = dateTime.getMinute();
    		int hours = dateTime.getHour();
    		int day = dateTime.getDayOfMonth();
    		int month = dateTime.getMonth().getValue();
    		String expression = " 0 " + (minute - 2) + " " + hours + " " + day + " " + month + " ?";
    		CronTrigger trigger = new CronTrigger(expression, TimeZone.getTimeZone(TimeZone.getDefault().getID()));
    		scheduler.schedule(task, trigger);
        }	    
	    model.addAttribute("authUser", user.getEmail());
	    model.addAttribute("authUserImage", Base64.getEncoder().encodeToString(user.getImage()));
        model.addAttribute("tasks", tasks);
        model.addAttribute("task", new Task());
        model.addAttribute("title", "Tasks");    		    
        return "user/index";
    }
    
    @PostMapping(value="/save")
    public String save (@ModelAttribute Task task, RedirectAttributes redirectAttributes, Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    User user = userService.findByEmail(auth.getName());   	
	    List<Task> tasks = user.getTasks();
        Task currTask = taskService.save(task);
        tasks.add(currTask);
        userService.addTasks(user, tasks);
        if(currTask != null) {
            redirectAttributes.addFlashAttribute("successmessage", "Task is saved successfully");
            return "redirect:/user/home";
        }else {
            model.addAttribute("errormessage", "Task is not save, Please try again");
            model.addAttribute("task", task);
            return "user/index";
        }
    }  
    
}