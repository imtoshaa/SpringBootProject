package by.teachmeskills.eshop.utils;

import by.teachmeskills.eshop.domain.entities.User;
import by.teachmeskills.eshop.services.IUserService;
import by.teachmeskills.eshop.services.impl.UserServiceImpl;
import lombok.AllArgsConstructor;

public class UserAuthenticationUtils {

    private static IUserService userService;

    public static boolean isAuthenticated(User user) throws Exception {
        return user != null && userService.checkUser(user);
    }
}
