package dev.moghrabi.sameeh.bankapp.dto;

import dev.moghrabi.sameeh.bankapp.constant.CommonConst;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountDto {
    @NotNull(message = CommonConst.ConstraintMessages.CUSTOMER_ID_NOT_EMPTY)
    private Long customerId;
    @Min(value = 0, message = CommonConst.ConstraintMessages.INITIAL_CREDIT_POSITIVE)
    private Double initialCredit;
}
