package com.nnk.springboot.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
 * Provide an AuditorAware Bean
 * that tells Spring who the current user is.
 *
 * @see JpaAuditingConfiguration
 * @see com.nnk.springboot.domain.BidList#creationDate
 * @see com.nnk.springboot.domain.BidList#revisionDate
 */
@Component("auditorProvider")
public class AuditorAwareImpl implements AuditorAware<String> {

    /**
     *
     * @return maybe the username of the currently logged in user
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            // Not authenticated (i.e., not logged in): nobody: ""
            return Optional.empty();
        }
        // Current username
        return Optional.of(authentication.getName());
    }
}
