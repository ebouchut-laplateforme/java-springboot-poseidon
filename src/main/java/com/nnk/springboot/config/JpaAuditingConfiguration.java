package com.nnk.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * This configuration class enables auditing.
 * A configuration for entity fields annotated
 * with <code>@CreatedDate</code>, <code>@CreatedBy</code>,
 * <code>@LastModificationDate</code>, <code>@LastModifiedBy</code>
 * to be set automatically.
 *
 * @see AuditorAwareImpl
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider") // The class providing the name of the logged in user will be annotated with @Component(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfiguration {
}
