package by.rom.restapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
public class MemberDTO extends BaseDTO{

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Length(min = 7,max = 7,message = "phone number should be exact 7 characters.")
    private String telephoneNumber;
}
