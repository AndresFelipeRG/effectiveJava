package com.effectivejava.items.constraintvalidation.dto;
//A Data Tranfert Object helps to encapsulate data from a call. Instead of providing multiple return
//parameters from an interface an object encapsulates all the data when a call is made to an interface.
//One advantage is that DTOs encapsulate the serialization process.

import com.effectivejava.items.constraintvalidation.constraints.group.CreateNurseValidationGroup;
import com.effectivejava.items.constraintvalidation.constraints.group.UpdateNurseValidationGroup;
import com.effectivejava.items.constraintvalidation.utils.Patterns;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data //getters setters hash tostring
public class NurseDto {

    @JsonProperty("id")
    @NotNull(groups = UpdateNurseValidationGroup.class)//Useful when we apply validation in 2 steps. In the first a subset of fields is required and in the second step a different subset of fields is required
    @Null(groups = CreateNurseValidationGroup.class)
    @Pattern(regexp = Patterns.UUID_PATTERN)
    private String id;

    @JsonProperty("speacility")
    private String speciality;

    @JsonProperty("user_id")
    @NotNull(groups = CreateNurseValidationGroup.class)
    @Null(groups = UpdateNurseValidationGroup.class)
    @Pattern(regexp = Patterns.UUID_PATTERN)
    private String userId;
}
