package com.controller;

import com.model.Role;
import com.model.User;
import com.service.RoleService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Controller
public class MainController {
    UserService userService;
    @Autowired(required = true)
    @Qualifier("userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    RoleService roleService;
    @Autowired(required = true)
    @Qualifier("roleService")
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String main(Model model){
        model.addAttribute("users", new User());
        model.addAttribute("listUser", userService.list());
        model.addAttribute("roles", new Role());
        model.addAttribute("listRole", roleService.list());
        return "index";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String addUser(User user){
        if (user.getId() != 0){
            userService.updateUser(user);
        }
        else {
            userService.add(user);
        }
        return "redirect:/";
    }
    @RequestMapping(value = "/role/add", method = RequestMethod.GET)
    public String addRole(Role role){
        if (role.getId() != 0){
            roleService.updateRole(role);
        }
        else {
            roleService.addRole(role);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/";
    }
    @RequestMapping(value = "/role/delete/{id}", method = RequestMethod.GET)
    public String deleteRole(@PathVariable("id") int id){
        roleService.deleteRole(id);
        return "redirect:/";
    }

    @RequestMapping(value = "user/update/{id}", method = RequestMethod.GET)
    public String searchUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.searchUser(id));
        return "editUser";
    }
    @RequestMapping(value = "role/update/{id}", method = RequestMethod.GET)
    public String searchRole(@PathVariable("id") int id, Model model){
        model.addAttribute("role", roleService.searchRole(id));
//        model.addAttribute("users", roleService.searchRole(id).getUsers().toString());
        return "editRole";
    }

    @RequestMapping(value = "/user/roles/{id}", method = RequestMethod.GET)
    public String users(@PathVariable("id") int id, Model model){
        List<Role> list = userService.roleList(id);
        model.addAttribute("listRole", list);
        model.addAttribute("role", new Role());
        model.addAttribute("user", new User());
        model.addAttribute("username", userService.searchUser(id));
        return "roles";
    }
    @RequestMapping(value = "/role/users/{id}", method = RequestMethod.GET)
    public String roles(@PathVariable("id") int id, Model model){
        List<User> list = roleService.roleList(id);
        model.addAttribute("listUser", list);
        model.addAttribute("user", new User());
        model.addAttribute("role", new Role());
        model.addAttribute("role2", roleService.searchRole(id));
        return "users";
    }
    @ModelAttribute("downRoleList")
    public Map<String, String> downRoleList(){
        Map<String, String> map = new HashMap<>();
        List<Role> list = roleService.list();
        for (Role r: list){
            map.put(String.valueOf(r.getRole()), String.valueOf(r.getRole()));
        }
        return map;
    }
}