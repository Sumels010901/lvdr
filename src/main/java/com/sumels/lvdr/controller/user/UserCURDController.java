package com.sumels.lvdr.controller.user;


import com.sumels.lvdr.dto.ApiMessageDto;
import com.sumels.lvdr.dto.ResponseListObj;
import com.sumels.lvdr.dto.user.CreateUserRequest;
import com.sumels.lvdr.entity.User;
import com.sumels.lvdr.service.UserService;
import com.sumels.lvdr.utils.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserCURDController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/add")
    public ApiMessageDto<String> addUser(@RequestBody CreateUserRequest request) {
        ApiMessageDto<String> response = new ApiMessageDto<>();
        User user = userMapper.createRequestToEntity(request);
        userService.createUser(user);

        response.setMessage("Create user success");
        return response;
    }

    @GetMapping("/all")
    public ApiMessageDto<ResponseListObj<User>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction
    ) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);

        ApiMessageDto<ResponseListObj<User>> response = new ApiMessageDto<>();
        ResponseListObj<User> responseListObj = new ResponseListObj<>();

        Page<User> userPage = userService.getAllUsers(pageable);

        responseListObj.setData(userPage.getContent());
        responseListObj.setPage(pageable.getPageNumber());
        responseListObj.setTotalPage(userPage.getTotalPages());
        responseListObj.setTotalElements(userPage.getTotalElements());

        response.setData(responseListObj);
        response.setMessage("Get List Success");
        return response;
    }

    @GetMapping("/get")
    public ApiMessageDto<User> getUser(@RequestParam(required = false) String username,
                                       @RequestParam(required = false) Long id) {
        ApiMessageDto<User> response = new ApiMessageDto<>();
        if(id != null) {
            User user = userService.getById(id);
            response.setData(user);
            response.setMessage("Get User by id success");
            return response;
        } else if (username != null) {
            User user = userService.getByUsername(username);
            response.setData(user);
            response.setMessage("Get User by username success");
            return response;
        } else {
            response.setMessage("Must enter at least one field");
            return response;
        }

    }
}
