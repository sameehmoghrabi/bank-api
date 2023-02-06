package dev.moghrabi.sameeh.bankapp.constant;

public class CommonConst {

    private CommonConst() {
        // private constructor to hide the public implicit one
    }

    public static final class JoinColumn {

        public static final String CUSTOMER_ID = "customer_id";
        public static final String ACCOUNT_ID = "account_id";

        private JoinColumn() {
            // private constructor to hide the public implicit one
        }
    }

    public static final class Feedback {

        public static final String NEW_ACCOUNT_CREATED = "New account created!";
        public static final String NEW_CUSTOMER_CREATED = "New customer created!";

        private Feedback() {
            // private constructor to hide the public implicit one
        }
    }

    public static final class ConstraintMessages {

        public static final String CUSTOMER_ID_NOT_EMPTY = "CustomerId cannot be empty!";
        public static final String INITIAL_CREDIT_POSITIVE = "Initial credit cannot be negative!";

        private ConstraintMessages() {
            // private constructor to hide the public implicit one
        }
    }

}
