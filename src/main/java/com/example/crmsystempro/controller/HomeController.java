package com.example.crmsystempro.controller;

import com.example.crmsystempro.entities.ApplicationRequest;
import com.example.crmsystempro.services.ApplicationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private ApplicationRequestService requestService;

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
    public String addRequestPage() {
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
        return "details";
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