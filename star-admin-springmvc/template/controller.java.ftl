package com.cise.cms.core.modules.${package}.controllers;

import com.cise.cms.core.applications.base.BaseControllers;
import com.cise.cms.core.modules.${package}.models.${model};
import com.cise.cms.core.modules.${package}.service.${model}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ${controllerFileName} extends BaseControllers {

    @Autowired
    ${model}Service service;

    @GetMapping("${path}") //search
    public String content(Model model,
                          @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                          @RequestParam(value = "search", required = false) String search) {
        log.debug("${path} crud page : " + page + " and search key : " + search);
        model.addAttribute("search", search);
        if (null == search) {
            model.addAttribute("page", service.page((0 == page ? page : page - 1)));
        } else {
            model.addAttribute("page", service.page(search, (0 == page ? page : page - 1)));
        }
        return validSession(model, "index", "contents/${path}/content", "content");
    }

    @GetMapping("${path}/form")
    public String form(Model model, @RequestParam(value = "id", required = false, defaultValue = "0") long id) {
        log.debug("${path} form with id : " + id);
        if (0 == id) {
            model.addAttribute("${path}", new ${model}());
        } else {
            ${model} ${path} = service.findById(id);
            if (null == ${path}) return "redirect:/${path}";
            model.addAttribute("${path}", ${path});
        }
        return validSession(model, "index", "contents/${path}/form", "content");
    }

    @PostMapping("${path}/save")
    public String save(Model model, @Valid ${model} o, BindingResult bindingResult) {
        log.debug("${path} save");
        if (bindingResult.hasErrors()) {
            model.addAttribute("${path}", o);
            return validSession(model, "index", "contents/${path}/form", "content");
        }
        service.createOrUpdate(o);
        return "redirect:/${path}";
    }

    @PostMapping("${path}/delete")
    @ResponseBody
    public ${model} delete(@RequestBody ${model} o) {
        log.debug("${path} deleted : "+getUser().getUsername());
        log.debug("${path} o");
        service.delete(o);
        return o;
    }
}
