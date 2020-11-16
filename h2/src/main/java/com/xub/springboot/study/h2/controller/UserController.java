package com.xub.springboot.study.h2.controller;

import com.xub.springboot.study.h2.entity.User;
import com.xub.springboot.study.h2.repo.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public void saveUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping("/user/{id}")
    public User getById(@PathVariable("id") Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return new User();
    }

    @PutMapping("/user/{id}")
    public void updateById(@PathVariable("id") Integer id, @RequestBody User user) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User originalUser = optionalUser.get();
            BeanUtils.copyProperties(user, originalUser);
            userRepository.save(originalUser);
        }
    }

    @DeleteMapping("/user/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
    }

    /**
     *
     * @param pageNum pageNum从0开始
     * @param pageSize
     * @return
     */
    @GetMapping("/userPage")
    public Page<User> userPage(@RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
                               @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<User> all = userRepository.findAll(pageable);
        return all;
    }

    @GetMapping("/users")
    public List<User> users() {
        return userRepository.findAll();
    }

}
