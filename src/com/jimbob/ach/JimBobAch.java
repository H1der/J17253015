package com.jimbob.ach;

public class JimBobAch implements Ach {

    @Override
    public AchResponse issueDebit(AchCredentials credentials, AchTransactionData data) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AchResponse markTransactionAsNSF(AchCredentials credentials, AchTransactionData data, String traceCode) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AchResponse refundTransaction(AchCredentials credentials, AchTransactionData data, String traceCode) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AchResponse issueCredit(AchCredentials credentials, AchTransactionData data) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AchResponse voidSameDayTransaction(AchCredentials credentials, AchTransactionData data, String traceCode) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AchResponse queryTransactionStatus(AchCredentials credentials, AchTransactionData data, String traceCode) {
        // TODO Auto-generated method stub
        return null;
    }

}
