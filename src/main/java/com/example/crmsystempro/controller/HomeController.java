package com.example.crmsystempro.controller;

import com.example.crmsystempro.entities.ApplicationRequest;
import com.example.crmsystempro.entities.Course;
import com.example.crmsystempro.entities.Operators;
import com.example.crmsystempro.services.ApplicationRequestService;
import com.example.crmsystempro.services.CourseService;
import com.example.crmsystempro.services.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ApplicationRequestService requestService;

    @Autowired
    private CourseService coursesService;

    @Autowired
    private OperatorService operatorService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("requests", requestService.getAllRequests());
        return "index";
    }

    @GetMapping("/new-requests")
    public String newRequests(Model model) {
        model.addAttribute("requests", requestService.getNewRequests());
        return "index";
    }

    @GetMapping("/processed-requests")
    public String processedRequests(Model model) {
        model.addAttribute("requests", requestService.getProcessedRequests());
        return "index";
    }

    @GetMapping("/add-request")
    public String addRequestPage(Model model) {
        model.addAttribute("courses", coursesService.getAllCourses());
        return "add-request";
    }

    @PostMapping("/add-request")
    public String addRequest(ApplicationRequest request) {
        requestService.addRequest(request);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("request", requestService.getRequestById(id));
        model.addAttribute("operators", operatorService.getAllOperators());
        return "details";
    }

    @GetMapping("/add-course")
    public String addCoursePage() {
        return "add-course"; // Возвращает имя HTML файла
    }


    @PostMapping("/add-course")
    public String addCourse(Course course) {
        coursesService.addCourse(course);
        return "redirect:/add-request"; // Перенаправляем на страницу добавления заявки
    }


    @GetMapping("/add-operator")
    public String addOperatorPage() {
        return "add-operator"; // Возвращает имя HTML файла
    }

    @PostMapping("/add-operator")
    public String addOperator(Operators operator) {
        operatorService.addOperator(operator);
        return "redirect:/"; // Перенаправляем на главную страницу
    }


    @PostMapping("/assign-operators")
    public String assignOperators(@RequestParam(name = "requestId") Long requestId,
                                  @RequestParam(name = "operatorId") List<Long> operatorIds) {
        requestService.assignOperators(requestId, operatorIds);
        return "redirect:/details/" + requestId;
    }


    @PostMapping("/remove-operator")
    public String removeOperator(@RequestParam(name = "requestId") Long requestId,
                                 @RequestParam(name = "operatorId") Long operatorId) {
        requestService.removeOperatorFromRequest(requestId, operatorId);
        return "redirect:/details/" + requestId;
    }


    @PostMapping("/process-request/{id}")
    public String processRequest(@PathVariable(name = "id") Long id) {
        requestService.processRequest(id);
        return "redirect:/details/" + id;
    }

    @PostMapping("/delete-request/{id}")
    public String deleteRequest(@PathVariable(name = "id") Long id) {
        requestService.deleteRequest(id);
        return "redirect:/";
    }

}