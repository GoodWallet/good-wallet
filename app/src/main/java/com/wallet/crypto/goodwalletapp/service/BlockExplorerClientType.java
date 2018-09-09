package com.wallet.crypto.goodwalletapp.service;

import com.wallet.crypto.goodwalletapp.entity.Transaction;

import io.reactivex.Observable;

public interface BlockExplorerClientType {
	Observable<Transaction[]> fetchTransactions(String forAddress);
}
