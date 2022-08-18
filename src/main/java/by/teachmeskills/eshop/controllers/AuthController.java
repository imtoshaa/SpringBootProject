package by.teachmeskills.eshop.controllers;

import by.teachmeskills.eshop.domain.entities.User;
import by.teachmeskills.eshop.services.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import static by.teachmeskills.eshop.utils.PagesPathEnum.SIGN_IN_PAGE;
import static by.teachmeskills.eshop.utils.EshopConstants.USER;

@Slf4j
@RestController
@SessionAttributes({USER})
@RequestMapping("/login")
public class AuthController {

    private final IUserService userService;

    public AuthController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView openSignInPage() {
        log.info("Redirect to signin page.");
        return new ModelAndView(SIGN_IN_PAGE.getPath());
    }

    @PostMapping
    public ModelAndView login(@ModelAttribute(USER) User user) throws Exception {
        return userService.login(user);
    }

    @ModelAttribute(USER)
    public User setUpUserForm() {
        return new User();
    }
}
