package com.wallet.crypto.goodwalletapp.repository;

import com.wallet.crypto.goodwalletapp.entity.Transaction;
import com.wallet.crypto.goodwalletapp.entity.Wallet;

import io.reactivex.Single;

public class TransactionInDiskSource implements TransactionLocalSource {
	@Override
	public Single<Transaction[]> fetchTransaction(Wallet wallet) {
		return null;
	}

	@Override
	public void putTransactions(Wallet wallet, Transaction[] transactions) {

	}

    @Override
    public void clear() {

    }
}
