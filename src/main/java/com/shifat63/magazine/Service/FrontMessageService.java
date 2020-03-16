package com.shifat63.magazine.Service;

import java.util.Set;
import com.shifat63.magazine.Model.FrontMessage;

public interface FrontMessageService extends CrudService<FrontMessage, Integer> {
	public Set<FrontMessage> getActiveFrontMessages(Boolean isActive);
}
