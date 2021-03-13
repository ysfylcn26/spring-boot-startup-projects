package com.core.model.models.audit;

import com.core.model.models.entity.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditAwareImpl implements AuditorAware<String> {

    public static final String ANONYMOUS_USER = "anonymousUser";

    @Override
    public Optional<String> getCurrentAuditor() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals(ANONYMOUS_USER))
            return Optional.of("-");
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Optional.of(principal.getUsername());
    }
}