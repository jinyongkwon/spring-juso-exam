package site.metacoding.addressapitest.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.addressapitest.domain.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserJoinReqDto {
    @Pattern(regexp = "[a-zA-Z0-9]{4,20}", message = "유저네임은 한글이 들어갈 수 없습니다.")
    @Size(min = 4, max = 20)
    @NotBlank
    private String username;
    @Size(min = 4, max = 50)
    @NotBlank
    private String password;
    @Size(min = 4, max = 20)
    @NotBlank
    private String email;
    @Size(min = 4, max = 50)
    @NotBlank
    private String address;

    public User toEntity() {
        User user = User.builder()
                .username(username)
                .password(password)
                .email(email)
                .address(address)
                .build();
        return user;
    }
}
