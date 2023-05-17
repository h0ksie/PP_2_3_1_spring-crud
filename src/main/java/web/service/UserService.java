package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void create(User user);

    List<User> findAll();

    void update(Long id, User user);

    void delete(Long id);

    User getUserById(Long id);
}
