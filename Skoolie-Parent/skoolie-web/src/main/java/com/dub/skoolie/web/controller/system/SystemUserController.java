/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system;

import com.dub.skoolie.structures.people.faculty.DistrictAdminBean;
import com.dub.skoolie.structures.people.faculty.SchoolAdminBean;
import com.dub.skoolie.structures.people.faculty.TeacherBean;
import com.dub.skoolie.structures.people.parents.ParentBean;
import com.dub.skoolie.structures.people.students.StudentBean;
import com.dub.skoolie.structures.usr.security.GroupBean;
import com.dub.skoolie.structures.usr.security.RoleBean;
import com.dub.skoolie.structures.usr.security.UserBean;
import com.dub.skoolie.web.service.district.UiDistrictService;
import com.dub.skoolie.web.service.people.faculty.UiDistrictAdminService;
import com.dub.skoolie.web.service.people.faculty.UiSchoolAdminService;
import com.dub.skoolie.web.service.people.faculty.UiTeacherService;
import com.dub.skoolie.web.service.people.parents.UiParentService;
import com.dub.skoolie.web.service.people.students.UiStudentService;
import com.dub.skoolie.web.service.school.UiSchoolService;
import com.dub.skoolie.web.service.usr.security.UiGroupService;
import com.dub.skoolie.web.service.usr.security.UiRoleService;
import com.dub.skoolie.web.service.usr.security.UiUserService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin W
 */
@Controller
public class SystemUserController {
    
    @Autowired
    UiUserService uiUserServiceImpl;
    
    @Autowired
    UiRoleService uiRoleServiceImpl;
    
    @Autowired
    UiGroupService uiGroupServiceImpl;
    
    @Autowired
    UiDistrictAdminService uiDistrictAdminServiceImpl;
    
    @Autowired
    UiSchoolAdminService uiSchoolAdminServiceImpl;
    
    @Autowired
    UiTeacherService uiTeacherServiceImpl;
    
    @Autowired
    UiParentService uiParentServiceImpl;
    
    @Autowired
    UiStudentService uiStudentServiceImpl;
    
    @Autowired
    UiSchoolService uiSchoolServiceImpl;
    
    @Autowired
    UiDistrictService uiDistrictServiceImpl;
    
    @RequestMapping(value="/system/users", method=RequestMethod.GET)
    public ModelAndView getUsers(Model model) {
        List<UserBean> users = uiUserServiceImpl.getUsers();
        UserBean userBean = new UserBean();
        List<String> allusertypes = uiUserServiceImpl.getUserTypes();
        model.addAttribute("userBean", userBean);
        model.addAttribute("users", users);
        model.addAttribute("allUserTypes", allusertypes);
        return new ModelAndView("system/users");
    }
    
    @RequestMapping(value="/system/users/activate", method=RequestMethod.POST)
    public ModelAndView activateUser(@RequestParam("username") String username, HttpServletRequest request) {
        String referrer = request.getHeader("Referer");
        UserBean userBean = uiUserServiceImpl.getUser(username);
        if(null == userBean.getEnabled() || userBean.getEnabled() == 0) {
            userBean.setEnabled(1);
        } else {
            userBean.setEnabled(0);
        }
        uiUserServiceImpl.updateUser(userBean);
        return new ModelAndView("redirect:" + referrer);
    }
    
    @RequestMapping(value="/system/users", method=RequestMethod.POST)
    public ModelAndView addUser(@Valid UserBean userBean, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("userBean", userBean);
            model.addAttribute("users", uiUserServiceImpl.getUsers());
            model.addAttribute("allUserTypes", uiUserServiceImpl.getUserTypes());
            return new ModelAndView("system/users");
        }
        uiUserServiceImpl.addUser(userBean);
        return new ModelAndView("redirect:/system/users/" + userBean.getUsername());
    }
    
    @RequestMapping(value="/system/users/{username}", method=RequestMethod.GET)
    public ModelAndView getUser(@PathVariable("username") String username, Model model) {
        UserBean userBean = uiUserServiceImpl.getUser(username);
        List<RoleBean> roles = uiRoleServiceImpl.getRoles();
        List<GroupBean> groups = uiGroupServiceImpl.getGroups();
        model.addAttribute("userBean", userBean);
        model.addAttribute("groups", groups);
        model.addAttribute("roles", roles);
        //Different user types have different UI objects
        switch (userBean.getType()) {
            case "DISTRICT_ADMIN": 
                DistrictAdminBean districtAdminBean = uiDistrictAdminServiceImpl.getDistrictAdmin(userBean.getUsername());
                if(null == districtAdminBean) {
                    districtAdminBean = new DistrictAdminBean();
                    districtAdminBean.setUser(userBean);
                    districtAdminBean.setUsername(userBean.getUsername());
                }
                model.addAttribute("districtAdminBean", districtAdminBean);
                model.addAttribute("allDistricts", uiDistrictServiceImpl.getDistricts());
                break;
            case "SCHOOL_ADMIN":
                SchoolAdminBean schoolAdminBean = uiSchoolAdminServiceImpl.getSchoolAdmin(userBean.getUsername());
                if(null == schoolAdminBean) {
                    schoolAdminBean = new SchoolAdminBean();
                    schoolAdminBean.setUser(userBean);
                    schoolAdminBean.setUsername(userBean.getUsername());
                }
                model.addAttribute("schoolAdminBean", schoolAdminBean);
                model.addAttribute("allSchools", uiSchoolServiceImpl.getSchools());
                break;
            case "TEACHER":
                TeacherBean teacherBean = uiTeacherServiceImpl.getTeacher(userBean.getUsername());
                if(null == teacherBean) {
                    teacherBean = new TeacherBean();
                    teacherBean.setUser(userBean);
                    teacherBean.setUsername(userBean.getUsername());
                }
                model.addAttribute("allSchools", uiSchoolServiceImpl.getSchools());
                model.addAttribute("teacherBean", teacherBean);
                break;
            case "STUDENT":
                StudentBean studentBean = uiStudentServiceImpl.getStudent(userBean.getUsername());
                if(null == studentBean) {
                    studentBean = new StudentBean();
                    studentBean.setUser(userBean);
                    studentBean.setUsername(userBean.getUsername());
                }
                model.addAttribute("allSchools", uiSchoolServiceImpl.getSchools());
                model.addAttribute("studentBean", studentBean);
                break;
            case "PARENT":
                ParentBean parentBean = uiParentServiceImpl.getParent(userBean.getUsername());
                if(null == parentBean) {
                    parentBean = new ParentBean();
                    parentBean.setUser(userBean);
                    parentBean.setUsername(userBean.getUsername());
                }
                model.addAttribute("parentBean", parentBean);
                break;
            case "SYSTEM":
                break;
                
        }
        return new ModelAndView("system/user");
    }
    
}
