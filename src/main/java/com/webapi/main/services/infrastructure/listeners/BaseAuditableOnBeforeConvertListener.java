package com.webapi.main.services.infrastructure.listeners;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.webapi.main.services.domain.BaseEntity;

@Component
public class BaseAuditableOnBeforeConvertListener extends AbstractMongoEventListener<BaseEntity>{
	
	@Override
	public void onBeforeConvert(BeforeConvertEvent<BaseEntity> event) {
		Date timeStamp=new Date();
		if(event.getSource().getId()==null) {
			event.getSource().setId(UUID.randomUUID().toString());
		}
		if(event.getSource().getCreatedDate()==null) {
			event.getSource().setCreatedDate(timeStamp);
		}
		event.getSource().setLastModifiedDate(timeStamp);
		super.onBeforeConvert(event);
	}
}
