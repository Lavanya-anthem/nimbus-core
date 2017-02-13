/**
 * 
 */
package com.anthem.oss.nimbus.core.domain.model.state;

import java.util.List;

import com.anthem.oss.nimbus.core.domain.command.Action;
import com.anthem.oss.nimbus.core.domain.model.state.DomainState.MappedParam;
import com.anthem.oss.nimbus.core.domain.model.state.DomainState.Param;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Soham Chakravarti
 *
 */
@Getter @Setter @RequiredArgsConstructor @ToString
public class Notification<T> {
	
	@Getter @RequiredArgsConstructor
	public enum ActionType {
		_updateState(Action._update),

		_newModel(Action._new),
		_deleteModel(Action._delete),
		
		_newElem(Action._new),
		_deleteElem(Action._delete)
		;
		final private Action action;
	}
	
	final private Param<T> source;
	final private ActionType actionType;
	final private Param<?> eventParam;
	
	public interface Producer<T> extends Dispatcher<T> {
		public List<MappedParam<?, T>> getEventSubscribers();
		public void registerSubscriber(MappedParam<?, T> subscriber);
	}
	
	public interface Dispatcher<T> {
		public void notifySubscribers(Notification<T> event);
	}
	
	public interface Consumer<T> {
		public void handleNotification(Notification<T> event);
	}
}