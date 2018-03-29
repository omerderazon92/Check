package com.example.omer.check;

/**
 * Created by Omer on 16/03/2018.
 */

class Credits {

    String companyName;
    int sumOfCredit;

    public Credits(String companyName, int sumOfCredit) {
        this.companyName = companyName;
        this.sumOfCredit = sumOfCredit;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public int getSumOfCredit() {
        return this.sumOfCredit;
    }
}
