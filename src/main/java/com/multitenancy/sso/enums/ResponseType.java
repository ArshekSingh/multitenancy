//package com.multitenancy.sso.enums;
//
//import lombok.Getter;
//
//@Getter
//public enum ResponseType {
//
//    // Add pertinent response codes and messages
//
//    SUCCESS("100", "SUCCESS"),
//    PARTNER_CREATED_SUCCESS("100","Partner created successfully"),
//    BDO_LEAVE_MARKED_SUCCESS("100", "Leave marked successfully"),
//    PARTNER_UPDATED_SUCCESS("100","Partner updated successfully"),
//    PARTNER_REJECTED_SUCCESS("100","Partner rejected successfully"),
//    BDO_PUNCH_IN_SUCCESS("100","Punched in successfully"),
//    BDO_PUNCH_OUT_SUCCESS("100","Punched out successfully"),
//    OTP_GENERATED_SUCCESS("100","Otp generated successfully"),
//    OTP_VERIFIED_SUCCESS("100","Otp verified successfully"),
//    PROCESSING("102", "PROCESSING"), INITIATED("103", "INITIATED"), FAILED("104", "FAILED"),
//    APPROVAL_PENDING("105", "APPROVAL PENDING"), ERROR("106", "ERROR"),
//    USER_NOT_FOUND("202", "User id not found", "201", "Invalid credentials"),
//    // VENDOR_COMMUNICATION_ERROR("903", " Vendor Communication Error", "999",
//    // "Internal System Error"),
//    VENDOR_COMMUNICATION_ERROR("903", " Vendor Communication Error", "903", " Vendor Communication Error"),
//    CUSTOM_QUERY_ERROR("203", "Custom Query Error ", "201", "Custom Query Error"),
//    TOKEN_NOT_FOUND("801", "Token not found!"),
//    ENTRY_ALREADY_PUNCHED_IN("301", "BDO already punched In!"),
//    OTP_EXPIRED("255", "OTP code has expired!"), RTGS_SHEET_CREATION_ERROR("256", "RTGS Sheet Creation Error!"),
//    ENTERED_PASSWORD_DIFFERENT("399", "The entered password is different from the current password!"),
//    PASSWORD_DOES_NOT_MATCH("303", "The new and repeated passwords do not match!"),
//    WHATSAPP_NUMBER_NOT_GIVEN("303", "Whatsapp number required!"),
//    SANCTION_CONDITION_NOT_FOUND("301", "Sanction condition not found!"),
//    OTP_VERIFIED("304","OTP already verified"),
//    USER_PASSWORD_INCORRECT("203", "User password incorrect", "201", "Invalid credentials"),
//    CONSECUTIVE_YEAR_DATA_EXPECTED("312", "ITR details for consecutive years expected"),
//    USER_STATUS_INACTIVE("409", "User status inactive!"), USER_NOT_REGISTED("409", "User not registered!"),
//    FIELD_NOT_FOUND("301", "Field not found"), USER_ALREADY_REGISTED("409", "User already registered!"),
//    MOBILE_NUM_NOT_FOUND("409", "Mobile number is not present"),
//    MAX_OTP_ATTEMPTS_EXCEEDED("410", "Maximum OTP generation attempts exceeded. Please try again later."),
//    MIN_OTP_GENERATION_GAP_NOT_MET("411", "Please try again in 30 seconds"),
//    VERIFICATION_ALREADY_COMPLETED("305", "Verification already completed"),
//    VERIFICATION_ALREADY_PROCESSED_BY_VENDOR("305", "Verification already processed by vendor"),
//    VERIFICATION_ALREADY_INITIATED("305", "Verification already initiated!"),
//    VERIFICATION_ALREADY_EXISTS("305", "Verification already exists"),
//    VERIFICATION_NOT_ALLOWED("304", "This type of verification is not allowed for this applicant!"),
//    INCOME_PROGRAM_NOT_ADDED("314", "Income program not found"), PASSWORD_ALREADY_USED("312", "Password already used!"),
//    INVALID_NUMBER("309", " Invalid Monthly|Daily projection", "309", "Monthly|Daily projection must be 0 to 99"),
//    VENDOR_EXISTS("304", "Vendor already exists!"),
//    GROWTH_PARTNER_ALREADY_EXISTS("304", "Partner already exists!"),
//    VENDOR_REINITATE_FAILED("304", "Vendor reinitiation failed", "305", "old vendor and new vendor same"),
//
//    DUPLICATE_RECORD("204", "Duplicate record found"), DATA_EMPTY("305", "No data found!", "305", "Data fetch empty"),
//    DEVIATION_NOT_FOUND("309", "Deviation not found!"), INVALID_CREDENTIALS("404", "Incorrect password or user ID!"),
//    EMPTY_REQUEST("909", "The Request body and parameters are empty!"),
//    DEVIATION_ALREADY_APPROVED("302", "Deviation already Approved!"),
//    DEVIATION_NOT_IN_PENDING("303", "Status already moved from PENDING!"),
//
//    INVALID_INPUT("301", "Invalid input", "300", "Invalid input"),
//    KARZA_COMMUNICATION_ERROR("902", "Karza Communication Error", "999", "Internal System Error"),
//
//    JAXB_EXCEPTION("904", "JAXB Processing Error", "999", "Internal System Error"),
//    GENERIC_ERROR("905", "Generic Error", "999", "Internal System Error"),
//    DATE_PARSE_ERROR("906", " Date Parsing Excption", "999", "Internal System Error"),
//
//    JWT_EXCEPTION("412", "Invalid token found", "500", "The token received is either malformed or is "),
//    JWT_SECURITY_EXCEPTION("412", "Invalid token found", "500", "Access Token not found!"),
//
//    LEAD_NOT_FOUND("302", "Lead Id does not exists", "300", "Lead is not found"),
//    INVALID_VERIFICATION("302", "Verification Type not Found!"),
//    VERIFICATION_UPDATE_FAILED("302", "Verification update failed!", "201", "Verification already complete"),
//    LOAN_VERIFICATION_NOT_FOUND("304", "Verification initiation failed", "315", "Loan Verification Id not found !"),
//    RCU_DOCUMENT_LIST_EMPTY("315", "Rcu Document list empty!"), NO_PROPERTY_SELECTED("315", "No property selected!"),
//    DISBURSEMENT_PROCESSING_ERROR("401", "Disbursement Processing Error ", "999", "Internal System Error"),
//    LOAN_VERIFICATION_REMARKS_REQUIRED("303", "Remarks are required!"),
//    ITR_DETAILS_ALREADY_FILLED("304", "ITR details for this Financial year already filled"),
//    ITR_DATE_WRONG("305", "ITR filing date wrong for the given financial year"),
//    BANK_ACCOUNT_DETAILS_ALREADY_EXISTS("311", "Bank account details already exists"),
//    COLLECTION_PROCESSING_ERROR("402", "Collection Processing Error", "999", "Internal System Error"),
//    TRENCH_DISBURSEMENT_PROCESSING_ERROR("403", "Trench Disbursement Processing Error", "999", "Internal System Error"),
//    CREDIT_BUREAUE_OBLIGATION_SUMMERY_ERROR("907", "Error While Creating Obligation Summary", "999",
//            "Internal System Error"),
//    CREDIT_BUREAU_FETCHING_ERROR("908", "Credit Bureau Fetching Error"),
//    EMPTY_EMPLOYEE_ID("910", "Employee ID Can't be Empty", "909", "Employee ID is Null"),
//    INVALID_BRANCH_CODE("303", "Invalid BranchCode", "300", "Invalid BranchCode"),
//    INVALID_TYPE_OR_TITLE("304", "Invalid Designation Name or Employee Role Type", "300",
//            "Please provide the correct information either Title or Type are incorrect"),
//    INVALID_CURRENT_BRANCH_CODE("306", "Invlaid to office Branch Code", "300",
//            "Please provide the correct Branch Code"),
//    INVALID_TRANSFER_BRANCH_CODE("306", "Invlaid from office Branch Code", "300",
//            "Please provide the correct Branch Code"),
//    INVALID_DATE_OF_LEAVING("307", "Invalid Date Of Leaving", "300", "Invalid Date Of Leaving"),
//    NO_USER_FOUND("308", "No user found", "300", "User Not Found"),
//    USER_ALREADY_EXIST("309", "User already exist", "300", "User already exist"),
//    USER_ALREADY_ACTIVE("310", "User is already active", "300", "User is already active"),
//    USER_ALREADY_SUSPENDED("311", "User is already Terminated", "300", "User is already Terminated"),
//    MNO_ALREADY_REGISTERED("312", "Mobile Number Already Registered", "300", "Mobile Number Already Registered"),
//    INVALID_PORTFOLIO_TRANSFER_ENO("313", "Invalid Portfolio Transfer Employee No", "300",
//            "Invalid Portfolio Transfer Employee No"),
//    DATE_VALIDATION_MESSAGE("314", "Invalid Date", "300", "Invalid Date"),
//    INVALID_TURN_OVER_TYPE("315", "Invalid Turn Over Type", "300", "Please add correct turn over type"),
//    INVALID_QUESTION_MASTER_TYPE("316", "Invalid Question Master Type", "300", "Please add correct question type"),
//    INCOME_OF_DIFFERENT_PROGRAM_EXISTS("303", "Income details of different income program exists!"),
//    INSURENCE_DETAILS_ID_NOT_FOUND("302", "Insurence Detail Id does not exists", "300",
//            "Insurence Detail is not found"),
//    INCOME_ALREADY_ADDED("305", "Income of this turnover type already added : "),
//    INCOME_NOT_CONSIDERED("310", "Income of Main Applicant is not considered! "),
//    AWS_ERROR("901", "AWS Secrets Manager Error", "999", "Internal System Error"),
//    VALIDATION_FAIL("407", "Request Body Validation Failed", "406", "Validation Failed"),
//    REGEX_ERROR("407", "regex does not match"), PRECISION_ERROR("407", " precision does not match the criteria"),
//    LENGTH_ERROR("407", " length does not match the criteria"),
//    FORMAT_ERROR("407", " format does not match the criteria"),
//    FILE_SIZE_ERROR("407", " file size does not match the criteria"), UNKNOWN_TYPE_ERROR("410", " unknown type field"),
//    UNKNOWN_ERROR("999", "Internal System Error"), NO_RESULT_FOUND("350", "No result found!"),
//    RUNTIME_EXCEPTION("409", "Invalid token found", "500", "The token received is either malformed or is "),
//    EMPLOYEE_NOT_FOUND("302", "Employee Id does not exists", "300", "Employee not found"),
//    VENDOR_NOT_FOUND("302", "Vendor Id does not exists", "300", "Vendor not found"),
//    LOAN_APPLICATION_NOT_FOUND("302", "Loan Application Id does not exists", "300", "Loan Application not found"),
//    APPLICANT_NOT_FOUND("302", "Applicant Id does not exists", "300", "Applicant not found"),
//    NOMINEE_NOT_FOUND("302", "Nominee Applicant Id does not exists", "300", "Applicant not found"),
//    INSURED_PERSON_NOT_FOUND("302", "Insured Applicant Id does not exists", "300", "Applicant not found"),
//    LOAN_APPLICATION_STAGE_NOT_SUPPORTED("301", "Loan Application stage "),
//    NEGATIVE_INCOME_NOT_ALLOWED("301","Negative income not allowed"),
//
//    MAIN_APPLICANT_ALREADY_EXISTS("309", "MAIN APPLICANT already exists!"),
//    PRIMARY_CO_APPLICANT_ALREADY_EXISTS("309", "PRIMARY CO APPLICANT already exists!"),
//    APPLICANT_ADDRESS_NOT_FOUND("302", "Applicant Address Id does not exists", "300", "Applicant Address is not found"),
//    APPLICANT_ALREADY_EXIST("309", "Applicant already exist", "300", "Applicant already exist"),
//    CUSTOMER_NOT_FOUND("302", "Customer Id does not exists", "300", "Customer not found"),
//    BANK_ACCOUNT_DETAILS_NOT_FOUND("302", "Bank Account Details not found"),
//    LEGAL_COMPLIANCE_NOT_FOUND("302", "Legal Compliance not found"),
//    COLLATERALS_NOT_FOUND("302", "Collaterals not found"),
//    FINANCIAL_DETAILS_NOT_FOUND("302", "Financial details not found"),
//    APPLICANT_LOCATION_NOT_FOUND("302", "Applicant location not found"),
//    BUSINESS_DETAILS_NOT_FOUND("302", "Business details not found"),
//    PROJECTION_NOT_COVERED("306", "Target not covered!"), PROJECTION_DATE_INVALID("307", "Previous Date not allowed!"),
//    TARGET_UPDATION_FAILED("319", "Target Updation not allowed at current time"),
//    AGENT_DAILY_TARGET_NOT_FOUND("304", "No bdo target found!", "350", "No data found under the id"),
//    ALREADY_TRANSFERED("315", "Daily projection for this employee already transfered!"),
//    LOCATION_NOT_FOUND("304", "Location not found"), ACCESS_DENIED("666", "Access Denied!"),
//    LOAN_CHARGES_NOT_FOUND("302", "Loan Charges not found"), LOCATION_NOT_PROVIDED("304", "Location not provided!"),
//
//    DOCUMENT_NOT_FOUND("320", "Document not found", "300", "Document is not present"),
//    // ESIGN
//    ESTAMP_COORDINATE_ERROR("808", "Key not found in coordinatesMap or invalid value type"),
//    DOCUMENT_NOT_EXIST("809", "Document with this Document ID is not Present"), BAD_REQUEST("810", "Invalid Request"),
//    APPLICATIONID_NOT_FOUND("811", "No Application ID found for this request"),
//    APPLICANTION_ALREADY_EXIST("315", "Applicantion already exist", "300", "Applicantion already exist"),
//    DOCUMENT_ALREADY_SIGNED("302", "Document already signed"),
//
//    MONTHLY_PROJECTION_ALREADY_FILLED("305", "Monthly Projection for employee already filled"),
//    USER_CANNOT_UPDATE_MONTHLY_PROJECTION("305","User cannot update the monthly projection"),
//    NO_PROJECTION_FOUND("318", "No projection found for this branch for this month!"),
//    ZERO_PROJECTION_NOT_ALLOWED("250", "Projection can not be 0 or negative!"),
//    LOAN_APPLICATION_NOT_REJECTED_YET("303", "Loan application not in rejected state"),
//    LOAN_CHARGES_ALREADY_EXIST("309", "Loan Charges Detail already exist", "300", "Loan Charges Detail already exist"),
//    LOAN_CHARGES_ALREADY_COLLECTED("310", "Loan Charges already collected", "300", "Loan Charges already collected"),
//    DOCUMENT_SENT_FOR_ESIGNING("313", "Document already sent for esigning!"),
//    INSURANCE_CALCULATION_ERROR("302", "Insurance Calculation Error", "300", "Insurance Calculation Error"),
//    COVERAGE_DURATION_ERROR("303", "Insurance coverage duration should be between 2 and 15 years", "301",
//            "Insurance coverage duration should be between 2 and 15 years"),
//    AGE_RANGE_ERROR("304", "Age  should be between 18 and 60 years", "302", "Age  should be between 18 and 60 years"),
//    SANCTION_AMOUNT_ERROR("305", "Sanction amount should be between 50000 and 1500000", "303",
//            "Sanction amount should be between 50000 and 1500000"),
//    LOAN_ALREADY_SANCTIONED("302", "Loan already sanctioned!"), MITIGANT_REQUIRED("301", "Mitigants are required!"),
//
//    APPLICANT_LOAN_APPLICATION_NOT_FOUND("302", "Applicant and loan application not found"),
//    CONSENT_ALREADY_TAKEN("310", "Consent already taken"),
//    PROVIDE_MINIMUM_FOUR_CHARACTER("407", "Please provide minimum four character"),
//    CONSENT_NOT_TAKEN("320", "Applicant Consent not taken", "300", "Applicant Consent not taken"),
//    AGE_LESS_THAN_23("350", "Main Applicant age less than 23", "300", "Main Applicant age less than 23"),
//    AGE_MORE_THAN_100("350", "Applicant age More than 100", "300", "Applicant age More than 100"),
//    AGE_LESS_THAN_18("351", "Main Applicant age less than 18", "300", "Main Applicant age less than 18"),
//
//    INSUFFICIENT_DATA_ERROR("358", "Insufficent data for fetching bureau details"),
//    LOAN_DETAILS_NOT_FOUND("359", "Loan application details not present"),
//    ROI_MORE_THAN_2("360", "ROI waiver cannot be greater than 2%"),
//    PF_MORE_THAN_LIMIT("361", "Processing fees ROI waiver cannot be greater than 0.5"),
//    ROI_MORE_THAN_MAX_LIMIT("362", "ROI cannot be greater than proposed ROI"),
//    DOCUMENT_ALREADY_EXIST("363", "Document already exist"),
//    AGE_MORE_THAN_75("364", "Main Applicant age more than 75", "300", "Main Applicant age more than 75"),
//    AGE_MORE_THAN_70("365", "Main Applicant age more than 70", "300", "Main Applicant age more than 70"),
//    NO_ROLES_ASSIGNED("333", "No roles assigned to the user"),
//    CONSIDERED_PERCENTAGE_ALREADY_PROVIDED("321", "Considered Percentage different!"),
//    NO_PERMISSION_ASSIGNED("333", "No permission assigned!"), PAN_NAME_MISMATCH("367", "Pan card name mismatch"),
//    MOBILE_NUMBER_MANDATORY("368", "Mobile number is mandatory"),
//    FIRST_NAME_MANDATORY("369", "First name can not be blank"), INVALID_PINCODE("370", "Invalid Pincode"),
//    ALREADY_INACTIVE("371", "Already Inactive"), EXPENSE_ALREADY_EXIST("372", "Expense detail already Added"),
//    EXPENSE_NOT_FOUND("373", "Applicant expense detail id not found"),
//    LEAD_COUNT_EXCEEDED("374", "lead count more than five."), QUERY_NOT_FOUND("373", "Application query not found"),
//    PAN_CARD_NUMBER_NOT_FOUND("367", "Pan card number not found for main applicant"),
//    DOCUMENT_MISMATCH("368", "Document mismatch"),
//    INVALID_TURN_OVER_AMOUNT("376", "Invalid Turnover Amount", "300", "Invalid Turnover Amount"),
//    INVALID_INSURED_AMOUNT("376", "Invalid Insured Amount", "300", "Invalid Insured Amount"),
//    INSURANCE_ALREADY_ADDED("313", "Insurance already added"),
//
//    EMI_PAYING_CAPACITY_LESS_THAN_ESTIMATED("377", "Emi paying capacity less than estimated fusion emi"),
//
//    OTP_LIMIT_EXCEEDED("378", "Maximum count of OTP reached"), NO_OTP_FOUND("379", "No OTP found for applicant"),
//    ROI_RANGE_ERROR("380", "ROI not in range"), PF_ROI_RANGE_ERROR("381", "PF ROI not in range"),
//    MPIN_ALREADY_SET("382", "Mpin already set"), INVALID_MPIN_FORMAT("383", "Invalid Mpin Format"),
//    PAYMENT_ALREADY_INITIATED("699", "Payment Already Initiated"),
//    QUERY_ALREADY_INITIATED("699", "Query Already Initiated"),
//
//    KYC_DOCUMENT_LIST_EMPTY("384", "KYC Document list empty!"),
//    FILE_NOT_FOUND_FOR_PROVIDED_CATEGORY("385", "File not found for provided category"),
//    DOCUMENT_TRACKER_NOT_FOUND("386", "Document Tracker not found"),
//    OTHER_INSURANCE_TYPE_NOT_FOUND("399", "Other insurance type not found"),
//    SIGNED_DOCUMENT_DOES_NOT_EXISTS("310", "Signed document not found"),
//    INVALID_SIGNED_DOCUMENT("512", "Uploaded Signed document is either corrupt or invalid!"),
//    BUSINESS_REFERENCE_NOT_FOUND("310", "Business reference not found"),
//    DISBURSEMENT_DETAIL_NOT_FOUND("310", "Disbursement Detail not found"),
//
//    DSR_ENTRY_NOT_FOUND("301", "DSR Entry not found !"), ENTRY_ALREADY_PUNCHED_OUT("301", "BDO already punched out!"),
//    OTP_NOT_FOUND("311", "OTP not found!!"),
//
//    BATCH_PROCESSING_ERROR("900", "Error While Batch Processing"),
//    BATCH_IN_PROCESS("950", "Error While Batch Processing"),
//    BATCH_PROCESSED("951", "Error While Batch Processing"),
//
//
//    BANK_DETAILS_NOT_MATCHING("400", "Bank details not matching"),
//    LOAN_STAGE_REQUIREMENTS_NOT_MET("401", "Loan stage requirements not met"),
//
//    ENACH_PROCESSING_ERROR("402", "Enach Processing Error"),
//
//    INVALID_EMI_TYPE("399", "Invalid EMI Type"), BANKING_REPAYEMENT_DETAILS_ERROR("389", "Banking Repayment Error"),
//    TRANCHE_DETAILS_NOT_FOUND("387", "Tranche detail not found at this stage"),
//    PAYEMENT_SHEET_ERROR("388", "Payment Sheet Creation Error"),
//    PAYOUT_REQUEST_ALREADY_EXIST("251", "Loan Payout Request Already Exist"),
//    PAYOUT_REQUEST_NOT_EXIST("252", "No Payout request exist for the corresponding loan/tranchePart Id"),
//    CIBIL_SCORE_ERROR("353", "CIBIL score norms not met"),
//    HDFC_PAYMENT_REQUEST_FAILED("605", "Request for payment denied"),
//    PRIVATE_KEY_ERROR("601", "Unable to fetch Private Key"), ENCRYPTION_ERROR("602", "Unable to Encrypt Request"),
//    LOAN_AMOUNT_MUST_BE_WITH_IN_RANGE("352", "Loan amount must be within range"),
//    MONTHLY_INCOME_ERROR("356", "Min Income Norms not met"), MONTHLY_TENURE_ERROR("357", "Tenure not in range"),
//    DECRYPTION_ERROR("603", "Unable to Decrypt Request"), PUBLIC_KEY_ERROR("604", "Unable to fetch Public Key"),
//    CALL_RECORD_NOT_FOUND("605", "Call Record Not Found"), DUE_DILIGENCE_ERROR("606", "Due Diligence Error"),
//
//    RECIPIENT_ADDRESS_REQUIRED("420", "Recipient Email Address required!"),
//    COLLECTION_DETAILS_ERROR("390", "Collection  Error"), POS_NOT_EXIST("799", "Principle outstanding not found"),
//    INVALID_EMI_AMOUNT("801", "Invalid EMI Amount"),
//    INTEREST_OUTSTANDING_NULL("802", "Interest Outstanding is null or RPS Field doesnot Exist"),
//    RPS_ERROR("802", "RPS Field doesnot Exist"),
//
//    ADD_ADDRESS("100", "Address created Successfully"),
//    INSERT_VERSION("100", "Version created Successfully"),
//    UPDATE_ADDRESS("100", "Address updated Successfully"),
//    DELETE_ADDRESS("100", "Address deleted Successfully"),
//
//    CREATE_PARTNER("100", "Partner created Successfully"),
//    UPDATE_PARTNER("100", "Partner updated Successfully"),
//    ADD_APPLICANT("100", "Applicant created Successfully"),
//    UPDATE_APPLICANT("100", "Applicant updated Successfully"),
//    DELETE_APPLICANT("100", "Applicant deleted Successfully"),
//    RESTORE_APPLICANT("100", "Applicant restored Successfully"),
//    SWAP_APPLICANT("100", "Applicant Swap Successfully"),
//    UPDATE_APPLICANT_INCOME_INFO("100", "Applicant Income Info updated Successfully"),
//    SEND_APPLICANT_CONSENT("100", "Otp sent successfully!"),
//    OTP_APPLICANT_CONSENT("100", "Bureau consent taken Successfully"),
//    UPDATE_APPLICANT_FAMILY_DETAIL("100", "Applicant Family Detail updated Successfully"),
//
//    UPDATE_APPLICANT_DD("100", " ApplicantDD updated Successfully"),
//
//    ADD_APPLICANT_EXPENSE("100", "Applicant Expense created Successfully"),
//    UPDATE_APPLICANT_EXPENSE("100", "Applicant Expense updated Successfully"),
//    DELETE_APPLICANT_EXPENSE("100", "Applicant Expense deleted Successfully"),
//
//    ADD_QUERIES("100", "Application Queries created Successfully"),
//    RESOLVE_QUERIES("100", "Application  Resolve Queries  Successfully"),
//    SUBMIT_QUERIES("100", "Application  Submit Queries  Successfully"),
//    ACCEPT_ADD_QUERIES("100", "Application  Accept add  Queries  Successfully"),
//    ACCEPT_REPLACE_QUERIES("100", "Application  Accept Replace  Queries  Successfully"),
//    REJECT_QUERIES("100", "Application  Reject  Queries  Successfully"),
//    ACCEPT_QUERIES("100", "Application  Queries Accepted Successfully"),
//    DELETE_QUERIES("100", "Application  Queries deleted Successfully"),
//
//
//    ADD_BRANCH("100", "Branch created  Successfully"),
//    UPDATE_BRANCH("100", "Branch   updated  Successfully"),
//    DELETE_BRANCH("100", " Branch   deleted  Successfully"),
//
//    ADD_PINCODE("100", "pincode created  Successfully"),
//    UPDATE_PINCODE("100", "pincode   updated  Successfully"),
//    DELETE_PINCODE("100", " pincode   deleted  Successfully"),
//    ADD_BANK("100", "Bank  Detail created  Successfully"),
//    UPDATE_BANK("100", "Bank  Detail updated  Successfully"),
//    DELETE_BANK("100", "Bank  Detail deleted  Successfully"),
//
//    VERIFY_ACCOUNT("100", "Bank Account  verify  Successfully"),
//    SWAP_ACCOUNT("100", "Repayment Bank Account Swap Successfully"),
//
//
//
//    ADD_BANK_DOCUMENT("100", "Bank Document created  Successfully"),
//
//    ADD_BUSINESS("100", "Business created  Successfully"),
//    UPDATE_BUSINESS("100", "Business updated  Successfully"),
//    DELETE_BUSINESS("100", "Business deleted  Successfully"),
//    ADD_BUSINESS_DOCUMENT("100", "Business Document created  Successfully"),
//    CONVERT_BUSINESS_TO_APPLICANT("100", "Business Converted  Successfully"),
//    ADD_LEGAL_COMPLIANCE("100", "Legal Compliance created  Successfully"),
//    UPDATE_LEGAL_COMPLIANCE("100", "Legal Compliance updated  Successfully"),
//    DELETE_LEGAL_COMPLIANCE("100", "Legal Compliance deleted  Successfully"),
//    ADD_BUSINESS_INCOME("100", "Business Income created  Successfully"),
//    UPDATE_BUSINESS_INCOME("100", "Business Income updated  Successfully"),
//    DELETE_BUSINESS_INCOME("100", "Business Income deleted  Successfully"),
//    ADD_CALLING("100", "Calling created  Successfully"),
//    UPDATE_CALLING("100", "Calling updated  Successfully"),
//    DELETE_CALLING("100", "Calling  deleted  Successfully"),
//
//    ADD_COLLATERAL("100", "Collateral created  Successfully"),
//    ADD_CERSAI_CHARGE("100", "Cersai charge added Successfully"),
//    UPDATE_COLLATERAL("100", "Collateral updated  Successfully"),
//    DELETE_COLLATERAL("100", "Collateral  deleted  Successfully"),
//    ADD_COLLATERAL_DOCUMENT("100", "Collateral Document created  Successfully"),
//
//    ADD_DEVIATION("100", "Deviation created  Successfully"),
//    UPDATE_DEVIATION("100", "Deviation updated  Successfully"),
//    DELETE_DEVIATION("100", "Deviation  deleted  Successfully"),
//    DEVIATION_APPROVAL("100", "Deviation  Approved Successfully"),
//
//    ADD_DOCUMENT("100", "Document created  Successfully"),
//    UPDATE_DOCUMENT("100", "Document updated  Successfully"),
//    DELETE_DOCUMENT("100", "Document  deleted  Successfully"),
//    UPLOAD_DOCUMENT("100", "Document uploaded Successfully"),
//    DOWNLOAD_URL("100", "Document URL Download Successfully"),
//
//    ADD_FAMILY("100", "Family Detail created  Successfully"),
//    UPDATE_FAMILY("100", "Family Detail  updated  Successfully"),
//    DELETE_FAMILY("100", "Family Detail  deleted  Successfully"),
//
//    ADD_FINANCIAL("100", "Financial Detail created  Successfully"),
//    DELETE_FINANCIAL("100", "Financial Detail  deleted  Successfully"),
//
//    ADD_LEAD("100", "Lead created  Successfully"),
//    UPDATE_LEAD("100", "Lead updated  Successfully"),
//    DELETE_LEAD("100", "Lead  deleted  Successfully"),
//    ADD_LEAD_FOLLOW_UP("100", "Lead Follow up created  Successfully"),
//    CHANGE_LEAD("100", "Lead Change  Successfully"),
//
//    ADD_ANSWER("100", "Answer created  Successfully"),
//    UPDATE_ANSWER("100", "Answer Detail  updated  Successfully"),
//    DELETE_ANSWER("100", "Answer Detail  deleted  Successfully"),
//
//    ADD_LOAN_APPLICATION("100", "Loan Application created  Successfully"),
//    UPDATE_LOAN_APPLICATION("100", "Loan Application   updated  Successfully"),
//    DELETE_LOAN_APPLICATION("100", "Loan Application   deleted  Successfully"),
//    STAGE_CHANGE("100", "Loan Application Stage Changed  Successfully"),
//    REOPEN_APPLICATION("100", "Loan Application Reopen Successfully"),
//    CLONE_LOAN_APPLICATION("100", "Loan Application Cloned Successfully"),
//
//    CHANGE_LOAN_AMOUNT("100", "Loan Application Amount Changed  Successfully"),
//
//    ADD_TIMELINE("100", "TimeLine created  Successfully"),
//    DELETE_TIMELINE("100", "TimeLine   deleted  Successfully"),
//
//    ADD_PERSONAL("100", "Personal Detail created  Successfully"),
//
//    REPORT_PERMISSION_ERROR("100", "User does not have permission to view this report"),
//
//    ADD_BUSINESS_PARTNERSHIP("100", "Partnership added  Successfully"),
//    UNABLE_TO_INITIATE_VERIFICATION("311", "Unable to initiate"),
//    LTV_RANGE_ERROR("357", "LTV not in range"),
//
//    REJECT_LEAD("100", "Lead rejected Successfully"),
//    LOAN_CHARGES_ERROR("100", "Loan Charges cannot be added manually "),
//    INVALID_FILE_TYPE("510", "Image Corrupted!"),
//    LOCATION_TRACKER_NOT_FOUND("302", "User Location Tracker details not found"),
//    DELETE_OBLIGATION("100", "Obligation deleted Successfully"),
//    RESTORE_OBLIGATION("100", "Obligation restored Successfully"),
//    OBLIGATION_NOT_FOUND("302", "Obligation Id does not exists", "300", "Obligation is not found"),
//    ENTRY_NOT_PUNCHED_IN("303","User has not been punched in yet"),
//    UNADJUSTED_COLLECTION_EXISTS("313","Un-adjusted collections exists. Please adjust them before moving forward!" ),
//    FILE_LIMIT_EXCEED("111","File is too large. The size limit is 10 MB." );
//
//
//    ;
//
//
//    private final String internalResponseCode;
//    private final String internalResponseMessage;
//    private final String responseCode;
//    private final String responseMessage;
//
//    public static ResponseType getResponseTypeByCode(String code) {
//        for (ResponseType responseType : ResponseType.values()) {
//            if (responseType.getResponseCode().equals(code) || (responseType.getInternalResponseCode() != null
//                    && responseType.getInternalResponseCode().equals(code))) {
//                return responseType;
//            }
//        }
//
//        return GENERIC_ERROR; // Return null if code is not found
//    }
//
//    ResponseType(String responseCode, String responseMessage) {
//        this.responseCode = responseCode;
//        this.responseMessage = responseMessage;
//        this.internalResponseCode = null;
//        this.internalResponseMessage = null;
//    }
//
//    ResponseType(String internalResponseCode, String internalResponseMessage, String responseCode,
//                 String responseMessage) {
//        this.internalResponseCode = internalResponseCode;
//        this.internalResponseMessage = internalResponseMessage;
//        this.responseCode = responseCode;
//        this.responseMessage = responseMessage;
//    }
//
//    public String getInternalResponseCode() {
//        return this.internalResponseCode;
//    }
//
//    public String getInternalResponseMessage() {
//        return this.internalResponseMessage;
//    }
//
//    public String getResponseCode() {
//        return this.responseCode;
//    }
//
//    public String getResponseMessage() {
//        return this.responseMessage;
//    }
//}
