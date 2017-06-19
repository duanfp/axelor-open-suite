/**
 * Axelor Business Solutions
 *
 * Copyright (C) 2017 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.axelor.apps.hr.service.extra.hours;

import java.io.IOException;

import javax.mail.MessagingException;

import com.axelor.apps.base.service.administration.GeneralService;
import com.axelor.apps.hr.db.ExtraHours;
import com.axelor.apps.hr.db.HRConfig;
import com.axelor.apps.hr.db.repo.ExtraHoursRepository;
import com.axelor.apps.hr.service.config.HRConfigService;
import com.axelor.apps.message.db.Message;
import com.axelor.apps.message.service.TemplateMessageService;
import com.axelor.auth.AuthUtils;
import com.axelor.exception.AxelorException;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class ExtraHoursServiceImpl implements ExtraHoursService  {
	
	protected ExtraHoursRepository extraHoursRepo;
	protected GeneralService generalService;
	protected HRConfigService hrConfigService;
	protected TemplateMessageService templateMessageService;
	
	@Inject
	public ExtraHoursServiceImpl(ExtraHoursRepository extraHoursRepo, GeneralService generalService,
			HRConfigService hrConfigService, TemplateMessageService templateMessageService)  {
		
		this.extraHoursRepo = extraHoursRepo;
		this.generalService = generalService;
		this.hrConfigService = hrConfigService;
		this.templateMessageService = templateMessageService;
	}
	
	
	@Transactional(rollbackOn = {AxelorException.class, Exception.class})
	public void cancel(ExtraHours extraHours) throws AxelorException {
		
		extraHours.setStatusSelect(ExtraHoursRepository.STATUS_CANCELED);
		extraHoursRepo.save(extraHours);
	}
	
	public Message sendCancellationEmail(ExtraHours extraHours) throws AxelorException, ClassNotFoundException, InstantiationException, IllegalAccessException, MessagingException, IOException  {

		HRConfig hrConfig = hrConfigService.getHRConfig(extraHours.getCompany());

		if(hrConfig.getTimesheetMailNotification())  {

			return templateMessageService.generateAndSendMessage(extraHours, hrConfigService.getCanceledExtraHoursTemplate(hrConfig));

		}

		return null;

	}


	@Transactional(rollbackOn = {AxelorException.class, Exception.class})
	public void confirm(ExtraHours extraHours) throws AxelorException  {
				
		extraHours.setStatusSelect(ExtraHoursRepository.STATUS_CONFIRMED);
		extraHours.setSentDate(generalService.getTodayDate()); 
		
		extraHoursRepo.save(extraHours);
		
	}

	
	public Message sendConfirmationEmail(ExtraHours extraHours) throws AxelorException, ClassNotFoundException, InstantiationException, IllegalAccessException, MessagingException, IOException  {
		
		HRConfig hrConfig = hrConfigService.getHRConfig(extraHours.getCompany());
		
		if(hrConfig.getExtraHoursMailNotification())  {
				
			return templateMessageService.generateAndSendMessage(extraHours, hrConfigService.getSentExtraHoursTemplate(hrConfig));
				
		}
		
		return null;
		
	}
	
	
	@Transactional(rollbackOn = {AxelorException.class, Exception.class})
	public void validate(ExtraHours extraHours) throws AxelorException  {
		
		extraHours.setStatusSelect(ExtraHoursRepository.STATUS_VALIDATED);
		extraHours.setValidatedBy(AuthUtils.getUser());
		extraHours.setValidationDate(generalService.getTodayDate());
		
		extraHoursRepo.save(extraHours);
		
	}
	
	
	public Message sendValidationEmail(ExtraHours extraHours) throws AxelorException, ClassNotFoundException, InstantiationException, IllegalAccessException, MessagingException, IOException  {
		
		HRConfig hrConfig = hrConfigService.getHRConfig(extraHours.getCompany());
		
		if(hrConfig.getExtraHoursMailNotification())  {
				
			return templateMessageService.generateAndSendMessage(extraHours, hrConfigService.getValidatedExtraHoursTemplate(hrConfig));
				
		}
		
		return null;
		
	}
	
	@Transactional(rollbackOn = {AxelorException.class, Exception.class})
	public void refuse(ExtraHours extraHours) throws AxelorException  {
		
		extraHours.setStatusSelect(ExtraHoursRepository.STATUS_REFUSED);
		extraHours.setRefusedBy(AuthUtils.getUser());
		extraHours.setRefusalDate(generalService.getTodayDate());
		
		extraHoursRepo.save(extraHours);
		
	}
	
	public Message sendRefusalEmail(ExtraHours extraHours) throws AxelorException, ClassNotFoundException, InstantiationException, IllegalAccessException, MessagingException, IOException  {
		
		HRConfig hrConfig = hrConfigService.getHRConfig(extraHours.getCompany());
		
		if(hrConfig.getExtraHoursMailNotification())  {
				
			return templateMessageService.generateAndSendMessage(extraHours, hrConfigService.getRefusedExtraHoursTemplate(hrConfig));
				
		}
		
		return null;
		
	}
}
