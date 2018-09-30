package com.adinnet.codeview.builder;

/**
 * @author zoujian.
 * @date 2018/9/20
 */

public class User {
    private final String mFirstName;
    private final String mLastName;
    private final String mGender;
    public final int mAge;
    private final String mPhoneNo;

    private User(Builder builder) {
        mFirstName = builder.mFirstName;
        mLastName = builder.mLastName;
        mGender = builder.mGender;
        mAge = builder.mAge;
        mPhoneNo = builder.mPhoneNo;
    }

    public static final class Builder {
        private String mFirstName;
        private String mLastName;
        private String mGender;
        private int mAge;
        private String mPhoneNo;

        public Builder() {
        }

        public Builder mFirstName(String val) {
            mFirstName = val;
            return this;
        }

        public Builder mLastName(String val) {
            mLastName = val;
            return this;
        }

        public Builder mGender(String val) {
            mGender = val;
            return this;
        }

        public Builder mAge(int val) {
            mAge = val;
            return this;
        }

        public Builder mPhoneNo(String val) {
            mPhoneNo = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}
