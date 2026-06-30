package org.petstore.demo.api;

import org.petstore.demo.api.model.User;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SearchController {

    @QueryMapping
    public User userByUserName(@Argument String username) {
        return new User().id(1L).firstName("f").lastName("l").userStatus(0).username(username);
    }
}
