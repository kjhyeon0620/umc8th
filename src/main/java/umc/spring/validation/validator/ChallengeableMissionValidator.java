package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.service.MissionMemberCommandService;
import umc.spring.validation.annotation.ChallengeableMission;

@Component
@RequiredArgsConstructor
public class ChallengeableMissionValidator implements ConstraintValidator<ChallengeableMission, Long> {

    private final MissionMemberCommandService missionMemberCommandService;

    @Override
    public void initialize(ChallengeableMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        Long memberIdWithToken = 1L;

        boolean isValid = missionMemberCommandService.isMissionReadyForChallenge(memberIdWithToken, missionId);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    ErrorStatus.ALREADY_CHALLENGED_MISSION.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
