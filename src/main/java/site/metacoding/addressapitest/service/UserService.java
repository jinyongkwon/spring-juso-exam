package site.metacoding.addressapitest.service;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.addressapitest.domain.User;
import site.metacoding.addressapitest.domain.UserRepository;
import site.metacoding.addressapitest.handler.ex.CustomApiException;
import site.metacoding.addressapitest.handler.ex.CustomException;
import site.metacoding.addressapitest.web.dto.UserUpdateReqDto;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void 회원가입(User user) {
        String rawPassword = user.getPassword(); // 1234
        String encPassword = bCryptPasswordEncoder.encode(rawPassword); // 해쉬 알고리즘
        user.setPassword(encPassword);
        userRepository.save(user);
    }

    @Transactional
    public void 회원탈퇴(Integer userId, HttpSession session) {
        User userEntity = id로유저찾기(userId);
        userRepository.deleteById(userEntity.getId());
        session.invalidate();
    }

    @Transactional
    public void 회원수정(Integer userId, UserUpdateReqDto userUpdateReqDto, HttpSession session) {
        User userEntity = id로유저찾기(userId);
        userEntity.setEmail(userUpdateReqDto.getEmail());
        userEntity.setAddress(userUpdateReqDto.getAddress());
        session.setAttribute("principal", userEntity);
    }

    private User id로유저찾기(Integer userId) {
        Optional<User> userOp = userRepository.findById(userId);
        if (userOp.isPresent()) {
            return userOp.get();
        } else {
            throw new CustomApiException("유저를 찾을수가 없습니다.");
        }
    }
}
