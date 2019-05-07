package com.rspace.controller;

import com.rspace.model.User;
import com.rspace.service.FileStorageService;
import com.rspace.util.MediaTypeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/")
public class IndexController {

    @Autowired
    private FileStorageService fileStorageService;

    private final String resumeFile = "Rohan Parekh.pdf";

    @Autowired
    private ServletContext servletContext;

    @GetMapping(path = "/")
    public ModelAndView index(Model model) {
        ModelAndView mav = new ModelAndView("/pages/index");

        User user = new User();
        user.setFirstName("ROHAN");
        user.setLastName("PAREKH");
        user.setEmail("rohan.parekh.in@gmail.com");
        user.setPhone("+49-176-5902-6005");
        user.setAddress("Berlin, Germany");
        user.setLinkedUrl("https://www.linkedin.com/in/rohan-parekh/");
        user.setAbout("");
        user.setId(1L);

//        model.addAttribute("user", userRepository.findById(1L));
        mav.addObject("user", user);
        return mav;
    }

    @GetMapping("/downloadResume")
    public ResponseEntity<Resource> downloadFile(HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(resumeFile);

        MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, resumeFile);

        return ResponseEntity.ok()
                .contentType(mediaType)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
