package site.metacoding.addressapitest.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.addressapitest.service.UserService;
import site.metacoding.addressapitest.util.UtilValid;
import site.metacoding.addressapitest.web.dto.JusoDto;
import site.metacoding.addressapitest.web.dto.UserJoinReqDto;
import site.metacoding.addressapitest.web.dto.UserUpdateReqDto;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final HttpSession session;

    @PostMapping("/juso")
    public String juso(JusoDto testDto, Model model) {
        model.addAttribute("dto", testDto);
        return "jusoPopup";
    }

    @GetMapping("/juso")
    public String jusoPopup() {
        return "jusoPopup";
    }

    @PostMapping("/join")
    public String join(@Valid UserJoinReqDto userJoinReqDto, BindingResult bindingResult) {

        UtilValid.요청에러처리(bindingResult);
        userService.회원가입(userJoinReqDto.toEntity());

        return "redirect:/login-form";
    }

    @PutMapping("/s/api/user/{userId}")
    public ResponseEntity<?> update(@PathVariable Integer userId, @RequestBody UserUpdateReqDto userUpdateReqDto) {
        userService.회원수정(userId, userUpdateReqDto, session);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/s/api/user/{userId}")
    public ResponseEntity<?> delete(@PathVariable Integer userId) {
        userService.회원탈퇴(userId, session);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/join-form")
    public String joinForm() {
        return "join-form";
    }

    @GetMapping("/login-form")
    public String loginForm() {
        return "login-form";
    }

    @GetMapping("/s/update-form")
    public String updateForm() {
        return "update-form";
    }
}
