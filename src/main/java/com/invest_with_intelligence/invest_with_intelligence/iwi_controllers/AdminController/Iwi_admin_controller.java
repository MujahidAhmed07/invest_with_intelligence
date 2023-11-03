package com.invest_with_intelligence.invest_with_intelligence.iwi_controllers.AdminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invest_with_intelligence.invest_with_intelligence.iwi_entities.AdminEntity.Iwi_admin_entity;
import com.invest_with_intelligence.invest_with_intelligence.iwi_services.AdminServices.Iwi_admin_service;

@RestController
@RequestMapping("/admin")
public class Iwi_admin_controller {

    @Autowired
    private Iwi_admin_service iwi_admin_service;

    // Logger logger = LoggerFactory.getLogger(Iwi_admin_controller.class);

    @GetMapping("/admin_account/")
    public List<Iwi_admin_entity> get_admin() {
        return iwi_admin_service.get_admin();
    }

    @GetMapping("/admin_account/check")
    public String check() {
        return "test api";
    }

    @GetMapping("/admin_account/{id}")
    public Iwi_admin_entity get_admin_by_id(@PathVariable("id") Long admin_login_id) {
        return iwi_admin_service.get_admin_by_id(admin_login_id);
    }

    @PostMapping("/add_admin_account")
    public Iwi_admin_entity add_admin_account(@RequestBody Iwi_admin_entity iwi_admin_entity) {
        return iwi_admin_service.add_admin_account(iwi_admin_entity);
    }

    @PutMapping("/change_admin_account/{id}")
    public Iwi_admin_entity change_admin_account(@RequestBody Iwi_admin_entity iwi_admin_entity) {
        return iwi_admin_service.change_admin_account(iwi_admin_entity);
    }

}
