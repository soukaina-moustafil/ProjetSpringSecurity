package com.example.Tp1;


import javafx.scene.input.ClipboardContent;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class FirstController {

 private static final  List<Client> clients1= Arrays.asList(
         new Client(1,"soukaina","moustafil"),
         new Client(2,"safae","Naouis"),
         new Client(3,"houda","belhaj")
 );

    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        return "index.html";
    }

    @GetMapping("/Login")
    public String Login(Map<String, Object> model) {
        return "Login.html";
    }

    @GetMapping("/Admin")
    public String Admin(Map<String, Object> model) {
        return "Admin.html";
    }

    @GetMapping("/User")
    public String User(Map<String, Object> model) {
        return "CompteUser.html";
    }


    @GetMapping("/Users")
   @PreAuthorize("hasAuthority('USER')")
    public  List<Client> getAllUser() {
        return clients1;
    }

    @PostMapping("/addUser")
   @PreAuthorize("hasAuthority('ADMIN')")
    public Client UserU( ) {
    /*public Client UserU( @RequestBody Map<String, Object> model) {

        int id = (int) model.get("id");
        String nom = (String) model.get("prenom");

        String prenom = (String) model.get("prenom");

        return new Client(id,nom,prenom) */

      return  new Client(6,"SK","MST");
    }

    @DeleteMapping("/deleteUser/{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        System.out.println("user deleted"+userId);
    }


    @PutMapping("/putUser/{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public void putUser(@PathVariable("userId") Integer userId,@RequestBody Client clt) {
        System.out.println("user updated"+userId);
        System.out.println(clt);
    }


}
