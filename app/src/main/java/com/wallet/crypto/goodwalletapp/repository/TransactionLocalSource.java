package com.wallet.crypto.goodwalletapp.repository;

import com.wallet.crypto.goodwalletapp.entity.Transaction;
import com.wallet.crypto.goodwalletapp.entity.Wallet;

import io.reactivex.Single;

public interface TransactionLocalSource {
	Single<Transaction[]> fetchTransaction(Wallet wallet);

	void putTransactions(Wallet wallet, Transaction[] transactions);

    void clear();
}
