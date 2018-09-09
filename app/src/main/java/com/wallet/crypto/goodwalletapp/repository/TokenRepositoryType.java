package com.wallet.crypto.goodwalletapp.repository;

import com.wallet.crypto.goodwalletapp.entity.Token;
import com.wallet.crypto.goodwalletapp.entity.Wallet;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface TokenRepositoryType {

    Observable<Token[]> fetch(String walletAddress);

    Completable addToken(Wallet wallet, String address, String symbol, int decimals);
}
