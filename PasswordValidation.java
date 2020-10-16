
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class PasswordValidation implements ConstraintValidator<PasswordValid, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        LengthRule lenghtRule = new LengthRule(12, 200);
        CharacterRule upperCaseRule = new CharacterRule(EnglishCharacterData.UpperCase, 3);
        CharacterRule lowerCaseRule = new CharacterRule(EnglishCharacterData.LowerCase, 3);
        CharacterRule specialCharacterRule = new CharacterRule(EnglishCharacterData.Special, 2);
        CharacterRule digitRule = new CharacterRule(EnglishCharacterData.Digit, 2);
        PasswordValidator passwordValidator = new PasswordValidator(Arrays.asList(
                lenghtRule,
                upperCaseRule,
                lowerCaseRule,
                specialCharacterRule,
                digitRule
        ));
        if (password == null) return false;
        RuleResult ruleResult = passwordValidator.validate(
                new PasswordData(password)
        );
        if (ruleResult.isValid()) return true;

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(String.join("\n",
                passwordValidator.getMessages(ruleResult))).addConstraintViolation();
        return false;
    }
}
