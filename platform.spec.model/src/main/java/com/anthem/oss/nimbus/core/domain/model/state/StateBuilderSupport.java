/**
 * 
 */
package com.anthem.oss.nimbus.core.domain.model.state;

import com.anthem.nimbus.platform.spec.contract.event.EventPublisher;
import com.anthem.oss.nimbus.core.domain.model.config.ValidatorProvider;
import com.anthem.oss.nimbus.core.domain.model.state.repo.ParamStateGateway;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author Rakesh Patel
 *
 */
@Getter @Setter @RequiredArgsConstructor
public class StateBuilderSupport {
	
	private final EventPublisher eventPublisher;
	
	//private final ClientUser clientUser;
	
	private final ValidatorProvider validatorProvider;
	
	private final ParamStateGateway paramStateGateway;
}
 