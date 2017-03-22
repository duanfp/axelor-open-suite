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
package com.axelor.apps.bankpayment.exception;

/**
 * Interface of Exceptions. Enum all exception of axelor-account.
 *
 * @author dubaux
 *
 */
public interface IExceptionMessage {


	/**
	 * Bank statement service
	 */

	static final String BANK_STATEMENT_1 = /*$$(*/ "%s : Computed balance and Ending Balance must be equal" /*)*/ ;
	static final String BANK_STATEMENT_2 = /*$$(*/ "%s : MoveLine amount is not equals with bank statement line %s" /*)*/ ;
	static final String BANK_STATEMENT_3 = /*$$(*/ "%s : Bank statement line %s amount can't be null" /*)*/ ;

	
	/**
	 * Account config Bank Payment Service
	 */
	
	static final String ACCOUNT_CONFIG_41 = /*$$(*/ "%s : Veuillez configurer un signataire par défaut pour la société %s" /*)*/;
	
	static final String ACCOUNT_CONFIG_SEQUENCE_5 = /*$$(*/ "%s : Please, configure a sequence for the SEPA Credit Transfers and the company %s" /*)*/;
	static final String ACCOUNT_CONFIG_SEQUENCE_6 = /*$$(*/ "%s : Please, configure a sequence for the SEPA Direct Debits and the company %s" /*)*/;
	static final String ACCOUNT_CONFIG_SEQUENCE_7 = /*$$(*/ "%s : Please, configure a sequence for the International Credit Transfers and the company %s" /*)*/;
	static final String ACCOUNT_CONFIG_SEQUENCE_8 = /*$$(*/ "%s : Please, configure a sequence for the International Direct Debits and the company %s" /*)*/;
	static final String ACCOUNT_CONFIG_SEQUENCE_9 = /*$$(*/ "%s : Please, configure a sequence for the International Treasury Transfers and the company %s" /*)*/;
	static final String ACCOUNT_CONFIG_SEQUENCE_10 = /*$$(*/ "%s : Please, configure a sequence for the National Treasury Transfers and the company %s" /*)*/;
	static final String ACCOUNT_CONFIG_SEQUENCE_11 = /*$$(*/ "%s : Please, configure a sequence for the Other Bank Orders and the company %s" /*)*/;

	static final String ACCOUNT_CONFIG_EXTERNAL_BANK_TO_BANK_ACCOUNT = /*$$(*/ "%s : Please, configure an account for the bank order for the external bank to bank transfer for the company %s" /*)*/;
	static final String ACCOUNT_CONFIG_INTERNAL_BANK_TO_BANK_ACCOUNT = /*$$(*/ "%s : Please, configure an account for the bank order for the internal bank to bank transfer for the company %s" /*)*/;
	
	
	/**
	 *  BankOrder service
	 */
	static final String BANK_ORDER_DATE = /*$$(*/ "Bank Order date can't be in the past" /*)*/;
	static final String BANK_ORDER_DATE_MISSING = /*$$(*/ "Please fill bank order date"/*)*/;
	static final String BANK_ORDER_TYPE_MISSING = /*$$(*/ "Please fill bank order type" /*)*/;
	static final String BANK_ORDER_PARTNER_TYPE_MISSING = /*$$(*/ "Please fill partner type for the bank order" /*)*/;
	static final String BANK_ORDER_COMPANY_MISSING = /*$$(*/ "Please fill the sender company" /*)*/;
	static final String BANK_ORDER_BANK_DETAILS_MISSING = /*$$(*/ "Please fill the bank details" /*)*/;
	static final String BANK_ORDER_CURRENCY_MISSING = /*$$(*/ "Please fill currency for the bank order" /*)*/;
	static final String BANK_ORDER_AMOUNT_NEGATIVE = /*$$(*/ "Amount value of the bank order is not valid" /*)*/;
	static final String BANK_ORDER_PAYMENT_MODE_MISSING = /*$$(*/ "Please select a payment mode" /*)*/;
	static final String BANK_ORDER_SIGNATORY_MISSING = /*$$(*/ "Please select a signatory" /*)*/;
	static final String BANK_ORDER_WRONG_SENDER_RECORD = /*$$(*/ "Anomaly has been detected during file generation for the sender record of the bank order %s" /*)*/;
	static final String BANK_ORDER_WRONG_MAIN_DETAIL_RECORD = /*$$(*/ "Anomaly has been detected during file generation for the detail record of the bank order line %s" /*)*/;
	static final String BANK_ORDER_WRONG_BENEFICIARY_BANK_DETAIL_RECORD = /*$$(*/ "Anomaly has been detected during file generation for the beneficiary bank detail record of the bank order line %s" /*)*/;
	static final String BANK_ORDER_WRONG_FURTHER_INFORMATION_DETAIL_RECORD = /*$$(*/ "Anomaly has been detected during file generation for the further information detail record of the bank order line %s" /*)*/;
	static final String BANK_ORDER_WRONG_TOTAL_RECORD = /*$$(*/ "Anomaly has been detected during file generation for the total record of the bank order %s" /*)*/;
	static final String BANK_ORDER_ISSUE_DURING_FILE_GENERATION = /*$$(*/ "Anomaly has been detected during file generation for bank order %s" /*)*/;
	static final String BANK_ORDER_COMPANY_NO_SEQUENCE = /*$$(*/ "The company %s does not have bank order sequence" /*)*/;
	static final String BANK_ORDER_LINE_BANK_DETAILS_FORBIDDEN = /*$$(*/ "You cannot use this bank account because he is not authorized by the ebics partner." /*)*/;

	
	/**
	 *  BankOrder lines
	 */
	static final String BANK_ORDER_LINES_MISSING = /*$$(*/ "You can't validate this bank order. you need to fill at least one bank order line" /*)*/;
	static final String BANK_ORDER_LINE_COMPANY_MISSING = /*$$(*/ "Please select a company for the bank order lines inserted" /*)*/;
	static final String BANK_ORDER_LINE_PARTNER_MISSING = /*$$(*/ "Please select a partner for the bank order lines inserted" /*)*/;
	static final String BANK_ORDER_LINE_AMOUNT_NEGATIVE = /*$$(*/ "Amount value of a bank order line is not valid" /*)*/;
	static final String BANK_ORDER_LINE_TOTAL_AMOUNT_INVALID = /*$$(*/ "Total amount of bank order lines must be equal to the bank order amount" /*)*/;
	
	
	/**
	 * BankOrder merge
	 */
	static final String BANK_ORDER_MERGE_AT_LEAST_TWO_BANK_ORDERS = /*$$(*/ "Please select at least two bank orders" /*)*/;
	static final String BANK_ORDER_MERGE_STATUS = /*$$(*/ "Please select draft or awaiting signature bank orders only" /*)*/;
	static final String BANK_ORDER_MERGE_SAME_STATUS = /*$$(*/ "Please select some bank orders that have the same status" /*)*/;
	static final String BANK_ORDER_MERGE_SAME_ORDER_TYPE_SELECT = /*$$(*/ "Please select some bank orders that have the same status" /*)*/;
	static final String BANK_ORDER_MERGE_SAME_PAYMENT_MODE = /*$$(*/ "Please select some bank orders that have the same payment mode" /*)*/;
	static final String BANK_ORDER_MERGE_SAME_PARTNER_TYPE_SELECT = /*$$(*/ "Please select some bank orders that have the same partner type" /*)*/;
	static final String BANK_ORDER_MERGE_SAME_SENDER_COMPANY = /*$$(*/ "Please select some bank orders that have the same sender company" /*)*/;
	static final String BANK_ORDER_MERGE_SAME_SENDER_BANK_DETAILS = /*$$(*/ "Please select some bank orders that have the same sender bank details" /*)*/;
	static final String BANK_ORDER_MERGE_SAME_CURRENCY = /*$$(*/ "Please select some bank orders that have the same currency" /*)*/;
	
	/**
	 * BankOrder file
	 */
	static final String BANK_ORDER_FILE_NO_FOLDER_PATH = /*$$(*/ "No folder path has been defined in the payment mode %s" /*)*/;
	static final String BANK_ORDER_FILE_UNKNOW_FORMAT = /*$$(*/ "Unknow format for file generation for payment mode %s" /*)*/;

	
	/**
	 *  Ebics
	 */
	static final String EBICS_WRONG_PASSWORD = /*$$(*/ "Incorrect password, please try again" /*)*/;
	static final String EBICS_MISSING_PASSWORD = /*$$(*/ "Please insert a password" /*)*/;
	static final String EBICS_MISSING_NAME = /*$$(*/ "Please select a user name" /*)*/;
	static final String EBICS_TEST_MODE_NOT_ENABLED = /*$$(*/ "Test mode is not enabled or test file is missing" /*)*/;
	static final String EBICS_MISSING_CERTIFICATES = /*$$(*/  "Please add certificates to print" /*)*/;

	
	
	
}
