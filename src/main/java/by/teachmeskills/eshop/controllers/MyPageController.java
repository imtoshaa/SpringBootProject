package by.teachmeskills.eshop.controllers;

import by.teachmeskills.eshop.domain.entities.User;
import by.teachmeskills.eshop.services.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import static by.teachmeskills.eshop.utils.EshopConstants.USER;

@Slf4j
@RestController
@SessionAttributes({USER})
@RequestMapping("/mypage")
@AllArgsConstructor
public class MyPageController {

    private IUserService userService;

    @GetMapping("/open")
    public ModelAndView openMyPage(@ModelAttribute(USER) User user) throws Exception {
        log.info("Redirect to my page.");
        return userService.getUserDataForMyPage(user);
    }
}
