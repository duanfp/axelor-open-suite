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
package com.axelor.apps.bankpayment.module;

import com.axelor.app.AxelorModule;
import com.axelor.apps.account.service.config.AccountConfigService;
import com.axelor.apps.account.service.payment.invoice.payment.InvoicePaymentCancelServiceImpl;
import com.axelor.apps.account.service.payment.invoice.payment.InvoicePaymentValidateServiceImpl;
import com.axelor.apps.bankpayment.db.repo.BankOrderManagementRepository;
import com.axelor.apps.bankpayment.db.repo.BankOrderRepository;
import com.axelor.apps.bankpayment.db.repo.BankReconciliationManagementRepository;
import com.axelor.apps.bankpayment.db.repo.BankReconciliationRepository;
import com.axelor.apps.bankpayment.db.repo.EbicsBankAccountRepository;
import com.axelor.apps.bankpayment.db.repo.EbicsBankRepository;
import com.axelor.apps.bankpayment.db.repo.EbicsCertificateAccountRepository;
import com.axelor.apps.bankpayment.db.repo.EbicsCertificateRepository;
import com.axelor.apps.bankpayment.ebics.service.EbicsBankService;
import com.axelor.apps.bankpayment.ebics.service.EbicsBankServiceImpl;
import com.axelor.apps.bankpayment.ebics.service.EbicsPartnerService;
import com.axelor.apps.bankpayment.ebics.service.EbicsPartnerServiceImpl;
import com.axelor.apps.bankpayment.service.bankorder.BankOrderMergeService;
import com.axelor.apps.bankpayment.service.bankorder.BankOrderMergeServiceImpl;
import com.axelor.apps.bankpayment.service.bankorder.BankOrderMoveService;
import com.axelor.apps.bankpayment.service.bankorder.BankOrderMoveServiceImpl;
import com.axelor.apps.bankpayment.service.bankorder.BankOrderService;
import com.axelor.apps.bankpayment.service.bankorder.BankOrderServiceImpl;
import com.axelor.apps.bankpayment.service.config.AccountConfigBankPaymentService;
import com.axelor.apps.bankpayment.service.invoice.payment.InvoicePaymentCancelServiceBankPayImpl;
import com.axelor.apps.bankpayment.service.invoice.payment.InvoicePaymentValidateServiceBankPayImpl;

public class BankPaymentModule extends AxelorModule {

	@Override
	protected void configure() {
		
		 bind(BankReconciliationRepository.class).to(BankReconciliationManagementRepository.class);
		 
		 bind(BankOrderRepository.class).to(BankOrderManagementRepository.class);
		 
		 bind(EbicsBankRepository.class).to(EbicsBankAccountRepository.class);
	        
		 bind(EbicsBankService.class).to(EbicsBankServiceImpl.class);
		 
		 bind(EbicsPartnerService.class).to(EbicsPartnerServiceImpl.class);
        
		 bind(EbicsCertificateRepository.class).to(EbicsCertificateAccountRepository.class);
		 
		 bind(BankOrderService.class).to(BankOrderServiceImpl.class);
		 
		 bind(BankOrderMergeService.class).to(BankOrderMergeServiceImpl.class);
	        
	     bind(BankOrderMoveService.class).to(BankOrderMoveServiceImpl.class);
	    
	     bind(InvoicePaymentCancelServiceImpl.class).to(InvoicePaymentCancelServiceBankPayImpl.class);
	     
	     bind(InvoicePaymentValidateServiceImpl.class).to(InvoicePaymentValidateServiceBankPayImpl.class);

	     bind(AccountConfigService.class).to(AccountConfigBankPaymentService.class);

	}

}
