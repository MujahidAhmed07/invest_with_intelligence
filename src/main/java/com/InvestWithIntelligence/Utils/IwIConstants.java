package com.InvestWithIntelligence.Utils;

public class IwIConstants {

        // Validation
        public static final String ID_VALIDATION = "ID must be a greater than zero & non-null value!";
        public static final String USERNAME_VALIDATION = "Username Can't be Empty!";
        public static final String EMAIL_VALIDATION = "Email Can't be Empty!";

        // Response Error Message
        public static final String OBJ_NOT_NULL = "Object can't be null value!";
        public static final String NOT_EMPTY = "This field can't be empty!";
        public static final String NOT_NULL_EMPTY = "can't be null or empty!";
        public static final String ID_NOT_FOUND = "ID not found!";

        // ROLES
        // public static final Role ENTREPRENUER_ROLE = "ENTREPRENEUR";
        // public static final Role INVESTOR_ROLE = "INVESTOR";
        // public static final Role ADMIN_ROLE = "ADMIN";

        // VERIFYING EXISTING DATA
        public static final String USERNAME_EXISTS = "Username already exists!";
        public static final String EMAIL_EXISTS = "Email already exists!";

        // Success Messages

        public static final String DATA_DELETED = "Data deleted successfully! ID : ";

        // API COLLECTION VARIABLES
        public static final String[] ADMIN_WHITE_LIST_URLS = {
                        "api/iwi/admin/update/account/",
                        "api/iwi/admin/get/username"

        };

        public static final String[] INVESTOR_WHITE_LIST_URLS = {
                        "api/iwi/investor/delete/account",
                        "api/iwi/investor/get/email",
                        "api/iwi/imeta/update"
        };

        public static final String[] ENTREPRENUER_WHITE_LIST_URLS = {
                        "api/iwi/entreprenuer/delete/account",
                        "api/iwi/entreprenuer/get/all/entreprenuer",
                        "api/iwi/emeta/update",
                        "api/iwi/entreprenuer/get/email"
        };

        // FOR PUBlIC ACCESS
        public static final String[] PUBLIC_WHITE_LIST_URLS = {
                        "api/iwi/entreprenuer/add/account",
                        "api/iwi/investor/add/account",
                        "api/iwi/admin/add/account",
                        "api/iwi/auth/admin/login",
                        "api/iwi/auth/investor/login",
                        "api/iwi/auth/entreprenuer/login"
        };

}
