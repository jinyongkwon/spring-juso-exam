package site.metacoding.addressapitest.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserUpdateReqDto {
    @Size(min = 4, max = 20)
    @NotBlank
    private String email;
    @Size(min = 4, max = 50)
    @NotBlank
    private String address;
}
