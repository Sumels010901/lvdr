package com.sumels.lvdr.controller.user;


import com.sumels.lvdr.dto.ApiMessageDto;
import com.sumels.lvdr.dto.ResponseListObj;
import com.sumels.lvdr.dto.user.CreateUserRequest;
import com.sumels.lvdr.exception.NotFoundException;
import com.sumels.lvdr.model.User;
import com.sumels.lvdr.service.UserService;
import com.sumels.lvdr.utils.convertListToPageUtils;
import com.sumels.lvdr.utils.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

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
    public ApiMessageDto<ResponseListObj<User>> getAll(Pageable pageable) {
        ApiMessageDto<ResponseListObj<User>> response = new ApiMessageDto<>();
        Page<User> userPage = convertListToPageUtils.convertListToPage(userService.getAllUsers(), pageable);

        ResponseListObj<User> responseListObj = new ResponseListObj<>();
        responseListObj.setData(userPage.getContent());
        responseListObj.setPage(pageable.getPageNumber());
        responseListObj.setTotalPage(userPage.getTotalPages());
        responseListObj.setTotalElements(userPage.getTotalElements());

        response.setData(responseListObj);
        response.setMessage("Get List Success");
        return response;
    }

    @GetMapping("/get")
    public ApiMessageDto<User> getByUserName(@RequestParam String username) {
        ApiMessageDto<User> response = new ApiMessageDto<>();
        User user = userService.getByUsername(username);

        response.setData(user);
        response.setMessage("Get User by username success");
        return response;
    }
}
